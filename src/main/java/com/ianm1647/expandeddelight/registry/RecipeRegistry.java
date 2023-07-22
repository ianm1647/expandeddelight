package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipe;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RecipeRegistry {
    public static RecipeSerializer<JuicerRecipe> JUICER_SERIALIZER;
    public static RecipeType<JuicerRecipe> JUICER_TYPE;

    public static void registerRecipes() {
        JUICER_SERIALIZER = serializer("juicing", new JuicerRecipeSerializer());
        JUICER_TYPE = type("juicing", new JuicerRecipeSerializer.JuicerRecipeType());
    }

    public static RecipeType type(String name, RecipeType recipe) {
        return Registry.register(Registries.RECIPE_TYPE, new Identifier(ExpandedDelight.MODID, name), recipe);
    }

    public static RecipeSerializer serializer(String name, RecipeSerializer recipe) {
        return Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ExpandedDelight.MODID, name), recipe);
    }
}
