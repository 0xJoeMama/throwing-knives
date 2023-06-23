package io.github.joemama.throwing.knives.data

import io.github.joemama.throwing.knives.ThrowingKnives
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Blocks
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture

@Suppress("unused")
object ThrowingKnivesDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        LoggerFactory.getLogger("datagen").info("Generating data....")
        val pack = gen.createPack()
        pack.addProvider(::TagProvider)
        pack.addProvider(::ItemModelProvider)
        pack.addProvider(::TranslationProvider)
    }

    class TagProvider(out: FabricDataOutput, reg: CompletableFuture<RegistryWrapper.WrapperLookup>) :
        FabricTagProvider.BlockTagProvider(out, reg) {
        override fun configure(arg: RegistryWrapper.WrapperLookup) {
            this.getOrCreateTagBuilder(ThrowingKnives.SOFT_BLOCKS)
                .add(Blocks.CLAY)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.WOOL)
                .forceAddTag(BlockTags.WOOL_CARPETS)
        }
    }

    class ItemModelProvider(out: FabricDataOutput) : FabricModelProvider(out) {
        override fun generateBlockStateModels(blocks: BlockStateModelGenerator) = Unit

        override fun generateItemModels(items: ItemModelGenerator) {
            items.register(ThrowingKnives.DIAMOND_THROWING_KNIFE, Models.GENERATED)
            items.register(ThrowingKnives.IRON_THROWING_KNIFE, Models.GENERATED)
            items.register(ThrowingKnives.GOLD_THROWING_KNIFE, Models.GENERATED)
            items.register(ThrowingKnives.NETHERITE_THROWING_KNIFE, Models.GENERATED)
        }
    }

    class TranslationProvider(out: FabricDataOutput) : FabricLanguageProvider(out) {
        override fun generateTranslations(builder: TranslationBuilder) {
            builder.add(ThrowingKnives.DIAMOND_THROWING_KNIFE, "Diamond Throwing Knife")
            builder.add(ThrowingKnives.IRON_THROWING_KNIFE, "Iron Throwing Knife")
            builder.add(ThrowingKnives.GOLD_THROWING_KNIFE, "Gold Throwing Knife")
            builder.add(ThrowingKnives.NETHERITE_THROWING_KNIFE, "Netherite Throwing Knife")
            builder.add(ThrowingKnives.THROWN_KNIFE, "Thrown Knife")
            builder.add("sound.throwing-knives.knife_hit", "Hit hard surface")
        }
    }
}