package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.recipe.JuicerRecipe;
import com.ianm1647.expandeddelight.recipe.JuicerRecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class RecipeRegistry {
    public static RecipeSerializer<JuicerRecipe> JUICER_SERIALIZER;
    public static RecipeType<JuicerRecipe> JUICER_TYPE;

    public static void registerRecipes() {
        JUICER_SERIALIZER = serializer("juicing", new JuicerRecipeSerializer());
        JUICER_TYPE = type("juicing", new JuicerRecipeSerializer.JuicerRecipeType());
    }

    public static <T extends Recipe<?>> RecipeType<T> type(String name, RecipeType<T> recipe) {
        return Registry.register(Registries.RECIPE_TYPE, new Identifier(ExpandedDelight.MODID, name), recipe);
    }

    public static <T extends Recipe<?>> RecipeSerializer<T> serializer(String name, RecipeSerializer<T> recipe) {
        return Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ExpandedDelight.MODID, name), recipe);
    }
}