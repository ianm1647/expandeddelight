package com.ianm1647.expandeddelight.block.entity;

import com.ianm1647.expandeddelight.registry.BlockEntityRegistry;
import com.ianm1647.expandeddelight.registry.RecipeRegistry;
import com.ianm1647.expandeddelight.util.inventory.ImplementedInventory;
import com.ianm1647.expandeddelight.util.inventory.screen.JuicerScreenHandler;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class JuicerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 200;

    public JuicerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.JUICER, blockPos, blockState);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> JuicerBlockEntity.this.progress;
                    case 1 -> JuicerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> JuicerBlockEntity.this.progress = value;
                    case 1 -> JuicerBlockEntity.this.maxProgress = value;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.expandeddelight.juicer");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new JuicerScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("cooler.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("cooler.progress");
    }

    public static void tick(World world, BlockPos pos, BlockState state, JuicerBlockEntity entity) {
        if(hasRecipe(entity)) {
            entity.progress++;
            if(entity.progress > entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
        }
        boolean dirty = false;
        if (!entity.getStack(3).isEmpty()) {
            if (!entity.getStack(2).isEmpty()) {
                entity.useStoredBottleOnJuice();
                dirty = true;
            }
        }
    }

    private static void craftItem(JuicerBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<JuicerRecipe> match = world.getRecipeManager()
                .getFirstMatch(RecipeRegistry.JUICER_TYPE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(0,1);
            entity.removeStack(1, 1);

            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(JuicerBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<JuicerRecipe> match = world.getRecipeManager()
                .getFirstMatch(RecipeRegistry.JUICER_TYPE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }

    private void resetProgress() {
        this.progress = 0;
    }

    /* from CookingPotBlockEntity class */

    private void useStoredBottleOnJuice() {
        ItemStack juiceDisplay = this.getStack(3);
        ItemStack bottleInput = this.getStack(2);
        ItemStack finalOutput = this.getStack(4);
        if (bottleInput.isOf(Items.GLASS_BOTTLE) && finalOutput.getCount() < finalOutput.getMaxCount()) {
            int smallerStack = Math.min(juiceDisplay.getCount(), bottleInput.getCount());
            int juiceCount = Math.min(smallerStack, juiceDisplay.getMaxCount() - finalOutput.getCount());
            if (finalOutput.isEmpty()) {
                bottleInput.decrement(juiceCount);
                this.setStack(4, juiceDisplay.split(juiceCount));
            } else if (finalOutput.getItem() == juiceDisplay.getItem()) {
                juiceDisplay.decrement(juiceCount);
                bottleInput.decrement(juiceCount);
                finalOutput.increment(juiceCount);
            }
        }

    }

    public ItemStack useBottleOnJuice(ItemStack container) {
        if (container.isOf(Items.GLASS_BOTTLE) && !this.getStack(3).isEmpty()) {
            container.decrement(1);
            return this.getStack(3).split(1);
        } else {
            return ItemStack.EMPTY;
        }
    }

    public DefaultedList<ItemStack> getDroppableInventory() {
        DefaultedList<ItemStack> drops = DefaultedList.of();

        for (int i = 0; i < 5; ++i) {
            drops.add(i == 3 ? ItemStack.EMPTY : this.getStack(i));
        }

        return drops;
    }
}
