package ianm1647.expandeddelight.common.item;

import ianm1647.expandeddelight.client.gui.JuicerTooltip;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class JuicerItem extends BlockItem {
    private static final int BAR_COLOR = Mth.color(0.4F, 0.4F, 1.0F);

    public JuicerItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    public boolean isBarVisible(ItemStack stack) {
        return getServingCount(stack) > 0;
    }

    public int getBarWidth(ItemStack stack) {
        return Math.min(1 + 12 * getServingCount(stack) / 64, 13);
    }

    public int getBarColor(ItemStack stack) {
        return BAR_COLOR;
    }

    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        ItemStack drinkStack = JuicerBlockEntity.getDrinkFromItem(stack);
        return Optional.of(new JuicerTooltip.JuicerTooltipComponent(drinkStack));
    }

    private static int getServingCount(ItemStack stack) {
        ItemStack drinkStack = JuicerBlockEntity.getDrinkFromItem(stack);
        return drinkStack.getCount();
    }
}
