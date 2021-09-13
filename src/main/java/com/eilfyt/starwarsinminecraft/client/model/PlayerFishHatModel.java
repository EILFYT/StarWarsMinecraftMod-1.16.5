package com.eilfyt.starwarsinminecraft.client.model;


import com.ibm.icu.impl.FormattedStringBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PlayerFishHatModel extends PlayerModel<AbstractClientPlayerEntity> {
	public final ModelRenderer teeth;
	public final ModelRenderer teeth2;
	public final ModelRenderer teeth3;
	public final ModelRenderer teeth4;
	 public final ModelRenderer bb_main;

	public PlayerFishHatModel() {
		super(0, false);
		texWidth = 64;
		texHeight = 64;

		teeth = new ModelRenderer(this, 0, 0);
		teeth.setPos(0.0F, 24.0F, 0.0F);
		teeth.texOffs(0, 0).addBox(-7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(-5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(-3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth.texOffs(0, 0).addBox(-1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		teeth2 = new ModelRenderer(this);
		teeth2.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(teeth2, 0.0F, -1.5708F, 0.0F);
		teeth2.texOffs(0, 0).addBox(-7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(-5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(-3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth2.texOffs(0, 0).addBox(-1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		teeth3 = new ModelRenderer(this);
		teeth3.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(teeth3, 0.0F, 3.1416F, 0.0F);
		teeth3.texOffs(0, 0).addBox(-7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(-5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(-3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth3.texOffs(0, 0).addBox(-1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		teeth4 = new ModelRenderer(this);
		teeth4.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(teeth4, 0.0F, 1.5708F, 0.0F);
		teeth4.texOffs(0, 0).addBox(-7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(-5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(-3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(7.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(5.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(3.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		teeth4.texOffs(0, 0).addBox(-1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 33).addBox(-9.0F, -14.0F, -9.0F, 18.0F, 13.0F, 18.0F, 0.0F, false);
		bb_main.texOffs(50, 0).addBox(-5.0F, -9.0F, 9.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(50, 0).addBox(-5.0F, -9.0F, -10.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(35, 47).addBox(-1.0F, -19.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(10, 41).addBox(-3.0F, -20.0F, -4.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-10.0F, -15.0F, -10.0F, 3.0F, 12.0F, 20.0F, 0.0F, false);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		teeth.render(matrixStack, buffer, packedLight, packedOverlay);
		teeth2.render(matrixStack, buffer, packedLight, packedOverlay);
		teeth3.render(matrixStack, buffer, packedLight, packedOverlay);
		teeth4.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}