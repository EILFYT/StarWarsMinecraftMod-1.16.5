package com.eilfyt.starwarsinminecraft.armor;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    //kybercrystal_layer_1
    //kybercrystal_layer_2
    KYBERCRYSTAL(StarWarsInMinecraft.MOD_ID + ":kybercrystal", 100, new int[] { 5, 7, 8, 4 }, 120,
            SoundEvents.ARMOR_EQUIP_TURTLE, 2.0f, () -> {return Ingredient.of(RegistryHandler.KYBERCRYSTAL.get());}, 5),
    DRAGON_SOUL(StarWarsInMinecraft.MOD_ID + ":dragon_soul", 150, new int[] {6, 9, 11, 5 }, 100,
            SoundEvents.ARMOR_EQUIP_ELYTRA, 3.0f, () -> {return Ingredient.of(RegistryHandler.DRAGONSOUL.get());}, 7),
    MAGMA(StarWarsInMinecraft.MOD_ID + ":magma", 80, new int[] {5, 7, 7, 4}, 30,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0f, () -> {return Ingredient.of(RegistryHandler.MAGMA.get());}, 5);



    private static final int[]  MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantibility;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantibility,
                     SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
       this.name = name;
       this.maxDamageFactor = maxDamageFactor;
       this.damageReductionAmountArray = damageReductionAmountArray;
       this.enchantibility = enchantibility;
       this.soundEvent = soundEvent;
       this.toughness = toughness;
       this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }


    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantibility;
    }


    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }


    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return this.damageReductionAmountArray[p_200902_1_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantibility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}