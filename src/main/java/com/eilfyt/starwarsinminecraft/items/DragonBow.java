package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.*;

public class DragonBow extends BowItem {
    public DragonBow() {
        super(new Item.Properties().group(StarWarsInMinecraft.TAB)
                .maxStackSize(1)
                .defaultMaxDamage(25)
                .maxDamage(2147)
        );
    }
}
