package com.eilfyt.starwarsinminecraft.client.render;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.client.model.PlayerFishHatModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class PlayerFishHatRenderer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
        private static final ResourceLocation TEXTURE = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/player/fishhat.png");
        private static final PlayerFishHatModel MODEL = new PlayerFishHatModel();
        private final PlayerRenderer renderer;

        public PlayerFishHatRenderer(PlayerRenderer playerRenderer) {
            super(playerRenderer);

            this.renderer = playerRenderer;
        }

        @Override
        public void render(MatrixStack matrix, IRenderTypeBuffer buffer, int packedLightIn, AbstractClientPlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!player.isInvisible()) {
                float red = 1;
                float green = 1;
                float blue = 1;

                getParentModel().teeth.copyFrom(renderer.getModel().head);
                IVertexBuilder vertexBuilder = buffer.getBuffer(getRenderType(getTextureLocation(player)));
                getParentModel().renderToBuffer(matrix, vertexBuilder, 15728640, OverlayTexture.NO_OVERLAY, red, green, blue, 1f);
            }
        }

        @Override
        public PlayerFishHatModel getParentModel() {
            return MODEL;
        }

        @Override
        protected ResourceLocation getTextureLocation(AbstractClientPlayerEntity entityIn) {
            return TEXTURE;
        }

        private static RenderType getRenderType(ResourceLocation texture) {
            RenderState.TextureState renderState = new RenderState.TextureState(texture, false, false);
            RenderState.TransparencyState transparencyState = new RenderState.TransparencyState("additive_transparency", () -> {
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            }, () -> {
                RenderSystem.disableBlend();
                RenderSystem.defaultBlendFunc();
            });
            RenderState.FogState fogState = new RenderState.FogState("black_fog", () -> {
                RenderSystem.fog(2918, 0.0F, 0.0F, 0.0F, 1.0F);
                RenderSystem.enableFog();
            }, () -> {
                FogRenderer.levelFogColor();
                RenderSystem.disableFog();
            });

            return RenderType.create("halo", DefaultVertexFormats.NEW_ENTITY, 7, 256, false, true, RenderType.State.builder().setTextureState(renderState).setTransparencyState(transparencyState).setWriteMaskState(new RenderState.WriteMaskState(true, false)).setDepthTestState(new RenderState.DepthTestState("==", 515)).setDiffuseLightingState(new RenderState.DiffuseLightingState(true)).setFogState(fogState).createCompositeState(false));
        }
}
