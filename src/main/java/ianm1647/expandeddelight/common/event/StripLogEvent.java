package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.Block.popResource;

public class StripLogEvent {

    public static void init() {
        UseBlockCallback.EVENT.register((player, level, interactionHand, blockHitResult) -> {
            InteractionHand hand = player.getUsedItemHand();
            ItemStack stack = player.getItemInHand(hand);
            BlockPos pos = blockHitResult.getBlockPos();
            BlockState state = level.getBlockState(pos);

            if (stack.getItem() instanceof AxeItem) {
                if (state.is(EDBlocks.CINNAMON_LOG.get())) {
                    popResource(level, pos, new ItemStack(EDItems.CINNAMON_STICK.get(), 2));
                    level.setBlock(pos, EDBlocks.CINNAMON_STRIPPED_LOG.get().defaultBlockState(), 3);
                    level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
                    stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                    player.swing(hand);
                    return InteractionResult.SUCCESS;
                }
                if (state.is(EDBlocks.CINNAMON_WOOD.get())) {
                    popResource(level, pos, new ItemStack(EDItems.CINNAMON_STICK.get(), 3));
                    level.setBlock(pos, EDBlocks.CINNAMON_STRIPPED_WOOD.get().defaultBlockState(), 3);
                    level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
                    stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                    player.swing(hand);
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.PASS;
        });
    }
}
