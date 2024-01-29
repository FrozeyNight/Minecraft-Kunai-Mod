package net.bartek.kunaimod.entities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.entities.projectile.IronThrownKunai;
import net.bartek.kunaimod.entities.projectile.ThrownKunai;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class IronThrownKunaiRenderer extends EntityRenderer<IronThrownKunai> {
    private final IronThrownKunaiModel model;
    public IronThrownKunaiRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new IronThrownKunaiModel(pContext.bakeLayer(ModModelLayers.IRON_THROWN_KUNAI_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(IronThrownKunai pEntity) {
        return new ResourceLocation(KunaiMod.MOD_ID, "textures/entity/iron_thrown_kunai.png");
    }

    @Override
    public void render(IronThrownKunai pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        pMatrixStack.pushPose();

        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));

        pMatrixStack.translate(0.0, -0.69, 0.0);

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
