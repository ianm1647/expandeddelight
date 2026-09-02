package ianm1647.expandeddelight.client.recipebook;

import com.google.common.collect.ImmutableList;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.common.registry.EDRecipeTypes;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;

public class RecipeCategories {

    public static RecipeBookCategories JUICING_SEARCH = RecipeBookCategories.valueOf("EXPANDEDDELIGHT_JUICING_SEARCH");
    public static RecipeBookCategories JUICING_DRINKS = RecipeBookCategories.valueOf("EXPANDEDDELIGHT_JUICING_DRINKS");
    public static RecipeBookCategories JUICING_MISC = RecipeBookCategories.valueOf("EXPANDEDDELIGHT_JUICING_MISC");

    public RecipeCategories() {
    }

    public static void init(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(RecipeBookType.valueOf("EXPANDEDDELIGHT_JUICING"), ImmutableList.of(JUICING_SEARCH, JUICING_DRINKS, JUICING_MISC));
        event.registerAggregateCategory(JUICING_SEARCH, ImmutableList.of(JUICING_DRINKS, JUICING_MISC));
        event.registerRecipeCategoryFinder(EDRecipeTypes.JUICING.get(), (recipe) -> {
            Recipe patt0$temp = recipe.value();
            if (patt0$temp instanceof JuicerRecipe juicerRecipe) {
                JuicerRecipeBookTab tab = juicerRecipe.getRecipeBookTab();
                if (tab != null) {
                    RecipeBookCategories var10000;
                    switch (tab) {
                        case DRINKS -> var10000 = JUICING_DRINKS;
                        case MISC -> var10000 = JUICING_MISC;
                        default -> throw new MatchException((String)null, (Throwable)null);
                    }
                    return var10000;
                }
            }
            return JUICING_MISC;
        });
    }
}
