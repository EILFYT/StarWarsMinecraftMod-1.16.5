package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.*;

import java.util.function.Predicate;

public class DragonBow extends BowItem {
    public DragonBow() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB)
                .stacksTo(1)
        );
    }

    @Override
    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return ShootableItem.BULLET;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ShootableItem.BULLET;
    }
}
