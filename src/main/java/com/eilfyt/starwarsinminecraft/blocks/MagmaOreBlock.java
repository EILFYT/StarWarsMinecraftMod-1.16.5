package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MagmaOreBlock extends Block {
    public MagmaOreBlock() {
            super(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(
                            25.0f, 1200.0f)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE) );
    }
}
