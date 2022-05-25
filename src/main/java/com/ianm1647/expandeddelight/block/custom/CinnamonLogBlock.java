package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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
        if(stack.getItem() instanceof AxeItem) {
            if(!player.isCreative()) {
                stack.damage(1, player, (playerx) -> playerx.sendToolBreakStatus(hand));
            }
            dropStack(world, pos, new ItemStack(ItemList.RAW_CINNAMON, 2));
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, Blocks.STRIPPED_OAK_LOG.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }
}
