package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.block.entity.JuicerBlockEntityUpdated;
import com.ianm1647.expandeddelight.registry.BlockEntityRegistry;
import com.nhoryzon.mc.farmersdelight.block.state.CookingPotSupport;
import com.nhoryzon.mc.farmersdelight.entity.block.CookingPotBlockEntity;
import com.nhoryzon.mc.farmersdelight.util.MathUtils;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class JuicerBlockUpdated extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public JuicerBlockUpdated(AbstractBlock.Settings settings) {
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
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
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

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new JuicerBlockEntityUpdated(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntityRegistry.JUICER, JuicerBlockEntityUpdated::tick);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        if (!world.isClient) {
            BlockEntity entity = world.getBlockEntity(pos);
            if (entity instanceof JuicerBlockEntityUpdated) {
                JuicerBlockEntityUpdated juicerBlockEntity = (JuicerBlockEntityUpdated)entity;
                ItemStack serving = juicerBlockEntity.useContainerOnJuicer(heldStack);
                if (serving != ItemStack.EMPTY) {
                    if (!player.getInventory().insertStack(serving)) {
                        player.dropItem(serving, false);
                    }
                    world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
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

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity var7 = world.getBlockEntity(pos);
            if (var7 instanceof JuicerBlockEntityUpdated) {
                JuicerBlockEntityUpdated juicerBlockEntity = (JuicerBlockEntityUpdated) var7;
                ItemScatterer.spawn(world, pos, juicerBlockEntity.getDroppableInventory());
                world.updateNeighbors(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        BlockEntity var5 = world.getBlockEntity(pos);
        if (var5 instanceof JuicerBlockEntityUpdated juicerBlockEntity) {
            return juicerBlockEntity;
        } else {
            return null;
        }
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof JuicerBlockEntityUpdated juicerBlockEntity) {
            return MathUtils.calcRedstoneFromItemHandler(juicerBlockEntity);
        } else {
            return 0;
        }
    }

}
