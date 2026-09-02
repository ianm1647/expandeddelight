package ianm1647.expandeddelight.common.block;

import com.mojang.serialization.MapCodec;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.utility.MathUtils;

import javax.annotation.Nullable;
import java.util.Optional;

public class JuicerBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;
    public static final VoxelShape SHAPE_NORTH;
    private static final VoxelShape SHAPE_SOUTH;
    private static final VoxelShape SHAPE_EAST;
    private static final VoxelShape SHAPE_WEST;
    public static final MapCodec<JuicerBlock> CODEC = simpleCodec(JuicerBlock::new);

    public JuicerBlock() {
        super(Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    public JuicerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide) {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if (tileEntity instanceof JuicerBlockEntity juicerBlockEntity) {
                ItemStack servingStack = juicerBlockEntity.useHeldItemOnDrink(heldStack);
                if (servingStack != ItemStack.EMPTY) {
                    if (!player.getInventory().add(servingStack)) {
                        player.drop(servingStack, false);
                    }
                    level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                } else {
                    player.openMenu(juicerBlockEntity, pos);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
        };
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
        };
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return state;
    }

    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        ItemStack stack = super.getCloneItemStack(level, pos, state);
        Optional<JuicerBlockEntity> juicer = level.getBlockEntity(pos, EDBlockEntityTypes.JUICER.get());
        if (juicer.isPresent()) {
            stack = juicer.get().getAsItem();
        }

        return stack;
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileEntity = level.getBlockEntity(pos);
            if (tileEntity instanceof JuicerBlockEntity) {
                JuicerBlockEntity juicerBlockEntity = (JuicerBlockEntity)tileEntity;
                Containers.dropContents(level, pos, juicerBlockEntity.getDroppableInventory());
                juicerBlockEntity.getUsedRecipesAndPopExperience(level, Vec3.atCenterOf(pos));
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof JuicerBlockEntity) {
            ItemStackHandler inventory = ((JuicerBlockEntity)tileEntity).getInventory();
            return MathUtils.calcRedstoneFromItemHandler(inventory);
        } else {
            return 0;
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return (EDBlockEntityTypes.JUICER.get()).create(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity) {
        return level.isClientSide
                ? createTickerHelper(blockEntity, EDBlockEntityTypes.JUICER.get(), JuicerBlockEntity::animationTick)
                : createTickerHelper(blockEntity, EDBlockEntityTypes.JUICER.get(), JuicerBlockEntity::juicingTick);
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        SHAPE_NORTH = Shapes.or(
                Shapes.box(0.1875, 0.375, 0.1875, 0.8125, 1.25, 0.8125),
                Shapes.box(0.375, 1.25, 0.375, 0.625, 1.375, 0.625),
                Shapes.box(0.4375, 1.3125, 0.4375, 0.5625, 1.75, 0.5625),
                Shapes.box(0.114276875, 1.5, 0.385723125, 0.864276875, 1.625, 0.635723125),
                Shapes.box(0.0625, 0, 0.8125, 0.1875, 0.25, 0.9375),
                Shapes.box(0.8125, 0, 0.8125, 0.9375, 0.25, 0.9375),
                Shapes.box(0.0625, 0, 0.0625, 0.1875, 0.25, 0.1875),
                Shapes.box(0.3125, 0.3125, 0, 0.4375, 0.5, 0.1875),
                Shapes.box(0.5625, 0.3125, 0, 0.6875, 0.5, 0.1875),
                Shapes.box(0.8125, 0, 0.0625, 0.9375, 0.25, 0.1875),
                Shapes.box(0.0625, 0.25, 0.0625, 0.9375, 0.375, 0.9375),
                Shapes.box(0.4375, 0.3125, 0, 0.5625, 0.375, 0.0625)
        );
        SHAPE_SOUTH = Shapes.or(
                Shapes.box(0.1875, 0.375, 0.1875, 0.8125, 1.25, 0.8125),
                Shapes.box(0.375, 1.25, 0.375, 0.625, 1.375, 0.625),
                Shapes.box(0.4375, 1.3125, 0.4375, 0.5625, 1.75, 0.5625),
                Shapes.box(0.13572312499999994, 1.5, 0.36427687500000006, 0.885723125, 1.625, 0.614276875),
                Shapes.box(0.8125, 0, 0.0625, 0.9375, 0.25, 0.1875),
                Shapes.box(0.0625, 0, 0.0625, 0.1875, 0.25, 0.1875),
                Shapes.box(0.8125, 0, 0.8125, 0.9375, 0.25, 0.9375),
                Shapes.box(0.5625, 0.3125, 0.8125, 0.6875, 0.5, 1),
                Shapes.box(0.3125, 0.3125, 0.8125, 0.4375, 0.5, 1),
                Shapes.box(0.0625, 0, 0.8125, 0.1875, 0.25, 0.9375),
                Shapes.box(0.0625, 0.25, 0.0625, 0.9375, 0.375, 0.9375),
                Shapes.box(0.4375, 0.3125, 0.9375, 0.5625, 0.375, 1)
        );
        SHAPE_EAST = Shapes.or(
                Shapes.box(0.1875, 0.375, 0.1875, 0.8125, 1.25, 0.8125),
                Shapes.box(0.375, 1.25, 0.375, 0.625, 1.375, 0.625),
                Shapes.box(0.4375, 1.3125, 0.4375, 0.5625, 1.75, 0.5625),
                Shapes.box(0.36427687500000006, 1.5, 0.11427687500000006, 0.614276875, 1.625, 0.864276875),
                Shapes.box(0.0625, 0, 0.0625, 0.1875, 0.25, 0.1875),
                Shapes.box(0.0625, 0, 0.8125, 0.1875, 0.25, 0.9375),
                Shapes.box(0.8125, 0, 0.0625, 0.9375, 0.25, 0.1875),
                Shapes.box(0.8125, 0.3125, 0.3125, 1, 0.5, 0.4375),
                Shapes.box(0.8125, 0.3125, 0.5625, 1, 0.5, 0.6875),
                Shapes.box(0.8125, 0, 0.8125, 0.9375, 0.25, 0.9375),
                Shapes.box(0.0625, 0.25, 0.0625, 0.9375, 0.375, 0.9375),
                Shapes.box(0.9375, 0.3125, 0.4375, 1, 0.375, 0.5625)
        );
        SHAPE_WEST = Shapes.or(
                Shapes.box(0.1875, 0.375, 0.1875, 0.8125, 1.25, 0.8125),
                Shapes.box(0.375, 1.25, 0.375, 0.625, 1.375, 0.625),
                Shapes.box(0.4375, 1.3125, 0.4375, 0.5625, 1.75, 0.5625),
                Shapes.box(0.38572312499999994, 1.5, 0.13572312499999994, 0.635723125, 1.625, 0.885723125),
                Shapes.box(0.8125, 0, 0.8125, 0.9375, 0.25, 0.9375),
                Shapes.box(0.8125, 0, 0.0625, 0.9375, 0.25, 0.1875),
                Shapes.box(0.0625, 0, 0.8125, 0.1875, 0.25, 0.9375),
                Shapes.box(0, 0.3125, 0.5625, 0.1875, 0.5, 0.6875),
                Shapes.box(0, 0.3125, 0.3125, 0.1875, 0.5, 0.4375),
                Shapes.box(0.0625, 0, 0.0625, 0.1875, 0.25, 0.1875),
                Shapes.box(0.0625, 0.25, 0.0625, 0.9375, 0.375, 0.9375),
                Shapes.box(0, 0.3125, 0.4375, 0.0625, 0.375, 0.5625)
        );
    }
}
