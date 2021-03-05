package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.Item;

public class SbUnstackableBase extends Item {

    public SbUnstackableBase(){
        super(new Item.Properties().group(StarWarsInMinecraft.SB_TAB)
                .maxStackSize(1));
    }
}
