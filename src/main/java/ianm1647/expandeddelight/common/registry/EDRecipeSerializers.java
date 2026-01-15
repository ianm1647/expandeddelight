package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class EDRecipeSerializers {
    public static Supplier<RecipeSerializer<?>> JUICING;

    public EDRecipeSerializers() {
    }

    public static void register() {
        JUICING = RegUtils.regRecipeSerializer("juicing", JuicerRecipe.Serializer::new);
    }
}

