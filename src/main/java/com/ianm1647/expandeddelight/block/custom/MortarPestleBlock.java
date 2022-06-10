package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
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

public class MortarPestleBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public MortarPestleBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(4, 2, 4, 5, 4, 12),
            Block.createCuboidShape(4, 0, 4, 12, 2, 12),
            Block.createCuboidShape(11, 2, 4, 12, 4, 12),
            Block.createCuboidShape(5, 2, 4, 11, 4, 5),
            Block.createCuboidShape(5, 2, 11, 11, 4, 12),
            Block.createCuboidShape(7, 0.70711, 9.12132, 9, 2.70711, 17.12132)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(11, 2, 4, 12, 4, 12),
            Block.createCuboidShape(4, 0, 4, 12, 2, 12),
            Block.createCuboidShape(4, 2, 4, 5, 4, 12),
            Block.createCuboidShape(5, 2, 11, 11, 4, 12),
            Block.createCuboidShape(5, 2, 4, 11, 4, 5),
            Block.createCuboidShape(7, 0.70711, -1.1213200000000008, 9, 2.70711, 6.878679999999999)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(4, 2, 4, 12, 4, 5),
            Block.createCuboidShape(4, 0, 4, 12, 2, 12),
            Block.createCuboidShape(4, 2, 11, 12, 4, 12),
            Block.createCuboidShape(11, 2, 5, 12, 4, 11),
            Block.createCuboidShape(4, 2, 5, 5, 4, 11),
            Block.createCuboidShape(-1.1213200000000008, 0.70711, 7, 6.878679999999999, 2.70711, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(4, 2, 11, 12, 4, 12),
            Block.createCuboidShape(4, 0, 4, 12, 2, 12),
            Block.createCuboidShape(4, 2, 4, 12, 4, 5),
            Block.createCuboidShape(4, 2, 5, 5, 4, 11),
            Block.createCuboidShape(11, 2, 5, 12, 4, 11),
            Block.createCuboidShape(9.12132, 0.70711, 7, 17.12132, 2.70711, 9)
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.isOf(Items.SUGAR_CANE)) {
            if (!player.isCreative()) {
                stack.decrement(1);
            }
            dropStack(world, pos, new ItemStack(Items.SUGAR, 2));
            world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        if(stack.isOf(ItemList.RAW_CINNAMON)) {
            if (!player.isCreative()) {
                stack.decrement(1);
            }
            dropStack(world, pos, new ItemStack(ItemList.GROUND_CINNAMON, 2));
            world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        if(stack.isOf(ItemList.SALT_ROCK)) {
            if(!player.isCreative()) {
                stack.decrement(1);
            }
            dropStack(world, pos, new ItemStack(ItemList.GROUND_SALT, 2));
            world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        player.sendMessage(Text.translatable("block.expandeddelight.mortar_and_pestle.pass"), true);
        return ActionResult.PASS;
    }

}
