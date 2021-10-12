package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.gui.CommandScrollGui;
import javafx.beans.property.StringProperty;
import net.minecraft.block.CommandBlockBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.command.impl.ExecuteCommand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CommandBookItem extends Item {
    public CommandBookItem() {
        super(new Properties().tab(StarWarsInMinecraft.TAB).stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        if (p_77659_3_ == Hand.MAIN_HAND) {
            Minecraft.getInstance().setScreen(new CommandScrollGui(p_77659_2_.getItemInHand(p_77659_3_)));
        } else {
            Minecraft.getInstance().player.chat(p_77659_2_.getItemInHand(p_77659_3_).getTag().getString("command"));
        }
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
