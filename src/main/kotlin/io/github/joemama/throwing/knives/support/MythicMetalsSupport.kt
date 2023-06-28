package io.github.joemama.throwing.knives.support

import io.github.joemama.throwing.knives.item.ThrowingKnifeItem
import io.github.joemama.throwing.knives.mkId
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Rarity

object MythicMetalsSupport {
    const val MODID: String = "mythicmetals"


    //TODO: balancing
    val ADAMANTITE_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val AQUARIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val BANGLUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))    //TODO: explosion on block hit
    val BRONZE_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val CARMOT_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val CELESTIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val COPPER_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val DURASTEEL_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val HALLOWED_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val KYBER_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val METALLURGIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val MIDAS_GOLD_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val MYTHRIL_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val ORICHALCUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val OSMIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val PALLADIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val PROMETHEUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val QUADRILLUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val RUNITE_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val STAR_PLATINUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val STEEL_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val STORMYX_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))

    fun register() {
        Registry.register(Registries.ITEM, mkId("mythicmetals/adamantite_throwing_knife"), ADAMANTITE_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/aquarium_throwing_knife"), AQUARIUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/banglum_throwing_knife"), BANGLUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/bronze_throwing_knife"), BRONZE_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/carmot_throwing_knife"), CARMOT_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/celestium_throwing_knife"), CELESTIUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/copper_throwing_knife"), COPPER_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/durasteel_throwing_knife"), DURASTEEL_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/hallowed_throwing_knife"), HALLOWED_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/kyber_throwing_knife"), KYBER_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/metallurgium_throwing_knife"), METALLURGIUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/midas_gold_throwing_knife"), MIDAS_GOLD_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/mythril_throwing_knife"), MYTHRIL_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/orichalcum_throwing_knife"), ORICHALCUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/osmium_throwing_knife"), OSMIUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/palladium_throwing_knife"), PALLADIUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/prometheum_throwing_knife"), PROMETHEUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/quadrillum_throwing_knife"), QUADRILLUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/runite_throwing_knife"), RUNITE_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/star_platinum_throwing_knife"), STAR_PLATINUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/steel_throwing_knife"), STEEL_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("mythicmetals/stormyx_throwing_knife"), STORMYX_THROWING_KNIFE)
    }

    //fun mkModId(path: String): Identifier = Identifier(MODID, path)
}