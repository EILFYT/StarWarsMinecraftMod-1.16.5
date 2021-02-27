package com.eilfyt.starwarsinminecraft.dimensions;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class ModDimensions {

    public static final RegistryKey<DimensionType> MUSTAFAR_TYPE = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "mustafar"));
    public static final RegistryKey<World> MUSTAFAR = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "mustafar"));
}