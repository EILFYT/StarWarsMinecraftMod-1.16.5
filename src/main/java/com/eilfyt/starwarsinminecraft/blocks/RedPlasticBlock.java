package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RedPlasticBlock extends Block {

    public RedPlasticBlock() {
        super(Block.Properties.of(Material.STONE)
                .strength(5.0f,60.0f)
                .sound(SoundType.ANCIENT_DEBRIS)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }
}