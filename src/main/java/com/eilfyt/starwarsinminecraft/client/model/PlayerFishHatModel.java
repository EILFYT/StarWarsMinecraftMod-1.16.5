package com.eilfyt.starwarsinminecraft.client.model;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PlayerFishHatModel extends PlayerModel<AbstractClientPlayerEntity> {
	 public final ModelRenderer fishHat;
	 public final ModelRenderer cube_r1;

	public PlayerFishHatModel() {
		super(0, false);
		texWidth = 64;
		texHeight = 64;


		fishHat = new ModelRenderer(this);
		fishHat.setPos(0.0F, 24.0F, 0.0F);


		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		fishHat.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.texOffs(0, 0).addBox(-5.0F, -6.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-4.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-2.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(2.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(4.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(4.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(4.0F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(4.0F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(4.0F, -6.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(3.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(1.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-1.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-3.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-5.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-5.0F, -6.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-5.0F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-5.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(8, 9).addBox(-7.0F, -17.0F, -6.0F, 3.0F, 11.0F, 12.0F, 0.0F, false);
		cube_r1.texOffs(10, 41).addBox(-3.0F, -21.0F, -4.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r1.texOffs(35, 47).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(50, 0).addBox(-3.0F, -11.0F, -6.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(50, 0).addBox(-3.0F, -11.0F, 5.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(0, 44).addBox(-5.0F, -16.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
	}
	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		fishHat.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}