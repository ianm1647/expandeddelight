package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class JuicerBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public JuicerBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(3, 2, 3, 13, 16, 13),
            Block.createCuboidShape(6, 16, 6, 10, 18, 10),
            Block.createCuboidShape(7, 18, 7, 9, 22, 9),
            Block.createCuboidShape(6, 19, 6, 18, 21, 10),
            Block.createCuboidShape(2, 0, 4, 4, 4, 6),
            Block.createCuboidShape(2, 0, 10, 4, 4, 12),
            Block.createCuboidShape(12, 0, 4, 14, 4, 6),
            Block.createCuboidShape(12, 0, 10, 14, 4, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(3, 2, 3, 13, 16, 13),
            Block.createCuboidShape(6, 16, 6, 10, 18, 10),
            Block.createCuboidShape(7, 18, 7, 9, 22, 9),
            Block.createCuboidShape(-2, 19, 6, 10, 21, 10),
            Block.createCuboidShape(12, 0, 10, 14, 4, 12),
            Block.createCuboidShape(12, 0, 4, 14, 4, 6),
            Block.createCuboidShape(2, 0, 10, 4, 4, 12),
            Block.createCuboidShape(2, 0, 4, 4, 4, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(3, 2, 3, 13, 16, 13),
            Block.createCuboidShape(6, 16, 6, 10, 18, 10),
            Block.createCuboidShape(7, 18, 7, 9, 22, 9),
            Block.createCuboidShape(6, 19, -2, 10, 21, 10),
            Block.createCuboidShape(4, 0, 12, 6, 4, 14),
            Block.createCuboidShape(10, 0, 12, 12, 4, 14),
            Block.createCuboidShape(4, 0, 2, 6, 4, 4),
            Block.createCuboidShape(10, 0, 2, 12, 4, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(3, 2, 3, 13, 16, 13),
            Block.createCuboidShape(6, 16, 6, 10, 18, 10),
            Block.createCuboidShape(7, 18, 7, 9, 22, 9),
            Block.createCuboidShape(6, 19, 6, 10, 21, 18),
            Block.createCuboidShape(10, 0, 2, 12, 4, 4),
            Block.createCuboidShape(4, 0, 2, 6, 4, 4),
            Block.createCuboidShape(10, 0, 12, 12, 4, 14),
            Block.createCuboidShape(4, 0, 12, 6, 4, 14)
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
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        ItemStack offHand = player.getOffHandStack();
        if(stack.isOf(Items.APPLE) && offHand.isOf(Items.GLASS_BOTTLE)) {
            if(!player.isCreative()) {
                stack.decrement(1);
                offHand.decrement(1);
            }
            player.giveItemStack(new ItemStack(ItemList.APPLE_JUICE));
            return ActionResult.SUCCESS;
        } else if(stack.isOf(Items.GLASS_BOTTLE) && offHand.isOf(Items.APPLE)) {
            if(!player.isCreative()) {
                stack.decrement(1);
                offHand.decrement(1);
            }
            player.giveItemStack(new ItemStack(ItemList.APPLE_JUICE));
            return ActionResult.SUCCESS;
        }
        player.sendMessage(new TranslatableText("block.expandeddelight.juicer.pass"), true);
        return ActionResult.PASS;
    }

}
