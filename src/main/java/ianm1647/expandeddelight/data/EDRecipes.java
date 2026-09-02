package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.data.recipe.*;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EDRecipes extends RecipeProvider {
    public EDRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(RecipeOutput output) {
        CraftingRecipes.register(output);
        CookingRecipes.register(output);
        CuttingRecipes.register(output);
        JuicingRecipes.register(output);
        SmeltingRecipes.register(output);

        CompatRecipes.register(output);
    }
}
