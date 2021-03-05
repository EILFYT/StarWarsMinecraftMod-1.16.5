package com.neonfish.starwarsinminecraft.items;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.Item;

public class UnstackableItemBase extends Item{


    public UnstackableItemBase() {
            super(new Item.Properties().group(StarWarsInMinecraft.TAB)
                .maxStackSize(1));
    }
}
