package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.blocks.IronForge;
import com.eilfyt.starwarsinminecraft.blocks.IronForgeTileEntity;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, StarWarsInMinecraft.MOD_ID);

    public static final RegistryObject<TileEntityType<IronForgeTileEntity>> IRON_FORGE_TE = TILES.register("iron_forge", () ->
            TileEntityType.Builder.of(IronForgeTileEntity::new, RegistryHandler.IRON_FORGE.get()).build(null));
}
