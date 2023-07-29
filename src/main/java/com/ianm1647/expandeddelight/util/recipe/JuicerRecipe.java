package com.ianm1647.expandeddelight.util.recipe;

import com.ianm1647.expandeddelight.registry.RecipeRegistry;
import com.nhoryzon.mc.farmersdelight.util.RecipeMatcher;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class JuicerRecipe implements Recipe<Inventory> {
    public static final int SLOTS = 2;
    private final Identifier id;
    private final DefaultedList<Ingredient> ingredients;
    private final ItemStack output;
    private final ItemStack container;
    private final int juiceTime;

    public JuicerRecipe(Identifier id, DefaultedList<Ingredient> ingredients, ItemStack output, ItemStack container, int juiceTime) {
        this.id = id;
        this.ingredients = ingredients;
        this.output = output;
        if (!container.isEmpty()) {
            this.container = container;
        } else if (output.getItem().getRecipeRemainder() != null) {
            this.container = new ItemStack(output.getItem().getRecipeRemainder());
        } else {
            this.container = ItemStack.EMPTY;
        }
        this.juiceTime = juiceTime;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> ingredients = DefaultedList.of();
        ingredients.addAll(this.ingredients);
        return ingredients;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        List<ItemStack> inputs = new ArrayList();
        int i = 0;

        for (int j = 0; j < 4; ++j) {
            ItemStack itemstack = inventory.getStack(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }
        return i == this.ingredients.size() && RecipeMatcher.findMatches(inputs, this.ingredients) != null;
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= ingredients.size();
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return this.output;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.JUICER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.JUICER_TYPE;
    }

    public int getJuiceTime() {
        return this.juiceTime;
    }

    public ItemStack getContainer() {
        return this.container;
    }
}
