package com.ianm1647.expandeddelight.util.inventory.screen.slot;

import com.ianm1647.expandeddelight.block.entity.CoolerBlockEntity;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class FuelSlot extends Slot {
    public FuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return CoolerBlockEntity.canUseAsFuel(stack) || FuelSlot.isBucket(stack);
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return FuelSlot.isBucket(stack) ? 1 : super.getMaxItemCount(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.isOf(Items.BUCKET);
    }
}