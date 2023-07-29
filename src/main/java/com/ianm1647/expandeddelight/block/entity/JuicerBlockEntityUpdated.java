package com.ianm1647.expandeddelight.block.entity;

import com.ianm1647.expandeddelight.block.custom.JuicerBlockUpdated;
import com.ianm1647.expandeddelight.registry.BlockEntityRegistry;
import com.ianm1647.expandeddelight.registry.RecipeRegistry;
import com.ianm1647.expandeddelight.util.inventory.ImplementedInventory;
import com.ianm1647.expandeddelight.util.inventory.screen.JuicerScreenHandler;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipe;
import com.nhoryzon.mc.farmersdelight.entity.block.SyncedBlockEntity;
import com.nhoryzon.mc.farmersdelight.entity.block.inventory.RecipeWrapper;
import com.nhoryzon.mc.farmersdelight.mixin.accessors.RecipeManagerAccessorMixin;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class JuicerBlockEntityUpdated extends SyncedBlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    public static final int JUICE_DISPLAY_SLOT = 3;
    public static final int CONTAINER_SLOT = 2;
    public static final int OUTPUT_SLOT = 4;
    public static final int INVENTORY_SIZE = 5;
    private final DefaultedList<ItemStack> inventory;
    private int juiceTime;
    private int juiceTimeTotal;
    private ItemStack container;
    protected final PropertyDelegate juicerData;
    private Identifier lastRecipeID;
    private boolean checkNewRecipe;

    public JuicerBlockEntityUpdated(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.JUICER, blockPos, blockState);
        this.inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
        this.container = ItemStack.EMPTY;
        this.checkNewRecipe = true;
        this.juicerData = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> JuicerBlockEntityUpdated.this.juiceTime;
                    case 1 -> JuicerBlockEntityUpdated.this.juiceTimeTotal;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> JuicerBlockEntityUpdated.this.juiceTime = value;
                    case 1 -> JuicerBlockEntityUpdated.this.juiceTimeTotal = value;
                }
            }
            public int size() {
                return 2;
            }
        };
    }

    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbt = new NbtCompound();
        this.writeNbt(nbt);
        return nbt;
    }

    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        Inventories.readNbt(tag, inventory);
        this.juiceTime = tag.getInt("JuiceTime");
        this.juiceTimeTotal = tag.getInt("JuiceTimeTotal");
        this.container = ItemStack.fromNbt(tag.getCompound("Container"));
    }

    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        Inventories.writeNbt(tag, inventory);
        tag.putInt("JuiceTime", this.juiceTime);
        tag.putInt("JuiceTimeTotal", this.juiceTime);
        tag.put("Container", this.container.writeNbt(new NbtCompound()));
    }

    public NbtCompound writeJuice(NbtCompound tag) {
        if (this.getJuice().isEmpty()) {
            return tag;
        } else {
            tag.put("Container", this.container.writeNbt(new NbtCompound()));
            DefaultedList<ItemStack> drops = DefaultedList.ofSize(5, ItemStack.EMPTY);
            for(int i = 0; i < 4; ++i) {
                drops.set(i, i == 3 ? this.getStack(i) : ItemStack.EMPTY);
            }
            tag.put("Inventory", Inventories.writeNbt(new NbtCompound(), drops));
            return tag;
        }
    }

    public Text getName() {
        return Text.translatable("container.expandeddelight.juicer");
    }

    @Override
    public Text getDisplayName() {
        return this.getName();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new JuicerScreenHandler(syncId, inv, this, this.juicerData);
    }

    public static void tick(World world, BlockPos pos, BlockState state, JuicerBlockEntityUpdated juicer) {
        boolean dirty = false;
        if (!world.isClient && juicer.hasInput()) {
            Optional<JuicerRecipe> recipe = juicer.getMatchingRecipe(new RecipeWrapper(juicer));
            if (recipe.isPresent() && juicer.canJuice(recipe.get())) {
                dirty = juicer.processJuicing(recipe.get());
            } else {
                juicer.juiceTime = 0;
            }
        } else if (juicer.juiceTime > 0) {
            juicer.juiceTime = MathHelper.clamp(juicer.juiceTime - 2, 0, juicer.juiceTimeTotal);
        }
        ItemStack juice = juicer.getJuice();
        if (!juice.isEmpty()) {
            if (!juicer.doesJuiceHaveContainer(juice)) {
                juicer.moveJuiceToOutput();
                dirty = true;
            } else if (!juicer.getStack(2).isEmpty()) {
                juicer.useStoredContainers();
                dirty = true;
            }
        }
        if (dirty) {
            juicer.inventoryChanged();
        }
    }

    private Optional<JuicerRecipe> getMatchingRecipe(RecipeWrapper inventory) {
        if (this.world == null) {
            return Optional.empty();
        } else {
            if (this.lastRecipeID != null) {
                Recipe<Inventory> recipe = ((RecipeManagerAccessorMixin)this.world.getRecipeManager()).getAllForType(RecipeRegistry.JUICER_TYPE).get(this.lastRecipeID);
                if (recipe instanceof JuicerRecipe) {
                    if (recipe.matches(inventory, this.world)) {
                        return Optional.of((JuicerRecipe)recipe);
                    }

                    if (ItemStack.areItemsEqual(recipe.getOutput(this.world.getRegistryManager()), this.getJuice())) {
                        return Optional.empty();
                    }
                }
            }
            if (this.checkNewRecipe) {
                Optional<JuicerRecipe> recipe = this.world.getRecipeManager().getFirstMatch(RecipeRegistry.JUICER_TYPE, inventory, this.world);
                if (recipe.isPresent()) {
                    this.lastRecipeID = (recipe.get()).getId();
                    return recipe;
                }
            }
            this.checkNewRecipe = false;
            return Optional.empty();
        }
    }

    private boolean processJuicing(JuicerRecipe recipe) {
        if (this.world != null && recipe != null) {
            ++this.juiceTime;
            this.juiceTimeTotal = recipe.getJuiceTime();
            if (this.juiceTime < this.juiceTimeTotal) {
                return false;
            } else {
                this.juiceTime = 0;
                this.container = recipe.getContainer();
                ItemStack recipeOutput = recipe.getOutput(this.world.getRegistryManager());
                ItemStack currentOutput = this.getStack(3);
                if (currentOutput.isEmpty()) {
                    this.setStack(3, recipeOutput.copy());
                } else if (currentOutput.getItem() == recipeOutput.getItem()) {
                    currentOutput.increment(recipeOutput.getCount());
                }
                for(int i = 0; i < 3; ++i) {
                    ItemStack itemStack = this.getStack(i);
                    if (itemStack.getItem().hasRecipeRemainder() && this.world != null) {
                        Direction direction = (this.getCachedState().get(JuicerBlockUpdated.FACING)).rotateYCounterclockwise();
                        double dropX = (double)this.pos.getX() + 0.5 + (double)direction.getOffsetX() * 0.25;
                        double dropY = (double)this.pos.getY() + 0.7;
                        double dropZ = (double)this.pos.getZ() + 0.5 + (double)direction.getOffsetZ() * 0.25;
                        ItemEntity entity = new ItemEntity(this.world, dropX, dropY, dropZ, new ItemStack(this.getStack(i).getItem().getRecipeRemainder()));
                        entity.setVelocity(((float)direction.getOffsetX() * 0.08F), 0.25, ((float)direction.getOffsetZ() * 0.08F));
                        this.world.spawnEntity(entity);
                    }
                    if (!this.getStack(i).isEmpty()) {
                        this.getStack(i).decrement(1);
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    protected boolean canJuice(Recipe<?> recipeIn) {
        if (this.hasInput() && recipeIn != null) {
            ItemStack recipeOutput = recipeIn.getOutput(this.world.getRegistryManager());
            if (recipeOutput.isEmpty()) {
                return false;
            } else {
                ItemStack currentOutput = this.getStack(3);
                if (currentOutput.isEmpty()) {
                    return true;
                } else if (!ItemStack.areItemsEqual(currentOutput, recipeOutput)) {
                    return false;
                } else if (currentOutput.getCount() + recipeOutput.getCount() <= this.getMaxCountPerStack()) {
                    return true;
                } else {
                    return currentOutput.getCount() + recipeOutput.getCount() <= recipeOutput.getMaxCount();
                }
            }
        } else {
            return false;
        }
    }

    private boolean hasInput() {
        for(int i = 0; i < 3; ++i) {
            if (!this.getStack(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public ItemStack getJuice() {
        return this.getStack(3);
    }

    public DefaultedList<ItemStack> getDroppableInventory() {
        DefaultedList<ItemStack> drops = DefaultedList.of();
        for (int i = 0; i < 4; ++i) {
            drops.add(i == 3 ? ItemStack.EMPTY : this.getStack(i));
        }
        return drops;
    }

    private void moveJuiceToOutput() {
        ItemStack juiceDisplay = this.getStack(3);
        ItemStack finalOutput = this.getStack(4);
        int juiceCount = Math.min(juiceDisplay.getCount(), juiceDisplay.getMaxCount() - finalOutput.getCount());
        if (finalOutput.isEmpty()) {
            this.setStack(4, juiceDisplay.split(juiceCount));
        } else if (finalOutput.getItem() == juiceDisplay.getItem()) {
            juiceDisplay.decrement(juiceCount);
            finalOutput.increment(juiceCount);
        }
    }

    private void useStoredContainers() {
        ItemStack juiceDisplay = this.getStack(3);
        ItemStack containerInput = this.getStack(2);
        ItemStack finalOutput = this.getStack(4);
        if (this.isContainerValid(containerInput) && finalOutput.getCount() < finalOutput.getMaxCount()) {
            int smallerStack = Math.min(juiceDisplay.getCount(), containerInput.getCount());
            int mealCount = Math.min(smallerStack, juiceDisplay.getMaxCount() - finalOutput.getCount());
            if (finalOutput.isEmpty()) {
                containerInput.decrement(mealCount);
                this.setStack(4, juiceDisplay.split(mealCount));
            } else if (finalOutput.getItem() == juiceDisplay.getItem()) {
                juiceDisplay.decrement(mealCount);
                containerInput.decrement(mealCount);
                finalOutput.increment(mealCount);
            }
        }

    }

    public ItemStack useContainerOnJuicer(ItemStack container) {
        if (this.isContainerValid(container) && !this.getJuice().isEmpty()) {
            container.decrement(1);
            return this.getJuice().split(1);
        } else {
            return ItemStack.EMPTY;
        }
    }

    private boolean doesJuiceHaveContainer(ItemStack meal) {
        return !this.container.isEmpty() || meal.getItem().hasRecipeRemainder();
    }

    public boolean isContainerValid(ItemStack containerItem) {
        if (containerItem.isEmpty()) {
            return false;
        } else {
            return !this.container.isEmpty() ? ItemStack.areItemsEqual(this.container, containerItem) : containerItem.isOf(this.getJuice().getItem().getRecipeRemainder());
        }
    }
}
