package com.ianm1647.expandeddelight.item.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class JuiceItem extends ConsumableItem {
    public JuiceItem(Settings settings) {
        super(settings);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        if (itemStack.isOf(ItemList.APPLE_JUICE)) {
            tooltip.add(Text.translatable("item.expandeddelight.apple_juice.tooltip").formatted(Formatting.BLUE));
        }
        if (itemStack.isOf(ItemList.SWEET_BERRY_JUICE)) {
            tooltip.add(Text.translatable("item.expandeddelight.sweet_berry_juice.tooltip").formatted(Formatting.BLUE));
        }
        if (itemStack.isOf(ItemList.GLOW_BERRY_JUICE)) {
            tooltip.add(Text.translatable("item.expandeddelight.glow_berry_juice.tooltip").formatted(Formatting.BLUE));
        }
    }
}
