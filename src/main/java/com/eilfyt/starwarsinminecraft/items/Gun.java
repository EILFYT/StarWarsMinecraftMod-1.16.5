package com.eilfyt.starwarsinminecraft.items;


        import java.util.List;
        import java.util.function.Predicate;
        import java.util.function.Supplier;

        import javax.annotation.Nullable;

        import com.eilfyt.starwarsinminecraft.entities.BulletEntity;
        import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
        import net.minecraft.client.gui.screen.Screen;
        import net.minecraft.client.util.ITooltipFlag;
        import net.minecraft.enchantment.Enchantment;
        import net.minecraft.enchantment.EnchantmentHelper;
        import net.minecraft.enchantment.Enchantments;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.entity.projectile.AbstractArrowEntity;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.ShootableItem;
        import net.minecraft.item.UseAction;
        import net.minecraft.item.crafting.Ingredient;
        import net.minecraft.stats.Stats;
        import net.minecraft.util.ActionResult;
        import net.minecraft.util.Hand;
        import net.minecraft.util.SoundCategory;
        import net.minecraft.util.SoundEvent;
        import net.minecraft.util.text.ITextComponent;
        import net.minecraft.util.text.TextFormatting;
        import net.minecraft.util.text.TranslationTextComponent;
        import net.minecraft.world.World;
        import net.minecraftforge.api.distmarker.Dist;
        import net.minecraftforge.api.distmarker.OnlyIn;

public class Gun extends ShootableItem {
    protected int bonusDamage;
    protected double damageMultiplier;
    protected int fireDelay;
    protected double inaccuracy;
    protected double projectileSpeed = 3;
    private int enchantability;
    protected boolean ignoreInvulnerability = false;
    protected double chanceFreeShot = 0;
    protected Supplier<Ingredient> repairMaterial;

    public Gun(Properties properties, int bonusDamage, double damageMultiplier, int fireDelay, double inaccuracy, int enchantability) {
        super(properties);
        this.bonusDamage = bonusDamage;
        this.damageMultiplier = damageMultiplier;
        this.enchantability = enchantability;
        this.fireDelay = fireDelay;
        this.inaccuracy = inaccuracy;
    }

    public Gun(Properties tab) {
        super(tab);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack gun = player.getItemInHand(hand);
        //"Oh yeah I will use the vanilla method so that quivers can do their thing"
        //guess what the quivers suck
        ItemStack ammo = player.getProjectile(gun);

        if (!ammo.isEmpty() || player.abilities.invulnerable) {
            if (ammo.isEmpty()) ammo = new ItemStack(RegistryHandler.BULLET.get());

            IBullet bulletItem = (IBullet) (ammo.getItem() instanceof IBullet ? ammo.getItem() : RegistryHandler.BULLET.get());
            if (!world.isClientSide) {
                boolean bulletFree = player.abilities.invulnerable || !shouldConsumeAmmo(gun, player);

                //Workaround for quivers not respecting getAmmoPredicate()
                ItemStack shotAmmo = ammo.getItem() instanceof IBullet ? ammo : new ItemStack(RegistryHandler.BULLET.get());
                shoot(world, player, gun, shotAmmo, bulletItem, bulletFree);

                gun.setDamageValue(1);
                if (!bulletFree) bulletItem.consume(ammo, player);
            }

            player.awardStat(Stats.ITEM_USED.get(this));

            player.getCooldowns().addCooldown(this, getFireDelay(gun, player));
            return ActionResult.consume(gun);
        }
        else return ActionResult.fail(gun);
    }
    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return arrow;
    }

    /**
     * Fires one shot after all the checks have passed. You can actually fire whatever you want here.<br>
     * Ammo is consumed afterwards, we're only shooting the bullet(s) here.
     * @param world world
     * @param player Player that shoots
     * @param gun Gun shooting
     * @param ammo Ammo being shot
     * @param bulletItem IBullet used for the shot, may not match the ammo
     * @param bulletFree true if no ammo was actually consumed (creative or Preserving enchant for example)
     */
    protected void shoot(World world, PlayerEntity player, ItemStack gun, ItemStack ammo, IBullet bulletItem, boolean bulletFree) {
        BulletEntity shot = bulletItem.createProjectile(world, ammo, player);
        shot.shootFromRotation(player, player.xRot, player.yRot, 0, (float)getProjectileSpeed(gun, player), (float)getInaccuracy(gun, player));
        shot.setBaseDamage((shot.getBaseDamage() + getBonusDamage(gun, player)) * getDamageMultiplier(gun, player));
        changeBullet(world, player, gun, shot, bulletFree);

        world.addFreshEntity(shot);
    }

    /**
     * Lets the gun do custom stuff to default bullets without redoing all the base stuff from shoot.
     */
    protected void changeBullet(World world, PlayerEntity player, ItemStack gun, BulletEntity bullet, boolean bulletFree) {

    }

    /**
     * Rolls chance to know if ammo should be consumed for the shot. Applies both the baseline chance and Preserving enchantment.<br>
     * If you change this don't forget to tweak getInverseChanceFreeShot accordingly for the tooltip (and call super).
     */
    public boolean shouldConsumeAmmo(ItemStack stack, PlayerEntity player) {

   return true;
    }

    /**
     * Gets the flat bonus damage (applied BEFORE the multiplier). This takes into account Impact enchantment.
     */
    public double getBonusDamage(ItemStack stack, @Nullable PlayerEntity player) {
        int impact = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, player);
        return bonusDamage + (impact >= 1 ? 0.5 * (impact + 1) : 0);
    }

    public double getDamageMultiplier(ItemStack stack, @Nullable PlayerEntity player) {
        return damageMultiplier;
    }

    /**
     * Gets the min time in ticks between 2 shots. This takes into account Sleight of Hand enchantment.
     */
    public int getFireDelay(ItemStack stack, @Nullable PlayerEntity player) {
        return Math.max(1, fireDelay);
    }

    /**
     * Checks if the gun has baseline perfect accuracy.<br>
     * Used for tooltip and for Bullseye (which can't be applied since it would do nothing).
     */
    public boolean hasPerfectAccuracy() {
        return inaccuracy <= 0;
    }

    /**
     * Gets the inaccuracy, taking into account Bullseye enchantment.<br>
     * Accuracy is actually inarccuracy internally, because it's easier to math.<br>
     * The formula is just accuracy = 1 / inaccuracy.
     */
    public double getInaccuracy(ItemStack stack, @Nullable PlayerEntity player) {
        return 0;
    }

    public double getProjectileSpeed(ItemStack stack, @Nullable PlayerEntity player) {
        //I wanted to follow kat's suggestion and make bullseye for snipers increase projectile speed
        //But high projectile speed cause weird "snapping" issues on bullets
        return projectileSpeed;
    }

    /**
     * Chance to actually CONSUME ammo, to properly multiply probabilities together.<br>
     * Tooltip then does the math to display it nicely.
     */
    public double getInverseChanceFreeShot(ItemStack stack, @Nullable PlayerEntity player) {
        return 1f;
    }



    /**
     * Sets a chance to NOT consume ammo, used when making the item for registering.
     */



    public Gun projectileSpeed(double projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
        return this;
    }

    /**
     * Sets the repair material, used when making the item for registering.
     */
    public Gun repair(Supplier<Ingredient> repairMaterial) {
        this.repairMaterial = repairMaterial;
        return this;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {

        return true;
    }




    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    //TODO ammo types
    private static final Predicate<ItemStack> BULLETS = (stack) -> stack.getItem() instanceof IBullet && ((IBullet)stack.getItem()).hasAmmo(stack);

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return com.eilfyt.starwarsinminecraft.items.ShootableItem.BULLET;
    }

    @Override
    public int getDefaultProjectileRange() {
        // No idea what this is yet, so using the Bow value (Crossbow is 8)
        return 30;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return (repairMaterial != null && repairMaterial.get().test(repair)) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !ItemStack.isSameIgnoreDurability(oldStack, newStack);
    }

}
