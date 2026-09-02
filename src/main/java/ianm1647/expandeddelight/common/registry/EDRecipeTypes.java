package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EDRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES;
    public static final Supplier<RecipeType<JuicerRecipe>> JUICING;

    public EDRecipeTypes() {
    }

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<T>() {
            public String toString() {
                return "expandeddelight:" + identifier;
            }
        };
    }

    static {
        RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, ExpandedDelight.MODID);
        JUICING = RECIPE_TYPES.register("juicing", () -> registerRecipeType("juicing"));
    }
}
