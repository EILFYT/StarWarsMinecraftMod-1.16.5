package com.eilfyt.starwarsinminecraft.client.render;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.client.model.PlayerFishHatModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
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
import net.minecraft.util.text.ITextComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerFishHatRenderer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
        private static final ResourceLocation TEXTURE = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/player/fishhat.png");
        private static final PlayerFishHatModel MODEL = new PlayerFishHatModel();
        private final PlayerRenderer renderer;
    public static List<String> users = new ArrayList<>();


    public PlayerFishHatRenderer(PlayerRenderer playerRenderer) {
            super(playerRenderer);

            this.renderer = playerRenderer;
        }

        @Override
        public void render(MatrixStack matrix, IRenderTypeBuffer buffer, int packedLightIn, AbstractClientPlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
           for (String user : users) {
               if (user.equals(player.getName()))  {
           }
            if (!player.isInvisible()) {
                float red = 1;
                float green = 1;
                float blue = 1;

                getParentModel().fishHat.copyFrom(renderer.getModel().head);
                IVertexBuilder vertexBuilder = buffer.getBuffer(getRenderType(getTextureLocation(player)));
                getParentModel().renderToBuffer(matrix, vertexBuilder, 15728640, OverlayTexture.NO_OVERLAY, red, green, blue, 1f);
            } }
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
            return RenderType.create("fishHat", DefaultVertexFormats.NEW_ENTITY, 7, 256, false, true, RenderType.State.builder().setTextureState(renderState).createCompositeState(false));
        }
}
