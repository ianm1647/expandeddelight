package ianm1647.expandeddelight.integration.kubejs.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface JuicingRecipeJS {
    RecipeKey<List<Ingredient>> INGREDIENTS = IngredientComponent.INGREDIENT.instance().asList().inputKey("ingredients");
    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK.outputKey("result");
    RecipeKey<ItemStack> CONTAINER = ItemStackComponent.ITEM_STACK.inputKey("container").defaultOptional();
    RecipeKey<Float> EXPERIENCE = NumberComponent.FLOAT.otherKey("experience").optional(0f);
    RecipeKey<Integer> TIME = NumberComponent.INT.otherKey("juicingtime").optional(200);

    RecipeSchema SCHEMA = new RecipeSchema(INGREDIENTS, RESULT, EXPERIENCE, TIME, CONTAINER);

}
