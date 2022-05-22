package com.ianm1647.expandeddelight.item.custom;

import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
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
        tooltip.add(new TranslatableText("item.expandeddelight.juice.tooltip").formatted(Formatting.BLUE));
    }
}
