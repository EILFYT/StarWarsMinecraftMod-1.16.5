package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.armor.ModArmorMaterial;
import com.eilfyt.starwarsinminecraft.blocks.*;
import com.eilfyt.starwarsinminecraft.init.FluidInit;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import com.eilfyt.starwarsinminecraft.items.*;
import com.eilfyt.starwarsinminecraft.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.ThreadContext;

public class RegistryHandler {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StarWarsInMinecraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StarWarsInMinecraft.MOD_ID);




    //items go here
    public static final RegistryObject<BulletItem> BULLET = ITEMS.register("bullet", BulletItem::new);
    public static final RegistryObject<Item> KYBERCRYSTAL = ITEMS.register("kyber_crystal", ItemBase::new);
    public static final RegistryObject<NukeTargetingDevice> NUKE_TARGETING_DEVICE = ITEMS.register("nuke_targeting_device", NukeTargetingDevice::new);
    public static final RegistryObject<Item> DRAGONSOUL = ITEMS.register("dragon_soul", ItemBase::new);
    public static final RegistryObject<Item> saberhandle = ITEMS.register("saber_handle", ItemBase::new);
    public static final RegistryObject<Item> crystal = ITEMS.register("crystal", ItemBase::new);
    public static final RegistryObject<Item> nethercrystal = ITEMS.register("nether_crystal", ItemBase::new);
    public static final RegistryObject<Item> battery = ITEMS.register("battery", ItemBase::new);
    public static final RegistryObject<Item> RED_POWDER = ITEMS.register("red_powder", ItemBase::new);
    public static final RegistryObject<Item> GREEN_POWDER = ITEMS.register("green_powder", ItemBase::new);
    public static final RegistryObject<IceCream> KYBER_APPLE = ITEMS.register("kyber_apple", IceCream::new);
    public static final RegistryObject<EnchantedKyberApple> ENCHANTED_KYBER_APPLE = ITEMS.register("enchanted_kyber_apple", EnchantedKyberApple::new);
    public static final RegistryObject<ModSpawnEggItem> PORG_SPAWN_EGG = ITEMS.register("porg_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.PORG, 0xFF861B, 0xF5D6BA, new Item.Properties().tab(StarWarsInMinecraft.TAB)));
    public static final RegistryObject<ModSpawnEggItem> DRAGON_ARCHER_SPAWN_EGG = ITEMS.register("dragon_archer_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.DRAGON_ARCHER, 0x000001, 0x8800DA, new Item.Properties().tab(StarWarsInMinecraft.TAB)));
    public static final RegistryObject<DragonBowItem> DRAGON_SOUL_BOW = ITEMS.register("dragon_soul_bow", DragonBow::new);
    public static final RegistryObject<CrossbowItem> BLASTER = ITEMS.register("blaster",  Blaster::new);
    public static final RegistryObject<Item> FUNNEL = ITEMS.register("funnel", ItemBase::new);
    public static final RegistryObject<SugarFunnel> SUGAR_FUNNEL = ITEMS.register("sugar_funnel", SugarFunnel::new);
    public static final RegistryObject<Item> NECRON_HANDLE = ITEMS.register("necrons_handle", SbUnstackableBase::new);
    public static final RegistryObject<Item> WITHER_CATALYST = ITEMS.register("wither_catalyst", SbItemBase::new);
    public static final RegistryObject<Item> SKYBLOCK_TAB_LOGO = ITEMS.register("sb_logo_for_tab_list_with_very_long_name_for_no_reason_at_all", NoTab::new);
    public static final RegistryObject<Item> LASRS_EYE = ITEMS.register("lasrs_eye", SbItemBase::new);
    public static final RegistryObject<Item> DIAMANTES_HANDLE = ITEMS.register("diamante_handle", SbItemBase::new);
    public static final RegistryObject<Item> MAGMA = ITEMS.register("magma", ItemBase::new);
    public static final RegistryObject<Item> ROD_OF_DISCORD = ITEMS.register("rod_of_discord", RodOfDiscord::new);
    public static final RegistryObject<BucketItem> BLUE_LAVA_BUCKET = ITEMS.register("blue_lava_bucket",
            () -> new BucketItem(() -> FluidInit.STILL_BLUE_LAVA.get(),
                    new Item.Properties().tab(StarWarsInMinecraft.TAB).stacksTo(1)));
//idek anymore man


    //blocks go here
    public static final RegistryObject<Block> KYBER_BLOCK = BLOCKS.register("kyber_block", KyberBlock::new);
    public static final RegistryObject<Block> DRAGON_SOUL_FRAGMENT = BLOCKS.register("dragon_soul_fragment", DragonSoulFragment::new);
    public static final RegistryObject<Block> SHREK_BLOCK = BLOCKS.register("shrek_block", ShrekBlock::new);
    public static final RegistryObject<Block> PLASTIC_BLOCK = BLOCKS.register("plastic_block", PlasticBlock::new);
    public static final RegistryObject<Block> RED_PLASTIC_BLOCK = BLOCKS.register("red_plastic_block", RedPlasticBlock::new);
    public static final RegistryObject<Block> HIDEY_KYBER_BLOCK = BLOCKS.register("hidey_kyber_block", HideyKyberBlock::new);
    public static final RegistryObject<Block> CRYSTAL_ORE_BLOCK = BLOCKS.register("crystal_ore", CrystalOreBlock::new);
    public static final RegistryObject<Block> NETHER_CRYSTAL_ORE_BLOCK = BLOCKS.register("nether_crystal_ore", NetherCrystalOreBlock::new);
    public static final RegistryObject<Block> MAGMA_ORE = BLOCKS.register("magma_ore", MagmaOreBlock::new);
    public static final RegistryObject<Block> BLACKSTONEE = BLOCKS.register("blackstone_two", BlackstoneBlock::new);
    public static final RegistryObject<Block> VERTICAL_KYBER_SLAB_BLOCK = BLOCKS.register("vertical_kyber_slab", VerticalKyberSlab::new);
    public static final RegistryObject<Block> IRON_FORGE = BLOCKS.register("iron_forge", IronForge::new);
    public static final RegistryObject<Block> DIAMOND_FORGE = BLOCKS.register("diamond_forge", DiamondForge::new);
    public static final RegistryObject<Block> NETHERITE_FORGE = BLOCKS.register("netherite_forge", NetheriteForge::new);
    public static final RegistryObject<Block> KYBER_FORGE = BLOCKS.register("kyber_forge", KyberForge::new);


    //block items
    public static final RegistryObject<Item> KYBER_BLOCK_ITEM = ITEMS.register("kyber_block", () -> new BlockItemBase(KYBER_BLOCK.get()));
    public static final RegistryObject<Item> DRAGON_SOUL_FRAGMENT_ITEM = ITEMS.register("dragon_soul_fragment", () -> new BlockItemBase(DRAGON_SOUL_FRAGMENT.get()));
    public static final RegistryObject<Item> SHREK_BLOCK_ITEM = ITEMS.register("shrek_block", () -> new A(SHREK_BLOCK.get()));
    public static final RegistryObject<Item> PLASTIC_BLOCK_ITEM = ITEMS.register("plastic_block", () -> new BlockItemBase(PLASTIC_BLOCK.get()));
    public static final RegistryObject<Item> RED_PLASTIC_BLOCK_ITEM = ITEMS.register("red_plastic_block", () -> new BlockItemBase(RED_PLASTIC_BLOCK.get()));
    public static final RegistryObject<Item> HIDEY_KYBER_BLOCK_ITEM = ITEMS.register("hidey_kyber_block", () -> new BlockItemBase(HIDEY_KYBER_BLOCK.get()));
    public static final RegistryObject<Item> CRYSTAL_ORE_BLOCK_ITEM = ITEMS.register("crystal_ore", () -> new BlockItemBase(CRYSTAL_ORE_BLOCK.get()));
    public static final RegistryObject<Item> NETHER_CRYSTAL_ORE_BLOCK_ITEM = ITEMS.register("nether_crystal_ore",() -> new BlockItemBase(NETHER_CRYSTAL_ORE_BLOCK.get()));
    public static final RegistryObject<Item> MAGMA_ORE_ITEM = ITEMS.register("magma_ore",() -> new BlockItemBase(MAGMA_ORE.get()));
    public static final RegistryObject<Item> VERTICAL_KYBER_SLAB_BLOCK_ITEM = ITEMS.register("vertical_kyber_slab",() -> new BlockItemBase(VERTICAL_KYBER_SLAB_BLOCK.get()));
    public static final RegistryObject<Item> IRON_FORGE_ITEM = ITEMS.register("iron_forge",() -> new BlockItemBase(IRON_FORGE.get()));
    public static final RegistryObject<Item> DIAMOND_FORGE_ITEM = ITEMS.register("diamond_forge",() -> new BlockItemBase(DIAMOND_FORGE.get()));
    public static final RegistryObject<Item> NETHERITE_FORGE_ITEM = ITEMS.register("netherite_forge", () -> new BlockItemBase(NETHERITE_FORGE.get()));
    public static final RegistryObject<Item> KYBER_FORGE_ITEM = ITEMS.register("kyber_forge", () -> new BlockItemBase(KYBER_FORGE.get()));


    //tools go here
    public static final RegistryObject<Lightsaber> KYBERCRYSTAL_SWORD = ITEMS.register("blue_lightsaber", Lightsaber::new
            );
    public static final RegistryObject<Lightsaber> KBERCRYSTAL_SWORD = ITEMS.register("green_lightsaber", Lightsaber::new
    );
    public static final RegistryObject<Lightsaber> KYBRCRYSTAL_SWORD = ITEMS.register("red_lightsaber", Lightsaber::new
    );
    public static final RegistryObject<Lightsaber> KYERCRYSTAL_SWORD = ITEMS.register("purple_lightsaber", Lightsaber::new
    );

    public static final RegistryObject<PickaxeItem> KYBERCRYSTAL_PICKAXE = ITEMS.register("kyber_pickaxe", () ->
            new PickaxeItem(ModItemTier.KYBERCRYSTAL, 6, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<AxeItem> KYBERCRYSTAL_AXE = ITEMS.register("kyber_axe", () ->
            new AxeItem(ModItemTier.KYBERCRYSTAL, 18, -2.4f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<ShovelItem> KYBERCRYSTAL_SHOVEL = ITEMS.register("kyber_shovel", () ->
            new ShovelItem(ModItemTier.KYBERCRYSTAL, 5, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<HoeItem> KYBERCRYSTAL_HOE = ITEMS.register("kyber_hoe", () ->
            new HoeItem(ModItemTier.KYBERCRYSTAL, 4, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<SwordItem> DRAGON_SOUL_SWORD = ITEMS.register("dragon_soul_sword", () ->
            new SwordItem(ModItemTier.DRAGON_SOUL, 18, 1000.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<PickaxeItem> DRAGON_SOUL_PICKAXE = ITEMS.register("dragon_soul_pickaxe", () ->
            new PickaxeItem(ModItemTier.DRAGON_SOUL, 7, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<AxeItem> DRAGON_SOUL_AXE = ITEMS.register("dragon_soul_axe", () ->
            new AxeItem(ModItemTier.DRAGON_SOUL, 20, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<ShovelItem> DRAGON_SOUL_SHOVEL = ITEMS.register("dragon_soul_shovel", () ->
            new ShovelItem(ModItemTier.DRAGON_SOUL, 6, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<HoeItem> DRAGON_SOUL_HOE = ITEMS.register("dragon_soul_hoe", () ->
            new HoeItem(ModItemTier.DRAGON_SOUL, 5, -2.0f, new Item.Properties().tab(StarWarsInMinecraft.TAB))
    );

    public static final RegistryObject<SwordItem> MAGMA_SWORD = ITEMS.register("magma_sword", () ->
            new SwordItem(ModItemTier.MAGMA, 15, 1000f, new Item.Properties().tab(StarWarsInMinecraft.TAB)
            ));

    public static final RegistryObject<PickaxeItem> MAGMA_PICKAXE = ITEMS.register("magma_pickaxe", () ->
            new PickaxeItem(ModItemTier.MAGMA, 5, -2f, new Item.Properties().tab(StarWarsInMinecraft.TAB)
            ));

    public static final RegistryObject<AxeItem> MAGMA_AXE = ITEMS.register("magma_axe", () ->
            new AxeItem(ModItemTier.MAGMA, 17, -2.4f, new Item.Properties().tab(StarWarsInMinecraft.TAB)
            ));
    public static final RegistryObject<ShovelItem> MAGMA_SHOVEL = ITEMS.register("magma_shovel", () ->
            new ShovelItem(ModItemTier.MAGMA, 4, -2f, new Item.Properties().tab(StarWarsInMinecraft.TAB)
            ));

    public static final RegistryObject<HoeItem> MAGMA_HOE = ITEMS.register("magma_hoe", () ->
            new HoeItem(ModItemTier.MAGMA, 3, -2f, new Item.Properties().tab(StarWarsInMinecraft.TAB)
            ));

    public static final RegistryObject<SwordItem> NECRONS_BLADE_UNREFINED = ITEMS.register("necrons_blade", () ->
            new SwordItem(ModItemTier.NECRON_BLADE, 38, 1000.0f, new Item.Properties().tab(StarWarsInMinecraft.SB_TAB))
    );
    public static final RegistryObject<Hyperion> HYPERION = ITEMS.register("hyperion", Hyperion::new);
    public static final RegistryObject<Hyperion> VALKYRIE = ITEMS.register("valkyrie", Hyperion::new);



    //armor
    public static final RegistryObject<ArmorItem> KYBER_HELMET = ITEMS.register("kyber_helmet", () ->
            new ArmorItem(ModArmorMaterial.KYBERCRYSTAL, EquipmentSlotType.HEAD, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<ArmorItem> KYBER_LEGGINGS = ITEMS.register("kyber_leggings", () ->
            new ArmorItem(ModArmorMaterial.KYBERCRYSTAL, EquipmentSlotType.LEGS, new Item.Properties().tab(StarWarsInMinecraft.TAB)));


    public static final RegistryObject<ArmorItem> KYBER_CHESTPLATE = ITEMS.register("kyber_chestplate", () ->
            new ArmorItem(ModArmorMaterial.KYBERCRYSTAL, EquipmentSlotType.CHEST, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<ArmorItem> KYBER_BOOTS = ITEMS.register("kyber_boots", () ->
            new ArmorItem(ModArmorMaterial.KYBERCRYSTAL, EquipmentSlotType.FEET, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<ArmorItem> DRAGON_SOUL_HELMET = ITEMS.register("dragon_soul_helmet", () ->
            new ArmorItem(ModArmorMaterial.DRAGON_SOUL, EquipmentSlotType.HEAD, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<ArmorItem> DRAGON_SOUL_CHESTPLATE = ITEMS.register("dragon_soul_chestplate", () ->
            new ArmorItem(ModArmorMaterial.DRAGON_SOUL, EquipmentSlotType.CHEST, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<ArmorItem> DRAGON_SOUL_LEGGINGS = ITEMS.register("dragon_soul_leggings", () ->
            new ArmorItem(ModArmorMaterial.DRAGON_SOUL, EquipmentSlotType.LEGS, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<ArmorItem> DRAGON_SOUL_BOOTS = ITEMS.register("dragon_soul_boots", () ->
            new ArmorItem(ModArmorMaterial.DRAGON_SOUL, EquipmentSlotType.FEET, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<MagmaArmor> MAGMA_HELMET = ITEMS.register("magma_helmet", () ->
            new MagmaArmor(ModArmorMaterial.MAGMA, EquipmentSlotType.HEAD, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<MagmaArmor> MAGMA_CHESTPLATE = ITEMS.register("magma_chestplate", () ->
            new MagmaArmor(ModArmorMaterial.MAGMA, EquipmentSlotType.CHEST, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<MagmaArmor> MAGMA_LEGGINGS = ITEMS.register("magma_leggings", () ->
            new MagmaArmor(ModArmorMaterial.MAGMA, EquipmentSlotType.LEGS, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    public static final RegistryObject<MagmaArmor> MAGMA_BOOTS = ITEMS.register("magma_boots", () ->
            new MagmaArmor(ModArmorMaterial.MAGMA, EquipmentSlotType.FEET, new Item.Properties().tab(StarWarsInMinecraft.TAB)));

    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }

}
