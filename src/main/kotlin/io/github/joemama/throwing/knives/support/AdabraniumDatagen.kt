package io.github.joemama.throwing.knives.support

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

object AdabraniumDatagen {
    fun generateItemModels(items: ItemModelGenerator) {
        items.register(AdabraniumSupport.ADAMANTIUM_THROWING_KNIFE, Models.GENERATED)
        items.register(AdabraniumSupport.NETHER_THROWING_KNIFE, Models.GENERATED)
        items.register(AdabraniumSupport.VIBRANIUM_THROWING_KNIFE, Models.GENERATED)
    }

    fun generateTranslations(builder: FabricLanguageProvider.TranslationBuilder) {
        val itemSuffix = "Throwing Knife"

        builder.add(AdabraniumSupport.ADAMANTIUM_THROWING_KNIFE, "Adamantium $itemSuffix")
        builder.add(AdabraniumSupport.NETHER_THROWING_KNIFE, "Nether $itemSuffix")
        builder.add(AdabraniumSupport.VIBRANIUM_THROWING_KNIFE, "Vibranium $itemSuffix")
    }
}