package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class IronForge extends ForgeBlock {
    public IronForge() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(6f, 1200f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }
}
