package ianm1647.expandeddelight.data.recipe;

import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCommonTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CookingRecipes {

    public static void register(RecipeOutput output) {
        cookMiscellaneous(output);
        cookMeals(output);
    }

    private static void cookMiscellaneous(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CINNAMON_APPLES.get(), 1, 200, 0.5F, Items.BOWL).addIngredient(Items.WATER_BUCKET).addIngredient(Items.APPLE).addIngredient(EDItems.CINNAMON.get()).addIngredient(Items.SUGAR).unlockedByItems("has_apple", Items.APPLE).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CINNAMON_RICE.get(), 1, 200, 0.5F, Items.BOWL).addIngredient(CommonTags.CROPS_RICE).addIngredient(EDItems.CINNAMON.get()).unlockedByItems("has_rice", ModItems.RICE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.SWEET_BERRY_JELLY.get(), 1, 200, 0.35F, EDItems.GLASS_JAR.get()).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SUGAR).unlockedByItems("has_berries", Items.SWEET_BERRIES).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.GLOW_BERRY_JELLY.get(), 1, 200, 0.35F, EDItems.GLASS_JAR.get()).addIngredient(Items.GLOW_BERRIES).addIngredient(Items.GLOW_BERRIES).addIngredient(Items.SUGAR).unlockedByItems("has_berries", Items.GLOW_BERRIES).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CRANBERRY_JELLY.get(), 1, 200, 0.35F, EDItems.GLASS_JAR.get()).addIngredient(EDItems.CRANBERRIES.get()).addIngredient(EDItems.CRANBERRIES.get()).addIngredient(Items.SUGAR).unlockedByItems("has_berries", EDItems.CRANBERRIES.get()).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.PEANUT_BUTTER.get(), 1, 100, 0.35F, Items.BOWL).addIngredient(EDCommonTags.CROPS_PEANUT).addIngredient(EDCommonTags.CROPS_PEANUT).addIngredient(CommonTags.FOODS_MILK).unlockedByItems("has_peanut", EDItems.PEANUT.get()).setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output);
    }

    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_SOUP.get(), 1, 200, 0.8F, Items.BOWL).addIngredient(Items.WATER_BUCKET).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.FOODS_LEAFY_GREEN).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_SOUP_CREAMY.get(), 1, 200, 0.8F, Items.BOWL).addIngredient(CommonTags.FOODS_MILK).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.FOODS_LEAFY_GREEN).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.PEANUT_HONEY_SOUP.get(), 1, 200, 0.8F, Items.BOWL).addIngredient(CommonTags.FOODS_MILK).addIngredient(EDCommonTags.CROPS_PEANUT).addIngredient(Items.HONEY_BOTTLE).unlockedByItems("has_peanut", EDItems.PEANUT.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.PEPERONATA.get(), 1, 200, 1.3F, Items.BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(EDCommonTags.CROPS_CHILI_PEPPER).addIngredient(CommonTags.CROPS_ONION).addIngredient(CommonTags.CROPS_TOMATO).addIngredient(CommonTags.FOODS_PASTA).unlockedByItems("has_chili_pepper", EDItems.CHILI_PEPPER.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_BACON_MEAL.get(), 1, 200, 1.2F, Items.BOWL).addIngredient(CommonTags.FOODS_RAW_BACON).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.CROPS_ONION).addIngredient(EDCommonTags.FOODS_CHEESE).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.MAC_AND_CHEESE.get(), 1, 200, 1.0F, Items.BOWL).addIngredient(CommonTags.FOODS_MILK).addIngredient(EDCommonTags.FOODS_CHEESE).addIngredient(CommonTags.FOODS_PASTA).addIngredient(EDCommonTags.DUSTS_SALT).unlockedByItems("has_cheese", EDItems.CHEESE_SLICE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_MUSHROOM_PASTA.get(), 1, 200, 1.3F, Items.BOWL).addIngredient(CommonTags.FOODS_PASTA).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(CommonTags.CROPS_ONION).addIngredient(Items.BROWN_MUSHROOM).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_FRITTATA.get(), 1, 200, 1.2F, Items.BOWL).addIngredient(Tags.Items.EGGS).addIngredient(Tags.Items.EGGS).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(EDCommonTags.FOODS_CHEESE).addIngredient(EDCommonTags.DUSTS_SALT).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CHILI_PEPPER_SALMON.get(), 1, 200, 1.3F, Items.BOWL).addIngredient(CommonTags.FOODS_COOKED_SALMON).addIngredient(EDCommonTags.CROPS_CHILI_PEPPER).addIngredient(CommonTags.CROPS_RICE).addIngredient(CommonTags.CROPS_ONION).unlockedByItems("has_chili_pepper", EDItems.CHILI_PEPPER.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.CRANBERRY_CHICKEN.get(), 1, 200, 0.9F, Items.BOWL).addIngredient(EDItems.CRANBERRIES.get()).addIngredient(CommonTags.FOODS_COOKED_CHICKEN).addIngredient(CommonTags.CROPS_ONION).unlockedByItems("has_cranberries", EDItems.CRANBERRIES.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.SWEET_POTATO_CASSEROLE.get(), 1, 200, 0.9F, Items.BOWL).addIngredient(EDItems.SWEET_POTATO.get()).addIngredient(CommonTags.FOODS_MILK).addIngredient(Tags.Items.EGGS).addIngredient(Items.SUGAR).unlockedByItems("has_sweet_potato", EDItems.SWEET_POTATO.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);

    }
}
