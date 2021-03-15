package com.eilfyt.starwarsinminecraft;

import com.eilfyt.starwarsinminecraft.commands.FlyHax;
import com.eilfyt.starwarsinminecraft.commands.ModCommands;
import com.eilfyt.starwarsinminecraft.dimensions.MustafarChunkGenerator;
import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import com.eilfyt.starwarsinminecraft.lists.ParticleList;
import com.eilfyt.starwarsinminecraft.lists.SoundList;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import com.eilfyt.starwarsinminecraft.world.gen.OreGeneration;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("starwars")
public class  StarWarsInMinecraft
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "starwars";

    public StarWarsInMinecraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);



        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ParticleList.PARTICLES.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        EffectRegister.EFFECTS.register(modEventBus);
        EffectRegister.POTIONS.register(modEventBus);
        SoundList.SOUNDS.register(modEventBus);
        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event) {


        OreGeneration.registerOre();
        EffectRegister.addPotionRecipes();
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.PORG.get(), PorgEntity.setCustomAttributes().create());
        });
        ItemModelsProperties.registerProperty(RegistryHandler.DRAGON_SOUL_BOW.get(), new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {

            return p_239428_2_ != null && p_239428_2_.isHandActive() && p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;

        });

        ItemModelsProperties.registerProperty(RegistryHandler.DRAGON_SOUL_BOW.get(), new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {

            if (p_239429_2_ == null) {

                return 0.0F;

            } else {

                return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)(p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;

            }

        });
    }
    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name);
    }




    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("starwarsmod") {

    @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.KYBERCRYSTAL.get());
        }
    };
    public static final ItemGroup E = new ItemGroup("tab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SHREK_BLOCK.get());
        }
    };
    public static final ItemGroup SB_TAB = new ItemGroup("sb_tab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SKYBLOCK_TAB_LOGO.get());
        }
    };
    public static void init(final FMLCommonSetupEvent event) {

          event.enqueueWork(() -> {

              Registry.register(Registry.CHUNK_GENERATOR_CODEC, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "chunkgen"),
                      MustafarChunkGenerator.CODEC);
          });
    }


    @SubscribeEvent
    public void serverLoad(RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
        FlyHax.register(event.getDispatcher());
    }
}