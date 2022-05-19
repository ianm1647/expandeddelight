package com.ianm1647.expandeddelight.item.custom;

import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class JuiceItem extends ConsumableItem {
    public JuiceItem(Settings settings) {
        super(settings);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
