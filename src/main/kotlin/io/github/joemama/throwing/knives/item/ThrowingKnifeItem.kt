package io.github.joemama.throwing.knives.item

import io.github.joemama.throwing.knives.entity.ThrownKnifeEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class ThrowingKnifeItem(settings: Settings): Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)
        if (world.isClient) {
            return TypedActionResult.pass(stack)
        }

        val entityStack = stack.copy()
        entityStack.count = 1
        stack.decrement(1)

        val entity = ThrownKnifeEntity(world, entityStack, user)

        world.spawnEntity(entity)

        return TypedActionResult.success(stack)
    }
}