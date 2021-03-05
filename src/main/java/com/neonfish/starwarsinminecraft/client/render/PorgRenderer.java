package com.neonfish.starwarsinminecraft.client.render;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import com.neonfish.starwarsinminecraft.client.model.PorgModel;
import com.neonfish.starwarsinminecraft.entities.PorgEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PorgRenderer extends MobRenderer<PorgEntity, PorgModel<PorgEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/porg.png");

    public PorgRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PorgModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(PorgEntity entity) {
        return TEXTURE;
    }
}

