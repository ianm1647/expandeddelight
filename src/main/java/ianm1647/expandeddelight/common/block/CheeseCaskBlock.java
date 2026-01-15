package ianm1647.expandeddelight.common.block;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CheeseCaskBlock extends Block {
    public CheeseCaskBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (this == EDBlocks.CHEESE_CASK.get()) {
            popResource(level, pos, new ItemStack(EDItems.CHEESE_WHEEL.get(), 2));
            level.setBlock(pos, EDBlocks.CASK.get().defaultBlockState(), 2);
            level.playSound(player, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        if (this == EDBlocks.GOAT_CHEESE_CASK.get()) {
            popResource(level, pos, new ItemStack(EDItems.GOAT_CHEESE_WHEEL.get(), 2));
            level.setBlock(pos, EDBlocks.CASK.get().defaultBlockState(), 2);
            level.playSound(player, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

}
