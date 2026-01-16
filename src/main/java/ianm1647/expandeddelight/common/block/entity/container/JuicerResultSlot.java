package ianm1647.expandeddelight.common.block.entity.container;

import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.refabricated.inventory.ItemHandler;
import vectorwing.farmersdelight.refabricated.inventory.ItemHandlerSlot;

public class JuicerResultSlot extends ItemHandlerSlot {
    public final JuicerBlockEntity tileEntity;
    private final Player player;
    private int removeCount;

    public JuicerResultSlot(Player player, JuicerBlockEntity tile, ItemHandler inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
        this.tileEntity = tile;
        this.player = player;
    }

    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @NotNull
    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }

        return super.remove(amount);
    }

    public void onTake(Player thePlayer, ItemStack stack) {
        this.checkTakeAchievements(stack);
        super.onTake(thePlayer, stack);
    }

    protected void onQuickCraft(ItemStack stack, int amount) {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }

    protected void checkTakeAchievements(ItemStack stack) {
        stack.onCraftedBy(this.player.level(), this.player, this.removeCount);
        if (!this.player.level().isClientSide) {
            this.tileEntity.awardUsedRecipes(this.player, this.tileEntity.getDroppableInventory());
        }

        this.removeCount = 0;
    }
}
