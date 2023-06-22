package io.github.joemama.throwing.knives.entity

import io.github.joemama.throwing.knives.ThrowingKnives
import net.minecraft.entity.EntityType
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.world.World

class ThrownKnifeEntity(type: EntityType<out ThrownItemEntity>, world: World) : ThrownItemEntity(type, world) {
    constructor(world: World, stack: ItemStack, user: LivingEntity) : this(ThrowingKnives.THROWN_KNIFE, world) {
        this.owner = user
        this.item = stack
        this.setPosition(user.eyePos.add(0.0, 0.1, 0.0))
        this.velocity = user.rotationVector.normalize().multiply(1.4)
    }

    override fun onBlockHit(bhr: BlockHitResult) {
        if (this.isRemoved) {
            return
        }

        val pos = bhr.blockPos
        val state = this.world.getBlockState(pos)

        if (state.isIn(ThrowingKnives.SOFT_BLOCKS)) {
            // TODO: Stick to block
        } else {
            val item = ItemEntity(this.world, this.x, this.y, this.z, this.stack)
            world.spawnEntity(item)
            this.world.playSound(null, pos, SoundEvents.ENTITY_ARROW_HIT, SoundCategory.BLOCKS, 0.5f, 1.0f)

            this.discard()
        }
    }

    override fun getDefaultItem(): Item = ThrowingKnives.DIAMOND_THROWING_KNIFE
}