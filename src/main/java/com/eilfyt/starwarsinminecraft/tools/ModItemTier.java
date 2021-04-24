package com.eilfyt.starwarsinminecraft.tools;

import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    MAGMA(5, 3333, 14.0f, 1.0f, 20, () -> {return Ingredient.of(RegistryHandler.MAGMA.get());}),
    KYBERCRYSTAL(5, 3456, 15.0f, 1.0f, 20, () -> {return Ingredient.of(RegistryHandler.KYBERCRYSTAL.get());}),
    DRAGON_SOUL(6, 4567, 20.0f, 1.0f, 20, () -> {return Ingredient.of(RegistryHandler.DRAGONSOUL.get());}),
    NECRON_BLADE(7, 999999, 40, 1.0f, 30, () -> {return Ingredient.of(RegistryHandler.WITHER_CATALYST.get());});

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }



    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }


    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}
