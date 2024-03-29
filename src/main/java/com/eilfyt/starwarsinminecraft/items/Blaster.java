package com.eilfyt.starwarsinminecraft.items;

import java.util.List;
        import java.util.Random;
        import java.util.function.Predicate;

        import javax.annotation.Nullable;

        import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
        import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
        import com.google.common.collect.Lists;
        import net.minecraft.advancements.CriteriaTriggers;
        import net.minecraft.client.util.ITooltipFlag;
        import net.minecraft.enchantment.EnchantmentHelper;
        import net.minecraft.enchantment.Enchantments;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.ICrossbowUser;
        import net.minecraft.entity.LivingEntity;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.entity.player.ServerPlayerEntity;
        import net.minecraft.entity.projectile.AbstractArrowEntity;
        import net.minecraft.entity.projectile.FireworkRocketEntity;
        import net.minecraft.entity.projectile.ProjectileEntity;
        import net.minecraft.item.*;
        import net.minecraft.nbt.CompoundNBT;
        import net.minecraft.nbt.ListNBT;
        import net.minecraft.stats.Stats;
        import net.minecraft.util.ActionResult;
        import net.minecraft.util.Hand;
        import net.minecraft.util.SoundCategory;
        import net.minecraft.util.SoundEvents;
        import net.minecraft.util.math.vector.Quaternion;
        import net.minecraft.util.math.vector.Vector3d;
        import net.minecraft.util.math.vector.Vector3f;
        import net.minecraft.util.text.ITextComponent;
        import net.minecraft.util.text.TextFormatting;
        import net.minecraft.util.text.TranslationTextComponent;
        import net.minecraft.world.World;
        import net.minecraftforge.api.distmarker.Dist;
        import net.minecraftforge.api.distmarker.OnlyIn;

public class Blaster extends CrossbowItem
{
    public Blaster() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB)
                .stacksTo(1)
                .fireResistant()
        );
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ShootableItem.BULLET;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {


        ItemStack gun = player.getItemInHand(hand);
        ItemStack itemstack = player.getProjectile(player.getUseItem());
        itemstack = new ItemStack(RegistryHandler.BULLET.get());
        if(true == !itemstack.isEmpty() || player.abilities.invulnerable) {
            fireProjectiles(world, player, hand, gun, 100, 0);
            fireProjectile(world, player, hand, gun, itemstack, 1f, player.abilities.invulnerable, 35, 0, 0);
            return ActionResult.consume(gun);
        }
        else return ActionResult.fail(gun);
    }

    @Override
    public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
    {
        int i = this.getUseDuration(stack);
        float f = getCharge(i, stack);

        if (f >= 0.6F && !isCharged(stack) && hasAmmo(entityLiving, stack))
        {
            setCharged(stack, true);
            SoundCategory soundcategory = entityLiving instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
            worldIn.playSound((PlayerEntity)null, entityLiving.getX(), entityLiving.getY(), entityLiving.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
        }
    }

    public static void fireProjectiles(World worldIn, LivingEntity shooter, Hand handIn, ItemStack stack, float velocityIn, float inaccuracyIn)
    {
        List<ItemStack> list = getChargedProjectiles(stack);
        float[] afloat = getRandomSoundPitches(shooter.getRandom());

        for(int i = 0; i < list.size(); ++i)
        {
            ItemStack itemstack = list.get(i);
            boolean flag = shooter instanceof PlayerEntity && ((PlayerEntity)shooter).abilities.invulnerable;
            if (!itemstack.isEmpty())
            {
                if (i == 0) {
                    fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, 0.0F);
                }
                else if (i == 1)
                {
                    fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, -10.0F);
                }
                else if (i == 2)
                {
                    fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, 10.0F);
                }
            }
        }

        fireProjectilesAfter(worldIn, shooter, stack);
    }

    private static void fireProjectile(World worldIn, LivingEntity shooter, Hand handIn, ItemStack crossbow, ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy, float projectileAngle)
    {
        if (!worldIn.isClientSide)
        {
            ProjectileEntity projectileentity;


                projectileentity = createArrow(worldIn, shooter, crossbow, projectile);
                if (isCreativeMode || projectileAngle != 0.0F)
                {
                    ((AbstractArrowEntity)projectileentity).pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                }


            if (shooter instanceof ICrossbowUser)
            {
                ICrossbowUser icrossbowuser = (ICrossbowUser)shooter;
                icrossbowuser.shootCrossbowProjectile(icrossbowuser.getTarget(), crossbow, projectileentity, projectileAngle);
            }
            else
            {
                Vector3d vec3d1 = shooter.getUpVector(1.0F);
                Quaternion quaternion = new Quaternion(new Vector3f(vec3d1), projectileAngle, true);
                Vector3d vec3d = shooter.getViewVector(1.0F);
                Vector3f vector3f = new Vector3f(vec3d);
                vector3f.transform(quaternion);
                projectileentity.shoot((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), velocity, inaccuracy);
            }

            crossbow.setDamageValue(crossbow.getDamageValue() - 1);
            worldIn.addFreshEntity(projectileentity);
            worldIn.playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
        }
    }
    public boolean shouldConsumeAmmo(ItemStack stack, PlayerEntity player) {

        return true;
    }

    private static AbstractArrowEntity createArrow(World worldIn, LivingEntity shooter, ItemStack crossbow, ItemStack ammo )
    {
        BulletItem arrowitem = (BulletItem) (ammo.getItem() instanceof BulletItem ? ammo.getItem() : RegistryHandler.BULLET.get());
        AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, shooter);
        abstractarrowentity.isCritArrow();
        abstractarrowentity.setSoundEvent(SoundEvents.CROSSBOW_HIT);
        abstractarrowentity.setShotFromCrossbow(true);
        abstractarrowentity.setPierceLevel((byte)5);

        return abstractarrowentity;
    }

    private static void fireProjectilesAfter(World worldIn, LivingEntity shooter, ItemStack stack)
    {
        if (shooter instanceof ServerPlayerEntity)
        {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)shooter;
            if (!worldIn.isClientSide)
            {
                CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayerentity, stack);
            }

            serverplayerentity.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        }

        clearProjectiles(stack);
    }

    private static void clearProjectiles(ItemStack stack)
    {
        CompoundNBT compoundnbt = stack.getTag();
        if (compoundnbt != null)
        {
            ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 9);
            listnbt.clear();
            compoundnbt.put("ChargedProjectiles", listnbt);
        }
    }

    private static float[] getRandomSoundPitches(Random rand)
    {
        boolean flag = rand.nextBoolean();
        return new float[]{1.0F, getRandomSoundPitch(flag), getRandomSoundPitch(!flag)};
    }

    private static float getRandomSoundPitch(boolean flagIn)
    {
        float f = flagIn ? 0.63F : 0.43F;
        return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
    }

    private static List<ItemStack> getChargedProjectiles(ItemStack stack)
    {
        List<ItemStack> list = Lists.newArrayList();
        CompoundNBT compoundnbt = stack.getTag();

        if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9))
        {
            ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 10);
            if (listnbt != null)
            {
                for(int i = 0; i < listnbt.size(); ++i)
                {
                    CompoundNBT compoundnbt1 = listnbt.getCompound(i);
                    list.add(ItemStack.of(compoundnbt1));
                }
            }
        }

        return list;
    }

    public static void setCharged(ItemStack stack, boolean chargedIn)
    {
        CompoundNBT compoundnbt = stack.getOrCreateTag();
        compoundnbt.putBoolean("Charged", chargedIn);
    }

    public static boolean isCharged(ItemStack stack)
    {
        CompoundNBT compoundnbt = stack.getTag();
        return compoundnbt != null && compoundnbt.getBoolean("Charged");
    }

    public int getUseDuration(ItemStack stack)
    {
        return getChargeTime(stack) + 3;
    }


    public static int getChargeTime(ItemStack stack)
    {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
        return i == 0 ? 25 : 25 - 5 * i;
    }

    private static float getCharge(int useTime, ItemStack stack)
    {
        float f = (float)useTime / (float)getChargeTime(stack);
        if (f > 0.6F)
        {
            f = 0.6F;
        }

        return f;
    }

    private static boolean hasAmmo(LivingEntity entityIn, ItemStack stack)
    {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, stack);
        int j = i == 0 ? 1 : 3;

        boolean flag = entityIn instanceof PlayerEntity && ((PlayerEntity)entityIn).abilities.invulnerable;

        ItemStack itemstack = entityIn.getProjectile(stack);
        ItemStack itemstack1 = itemstack.copy();

        for(int k = 0; k < j; ++k)
        {
            if (k > 0)
            {
                itemstack = itemstack1.copy();
            }

            if (itemstack.isEmpty() && flag)
            {
                itemstack = new ItemStack(RegistryHandler.BULLET.get());
                itemstack1 = itemstack.copy();
            }

            if (!func_220023_a(entityIn, stack, itemstack, k > 0, flag))
            {
                return false;
            }
        }

        return true;
    }

    private static boolean func_220023_a(LivingEntity p_220023_0_, ItemStack p_220023_1_, ItemStack p_220023_2_, boolean p_220023_3_, boolean p_220023_4_)
    {
        if (p_220023_2_.isEmpty())
        {
            return false;
        }
        else
        {
            boolean flag = p_220023_4_ && p_220023_2_.getItem() instanceof BulletItem;
            ItemStack itemstack;

            if (!flag && !p_220023_4_ && !p_220023_3_)
            {
                itemstack = p_220023_2_.split(1);

                if (p_220023_2_.isEmpty() && p_220023_0_ instanceof PlayerEntity)
                {
                    ((PlayerEntity)p_220023_0_).inventory.removeItem(p_220023_2_);
                }
            }
            else
            {
                itemstack = p_220023_2_.copy();
            }

            addChargedProjectile(p_220023_1_, itemstack);

            return true;
        }
    }

    private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile)
    {
        CompoundNBT compoundnbt = crossbow.getOrCreateTag();
        ListNBT listnbt;

        if (compoundnbt.contains("ChargedProjectiles", 9))
        {
            listnbt = compoundnbt.getList("ChargedProjectiles", 10);
        }
        else
        {
            listnbt = new ListNBT();
        }
        CompoundNBT compoundnbt1 = new CompoundNBT();
        projectile.save(compoundnbt1);
        listnbt.add(compoundnbt1);
        compoundnbt.put("ChargedProjectiles", listnbt);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return true;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == RegistryHandler.KYBERCRYSTAL.get();
    }
}
