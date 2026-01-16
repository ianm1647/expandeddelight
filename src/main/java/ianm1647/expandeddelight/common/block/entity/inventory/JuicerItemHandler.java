package ianm1647.expandeddelight.common.block.entity.inventory;

import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.item.base.SingleStackStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.StoragePreconditions;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.refabricated.inventory.ItemHandler;
import vectorwing.farmersdelight.refabricated.inventory.ItemStackHandler;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class JuicerItemHandler implements ItemHandler {
    private static final int SLOTS_INPUT = 2;
    private static final int SLOT_CONTAINER_INPUT = 3;
    private static final int SLOT_MEAL_OUTPUT = 4;
    private static final int INVENTORY_SIZE = 5;
    private final ItemStackHandler itemHandler;
    private final Direction side;

    public JuicerItemHandler(ItemStackHandler itemHandler, @Nullable Direction side) {
        this.itemHandler = itemHandler;
        this.side = side;
    }

    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return this.itemHandler.isItemValid(slot, stack);
    }

    public int getSlotCount() {
        return this.itemHandler.getSlotCount();
    }

    public @NotNull ItemStack getStackInSlot(int slot) {
        return this.itemHandler.getStackInSlot(slot);
    }

    public int getSlotLimit(int slot) {
        return this.itemHandler.getSlotLimit(slot);
    }

    public void setStackInSlot(int slot, ItemStack stack) {
        this.itemHandler.setStackInSlot(slot, stack);
    }

    @NotNull
    public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (this.side != null && !this.side.equals(Direction.UP)) {
            return slot == 3 ? this.itemHandler.insertItem(slot, stack, simulate) : stack;
        } else {
            return slot < 2 ? this.itemHandler.insertItem(slot, stack, simulate) : stack;
        }
    }

    @NotNull
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (this.side != null && !this.side.equals(Direction.UP)) {
            return slot == 4 ? this.itemHandler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
        } else {
            return slot < 2 ? this.itemHandler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
        }
    }

    public SingleSlotStorage<ItemVariant> getSlot(int slot) {
        return this.itemHandler.getSlot(slot);
    }

    public long insert(ItemVariant resource, long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notBlankNotNegative(resource, maxAmount);
        long inserted = 0L;
        Iterator<SingleStackStorage> it = this.getInsertableSlotsFor(resource);

        while(it.hasNext()) {
            SingleStackStorage slot = it.next();
            inserted += slot.insert(resource, maxAmount - inserted, transaction);
            if (inserted >= maxAmount) {
                break;
            }
        }

        return inserted;
    }

    public long extract(ItemVariant resource, long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notBlankNotNegative(resource, maxAmount);
        long extracted = 0L;
        Iterator<SingleStackStorage> it = this.getSlotsContaining(resource);

        while(it.hasNext()) {
            SingleStackStorage slot = it.next();
            extracted += slot.extract(resource, maxAmount - extracted, transaction);
            if (extracted >= maxAmount) {
                break;
            }
        }

        return extracted;
    }

    public @NotNull Iterator<StorageView<ItemVariant>> iterator() {
        return this.side != null && !this.side.equals(Direction.UP)
                ? Stream.of(this.itemHandler.getSlots().get(4)).iterator().next().iterator()
                : this.itemHandler.getSlots().subList(0, 2).getFirst().iterator();
    }

    private Iterator<SingleStackStorage> getInsertableSlotsFor(ItemVariant resource) {
        List<SingleSlotStorage<ItemVariant>> slots = this.side != null && !this.side.equals(Direction.UP) ? List.of(this.itemHandler.getSlots().get(3)) : this.itemHandler.getSlots().subList(0, 2);
        return slots.stream().filter((views) -> views.isResourceBlank() ||
                (views.getResource()).equals(resource)).map((storageView) ->
                (SingleStackStorage)storageView).iterator();
    }

    private Iterator<SingleStackStorage> getSlotsContaining(ItemVariant resource) {
        List<SingleSlotStorage<ItemVariant>> slots = this.side != null && !this.side.equals(Direction.UP) ? List.of(this.itemHandler.getSlots().get(4)) : this.itemHandler.getSlots().subList(0, 2);
        return slots.stream().filter((views) ->
                (views.getResource()).equals(resource)).map((storageView) ->
                (SingleStackStorage)storageView).iterator();
    }
}
