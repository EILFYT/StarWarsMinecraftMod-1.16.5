package com.eilfyt.starwarsinminecraft.items;


import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;

import java.util.Objects;


public class HackerPhoneScreen extends Screen {
    private static final int WIDTH = 180;
    private static final int HEIGHT = 216;



    private ResourceLocation GUI = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/gui/gui1.png");

    public HackerPhoneScreen() {
        super(new TranslationTextComponent("starwars.gui.agui"));
    }

    @Override
    protected void init() {
        super.init();
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;

        addButton(new Button(relX + 134, relY + 34, 18, 18, new StringTextComponent("Enable Fly"), (b) -> enableFly()));
        addButton(new Button(relX + 28, relY + 34, 18, 18, new StringTextComponent("Disable Fly"), (b) -> disableFly()));
    }

    private void enableFly() {
            Minecraft.getInstance().player.abilities.allowFlying = true;
    }


    private void disableFly() {
        Minecraft.getInstance().player.abilities.allowFlying = false;
        Minecraft.getInstance().player.abilities.isFlying = false;
    }

    private void enableNuker(PlayerEntity playerIn)
    {
        playerIn.getEntityWorld().createExplosion(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 5, Explosion.Mode.BREAK);
    }


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, WIDTH, HEIGHT);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void sendMessage(String text, boolean addToChat) {
        new TranslationTextComponent("starwars.chatmsg");
        super.sendMessage(text, true);
    }
}








