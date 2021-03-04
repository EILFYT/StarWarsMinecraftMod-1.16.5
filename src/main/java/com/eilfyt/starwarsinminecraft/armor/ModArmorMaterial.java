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
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 2.0f, () -> {return Ingredient.fromItems(RegistryHandler.KYBERCRYSTAL.get());}, 5),
    DRAGON_SOUL(StarWarsInMinecraft.MOD_ID + ":dragon_soul", 150, new int[] {6, 9, 11, 5 }, 100,
            SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 3.0f, () -> {return Ingredient.fromItems(RegistryHandler.DRAGONSOUL.get());}, 7),
    MAGMA(StarWarsInMinecraft.MOD_ID + ":magma", 80, new int[] {5, 7, 7, 4}, 30,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, () -> {return Ingredient.fromItems(RegistryHandler.MAGMA.get());}, 5);



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

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantibility;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return 0;
    }

}
// package com.CoolDood;
//
//import java.text.NumberFormat;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("pick a number from 1 to 20");
//            int input = scanner.nextInt();
//            long sponge = (long) Math.ceil(Math.random() * 20);
//            if (input == sponge) {
//                System.out.println("WOW YOU WON!");
//            } else {
//                System.out.println("sorry, you were wrong. the answer was " + sponge);
//            }
//    }
//}