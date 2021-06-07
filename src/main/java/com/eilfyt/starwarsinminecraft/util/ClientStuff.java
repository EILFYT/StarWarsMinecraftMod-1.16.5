package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.items.Blaster;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = StarWarsInMinecraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientStuff {
    @SubscribeEvent
    public static void someRandomMethod(FMLClientSetupEvent event) {


        ItemModelsProperties.register(RegistryHandler.KYBERCRYSTAL_SWORD.get(), new ResourceLocation("blocking"), (p_239428_0_, p_239428_1_, p_239428_2_) -> p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F);
        ItemModelsProperties.register(RegistryHandler.KYBRCRYSTAL_SWORD.get(), new ResourceLocation("blocking"), (p_239428_0_, p_239428_1_, p_239428_2_) -> p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F);
        ItemModelsProperties.register(RegistryHandler.KYERCRYSTAL_SWORD.get(), new ResourceLocation("blocking"), (p_239428_0_, p_239428_1_, p_239428_2_) -> p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F);
        ItemModelsProperties.register(RegistryHandler.KBERCRYSTAL_SWORD.get(), new ResourceLocation("blocking"), (p_239428_0_, p_239428_1_, p_239428_2_) -> p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F);

        ItemModelsProperties.register(RegistryHandler.DRAGON_SOUL_BOW.get(), new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F);

        ItemModelsProperties.register(RegistryHandler.DRAGON_SOUL_BOW.get(), new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {

            if (p_239429_2_ == null) {

                return 0.0F;

            } else {

                return p_239429_2_.getUseItem() != p_239429_0_ ? 0.0F : (float)(p_239429_0_.getUseDuration() - p_239429_2_.getUseItemRemainingTicks()) / 20.0F;

            }


        });
        ItemModelsProperties.register(RegistryHandler.BLASTER.get(), new ResourceLocation("pull"),
                (itemStack, clientWorld, livingEntity) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    } else {
                        return Blaster.isCharged(itemStack) ? 0.0F
                                : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks())
                                / (float) Blaster.getChargeTime(itemStack);
                    }
                });
        ItemModelsProperties.register(RegistryHandler.BLASTER.get(), new ResourceLocation("pulling"),
                (itemStack, clientWorld, livingEntity) -> {
                    return livingEntity != null && livingEntity.isUsingItem()
                            && livingEntity.getUseItem() == itemStack && !Blaster.isCharged(itemStack)
                            ? 1.0F
                            : 0.0F;
                });
        ItemModelsProperties.register(RegistryHandler.BLASTER.get(), new ResourceLocation("loaded"),
                (itemStack, clientWorld, livingEntity) -> Blaster.isCharged(itemStack) ? 1.0F : 0.0F);


    }
}
