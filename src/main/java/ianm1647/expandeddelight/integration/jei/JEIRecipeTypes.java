package ianm1647.expandeddelight.integration.jei;

import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import mezz.jei.api.recipe.RecipeType;

public class JEIRecipeTypes {
   public static final RecipeType<JuicerRecipe> JUICING = RecipeType.create("expandeddelight", "juicing", JuicerRecipe.class);
}
