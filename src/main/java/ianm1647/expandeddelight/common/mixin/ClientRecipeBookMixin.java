package ianm1647.expandeddelight.common.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import ianm1647.expandeddelight.client.recipebook.EDRecipeCategories;
import ianm1647.expandeddelight.client.recipebook.JuicerRecipeBookTab;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ClientRecipeBook.class})
public class ClientRecipeBookMixin {
    public ClientRecipeBookMixin() {
    }

    @Inject(
        method = {"setupCollections"},
        at = {@At(
    value = "INVOKE",
    target = "Lcom/google/common/collect/ImmutableMap;copyOf(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;"
)}
    )
    private void setupAggregateCategories(Iterable<RecipeHolder<?>> iterable, RegistryAccess registryAccess, CallbackInfo ci, @Local(ordinal = 1) Map<RecipeBookCategories, List<RecipeCollection>> aggregateCategories) {
        aggregateCategories.put(
                EDRecipeCategories.JUICING_SEARCH, Stream.of(EDRecipeCategories.JUICING_DRINKS, EDRecipeCategories.JUICING_MISC).flatMap((categories) ->
                        ((List)aggregateCategories.getOrDefault(categories, List.of())).stream()).toList());
    }

    @Inject(
        method = {"getCategory"},
        at = {@At(
    value = "INVOKE",
    target = "Lcom/mojang/logging/LogUtils;defer(Ljava/util/function/Supplier;)Ljava/lang/Object;",
    ordinal = 0
)},
        cancellable = true
    )
    private static void getCustomRecipeCategory(RecipeHolder<?> recipe, CallbackInfoReturnable<RecipeBookCategories> cir) {
        Recipe var3 = recipe.value();
        if (var3 instanceof JuicerRecipe juicerRecipe) {
            JuicerRecipeBookTab tab = juicerRecipe.getRecipeBookTab();
            if (tab != null) {
                RecipeBookCategories var10001;
                switch (tab) {
                    case DRINKS -> var10001 = EDRecipeCategories.JUICING_DRINKS;
                    case MISC -> var10001 = EDRecipeCategories.JUICING_MISC;
                    default -> throw new IncompatibleClassChangeError();
                }

                cir.setReturnValue(var10001);
            }
        }

    }
}