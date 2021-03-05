package com.neonfish.starwarsinminecraft.blocks;

import com.neonfish.starwarsinminecraft.dimensions.ModDimensions;
import com.neonfish.starwarsinminecraft.events.INotForgeBlock;
import com.neonfish.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.entity.EntitySize;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Predicate;

public class MustafarPortalSize {

    private static final AbstractBlock.IPositionPredicate POSITION_PREDICATE = (iNot, blockReader, pos) -> {
        return iNot.isPortalFrame(blockReader, pos);
    };
    private final IWorld world;
    private static ServerWorld worlde;
    private static INotForgeBlock iNot;

    private final Direction.Axis axis;
        private final Direction rightDir;
        private int portalBlockCount;
        @Nullable
        private BlockPos bottomLeft;
        private int height;
        private int width;

    public MustafarPortalSize(ServerWorld world1, IWorld world, Direction.Axis axis, Direction rightDir) {
        this.world = world;
        this.axis = axis;
        this.rightDir = rightDir;

    }
    protected MustafarPortalInfo func_241829_a(ServerWorld p_241829_1_) {
        MustafarPortalInfo portalinfo = func_241829_a(p_241829_1_);
        if (portalinfo != null && this.worlde.getDimensionKey() == World.OVERWORLD && p_241829_1_.getDimensionKey() == ModDimensions.MUSTAFAR) {
            Vector3d vector3d = portalinfo.pos.add(0.0D, -1.0D, 0.0D);
            return new MustafarPortalInfo(vector3d, Vector3d.ZERO, 90.0F, 0.0F);
        } else {
            return portalinfo;
        }
    }



    public static Optional<MustafarPortalSize> func_242964_a(IWorld world, BlockPos pos, Direction.Axis axis) {
            return func_242965_a(world, pos, (size) -> {
                return size.isValid() && size.portalBlockCount == 0;
            }, axis);
        }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent
    {
        private final MustafarPortalSize size;

        public PortalSpawnEvent(IWorld world, BlockPos pos, BlockState state, MustafarPortalSize size)
        {
            super(world, pos, state);
            this.size = size;
        }

        public MustafarPortalSize getPortalSize()
        {
            return size;
        }
    }



    public static Optional<MustafarPortalSize> onTrySpawnPortal(IWorld world, BlockPos pos, Optional<MustafarPortalSize> size)
    {
        if (!size.isPresent()) return size;
        return !MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size.get())) ? size : Optional.empty();
    }

        public static Optional<MustafarPortalSize> func_242965_a(IWorld world, BlockPos pos, Predicate<MustafarPortalSize> sizePredicate, Direction.Axis axis) {
            Optional<MustafarPortalSize> optional = Optional.of(new MustafarPortalSize(world, pos, axis)).filter(sizePredicate);
            if (optional.isPresent()) {
                return optional;
            } else {
                Direction.Axis direction$axis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
                return Optional.of(new MustafarPortalSize(world, pos, direction$axis)).filter(sizePredicate);
            }
        }

        public MustafarPortalSize(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
            this.world = worldIn;
            this.axis = axisIn;
            this.rightDir = axisIn == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
            this.bottomLeft = this.func_242971_a(pos);
            if (this.bottomLeft == null) {
                this.bottomLeft = pos;
                this.width = 1;
                this.height = 1;
            } else {
                this.width = this.func_242974_d();
                if (this.width > 0) {
                    this.height = this.func_242975_e();
                }
            }

        }

        @Nullable
        private BlockPos func_242971_a(BlockPos pos) {
            for(int i = Math.max(0, pos.getY() - 21); pos.getY() > i && canConnect(this.world.getBlockState(pos.down())); pos = pos.down()) {
            }

            Direction direction = this.rightDir.getOpposite();
            int j = this.func_242972_a(pos, direction) - 1;
            return j < 0 ? null : pos.offset(direction, j);
        }

        private int func_242974_d() {
            int i = this.func_242972_a(this.bottomLeft, this.rightDir);
            return i >= 2 && i <= 21 ? i : 0;
        }

        private int func_242972_a(BlockPos pos, Direction direction) {
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for(int i = 0; i <= 21; ++i) {
                blockpos$mutable.setPos(pos).move(direction, i);
                BlockState blockstate = this.world.getBlockState(blockpos$mutable);
                if (!canConnect(blockstate)) {
                    if (POSITION_PREDICATE.test(blockstate, this.world, blockpos$mutable)) {
                        return i;
                    }
                    break;
                }

                BlockState blockstate1 = this.world.getBlockState(blockpos$mutable.move(Direction.DOWN));
                if (!POSITION_PREDICATE.test(blockstate1, this.world, blockpos$mutable)) {
                    break;
                }
            }

            return 0;
        }

        private int func_242975_e() {
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            int i = this.func_242969_a(blockpos$mutable);
            return i >= 3 && i <= 21 && this.func_242970_a(blockpos$mutable, i) ? i : 0;
        }

        private boolean func_242970_a(BlockPos.Mutable mutablePos, int upDisplacement) {
            for(int i = 0; i < this.width; ++i) {
                BlockPos.Mutable blockpos$mutable = mutablePos.setPos(this.bottomLeft).move(Direction.UP, upDisplacement).move(this.rightDir, i);
                if (!POSITION_PREDICATE.test(this.world.getBlockState(blockpos$mutable), this.world, blockpos$mutable)) {
                    return false;
                }
            }

            return true;
        }

        private int func_242969_a(BlockPos.Mutable mutablePos) {
            for(int i = 0; i < 21; ++i) {
                mutablePos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
                if (!POSITION_PREDICATE.test(this.world.getBlockState(mutablePos), this.world, mutablePos)) {
                    return i;
                }

                mutablePos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
                if (!POSITION_PREDICATE.test(this.world.getBlockState(mutablePos), this.world, mutablePos)) {
                    return i;
                }

                for(int j = 0; j < this.width; ++j) {
                    mutablePos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                    BlockState blockstate = this.world.getBlockState(mutablePos);
                    if (!canConnect(blockstate)) {
                        return i;
                    }

                    if (blockstate.isIn(RegistryHandler.MUSTAFAR_PORTAL.get())) {
                        ++this.portalBlockCount;
                    }
                }
            }

            return 21;
        }

        private static boolean canConnect(BlockState state) {
            return state.isAir() || state.isIn(BlockTags.FIRE) || state.isIn(RegistryHandler.MUSTAFAR_PORTAL.get());
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks() {
            BlockState blockstate = RegistryHandler.MUSTAFAR_PORTAL.get().getDefaultState().with(MustafarPortalBlock.AXIS, this.axis);
            BlockPos.getAllInBoxMutable(this.bottomLeft, this.bottomLeft.offset(Direction.UP, this.height - 1).offset(this.rightDir, this.width - 1)).forEach((pos) -> {
                this.world.setBlockState(pos, blockstate, 18);
            });
        }

        public boolean validatePortal() {
            return this.isValid() && this.portalBlockCount == this.width * this.height;
        }

        public static Vector3d func_242973_a(TeleportationRepositioner.Result result, Direction.Axis axis, Vector3d positionVector, EntitySize size) {
            double d0 = (double)result.width - (double)size.width;
            double d1 = (double)result.height - (double)size.height;
            BlockPos blockpos = result.startPos;
            double d2;
            if (d0 > 0.0D) {
                float f = (float)blockpos.func_243648_a(axis) + size.width / 2.0F;
                d2 = MathHelper.clamp(MathHelper.func_233020_c_(positionVector.getCoordinate(axis) - (double)f, 0.0D, d0), 0.0D, 1.0D);
            } else {
                d2 = 0.5D;
            }

            double d4;
            if (d1 > 0.0D) {
                Direction.Axis direction$axis = Direction.Axis.Y;
                d4 = MathHelper.clamp(MathHelper.func_233020_c_(positionVector.getCoordinate(direction$axis) - (double)blockpos.func_243648_a(direction$axis), 0.0D, d1), 0.0D, 1.0D);
            } else {
                d4 = 0.0D;
            }

            Direction.Axis direction$axis1 = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            double d3 = positionVector.getCoordinate(direction$axis1) - ((double)blockpos.func_243648_a(direction$axis1) + 0.5D);
            return new Vector3d(d2, d4, d3);
        }

        public static MustafarPortalInfo func_242963_a(ServerWorld world, TeleportationRepositioner.Result result, Direction.Axis axis, Vector3d offsetVector, EntitySize size, Vector3d motion, float rotationYaw, float rotationPitch) {
            BlockPos blockpos = result.startPos;
            BlockState blockstate = world.getBlockState(blockpos);
            Direction.Axis direction$axis = blockstate.get(BlockStateProperties.HORIZONTAL_AXIS);
            double d0 = (double)result.width;
            double d1 = (double)result.height;
            int i = axis == direction$axis ? 0 : 90;
            Vector3d vector3d = axis == direction$axis ? motion : new Vector3d(motion.z, motion.y, -motion.x);
            double d2 = (double)size.width / 2.0D + (d0 - (double)size.width) * offsetVector.getX();
            double d3 = (d1 - (double)size.height) * offsetVector.getY();
            double d4 = 0.5D + offsetVector.getZ();
            boolean flag = direction$axis == Direction.Axis.X;
            Vector3d vector3d1 = new Vector3d((double)blockpos.getX() + (flag ? d2 : d4), (double)blockpos.getY() + d3, (double)blockpos.getZ() + (flag ? d4 : d2));
            return new MustafarPortalInfo(vector3d1, vector3d, rotationYaw + (float)i, rotationPitch);
        }
    }


