package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;




import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrystalOreBlock extends Block {
    public CrystalOreBlock() {
        super(Block.Properties.of(Material.STONE)
                .strength(
                        30.0f, 1200.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)

        );
    }
}
