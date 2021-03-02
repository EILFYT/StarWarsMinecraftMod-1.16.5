package com.eilfyt.starwarsinminecraft.blocks;

import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

import java.util.Optional;

public class Tlp implements net.minecraftforge.common.util.ITeleporter{
    protected ServerWorld world;
    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.rotateY();

        for(int i = -1; i < 3; ++i) {
            for(int j = -1; j < 4; ++j) {
                offsetPos.setAndOffset(originalPos, directionIn.getXOffset() * i + direction.getXOffset() * offsetScale, j, directionIn.getZOffset() * i + direction.getZOffset() * offsetScale);
                if (j < 0 && !this.world.getBlockState(offsetPos).getMaterial().isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.world.isAirBlock(offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }
    public Tlp() {}
    public Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.getFacingFromAxis(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.world.getWorldBorder();
        int i = this.world.func_234938_ad_() - 1;
        BlockPos.Mutable blockpos$mutable = pos.toMutable();

        for(BlockPos.Mutable blockpos$mutable1 : BlockPos.func_243514_a(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(i, this.world.getHeight(Heightmap.Type.MOTION_BLOCKING, blockpos$mutable1.getX(), blockpos$mutable1.getZ()));
            int k = 1;
            if (worldborder.contains(blockpos$mutable1) && worldborder.contains(blockpos$mutable1.move(direction, 1))) {
                blockpos$mutable1.move(direction.getOpposite(), 1);

                for(int l = j; l >= 0; --l) {
                    blockpos$mutable1.setY(l);
                    if (this.world.isAirBlock(blockpos$mutable1)) {
                        int i1;
                        for(i1 = l; l > 0 && this.world.isAirBlock(blockpos$mutable1.move(Direction.DOWN)); --l) {
                        }

                        if (l + 4 <= i) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                blockpos$mutable1.setY(l);
                                if (this.checkRegionForPlacement(blockpos$mutable1, blockpos$mutable, direction, 0)) {
                                    double d2 = pos.distanceSq(blockpos$mutable1);
                                    if (this.checkRegionForPlacement(blockpos$mutable1, blockpos$mutable, direction, -1) && this.checkRegionForPlacement(blockpos$mutable1, blockpos$mutable, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = blockpos$mutable1.toImmutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = blockpos$mutable1.toImmutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), MathHelper.clamp(pos.getY(), 70, this.world.func_234938_ad_() - 10), pos.getZ())).toImmutable();
            Direction direction1 = direction.rotateY();
            if (!worldborder.contains(blockpos)) {
                return Optional.empty();
            }

            for(int l1 = -1; l1 < 2; ++l1) {
                for(int k2 = 0; k2 < 2; ++k2) {
                    for(int i3 = -1; i3 < 3; ++i3) {
                        BlockState blockstate1 = i3 < 0 ? Blocks.BLACKSTONE.getDefaultState() : Blocks.AIR.getDefaultState();
                        blockpos$mutable.setAndOffset(blockpos, k2 * direction.getXOffset() + l1 * direction1.getXOffset(), i3, k2 * direction.getZOffset() + l1 * direction1.getZOffset());
                        this.world.setBlockState(blockpos$mutable, blockstate1);
                    }
                }
            }
        }

        for(int k1 = -1; k1 < 3; ++k1) {
            for(int i2 = -1; i2 < 4; ++i2) {
                if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
                    blockpos$mutable.setAndOffset(blockpos, k1 * direction.getXOffset(), i2, k1 * direction.getZOffset());
                    this.world.setBlockState(blockpos$mutable, Blocks.BLACKSTONE.getDefaultState(), 3);
                }
            }
        }

        BlockState blockstate = RegistryHandler.MUSTAFAR_PORTAL.get().getDefaultState().with(MustafarPortalBlock.AXIS, axis);

        for(int j2 = 0; j2 < 2; ++j2) {
            for(int l2 = 0; l2 < 3; ++l2) {
                blockpos$mutable.setAndOffset(blockpos, j2 * direction.getXOffset(), l2, j2 * direction.getZOffset());
                this.world.setBlockState(blockpos$mutable, blockstate, 18);
            }
        }

        return Optional.of(new TeleportationRepositioner.Result(blockpos.toImmutable(), 2, 3));
    }
}