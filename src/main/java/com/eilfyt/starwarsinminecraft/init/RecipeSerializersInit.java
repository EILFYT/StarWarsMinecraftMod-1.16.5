package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.util.ForgeRecipe;
import com.eilfyt.starwarsinminecraft.util.ForgeRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializersInit {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, StarWarsInMinecraft.MOD_ID);

    public static final RegistryObject<ForgeRecipeSerializer<ForgeRecipe>> FORGE =
            RECIPE_SERIALIZER.register("forge",new ForgeRecipeSerializer(ForgeRecipe::new));

}
