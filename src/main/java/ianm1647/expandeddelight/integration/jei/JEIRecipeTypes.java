package ianm1647.expandeddelight.integration.jei;

import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.integration.jei.resource.CheeseFermentingDummy;
import mezz.jei.api.recipe.RecipeType;

public class JEIRecipeTypes {
   public static final RecipeType<JuicerRecipe> JUICING = RecipeType.create("expandeddelight", "juicing", JuicerRecipe.class);
   public static final RecipeType<CheeseFermentingDummy> CHEESE_FERMENTING = RecipeType.create("expandeddelight", "cheese_fermenting", CheeseFermentingDummy.class);

}
