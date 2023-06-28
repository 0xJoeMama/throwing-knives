package io.github.joemama.throwing.knives.support

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

object MythicMetalsDatagen {

    fun generateItemModels(items: ItemModelGenerator) {
        items.register(MythicMetalsSupport.ADAMANTITE_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.AQUARIUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.BANGLUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.BRONZE_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.CARMOT_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.CELESTIUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.COPPER_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.DURASTEEL_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.HALLOWED_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.KYBER_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.METALLURGIUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.MIDAS_GOLD_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.MYTHRIL_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.ORICHALCUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.OSMIUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.PALLADIUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.PROMETHEUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.QUADRILLUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.RUNITE_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.STAR_PLATINUM_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.STEEL_THROWING_KNIFE, Models.GENERATED)
        items.register(MythicMetalsSupport.STORMYX_THROWING_KNIFE, Models.GENERATED)
    }

    fun generateTranslations(builder: FabricLanguageProvider.TranslationBuilder) {
        val itemSuffix = "Throwing Knife"

        builder.add(MythicMetalsSupport.ADAMANTITE_THROWING_KNIFE, "Adamantite $itemSuffix")
        builder.add(MythicMetalsSupport.AQUARIUM_THROWING_KNIFE, "Aquarium $itemSuffix")
        builder.add(MythicMetalsSupport.BANGLUM_THROWING_KNIFE, "Banglum $itemSuffix")
        builder.add(MythicMetalsSupport.BRONZE_THROWING_KNIFE, "Bronze $itemSuffix")
        builder.add(MythicMetalsSupport.CARMOT_THROWING_KNIFE, "Carmot $itemSuffix")
        builder.add(MythicMetalsSupport.CELESTIUM_THROWING_KNIFE, "Celestium $itemSuffix")
        builder.add(MythicMetalsSupport.COPPER_THROWING_KNIFE, "Copper $itemSuffix")
        builder.add(MythicMetalsSupport.DURASTEEL_THROWING_KNIFE, "Durasteel $itemSuffix")
        builder.add(MythicMetalsSupport.HALLOWED_THROWING_KNIFE, "Hallowed $itemSuffix")
        builder.add(MythicMetalsSupport.KYBER_THROWING_KNIFE, "Kyber $itemSuffix")
        builder.add(MythicMetalsSupport.METALLURGIUM_THROWING_KNIFE, "Metallurgium $itemSuffix")
        builder.add(MythicMetalsSupport.MIDAS_GOLD_THROWING_KNIFE, "Midas Gold $itemSuffix")
        builder.add(MythicMetalsSupport.MYTHRIL_THROWING_KNIFE, "Mythril $itemSuffix")
        builder.add(MythicMetalsSupport.ORICHALCUM_THROWING_KNIFE, "Orichalcum $itemSuffix")
        builder.add(MythicMetalsSupport.OSMIUM_THROWING_KNIFE, "Osmium $itemSuffix")
        builder.add(MythicMetalsSupport.PALLADIUM_THROWING_KNIFE, "Palladium $itemSuffix")
        builder.add(MythicMetalsSupport.PROMETHEUM_THROWING_KNIFE, "Prometheum $itemSuffix")
        builder.add(MythicMetalsSupport.QUADRILLUM_THROWING_KNIFE, "Quadrillum $itemSuffix")
        builder.add(MythicMetalsSupport.RUNITE_THROWING_KNIFE, "Runite $itemSuffix")
        builder.add(MythicMetalsSupport.STAR_PLATINUM_THROWING_KNIFE, "Star Platinum $itemSuffix")
        builder.add(MythicMetalsSupport.STEEL_THROWING_KNIFE, "Steel $itemSuffix")
        builder.add(MythicMetalsSupport.STORMYX_THROWING_KNIFE, "Stormyx $itemSuffix")
    }
}