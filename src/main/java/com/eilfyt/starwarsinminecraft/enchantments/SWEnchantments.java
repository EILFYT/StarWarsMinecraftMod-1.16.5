package com.eilfyt.starwarsinminecraft.enchantments;
import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class SWEnchantments {

        public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, StarWarsInMinecraft.MOD_ID);

        public static final RegistryObject<Enchantment> WITHER_IMPACT = ENCHANTMENTS.register("wither_impact", () -> new WitherImpactEnchant(Enchantment.Rarity.VERY_RARE));
    }

