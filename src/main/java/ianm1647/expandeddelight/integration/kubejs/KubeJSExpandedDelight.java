package ianm1647.expandeddelight.integration.kubejs;

import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class KubeJSExpandedDelight implements KubeJSPlugin {

    interface JuicingRecipe {

        RecipeKey<ItemStack> OUTPUT = ItemStackComponent.ITEM_STACK.key("result", ComponentRole.OUTPUT);
        RecipeKey<List<Ingredient>> INPUT = IngredientComponent.INGREDIENT.asList().key("ingredients", ComponentRole.INPUT);
        RecipeKey<Double> EXP = NumberComponent.DOUBLE.key("experience", ComponentRole.OTHER).optional(1.0);
        RecipeKey<Integer> TIME = NumberComponent.INT.key("juicingtime", ComponentRole.OTHER).optional(200);
        RecipeKey<ItemStack> CONTAINER = ItemStackComponent.ITEM_STACK.key("container", ComponentRole.INPUT).optional(ItemStack.EMPTY).allowEmpty();


        RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INPUT, EXP, TIME, CONTAINER);

    }

    interface CookingRecipe {

        RecipeKey<ItemStack> OUTPUT = ItemStackComponent.ITEM_STACK.key("result", ComponentRole.OUTPUT);
        RecipeKey<List<Ingredient>> INPUT = IngredientComponent.INGREDIENT.asList().key("ingredients", ComponentRole.INPUT);
        RecipeKey<Double> EXP = NumberComponent.DOUBLE.key("experience", ComponentRole.OTHER).optional(1.0);
        RecipeKey<Integer> TIME = NumberComponent.INT.key("cookingtime", ComponentRole.OTHER).optional(200);
        RecipeKey<ItemStack> CONTAINER = ItemStackComponent.ITEM_STACK.key("container", ComponentRole.INPUT).optional(ItemStack.EMPTY).allowEmpty();


        RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INPUT, EXP, TIME, CONTAINER);

    }

    interface CuttingRecipe {

        RecipeKey<List<Ingredient>> INPUT = IngredientComponent.INGREDIENT.asList().key("ingredients", ComponentRole.INPUT);
        RecipeKey<Ingredient> TOOL = IngredientComponent.INGREDIENT.key("tool", ComponentRole.OTHER);
        RecipeKey<List<ItemStack>> RESULTS = ItemStackComponent.ITEM_STACK.asList().key("result", ComponentRole.OUTPUT);
        RecipeKey<String> SOUND = StringComponent.ANY.key("sound", ComponentRole.OUTPUT).optional("").allowEmpty();

        RecipeSchema SCHEMA = new RecipeSchema(INPUT, TOOL, RESULTS, SOUND);

    }

    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry event) {
        event.register(ResourceLocation.fromNamespaceAndPath("expandeddelight", "juicing"), JuicingRecipe.SCHEMA);

        event.register(ResourceLocation.fromNamespaceAndPath("farmersdelight", "cooking"), CookingRecipe.SCHEMA);
        //event.register(ResourceLocation.fromNamespaceAndPath("farmersdelight", "cutting"), CuttingRecipe.SCHEMA);

    }

}
