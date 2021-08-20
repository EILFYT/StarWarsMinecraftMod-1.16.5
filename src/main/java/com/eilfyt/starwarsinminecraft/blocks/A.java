package com.eilfyt.starwarsinminecraft.blocks;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class A extends BlockItem {
    public A(Block block) {
        super(block, new Item.Properties().tab(StarWarsInMinecraft.E));
    }
    
}

