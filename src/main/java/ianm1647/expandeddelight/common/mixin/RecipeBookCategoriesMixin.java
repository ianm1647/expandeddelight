package ianm1647.expandeddelight.common.mixin;

import ianm1647.expandeddelight.client.recipebook.EDRecipeBookTypes;
import ianm1647.expandeddelight.client.recipebook.EDRecipeCategories;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin({RecipeBookCategories.class})
public class RecipeBookCategoriesMixin {
    public RecipeBookCategoriesMixin() {
    }

    @Inject(
        method = {"getCategories"},
        at = {@At("HEAD")},
        cancellable = true
    )
    private static void getCustomCategories(RecipeBookType recipeBookType, CallbackInfoReturnable<List<RecipeBookCategories>> cir) {
        if (recipeBookType == EDRecipeBookTypes.JUICING) {
            cir.setReturnValue(List.of(EDRecipeCategories.JUICING_SEARCH, EDRecipeCategories.JUICING_DRINKS, EDRecipeCategories.JUICING_MISC));
        }

    }
}