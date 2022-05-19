package com.ianm1647.expandeddelight.item.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class MortarPestleItem extends Item {
    public MortarPestleItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.expandeddelight.mortar_and_pestle.tooltip").formatted(Formatting.GRAY));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack offHand = user.getOffHandStack();
        if(stack.isOf(this) && offHand.isEmpty()) {
            user.sendMessage(new TranslatableText("item.expandeddelight.mortar_and_pestle.fail"), true);
        } else if (stack.isEmpty() && offHand.isOf(this)) {
            user.sendMessage(new TranslatableText("item.expandeddelight.mortar_and_pestle.fail"), true);
        }
        if(stack.isOf(this) && offHand.isOf(Items.SUGAR_CANE)) {
            if(!user.isCreative()) {
                stack.damage(1, user, (playerx) -> playerx.sendToolBreakStatus(hand));
                offHand.decrement(1);
            }
            user.giveItemStack(new ItemStack(Items.SUGAR, 2));
            return TypedActionResult.success(stack);
        } else if (stack.isOf(Items.SUGAR_CANE) && (stack.isOf(this))) {
            if(!user.isCreative()) {
                stack.damage(1, user, (playerx) -> playerx.sendToolBreakStatus(hand));
                offHand.decrement(1);
            }
            user.giveItemStack(new ItemStack(Items.SUGAR, 2));
            return TypedActionResult.success(stack);
        }
        if(stack.isOf(this) && offHand.isOf(ItemList.RAW_CINNAMON)) {
            if(!user.isCreative()) {
                stack.damage(1, user, (playerx) -> playerx.sendToolBreakStatus(hand));
                offHand.decrement(1);
            }
            user.giveItemStack(new ItemStack(ItemList.GROUND_CINNAMON, 2));
            return TypedActionResult.success(stack);
        } else if (stack.isOf(ItemList.RAW_CINNAMON) && stack.isOf(this)) {
            if(!user.isCreative()) {
                stack.damage(1, user, (playerx) -> playerx.sendToolBreakStatus(hand));
                offHand.decrement(1);
            }
            user.giveItemStack(new ItemStack(ItemList.GROUND_CINNAMON, 2));
            return TypedActionResult.success(stack);
        }
        if(stack.isOf(this) && offHand.isOf(ItemList.SALT_ROCK)) {
            if(!user.isCreative()) {
                stack.damage(1, user, (playerx) -> playerx.sendToolBreakStatus(hand));
                offHand.decrement(1);
            }
            user.giveItemStack(new ItemStack(ItemList.GROUND_SALT, 2));
            return TypedActionResult.success(stack);
        } else if (stack.isOf(ItemList.SALT_ROCK) && stack.isOf(this)) {
            if(!user.isCreative()) {
                stack.damage(1, user, (playerx) -> playerx.sendToolBreakStatus(hand));
                offHand.decrement(1);
            }
            user.giveItemStack(new ItemStack(ItemList.GROUND_SALT, 2));
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.pass(stack);
    }
}
