package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class FlyTotem extends Item {

    public FlyTotem() {
        super(new Item.Properties().group(StarWarsInMinecraft.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.abilities.allowFlying = true;
        if(worldIn.getGameTime()%(6000)==0)

    {
        playerIn.abilities.allowFlying = false;
    }

        return super.onItemRightClick(worldIn, playerIn, handIn);
}

}
