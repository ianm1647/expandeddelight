package com.ianm1647.expandeddelight.item.custom;

import com.ianm1647.expandeddelight.item.ItemList;
import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class JellyItem extends ConsumableItem {

    public JellyItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        if (itemStack.isOf(ItemList.SWEET_BERRY_JELLY)) {
            tooltip.add(Text.translatable("item.expandeddelight.sweet_berry_jelly.tooltip").formatted(Formatting.BLUE));
        }
        if (itemStack.isOf(ItemList.GLOW_BERRY_JELLY)) {
            tooltip.add(Text.translatable("item.expandeddelight.glow_berry_jelly.tooltip").formatted(Formatting.BLUE));
        }
    }
}
