package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlackstoneBlock extends Block {
    public BlackstoneBlock() {
        super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(1.5F, 6.0F));

    }
}
