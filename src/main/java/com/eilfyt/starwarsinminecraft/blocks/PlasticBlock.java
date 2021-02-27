package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PlasticBlock extends Block {

    public PlasticBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,60.0f)
                .sound(SoundType.NETHERITE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }
}