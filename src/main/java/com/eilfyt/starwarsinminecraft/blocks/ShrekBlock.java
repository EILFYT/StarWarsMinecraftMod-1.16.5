package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;

public class ShrekBlock extends Block {
    public ShrekBlock() {
        super(Block.Properties.of(Material.STONE)
                .sound(SoundType.BAMBOO)
                .jumpFactor(2.0f)
                .strength(0, 0)
        );
    }
}

