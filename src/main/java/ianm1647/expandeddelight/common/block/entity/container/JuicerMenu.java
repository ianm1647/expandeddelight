package ianm1647.expandeddelight.common.block.entity.container;

import com.mojang.datafixers.util.Pair;
import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDMenuTypes;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import vectorwing.farmersdelight.refabricated.inventory.ItemHandlerSlot;
import vectorwing.farmersdelight.refabricated.inventory.ItemStackHandler;
import vectorwing.farmersdelight.refabricated.inventory.RecipeWrapper;

import java.util.Objects;

public class JuicerMenu extends RecipeBookMenu<RecipeWrapper, JuicerRecipe> {
    private int output = 4;
    private int display = 2;
    private int bottle = 3;

    public static final ResourceLocation EMPTY_CONTAINER_SLOT_BOTTLE = ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "item/empty_container_slot_bottle");
    public final JuicerBlockEntity tileEntity;
    public final ItemStackHandler inventory;
    private final ContainerData juicerData;
    private final ContainerLevelAccess canInteractWithCallable;
    protected final Level level;

    public JuicerMenu(int windowId, Inventory playerInventory, BlockPos data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data), new SimpleContainerData(4));
    }

    public JuicerMenu(int windowId, Inventory playerInventory, JuicerBlockEntity tileEntity, ContainerData juicerDataIn) {
        super(EDMenuTypes.JUICER.get(), windowId);
        this.tileEntity = tileEntity;
        this.inventory = tileEntity.getInventory();
        this.juicerData = juicerDataIn;
        this.level = playerInventory.player.level();
        this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());
        int startX = 8;
        int startY = 18;
        int inputStartX = 42;
        int inputStartY = 23;
        int borderSlotSize = 18;

        for(int row = 0; row < 2; ++row) {
            for(int column = 0; column < 1; ++column) {
                this.addSlot(new ItemHandlerSlot(this.inventory, row * 1 + column, inputStartX + column * borderSlotSize, inputStartY + row * borderSlotSize));
            }
        }

        this.addSlot(new JuicerDrinkSlot(this.inventory, display, 118, 26));
        this.addSlot(new ItemHandlerSlot(this.inventory, bottle, 86, 55) {
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, JuicerMenu.EMPTY_CONTAINER_SLOT_BOTTLE);
            }
        });
        this.addSlot(new JuicerResultSlot(playerInventory.player, tileEntity, this.inventory, output, 118, 55));
        int startPlayerInvY = startY * 4 + 12;

        for(int row = 0; row < 3; ++row) {
            for(int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + row * 9 + column, startX + column * borderSlotSize, startPlayerInvY + row * borderSlotSize));
            }
        }

        for(int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startX + column * borderSlotSize, 142));
        }

        this.addDataSlots(juicerDataIn);
    }

    private static JuicerBlockEntity getTileEntity(Inventory playerInventory, BlockPos data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data);
        if (tileAtPos instanceof JuicerBlockEntity) {
            return (JuicerBlockEntity)tileAtPos;
        } else {
            throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
        }
    }

    public boolean stillValid(Player playerIn) {
        return stillValid(this.canInteractWithCallable, playerIn, (Block) EDBlocks.JUICER.get());
    }

    public ItemStack quickMoveStack(Player playerIn, int index) {
        int indexMealDisplay = 2;
        int indexContainerInput = 3;
        int indexOutput = 4;
        int startPlayerInv = indexOutput + 1;
        int endPlayerInv = startPlayerInv + 36;
        ItemStack slotStackCopy = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            slotStackCopy = slotStack.copy();
            if (index == indexOutput) {
                if (!this.moveItemStackTo(slotStack, startPlayerInv, endPlayerInv, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index <= indexOutput) {
                if (!this.moveItemStackTo(slotStack, startPlayerInv, endPlayerInv, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                boolean isValidContainer = slotStack.is(EDTags.VALID_JUICER_CONTAINERS) || slotStack.is(this.tileEntity.getContainer().getItem());
                if (isValidContainer && !this.moveItemStackTo(slotStack, indexContainerInput, indexContainerInput + 1, false)) {
                    return ItemStack.EMPTY;
                }

                if (!this.moveItemStackTo(slotStack, 0, indexMealDisplay, false)) {
                    return ItemStack.EMPTY;
                }

                if (!this.moveItemStackTo(slotStack, indexContainerInput, indexOutput, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotStack.getCount() == slotStackCopy.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, slotStack);
        }

        return slotStackCopy;
    }

    public int getJuiceProgressionScaled() {
        int i = this.juicerData.get(0);
        int j = this.juicerData.get(1);
        return j != 0 && i != 0 ? i * 40 / j : 0;
    }

    public void fillCraftSlotsStackedContents(StackedContents helper) {
        for(int i = 0; i < this.inventory.getSlotCount(); ++i) {
            helper.accountSimpleStack(this.inventory.getStackInSlot(i));
        }
    }

    public void clearCraftingContent() {
        for(int i = 0; i < 2; ++i) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    public boolean recipeMatches(RecipeHolder<JuicerRecipe> recipe) {
        return recipe.value().matches(new RecipeWrapper(this.inventory), this.level);
    }

    public int getResultSlotIndex() {
        return 3;
    }

    public int getGridWidth() {
        return 1;
    }

    public int getGridHeight() {
        return 2;
    }

    public int getSize() {
        return 3;
    }

    public RecipeBookType getRecipeBookType() {
        return RecipeBookType.valueOf("EXPANDEDDELIGHT_JUICING");
    }

    public boolean shouldMoveToInventory(int slot) {
        return slot < this.getGridWidth() * this.getGridHeight();
    }
}
