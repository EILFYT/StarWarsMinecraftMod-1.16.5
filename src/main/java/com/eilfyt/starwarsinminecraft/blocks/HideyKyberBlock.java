
package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class HideyKyberBlock extends net.minecraft.block.Block {

    public HideyKyberBlock() {
        super(Properties.of(Material.STONE)
                .strength(9.0f, 1200.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .noCollission()
                .requiresCorrectToolForDrops()
                .harvestTool(ToolType.PICKAXE));

    }



    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof PlayerEntity) { ((PlayerEntity) entityIn).addEffect(new EffectInstance(Effects.INVISIBILITY, 2, 0)); }
        super.entityInside(state, worldIn, pos, entityIn);
    }
}

