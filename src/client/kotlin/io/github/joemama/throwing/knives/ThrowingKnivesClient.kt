package io.github.joemama.throwing.knives

import io.github.joemama.throwing.knives.render.ThrownKnifeEntityRenderer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry

@Environment(EnvType.CLIENT)
object ThrowingKnivesClient : ClientModInitializer {
	override fun onInitializeClient() {
		EntityRendererRegistry.register(ThrowingKnives.THROWN_KNIFE) {
			ThrownKnifeEntityRenderer(it)
		}
	}
}