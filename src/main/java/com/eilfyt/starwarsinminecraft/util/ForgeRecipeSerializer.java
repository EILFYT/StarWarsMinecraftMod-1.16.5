package com.eilfyt.starwarsinminecraft.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ForgeRecipeSerializer<T extends ForgeRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {


    private final ForgeRecipeSerializer.IFactory<T> factory;

    public ForgeRecipeSerializer(IFactory<T> factory) {
        this.factory = factory;
    }


    @Override
    @Nonnull
    public T fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        // group
        String groupString = JSONUtils.getAsString(json, "group", "");

        // ingredient
        JsonElement ingredientJSON = JSONUtils.isArrayNode(json, "ingredient") ? JSONUtils.getAsJsonArray(json, "ingredient") : JSONUtils.getAsJsonObject(json, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(ingredientJSON);



        // result
        ItemStack resultItemStack;
        if (!json.has("result")) {
            resultItemStack = ItemStack.EMPTY;
        }
        else if (json.get("result").isJsonObject() ) {
            resultItemStack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
        } else {
            String resultString = JSONUtils.getAsString(json, "result");
            ResourceLocation resultRS = new ResourceLocation(resultString);
            resultItemStack = new ItemStack(ForgeRegistries.ITEMS.getValue(resultRS));
        }

        // cookTime

        return this.factory.create(recipeId, groupString, ingredient, resultItemStack);
    }

    @Nullable
    @Override
    public T fromNetwork(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
        // group
        String groupString = buffer.readUtf(32767);

        // ingredient
        Ingredient ingredient = Ingredient.fromNetwork(buffer);

        // result
        ItemStack itemstack = buffer.readItem();

        // cookTime
        int cookTime = buffer.readVarInt();

        return this.factory.create(recipeId, groupString, ingredient, itemstack);
    }

    @Override
    public void toNetwork(PacketBuffer buffer, T recipe) {
        // group
        buffer.writeUtf(recipe.group);

        // ingredient
        recipe.ingredient.toNetwork(buffer);

        // result
        buffer.writeItem(recipe.result);
    }

    public interface IFactory<T extends ForgeRecipe> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result);
    }
}