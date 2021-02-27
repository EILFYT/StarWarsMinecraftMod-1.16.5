package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public class HackerPhone extends Item{
    public HackerPhone() {
        super(new Item.Properties().group(StarWarsInMinecraft.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        Minecraft.getInstance().displayGuiScreen(new HackerPhoneScreen());
    return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
