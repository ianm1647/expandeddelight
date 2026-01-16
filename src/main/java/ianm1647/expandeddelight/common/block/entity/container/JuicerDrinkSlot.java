package ianm1647.expandeddelight.common.block.entity.container;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.refabricated.inventory.ItemHandler;
import vectorwing.farmersdelight.refabricated.inventory.ItemHandlerSlot;

public class JuicerDrinkSlot extends ItemHandlerSlot {
    public JuicerDrinkSlot(ItemHandler inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    public boolean mayPickup(Player playerIn) {
        return false;
    }
}
