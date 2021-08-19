package com.eilfyt.starwarsinminecraft.blocks;

import com.eilfyt.starwarsinminecraft.init.TileEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class IronForgeTileEntity extends TileEntity {
CompoundNBT compoundNBT = new CompoundNBT();
    public IronForgeTileEntity(CompoundNBT compoundNBT) {
        super(TileEntityInit.IRON_FORGE_TE.get());
        this.compoundNBT = compoundNBT;
    }

    public IronForgeTileEntity() {
        super(TileEntityInit.IRON_FORGE_TE.get());
        this.compoundNBT.putInt("LavaLevel", 0);
    }

    @Override
    public CompoundNBT save(CompoundNBT p_189515_1_) {
        p_189515_1_ =compoundNBT;
        return super.save(p_189515_1_);
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
    }
    @Override
    public SUpdateTileEntityPacket getUpdatePacket(){
        return new SUpdateTileEntityPacket(getBlockPos(), -1, compoundNBT);
    }

}
