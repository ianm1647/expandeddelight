package com.ianm1647.expandeddelight.block.entity;

import com.google.common.collect.Maps;
import com.ianm1647.expandeddelight.registry.BlockEntityRegistry;
import com.ianm1647.expandeddelight.registry.RecipeRegistry;
import com.ianm1647.expandeddelight.util.inventory.ImplementedInventory;
import com.ianm1647.expandeddelight.util.inventory.screen.CoolerScreenHandler;
import com.ianm1647.expandeddelight.util.recipe.CoolerRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
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
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class CoolerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int[] INGREDIENT = new int[]{1};
    private static final int[] OUTPUT = new int[]{2};
    private static final int[] FUEL = new int[]{0};

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 800;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public CoolerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.COOLER, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> CoolerBlockEntity.this.progress;
                    case 1 -> CoolerBlockEntity.this.maxProgress;
                    case 2 -> CoolerBlockEntity.this.fuelTime;
                    case 3 -> CoolerBlockEntity.this.maxFuelTime;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CoolerBlockEntity.this.progress = value;
                    case 1 -> CoolerBlockEntity.this.maxProgress = value;
                    case 2 -> CoolerBlockEntity.this.fuelTime = value;
                    case 3 -> CoolerBlockEntity.this.maxFuelTime = value;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    public static Map<Item, Integer> createFuelTimeMap() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addFuel(map, Items.SNOWBALL, 800);
        addFuel(map, Items.SNOW_BLOCK, 1200);
        addFuel(map, Items.POWDER_SNOW_BUCKET, 2200);
        addFuel(map, Items.ICE, 2400);
        addFuel(map, Items.PACKED_ICE, 3600);
        addFuel(map, Items.BLUE_ICE, 4800);

        return map;
    }

    public static boolean canUseAsFuel(ItemStack stack) {
        return createFuelTimeMap().containsKey(stack.getItem());
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.expandeddelight.cooler");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CoolerScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("cooler.progress", progress);
        nbt.putInt("cooler.fuelTime", fuelTime);
        nbt.putInt("cooler.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("cooler.progress");
        fuelTime = nbt.getInt("cooler.fuelTime");
        maxFuelTime = nbt.getInt("cooler.maxFuelTime");
    }

    private void consumeFuel() {
        if(!getStack(0).isEmpty()) {
            this.fuelTime = createFuelTimeMap().getOrDefault(this.removeStack(0, 1).getItem(), 0);
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, CoolerBlockEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime--;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(CoolerBlockEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(CoolerBlockEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(CoolerBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CoolerRecipe> match = world.getRecipeManager()
                .getFirstMatch(RecipeRegistry.COOLER_TYPE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(CoolerBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CoolerRecipe> match = world.getRecipeManager()
                .getFirstMatch(RecipeRegistry.COOLER_TYPE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);

            entity.setStack(2, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return OUTPUT;
        } else {
            return side == Direction.UP ? INGREDIENT : FUEL;
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return this.isValid(slot, stack);
    }

    @Override
    public ItemStack removeStack(int slot) {
        if (slot == 2) {
            return Inventories.removeStack(this.inventory, slot);
        }
        return null;
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, ItemConvertible item, int fuelTime) {
        Item item2 = item.asItem();
        fuelTimes.put(item2, fuelTime);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(2).getItem() == output.getItem() || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
