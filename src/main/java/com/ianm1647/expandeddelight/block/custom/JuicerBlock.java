package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.block.entity.JuicerBlockEntity;
import com.ianm1647.expandeddelight.registry.BlockEntityRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class JuicerBlock extends BlockWithEntity implements BlockEntityProvider{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public JuicerBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(3, 6, 3, 13, 20, 13),
            Block.createCuboidShape(6, 20, 6, 10, 22, 10),
            Block.createCuboidShape(7, 21, 7, 9, 28, 9),
            Block.createCuboidShape(1.828427124746197, 24, 6.171572875253805, 13.828427124746197, 26, 10.171572875253805),
            Block.createCuboidShape(1, 0, 13, 3, 4, 15),
            Block.createCuboidShape(13, 0, 13, 15, 4, 15),
            Block.createCuboidShape(1, 0, 1, 3, 4, 3),
            Block.createCuboidShape(5, 5, 0, 7, 8, 3),
            Block.createCuboidShape(9, 5, 0, 11, 8, 3),
            Block.createCuboidShape(13, 0, 1, 15, 4, 3),
            Block.createCuboidShape(1, 4, 1, 15, 6, 15),
            Block.createCuboidShape(7, 5, 0, 9, 6, 1)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(3, 6, 3, 13, 20, 13),
            Block.createCuboidShape(6, 20, 6, 10, 22, 10),
            Block.createCuboidShape(7, 21, 7, 9, 28, 9),
            Block.createCuboidShape(2.171572875253803, 24, 5.828427124746195, 14.171572875253803, 26, 9.828427124746195),
            Block.createCuboidShape(13, 0, 1, 15, 4, 3),
            Block.createCuboidShape(1, 0, 1, 3, 4, 3),
            Block.createCuboidShape(13, 0, 13, 15, 4, 15),
            Block.createCuboidShape(9, 5, 13, 11, 8, 16),
            Block.createCuboidShape(5, 5, 13, 7, 8, 16),
            Block.createCuboidShape(1, 0, 13, 3, 4, 15),
            Block.createCuboidShape(1, 4, 1, 15, 6, 15),
            Block.createCuboidShape(7, 5, 15, 9, 6, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(3, 6, 3, 13, 20, 13),
            Block.createCuboidShape(6, 20, 6, 10, 22, 10),
            Block.createCuboidShape(7, 21, 7, 9, 28, 9),
            Block.createCuboidShape(6.171572875253805, 24, 2.171572875253803, 10.171572875253805, 26, 14.171572875253803),
            Block.createCuboidShape(13, 0, 13, 15, 4, 15),
            Block.createCuboidShape(13, 0, 1, 15, 4, 3),
            Block.createCuboidShape(1, 0, 13, 3, 4, 15),
            Block.createCuboidShape(0, 5, 9, 3, 8, 11),
            Block.createCuboidShape(0, 5, 5, 3, 8, 7),
            Block.createCuboidShape(1, 0, 1, 3, 4, 3),
            Block.createCuboidShape(1, 4, 1, 15, 6, 15),
            Block.createCuboidShape(0, 5, 7, 1, 6, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(3, 6, 3, 13, 20, 13),
            Block.createCuboidShape(6, 20, 6, 10, 22, 10),
            Block.createCuboidShape(7, 21, 7, 9, 28, 9),
            Block.createCuboidShape(5.828427124746195, 24, 1.828427124746197, 9.828427124746195, 26, 13.828427124746197),
            Block.createCuboidShape(1, 0, 1, 3, 4, 3),
            Block.createCuboidShape(1, 0, 13, 3, 4, 15),
            Block.createCuboidShape(13, 0, 1, 15, 4, 3),
            Block.createCuboidShape(13, 5, 5, 16, 8, 7),
            Block.createCuboidShape(13, 5, 9, 16, 8, 11),
            Block.createCuboidShape(13, 0, 13, 15, 4, 15),
            Block.createCuboidShape(1, 4, 1, 15, 6, 15),
            Block.createCuboidShape(15, 5, 7, 16, 6, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerLookDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // block entity

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof JuicerBlockEntity) {
                ItemScatterer.spawn(world, pos, ((JuicerBlockEntity) blockEntity).getDroppableInventory());
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof JuicerBlockEntity) {
                JuicerBlockEntity juicerBlockEntity = (JuicerBlockEntity) blockEntity;
                ItemStack stack = juicerBlockEntity.useBottleOnJuice(player.getStackInHand(hand));
                if (stack != ItemStack.EMPTY) {
                    if (!player.getInventory().insertStack(stack)) {
                        player.dropItem(stack, false);
                    }
                    world.playSound(player, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                } else {
                    NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
                    if (screenHandlerFactory != null) {
                        player.openHandledScreen(screenHandlerFactory);
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new JuicerBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntityRegistry.JUICER, JuicerBlockEntity::tick);
    }
}
