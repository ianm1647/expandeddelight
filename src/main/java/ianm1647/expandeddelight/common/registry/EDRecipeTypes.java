package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class EDRecipeTypes {
    public static Supplier<RecipeType<JuicerRecipe>> JUICING;

    public EDRecipeTypes() {
    }

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<T>() {
            public String toString() {
                return "expandeddelight:" + identifier;
            }
        };
    }

    public static void register() {
        JUICING = RegUtils.regRecipe("juicing", () -> registerRecipeType("juicing"));
    }
}
