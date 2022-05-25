package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.util.recipe.CoolerRecipe;
import com.ianm1647.expandeddelight.util.recipe.CoolerRecipeSerializer;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipe;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RecipeRegistry {
    public static RecipeSerializer<CoolerRecipe> COOLER_SERIALIZER;
    public static RecipeType<CoolerRecipe> COOLER_TYPE;

    public static RecipeSerializer<JuicerRecipe> JUICER_SERIALIZER;
    public static RecipeType<JuicerRecipe> JUICER_TYPE;

    public static void registerRecipes() {
        COOLER_SERIALIZER = serializer("cooling", new CoolerRecipeSerializer());
        COOLER_TYPE = type("cooling", new CoolerRecipeSerializer.CoolerRecipeType());

        JUICER_SERIALIZER = serializer("juicing", new JuicerRecipeSerializer());
        JUICER_TYPE = type("juicing", new JuicerRecipeSerializer.JuicerRecipeType());
    }

    public static RecipeType type(String name, RecipeType recipe) {
        return Registry.register(Registry.RECIPE_TYPE, new Identifier(ExpandedDelight.MOD_ID, name), recipe);
    }

    public static RecipeSerializer serializer(String name, RecipeSerializer recipe) {
        return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(ExpandedDelight.MOD_ID, name), recipe);
    }
}
