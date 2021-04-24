package com.eilfyt.starwarsinminecraft.dimensions;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class ModDimensions {

    public static final RegistryKey<DimensionType> MUSTAFAR_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "mustafar"));
    public static final RegistryKey<World> MUSTAFAR = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "mustafar"));
    public static final RegistryKey<DimensionType> HOTH_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "hoth"));
    public static final RegistryKey<World> HOTH = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "hoth"));
}