package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.Item;

public class UnstackableItemBase extends Item{


    public UnstackableItemBase() {
            super(new Item.Properties().tab(StarWarsInMinecraft.TAB)
                .stacksTo(1));
    }
}
