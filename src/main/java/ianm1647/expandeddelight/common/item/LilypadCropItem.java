package ianm1647.expandeddelight.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class LilypadCropItem extends Item {
    private final Block block;

    public LilypadCropItem(Block block1, Properties properties) {
        super(properties);
        block = block1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        FoodProperties foodproperties = itemstack.getFoodProperties(player);
        BlockHitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.WATER);
        BlockPos pos = hitresult.getBlockPos();
        if (foodproperties != null && !level.getBlockState(pos).getFluidState().isSource()) {
            if (player.canEat(foodproperties.canAlwaysEat())) {
                player.startUsingItem(hand);
                return InteractionResultHolder.consume(itemstack);
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            if (hitresult.getType() == HitResult.Type.BLOCK && level.getBlockState(pos).getFluidState().isSource() && !player.isUnderWater()) {
                if (!level.isClientSide) {
                    level.setBlock(pos.above(), block.defaultBlockState(), 2);
                    itemstack.consume(1, player);
                }
                level.playSound(player, pos, SoundEvents.WET_GRASS_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
            }
        }
        return InteractionResultHolder.pass(itemstack);
    }
}