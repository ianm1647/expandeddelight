package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CinnamonLogBlock extends PillarBlock {

    public CinnamonLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.getItem() instanceof ShearsItem) {
            if(!player.isCreative()) {
                stack.damage(1, player, (playerx) -> playerx.sendToolBreakStatus(hand));
            }
            dropStack(world, pos, new ItemStack(ItemList.RAW_CINNAMON, 1));
            world.setBlockState(pos, Blocks.OAK_LOG.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }
}
