package ianm1647.expandeddelight.data.recipe;

import alabaster.hearthandharvest.common.tag.HHCommonTags;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCommonTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CookingRecipes {

    public static void register(RecipeOutput output) {
        cookMiscellaneous(output);
        cookMeals(output);
    }

    private static void cookMiscellaneous(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CINNAMON_APPLES.get(), 1, 200, 0.5F, Items.BOWL).addIngredient(Items.WATER_BUCKET).addIngredient(Items.APPLE).addIngredient(EDItems.CINNAMON.get()).addIngredient(Items.SUGAR).unlockedByItems("has_apple", Items.APPLE).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CINNAMON_RICE.get(), 1, 200, 0.5F, Items.BOWL).addIngredient(CommonTags.Items.CROPS_RICE).addIngredient(EDItems.CINNAMON.get()).unlockedByItems("has_rice", ModItems.RICE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
    }

    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_SOUP.get(), 1, 200, 0.8F, Items.BOWL).addIngredient(Items.WATER_BUCKET).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.Items.FOODS_LEAFY_GREEN).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_SOUP_CREAMY.get(), 1, 200, 0.8F, Items.BOWL).addIngredient(Tags.Items.DRINKS_MILK).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.Items.FOODS_LEAFY_GREEN).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.PEPERONATA.get(), 1, 200, 1.3F, Items.BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(EDCommonTags.CROPS_CHILI_PEPPER).addIngredient(CommonTags.Items.CROPS_ONION).addIngredient(CommonTags.Items.CROPS_TOMATO).addIngredient(CommonTags.Items.FOODS_PASTA).unlockedByItems("has_chili_pepper", EDItems.CHILI_PEPPER.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_BACON_MEAL.get(), 1, 200, 1.2F, Items.BOWL).addIngredient(CommonTags.Items.FOODS_RAW_BACON).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.Items.CROPS_ONION).addIngredient(CommonTags.Items.CROPS_RICE).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_MUSHROOM_PASTA.get(), 1, 200, 1.3F, Items.BOWL).addIngredient(CommonTags.Items.FOODS_PASTA).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.Items.CROPS_ONION).addIngredient(Items.BROWN_MUSHROOM).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CHILI_PEPPER_SALMON.get(), 1, 200, 1.3F, Items.BOWL).addIngredient(CommonTags.Items.FOODS_COOKED_SALMON).addIngredient(EDCommonTags.CROPS_CHILI_PEPPER).addIngredient(CommonTags.Items.CROPS_RICE).addIngredient(CommonTags.Items.CROPS_ONION).unlockedByItems("has_chili_pepper", EDItems.CHILI_PEPPER.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CRANBERRY_CHICKEN.get(), 1, 200, 0.9F, Items.BOWL).addIngredient(EDItems.CRANBERRIES.get()).addIngredient(CommonTags.Items.FOODS_COOKED_CHICKEN).addIngredient(CommonTags.Items.CROPS_ONION).unlockedByItems("has_cranberries", EDItems.CRANBERRIES.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.SWEET_POTATO_CASSEROLE.get(), 1, 200, 0.9F, Items.BOWL).addIngredient(EDItems.SWEET_POTATO.get()).addIngredient(Tags.Items.DRINKS_MILK).addIngredient(Tags.Items.EGGS).addIngredient(Items.SUGAR).unlockedByItems("has_sweet_potato", EDItems.SWEET_POTATO.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);

    }
}
