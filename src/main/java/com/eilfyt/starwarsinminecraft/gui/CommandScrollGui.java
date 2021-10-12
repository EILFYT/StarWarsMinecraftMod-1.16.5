package com.eilfyt.starwarsinminecraft.gui;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.CommandSuggestionHelper;
import net.minecraft.client.gui.screen.AbstractCommandBlockScreen;
import net.minecraft.client.gui.screen.CommandBlockScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.common.util.Constants;

public class CommandScrollGui extends Screen {
    protected TextFieldWidget commandEdit;
    public static ItemStack stack;
    private static final int WIDTH = 180;
    private static final int HEIGHT = 216;

    public CommandScrollGui(ItemStack itemStack) {
        super(new TranslationTextComponent("starwars.gui.cmdScroll"));
        this.stack = itemStack;
    }


    @Override
    protected void init() {
        super.init();
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;
        this.commandEdit = new TextFieldWidget(this.font, relX / 2 - 150, 50, 300, 20, new TranslationTextComponent("advMode.command")) {
        };
        this.commandEdit.setMaxLength(32500);
        this.children.add(this.commandEdit);
        this.setInitialFocus(this.commandEdit);
        this.commandEdit.setFocus(true);
    }

    @Override
    public void tick() {
        this.commandEdit.tick();
    }

    @Override
    public void resize(Minecraft p_231152_1_, int p_231152_2_, int p_231152_3_) {
        String s = this.commandEdit.getValue();
        this.init(p_231152_1_, p_231152_2_, p_231152_3_);
        this.commandEdit.setValue(s);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        this.commandEdit.render(matrixStack, mouseX, mouseY, partialTicks);
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
    public void onClose() {
        String commandIn = commandEdit.getValue();
        if (commandIn.startsWith("/")) {
            stack.addTagElement("command", StringNBT.valueOf(commandIn));
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("The command on this Command Scroll has been set to \"" + commandIn + "\"."), Minecraft.getInstance().player.getUUID());
        }
        super.onClose();
    }
}
