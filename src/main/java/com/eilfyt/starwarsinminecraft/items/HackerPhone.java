package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

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
