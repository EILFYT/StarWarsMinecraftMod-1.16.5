package com.eilfyt.starwarsinminecraft.client.model;

import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PorgModel<T extends PorgEntity> extends EntityModel<T> {


        private final ModelRenderer bipedBody;
        private final ModelRenderer bipedHead;
        private final ModelRenderer bipedLeftArm;
        private final ModelRenderer bipedRightArm;
        private final ModelRenderer bipedLeftLeg;
        private final ModelRenderer bipedRightLeg;

        public PorgModel() {
            texWidth = 2048;
            texHeight = 2048;

            bipedBody = new ModelRenderer(this);
            bipedBody.setPos(4.0F, 18.0F, 0.0F);
            bipedBody.texOffs(1056, 269).addBox(-9.0F, -10.0F, -3.0F, 10.0F, 10.0F, 7.0F, 0.0F, true);

            bipedHead = new ModelRenderer(this);
            bipedHead.setPos(0.0F, 6.0F, 0.0F);
            bipedHead.texOffs(928, 341).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 6.0F, 5.0F, 0.0F, true);
            bipedHead.texOffs(595, 659).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.texOffs(550, 698).addBox(1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.texOffs(397, 634).addBox(-2.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.texOffs(461, 582).addBox(-2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.texOffs(467, 582).addBox(1.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

            bipedRightLeg = new ModelRenderer(this);
            bipedRightLeg.setPos(-3.0F, 18.0F, 0.0F);
            bipedRightLeg.texOffs(467, 192).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
            bipedRightLeg.texOffs(410, 250).addBox(1.0F, 4.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedRightLeg.texOffs(512, 218).addBox(-3.0F, 4.0F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, true);
            bipedRightLeg.texOffs(557, 224).addBox(-1.0F, 4.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedRightLeg.texOffs(435, 288).addBox(-2.0F, 4.0F, 1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);
            bipedRightLeg.texOffs(563, 262).addBox(-3.0F, 4.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

            bipedLeftLeg = new ModelRenderer(this);
            bipedLeftLeg.setPos(3.0F, 18.0F, -3.0F);
            bipedLeftLeg.texOffs(493, 314).addBox(-1.0F, 0.0F, 3.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
            bipedLeftLeg.texOffs(531, 250).addBox(2.0F, 4.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedLeftLeg.texOffs(435, 160).addBox(-1.0F, 4.0F, 4.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);
            bipedLeftLeg.texOffs(410, 262).addBox(-2.0F, 4.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedLeftLeg.texOffs(525, 282).addBox(0.0F, 4.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedLeftLeg.texOffs(461, 262).addBox(-2.0F, 4.0F, 2.0F, 5.0F, 2.0F, 2.0F, 0.0F, true);

            bipedRightArm = new ModelRenderer(this);
            bipedRightArm.setPos(-6.0F, 12.0F, 0.0F);
            bipedRightArm.texOffs(1030, 250).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.texOffs(1018, 275).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.texOffs(960, 262).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.texOffs(1043, 282).addBox(-3.0F, 1.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.texOffs(998, 243).addBox(-4.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.texOffs(1069, 269).addBox(-5.0F, 3.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);

            bipedLeftArm = new ModelRenderer(this);
            bipedLeftArm.setPos(5.0F, 11.0F, 0.0F);
            bipedLeftArm.texOffs(1050, 230).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.texOffs(1043, 294).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.texOffs(998, 218).addBox(0.0F, 1.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.texOffs(1018, 224).addBox(1.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.texOffs(1011, 262).addBox(2.0F, 3.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.texOffs(1018, 288).addBox(3.0F, 4.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
        }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.bipedHead.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.bipedBody.yRot = 0.0F;
        float f = 1.0F;
        this.bipedRightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_/ f;
        this.bipedLeftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_ / f;
        this.bipedRightLeg.yRot = 0.0F;
        this.bipedLeftLeg.yRot = 0.0F;
        this.bipedRightLeg.zRot = 0.0F;
        this.bipedLeftLeg.zRot = 0.0F;
    }




        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.xRot = x;
            modelRenderer.yRot = y;
            modelRenderer.zRot = z;
        }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        bipedBody.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
        bipedHead.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
        bipedRightLeg.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
        bipedLeftLeg.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
        bipedRightArm.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
        bipedLeftArm.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
    }
}

