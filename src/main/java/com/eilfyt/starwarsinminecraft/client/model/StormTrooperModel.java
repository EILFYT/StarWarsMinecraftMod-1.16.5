package com.eilfyt.starwarsinminecraft.client.model;

import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import com.eilfyt.starwarsinminecraft.entities.StormTrooperEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class StormTrooperModel<T extends StormTrooperEntity> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Chest;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;

	public StormTrooperModel() {
		texHeight = 64;
		texWidth = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-2.0F, 12.0F, 0.0F);
		RightLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		Chest = new ModelRenderer(this);
		Chest.setPos(0.0F, 6.0F, 0.0F);
		setRotationAngle(Chest, 0, 1.5788f, 0);
		Chest.texOffs(16, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(2.0F, 12.0F, 0.0F);
		LeftLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-4.0F, 2.0F, 0.0F);
		RightArm.texOffs(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(4.0F, 2.0F, 0.0F);
		LeftArm.texOffs(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}



	@Override
	public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		this.Head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
		this.Head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
		this.Chest.yRot = ((float)Math.PI / 2F);
		float f = 1.0F;
		this.RightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
		this.LeftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
		this.RightLeg.yRot = 0.0F;
		this.LeftLeg.yRot = 0.0F;
		this.RightLeg.zRot = 0.0F;
		this.LeftLeg.zRot = 0.0F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		Chest.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
		Head.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
		RightLeg.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
		LeftLeg.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
		RightArm.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
		LeftArm.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
	}
}