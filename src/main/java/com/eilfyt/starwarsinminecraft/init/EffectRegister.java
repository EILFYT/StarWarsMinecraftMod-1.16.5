package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.effects.KillEffect;
import com.eilfyt.starwarsinminecraft.effects.SugarRushEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectRegister {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, StarWarsInMinecraft.MOD_ID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, StarWarsInMinecraft.MOD_ID);
    public static void init() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Effect> KEEL = EFFECTS.register("healing", KillEffect::new);
    public static final RegistryObject<Potion> KEEL_POTION = POTIONS.register("healing_potion", () -> new Potion(new EffectInstance(KEEL.get(), 200, 0)));
    public static final RegistryObject<Effect> SUGAR_RUSH = EFFECTS.register("sugar_rush", SugarRushEffect::new);
    public static final RegistryObject<Potion> SUGAR_POTION = POTIONS.register("sugar_pot", () -> new Potion(new EffectInstance(SUGAR_RUSH.get(), 20, 0)));

    public static void addPotionRecipes() {
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.ROTTEN_FLESH, KEEL_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(KEEL_POTION.get(), Items.SUGAR, SUGAR_POTION.get()));
    }

    private static class BetterBrewingRecipe implements IBrewingRecipe {
        private final Potion bottleInput;
        private final Item itemInput;
        private final ItemStack output;

        public BetterBrewingRecipe(Potion bottleInputIn, Item itemInputIn, Potion outputIn) {
            this.bottleInput = bottleInputIn;
            this.itemInput = itemInputIn;
            this.output = PotionUtils.setPotion(new ItemStack(Items.POTION), outputIn);
        }


        @Override
        public boolean isInput(ItemStack input) {
            return PotionUtils.getPotion(input).equals(this.bottleInput);
        }

        @Override
        public boolean isIngredient(ItemStack ingredient) {
            return ingredient.getItem().equals(this.itemInput);
        }

        @Override
        public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
            if (isInput(input) && isIngredient(ingredient)){
                return this.output.copy();
            } else {
                return ItemStack.EMPTY;
            }
        }
    }
}
