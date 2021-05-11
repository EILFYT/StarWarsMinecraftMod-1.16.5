package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;

import java.util.function.Predicate;

public abstract class ShootableItem extends Item {
    public static final Predicate<ItemStack> BULLET = (p_220002_0_) -> {
        if( p_220002_0_.getItem() == RegistryHandler.BULLET.get()) {
            return true;
        }
        else{
            return false;
        }
    };

    public ShootableItem(Item.Properties p_i50040_1_) {
        super(p_i50040_1_);
    }


}
