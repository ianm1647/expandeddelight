package ianm1647.expandeddelight.integration.jei;

import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.common.registry.EDRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class JEIRecipes {
   private final RecipeManager recipeManager;

   public JEIRecipes() {
      Minecraft minecraft = Minecraft.getInstance();
      ClientLevel level = minecraft.level;
      if (level != null) {
         this.recipeManager = level.getRecipeManager();
      } else {
         throw new NullPointerException("minecraft world must not be null.");
      }
   }

   public List<JuicerRecipe> getJuicerRecipes() {
      return recipeManager.getAllRecipesFor(EDRecipeTypes.JUICING.get()).stream().map(RecipeHolder::value).toList();
   }
}
