package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.*;

public class DragonBow extends BowItem {
    public DragonBow() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB)
                .stacksTo(1)
        );
    }
}
