package com.eilfyt.starwarsinminecraft.client.render;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.client.model.DragonArcherModel;
import com.eilfyt.starwarsinminecraft.entities.AbstractDragonArcherEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DragonArcherRenderer extends BipedRenderer<AbstractDragonArcherEntity, DragonArcherModel<AbstractDragonArcherEntity>> {
    private static final ResourceLocation DRAGON_ARCHER_LOCATION = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/dragon_archer.png");

    public DragonArcherRenderer(EntityRendererManager p_i46143_1_) {
        super(p_i46143_1_, new DragonArcherModel<>(0.0f, false), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new DragonArcherModel<>(0.5F, true), new DragonArcherModel<>(1.0F, true)));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractDragonArcherEntity p_110775_1_) {
        return DRAGON_ARCHER_LOCATION;
    }

}
