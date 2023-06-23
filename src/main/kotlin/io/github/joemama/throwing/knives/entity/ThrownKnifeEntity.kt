package io.github.joemama.throwing.knives.entity

import io.github.joemama.throwing.knives.ThrowingKnives
import io.github.joemama.throwing.knives.item.ThrowingKnifeItem
import net.minecraft.entity.*
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.projectile.ProjectileUtil
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World
import org.joml.Math
import java.util.*
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2

class ThrownKnifeEntity(type: EntityType<out Entity>, world: World) : Entity(type, world), Ownable {
    private var owner: LivingEntity? = null
        set(value) {
            field = value
            this.ownerUid = value?.uuid
        }
    private var ownerUid: UUID? = null
    var item: ItemStack
        get() = this.dataTracker.get(ITEM)
        set(value) = this.dataTracker.set(ITEM, value)

    companion object {
        val ITEM: TrackedData<ItemStack> =
            DataTracker.registerData(ThrownKnifeEntity::class.java, TrackedDataHandlerRegistry.ITEM_STACK)
    }

    constructor(world: World, stack: ItemStack, user: LivingEntity) : this(ThrowingKnives.THROWN_KNIFE, world) {
        this.owner = user
        this.item = stack
        val normalizedLook = user.rotationVector.normalize()
        this.setPosition(user.eyePos)
        this.velocity = normalizedLook.multiply(1.2)
    }

    override fun tick() {
        super.tick()
        this.setPosition(this.pos.add(this.velocity))
        this.velocity = this.velocity.add(0.0, -0.03, 0.0)

        if (this.velocity.lengthSquared() != 0.0) {
            this.yaw = (atan2(this.velocity.x, this.velocity.z) * 180 / PI).toFloat()
            val horizontalLen = this.velocity.horizontalLengthSquared()
            if (this.velocity.horizontalLengthSquared() == 0.0) {
                this.pitch = (MathHelper.clamp(this.velocity.y * 3, -1.0, 1.0) * 90).toFloat()
            } else {
                this.pitch = (atan(
                    this.velocity.y * Math.invsqrt(horizontalLen)
                ) * 180 / PI).toFloat()
            }
        }

        if (this.isRemoved) {
            return
        }

        val hit = ProjectileUtil.getCollision(this) { true } ?: return
        when (hit.type) {
            HitResult.Type.ENTITY -> {
                val ehr = hit as EntityHitResult
                if (ehr.entity is LivingEntity) {
                    if (this.item.item is ThrowingKnifeItem) {
                        ehr.entity.damage(
                            this.damageSources.mobAttack(this.owner),
                            (this.item.item as ThrowingKnifeItem).damage
                        )
                    }
                    this.drop()
                }
            }

            HitResult.Type.BLOCK -> this.onBlockHit(hit as BlockHitResult)
            else -> {}
        }
    }

    private fun drop() {
        val item = ItemEntity(this.world, this.x, this.y, this.z, this.item)
        world.spawnEntity(item)
        this.world.playSound(null, this.blockPos, ThrowingKnives.KNIFE_HIT_HARD, SoundCategory.BLOCKS, 0.3f, 1.0f)

        this.discard()
    }

    private fun onBlockHit(bhr: BlockHitResult) {
        val pos = bhr.blockPos
        val state = this.world.getBlockState(pos)

        if (state.isIn(ThrowingKnives.SOFT_BLOCKS)) {
            // TODO: Stick to block
        } else {
            this.drop()
        }
    }

    override fun initDataTracker() {
        this.dataTracker.startTracking(ITEM, ThrowingKnives.IRON_THROWING_KNIFE.defaultStack)
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        this.ownerUid = nbt.getUuid("Owner")
        this.item = ItemStack.fromNbt(nbt.getCompound("Stack") ?: return)
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        this.owner?.let {
            nbt.putUuid("Owner", it.uuid)
        }
        nbt.put("Stack", this.item.writeNbt(NbtCompound()))
    }

    override fun getOwner(): Entity? = this.owner ?: if (!this.world.isClient && this.ownerUid != null) {
        (this.world as ServerWorld).getEntity(this.ownerUid)
    } else null
}