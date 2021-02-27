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
            textureWidth = 2048;
            textureHeight = 2048;

            bipedBody = new ModelRenderer(this);
            bipedBody.setRotationPoint(4.0F, 18.0F, 0.0F);
            bipedBody.setTextureOffset(1056, 269).addBox(-9.0F, -10.0F, -3.0F, 10.0F, 10.0F, 7.0F, 0.0F, true);

            bipedHead = new ModelRenderer(this);
            bipedHead.setRotationPoint(0.0F, 6.0F, 0.0F);
            bipedHead.setTextureOffset(928, 341).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 6.0F, 5.0F, 0.0F, true);
            bipedHead.setTextureOffset(595, 659).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.setTextureOffset(550, 698).addBox(1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.setTextureOffset(397, 634).addBox(-2.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.setTextureOffset(461, 582).addBox(-2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
            bipedHead.setTextureOffset(467, 582).addBox(1.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

            bipedRightLeg = new ModelRenderer(this);
            bipedRightLeg.setRotationPoint(-3.0F, 18.0F, 0.0F);
            bipedRightLeg.setTextureOffset(467, 192).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
            bipedRightLeg.setTextureOffset(410, 250).addBox(1.0F, 4.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedRightLeg.setTextureOffset(512, 218).addBox(-3.0F, 4.0F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, true);
            bipedRightLeg.setTextureOffset(557, 224).addBox(-1.0F, 4.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedRightLeg.setTextureOffset(435, 288).addBox(-2.0F, 4.0F, 1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);
            bipedRightLeg.setTextureOffset(563, 262).addBox(-3.0F, 4.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

            bipedLeftLeg = new ModelRenderer(this);
            bipedLeftLeg.setRotationPoint(3.0F, 18.0F, -3.0F);
            bipedLeftLeg.setTextureOffset(493, 314).addBox(-1.0F, 0.0F, 3.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
            bipedLeftLeg.setTextureOffset(531, 250).addBox(2.0F, 4.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedLeftLeg.setTextureOffset(435, 160).addBox(-1.0F, 4.0F, 4.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);
            bipedLeftLeg.setTextureOffset(410, 262).addBox(-2.0F, 4.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedLeftLeg.setTextureOffset(525, 282).addBox(0.0F, 4.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
            bipedLeftLeg.setTextureOffset(461, 262).addBox(-2.0F, 4.0F, 2.0F, 5.0F, 2.0F, 2.0F, 0.0F, true);

            bipedRightArm = new ModelRenderer(this);
            bipedRightArm.setRotationPoint(-6.0F, 12.0F, 0.0F);
            bipedRightArm.setTextureOffset(1030, 250).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.setTextureOffset(1018, 275).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.setTextureOffset(960, 262).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.setTextureOffset(1043, 282).addBox(-3.0F, 1.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.setTextureOffset(998, 243).addBox(-4.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedRightArm.setTextureOffset(1069, 269).addBox(-5.0F, 3.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);

            bipedLeftArm = new ModelRenderer(this);
            bipedLeftArm.setRotationPoint(5.0F, 11.0F, 0.0F);
            bipedLeftArm.setTextureOffset(1050, 230).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.setTextureOffset(1043, 294).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.setTextureOffset(998, 218).addBox(0.0F, 1.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.setTextureOffset(1018, 224).addBox(1.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.setTextureOffset(1011, 262).addBox(2.0F, 3.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
            bipedLeftArm.setTextureOffset(1018, 288).addBox(3.0F, 4.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
        }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bipedHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.bipedBody.rotateAngleY = 0.0F;
        float f = 1.0F;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        this.bipedRightLeg.rotateAngleZ = 0.0F;
        this.bipedLeftLeg.rotateAngleZ = 0.0F;
    }


    @Override
        public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
            bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
            bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
            bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
            bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
            bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
            bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
        }

        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.rotateAngleX = x;
            modelRenderer.rotateAngleY = y;
            modelRenderer.rotateAngleZ = z;
        }
    }

