package io.github.joemama.throwing.knives

import io.github.joemama.throwing.knives.entity.ThrownKnifeEntity
import io.github.joemama.throwing.knives.item.ThrowingKnifeItem
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.block.Block
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import org.slf4j.LoggerFactory

object ThrowingKnives : ModInitializer {
    const val MODID: String = "throwing-knives"
    private val logger = LoggerFactory.getLogger(MODID)

    val DIAMOND_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(Item.Settings().rarity(Rarity.UNCOMMON).maxCount(8))
    val IRON_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(Item.Settings().rarity(Rarity.UNCOMMON).maxCount(8))
    val GOLD_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(Item.Settings().rarity(Rarity.UNCOMMON).maxCount(8))
    val THROWN_KNIFE: EntityType<ThrownKnifeEntity> =
        FabricEntityTypeBuilder.create<ThrownKnifeEntity>()
            .entityFactory(::ThrownKnifeEntity)
            .spawnGroup(SpawnGroup.MISC)
            .disableSummon()
            .trackedUpdateRate(10)
            .trackRangeBlocks(20)
            .dimensions(EntityDimensions.fixed(0.2f, 0.2f))
            .build()

    val SOFT_BLOCKS: TagKey<Block> = TagKey.of(RegistryKeys.BLOCK, mkId("soft_blocks"))

    override fun onInitialize() {
        Registry.register(Registries.ITEM, mkId("diamond_throwing_knife"), DIAMOND_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("iron_throwing_knife"), IRON_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("gold_throwing_knife"), GOLD_THROWING_KNIFE)
        Registry.register(Registries.ENTITY_TYPE, mkId("thrown_knife"), THROWN_KNIFE)
        this.logger.info("Fully initialized Throwing Knives")
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register {
            it.add(ItemStack(DIAMOND_THROWING_KNIFE))
        }
    }
}

fun mkId(path: String): Identifier = Identifier(ThrowingKnives.MODID, path)