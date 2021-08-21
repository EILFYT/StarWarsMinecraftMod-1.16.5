package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.init.RecipeSerializersInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ForgeRecipe implements IRecipe<RecipeWrapper> {

    public static final IRecipeType<ForgeRecipe> FORGE = IRecipeType.register("forge");

    private final IRecipeType<?> type;
    private final ResourceLocation id;
    final String group;
    final Ingredient ingredient;
    final ItemStack result;



    public ForgeRecipe(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result) {
        type = FORGE;
        id = resourceLocation;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;

    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return this.ingredient.test(inv.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializersInit.FORGE.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }



    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(RegistryHandler.IRON_FORGE.get());
    }
}
