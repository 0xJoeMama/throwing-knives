package io.github.joemama.throwing.knives.support

import io.github.joemama.throwing.knives.item.ThrowingKnifeItem
import io.github.joemama.throwing.knives.mkId
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Rarity

object AdabraniumSupport {
    const val MODID: String = "adabraniummod"


    //TODO: balancing
    val ADAMANTIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val NETHER_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))
    val VIBRANIUM_THROWING_KNIFE: ThrowingKnifeItem =
        ThrowingKnifeItem(0.1f, Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1))

    fun register() {
        Registry.register(Registries.ITEM, mkId("adabraniummod/adamantium_throwing_knife"), ADAMANTIUM_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("adabraniummod/nether_throwing_knife"), NETHER_THROWING_KNIFE)
        Registry.register(Registries.ITEM, mkId("adabraniummod/vibranium_throwing_knife"), VIBRANIUM_THROWING_KNIFE)
    }

    //fun getModId(path: String): Identifier = Identifier(MODID, path)
}