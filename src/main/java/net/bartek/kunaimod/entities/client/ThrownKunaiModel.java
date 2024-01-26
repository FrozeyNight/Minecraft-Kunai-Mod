package net.bartek.kunaimod.entities.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ThrownKunaiModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "thrownkunai-v2"), "main");
	private final ModelPart blade;
	private final ModelPart circle;
	private final ModelPart upperhandle;
	private final ModelPart hilt;
	private final ModelPart bb_main;

	public ThrownKunaiModel(ModelPart root) {
		this.blade = root.getChild("blade");
		this.circle = root.getChild("circle");
		this.upperhandle = root.getChild("upperhandle");
		this.hilt = root.getChild("hilt");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition blade = partdefinition.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(0, 6).addBox(7.9F, -5.5F, -8.25F, 0.0F, 2.0F, 0.5F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(7.85F, -3.5F, -8.4F, 0.1F, 3.0F, 0.8F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(7.8F, -0.5F, -8.5F, 0.2F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 16.0F, 8.0F));

		PartDefinition circle = partdefinition.addOrReplaceChild("circle", CubeListBuilder.create().texOffs(4, 7).addBox(7.8F, 7.0F, -7.7F, 0.2F, 0.5F, 0.5F, new CubeDeformation(0.0F))
		.texOffs(4, 6).addBox(7.8F, 6.5F, -8.3F, 0.2F, 0.5F, 0.6F, new CubeDeformation(0.0F))
		.texOffs(6, 6).addBox(7.8F, 7.5F, -8.3F, 0.2F, 0.5F, 0.6F, new CubeDeformation(0.0F))
		.texOffs(2, 7).addBox(7.8F, 7.0F, -8.8F, 0.2F, 0.5F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 16.0F, 8.0F));

		PartDefinition upperhandle = partdefinition.addOrReplaceChild("upperhandle", CubeListBuilder.create().texOffs(5, 1).addBox(7.6F, 1.4F, -6.5F, 0.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(7.6F, 1.4F, -10.5F, 0.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(7.6F, 1.5F, -8.5F, 0.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 3).addBox(7.6F, 1.6F, -9.5F, 0.6F, 0.9F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 5).addBox(7.6F, 1.6F, -7.5F, 0.6F, 0.9F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 16.0F, 8.0F));

		PartDefinition hilt = partdefinition.addOrReplaceChild("hilt", CubeListBuilder.create().texOffs(2, 5).addBox(7.7F, 4.5F, -8.4F, 0.4F, 2.0F, 0.8F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(7.8F, 3.5F, -8.3F, 0.2F, 1.0F, 0.6F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 16.0F, 8.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3F, -5.5F, -1.5F, 0.4F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		blade.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		circle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		upperhandle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hilt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}