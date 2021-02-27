package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class DragonBow extends BowItem {
    public DragonBow() {
        super(new Item.Properties().group(StarWarsInMinecraft.TAB)
                .maxStackSize(1)
                .defaultMaxDamage(25)
                .maxDamage(2147)
        );
    }
}
