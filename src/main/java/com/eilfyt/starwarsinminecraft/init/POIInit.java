package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class POIInit extends net.minecraftforge.registries.ForgeRegistryEntry<PointOfInterestType>{
    public static final DeferredRegister<PointOfInterestType> POINT = DeferredRegister.create(ForgeRegistries.POI_TYPES, StarWarsInMinecraft.MOD_ID);

    public POIInit(String name, Set<BlockState> blockStates, int maxFreeTickets, Predicate<PointOfInterestType> predicate, int validRange) {
        this.name = name;
        this.blockStates = blockStates;
        this.maxFreeTickets = maxFreeTickets;
        this.predicate = predicate;
        this.validRange = validRange;
    }

    public static void init() {
        POINT.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    private static final Map<BlockState, PointOfInterestType> POIT_BY_BLOCKSTATE = net.minecraftforge.registries.GameData.getBlockStatePointOfInterestTypeMap();
    public static final PointOfInterestType MUSTAFAR_PORTAL = register("mustafar_portal",  getAllStates(RegistryHandler.MUSTAFAR_PORTAL.get()), 0, 1);

    private final String name;
    private final Set<BlockState> blockStates;
    private final int maxFreeTickets;
    private final Predicate<PointOfInterestType> predicate;
    private final int validRange;

    private static PointOfInterestType registerBlockStates(PointOfInterestType poit) {
        return poit;
    }
    private static PointOfInterestType register(String key, Set<BlockState> blockStates, int maxFreeTickets, int validRange) {
        return registerBlockStates(Registry.register(Registry.POINT_OF_INTEREST_TYPE, new ResourceLocation(key), new PointOfInterestType(key, blockStates, maxFreeTickets, validRange)));
    }

    private static PointOfInterestType register(String key, Set<BlockState> blockStates, int maxFreeTickets, Predicate<PointOfInterestType> predicate, int validRange) {
        return registerBlockStates(Registry.register(Registry.POINT_OF_INTEREST_TYPE, new ResourceLocation(key), new PointOfInterestType(key, blockStates, maxFreeTickets, predicate, validRange)));
    }
    public static Set<BlockState> getAllStates(Block blockIn) {
        return ImmutableSet.copyOf(blockIn.getStateContainer().getValidStates());
    }
    public static Optional<PointOfInterestType> forState(BlockState state) {
        return Optional.ofNullable(POIT_BY_BLOCKSTATE.get(state));
    }

    public ImmutableSet<BlockState> getBlockStates() {
        return ImmutableSet.copyOf(this.blockStates);
    }
}

