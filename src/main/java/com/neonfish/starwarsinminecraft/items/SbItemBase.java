package com.neonfish.starwarsinminecraft.items;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.Item;

public class SbItemBase extends Item {
    public SbItemBase()  {
        super(new Item.Properties().group(StarWarsInMinecraft.SB_TAB));
    }
}
