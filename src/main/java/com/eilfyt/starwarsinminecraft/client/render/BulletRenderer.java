package com.eilfyt.starwarsinminecraft.client.render;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.client.model.BulletModel;
import com.eilfyt.starwarsinminecraft.client.model.PorgModel;
import com.eilfyt.starwarsinminecraft.entities.BulletEntity;
import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BulletRenderer extends ArrowRenderer<BulletEntity> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/bullet.png");

    public BulletRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(BulletEntity entity) {
        return TEXTURE;
    }



}
