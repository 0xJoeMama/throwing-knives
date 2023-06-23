package io.github.joemama.throwing.knives.entity

import io.github.joemama.throwing.knives.ThrowingKnives
import io.github.joemama.throwing.knives.item.ThrowingKnifeItem
import net.minecraft.entity.*
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.ProjectileUtil
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.MathHelper
import net.minecraft.world.RaycastContext
import net.minecraft.world.World
import org.joml.Math
import java.util.*
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2

class ThrownKnifeEntity(type: EntityType<out Entity>, world: World) : Entity(type, world), Ownable {
    private val owner: LivingEntity?
        get() {
            if (this.world.isClient) {
                return null
            }

            return this.ownerUid?.let { (this.world as ServerWorld).getEntity(it) } as? LivingEntity
        }
    private var ownerUid: UUID? = null
    var stack: ItemStack
        get() = this.dataTracker.get(ITEM)
        set(value) = this.dataTracker.set(ITEM, value)

    // using isOnGround as a marker for being a wall because lazy....
    private var isOnWall: Boolean
        get() = this.isOnGround
        set(value) {
            this.isOnGround = value
        }

    companion object {
        @JvmStatic
        val ITEM: TrackedData<ItemStack> =
            DataTracker.registerData(ThrownKnifeEntity::class.java, TrackedDataHandlerRegistry.ITEM_STACK)
    }

    constructor(world: World, stack: ItemStack, user: LivingEntity) : this(ThrowingKnives.THROWN_KNIFE, world) {
        this.ownerUid = user.uuid
        this.stack = stack
        this.setPosition(user.eyePos)
        this.velocity = user.rotationVector.normalize().multiply(1.2)
    }

    override fun tick() {
        super.tick()
        if (this.isRemoved) {
            return
        }

        val hit = ProjectileUtil.getCollision(this) { it is LivingEntity } ?: return
        when (hit.type) {
            HitResult.Type.BLOCK -> this.onBlockHit(hit as BlockHitResult)
            HitResult.Type.ENTITY -> {
                val ehr = hit as EntityHitResult
                if (this.stack.item is ThrowingKnifeItem) {
                    ehr.entity.damage(
                        this.damageSources.mobAttack(this.owner),
                        (this.stack.item as ThrowingKnifeItem).damage
                    )
                    val item = this.stack.item
                    if (item is ThrowingKnifeItem) {
                        item.onHit(ehr.entity)
                    }
                }
                this.drop()
            }

            else -> {}
        }

        if (!this.isOnWall) {
            this.setPosition(this.pos.add(this.velocity))
            this.velocity = this.velocity.add(0.0, -0.03, 0.0)
        } else {
            this.attemptUnstick()
        }

        if (this.velocity.lengthSquared() != 0.0) {
            val horizontalLen = this.velocity.horizontalLengthSquared()
            if (this.velocity.horizontalLengthSquared() == 0.0) {
                this.pitch = (MathHelper.clamp(this.velocity.y * 3, -1.0, 1.0) * 90).toFloat()
            } else {
                this.pitch = (atan(
                    this.velocity.y * Math.invsqrt(horizontalLen)
                ) * 180 / PI).toFloat()
                this.yaw = (atan2(this.velocity.x, this.velocity.z) * 180 / PI).toFloat()
            }
        }
    }

    private fun attemptUnstick() {
        val bhr = this.world.raycast(RaycastContext(this.pos, this.pos.add(this.velocity), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this))
        val state = this.world.getBlockState(bhr.blockPos)

        if (state.isAir) {
            this.isOnWall = false
            this.velocity = this.velocity.multiply(0.05)
        }
    }

    private fun drop() {
        val item = ItemEntity(this.world, this.x, this.y, this.z, this.stack)
        world.spawnEntity(item)
        this.world.playSound(null, this.blockPos, ThrowingKnives.KNIFE_HIT_HARD, SoundCategory.BLOCKS, 0.3f, 1.0f)

        this.discard()
    }

    override fun canHit(): Boolean = true

    override fun canBeHitByProjectile(): Boolean = false

    private fun onBlockHit(bhr: BlockHitResult) {
        val pos = bhr.blockPos
        val state = this.world.getBlockState(pos)

       if (state.isIn(ThrowingKnives.SOFT_BLOCKS)) {
            if (!this.isOnWall) {
                this.isOnWall = true
                this.setPosition(bhr.pos)
            }
        } else {
            this.drop()
        }
    }

    override fun initDataTracker() {
        this.dataTracker.startTracking(ITEM, ThrowingKnives.IRON_THROWING_KNIFE.defaultStack)
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        this.ownerUid = nbt.getUuid("Owner")
        this.stack = ItemStack.fromNbt(nbt.getCompound("Stack") ?: return)
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        this.ownerUid?.let {
            nbt.putUuid("Owner", it)
        }
        nbt.put("Stack", this.stack.writeNbt(NbtCompound()))
    }

    override fun getOwner(): Entity? = this.owner
}