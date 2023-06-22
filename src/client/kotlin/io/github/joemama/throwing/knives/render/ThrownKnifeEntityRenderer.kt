package io.github.joemama.throwing.knives.render

import io.github.joemama.throwing.knives.entity.ThrownKnifeEntity
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory.Context
import net.minecraft.client.render.item.ItemRenderer
import net.minecraft.client.render.model.json.ModelTransformationMode
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.screen.PlayerScreenHandler
import net.minecraft.util.Identifier
import net.minecraft.util.math.RotationAxis

@Environment(EnvType.CLIENT)
class ThrownKnifeEntityRenderer(ctx: Context) : EntityRenderer<ThrownKnifeEntity>(ctx) {
    private val itemRenderer: ItemRenderer
    init {
        this.itemRenderer = ctx.itemRenderer
    }
    override fun getTexture(entity: ThrownKnifeEntity): Identifier = PlayerScreenHandler.BLOCK_ATLAS_TEXTURE

    override fun render(
        entity: ThrownKnifeEntity,
        yaw: Float,
        tickDelta: Float,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int
    ) {
        if (entity.age < 2) {
            return
        }

        matrices.push()
        matrices.scale(0.5f, 0.5f, 0.5f)
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.yaw + 90.0f))
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45.0f - entity.pitch))

        this.itemRenderer.renderItem(
           entity.item,
            ModelTransformationMode.FIXED,
            light,
            OverlayTexture.DEFAULT_UV,
            matrices,
            vertexConsumers,
            entity.world,
            entity.id
        )
        matrices.pop()
    }
}