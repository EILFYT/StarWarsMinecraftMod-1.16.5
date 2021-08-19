package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.blocks.BlueLavaFlowing;
import com.eilfyt.starwarsinminecraft.blocks.BlueLavaFluid;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.ThreadContext;

public class FluidInit {

    public static final ResourceLocation BLUE_LAVA_STILL = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "blocks/blue_lava_still");
    public static final ResourceLocation BLUE_LAVA_FLOWING = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "blocks/blue_lava_flowing");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, StarWarsInMinecraft.MOD_ID);

    public static final RegistryObject<FlowingFluid> STILL_BLUE_LAVA = FLUIDS.register("still_blue_lava",
            () -> new BlueLavaFluid.Source());
    public static final RegistryObject<FlowingFluid> FLOWING_BLUE_LAVA = FLUIDS.register("flowing_blue_lava",
            () -> new BlueLavaFluid.Flowing());

    public static final RegistryObject<FlowingFluidBlock> BLUE_LAVA_BLOCK = RegistryHandler.BLOCKS.register("blue_lava_block",
            () -> new FlowingFluidBlock(() -> STILL_BLUE_LAVA.get(), Block.Properties.of(Material.LAVA)
                    .noCollission().noDrops().strength(100)));
    public static final ForgeFlowingFluid.Properties BLUE_LAVA_PROPERTIES = new ForgeFlowingFluid.Properties(
        () -> STILL_BLUE_LAVA.get(), () -> FLOWING_BLUE_LAVA.get(),
        FluidAttributes.builder(BLUE_LAVA_STILL, BLUE_LAVA_FLOWING)).block(() -> FluidInit.BLUE_LAVA_BLOCK.get()).bucket(() -> RegistryHandler.BLUE_LAVA_BUCKET.get());
}
