package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.Item;

public class SbUnstackableBase extends Item {

    public SbUnstackableBase(){
        super(new Item.Properties().tab(StarWarsInMinecraft.SB_TAB)
                .stacksTo(1));
    }
}
