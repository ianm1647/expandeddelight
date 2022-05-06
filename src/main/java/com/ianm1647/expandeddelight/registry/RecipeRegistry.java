package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.util.recipe.CoolerRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RecipeRegistry {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(ExpandedDelight.MOD_ID, CoolerRecipe.Serializer.ID),
                CoolerRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(ExpandedDelight.MOD_ID, CoolerRecipe.Type.ID),
                CoolerRecipe.Type.INSTANCE);
    }
}
