package ianm1647.expandeddelight.data.recipe;

import ianm1647.expandeddelight.client.recipebook.JuicerRecipeBookTab;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.data.builder.JuicerRecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.stream.Stream;

public class JuicingRecipes {
    public JuicingRecipes() {
    }

    public static void register(RecipeOutput output) {
        juiceDrinks(output);
        juiceMiscellaneous(output);

    }

    private static void juiceDrinks(RecipeOutput output) {
        JuicerRecipeBuilder.juicerRecipe(EDItems.APPLE_JUICE.get(), 1, 200, 1.0f, Items.GLASS_BOTTLE)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_apple", Items.APPLE)
                .setRecipeBookTab(JuicerRecipeBookTab.DRINKS).build(output);
        JuicerRecipeBuilder.juicerRecipe(ModItems.MELON_JUICE.get(), 1, 200, 1.0f, Items.GLASS_BOTTLE)
                .addIngredient(Items.MELON_SLICE)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_melon", Items.MELON_SLICE)
                .setRecipeBookTab(JuicerRecipeBookTab.DRINKS).build(output);
        JuicerRecipeBuilder.juicerRecipe(EDItems.SWEET_BERRY_JUICE.get(), 1, 200, 1.0f, Items.GLASS_BOTTLE)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_berries", Items.SWEET_BERRIES)
                .setRecipeBookTab(JuicerRecipeBookTab.DRINKS).build(output);
        JuicerRecipeBuilder.juicerRecipe(EDItems.GLOW_BERRY_JUICE.get(), 1, 200, 1.0f, Items.GLASS_BOTTLE)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_berries", Items.GLOW_BERRIES)
                .setRecipeBookTab(JuicerRecipeBookTab.DRINKS).build(output);
        JuicerRecipeBuilder.juicerRecipe(EDItems.CRANBERRY_JUICE.get(), 1, 200, 1.0f, Items.GLASS_BOTTLE)
                .addIngredient(EDItems.CRANBERRIES.get())
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_berries", EDItems.CRANBERRIES.get())
                .setRecipeBookTab(JuicerRecipeBookTab.DRINKS).build(output);
    }

    private static void juiceMiscellaneous(RecipeOutput output) {

    }
}
