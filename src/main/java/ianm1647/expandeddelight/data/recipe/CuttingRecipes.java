package ianm1647.expandeddelight.data.recipe;

import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingRecipes {

    public static void register(RecipeOutput output) {
        cuttingBlocks(output);
        crushingMaterials(output);
        cuttingFoods(output);
        cuttingFlowers(output);
    }

    private static void cuttingBlocks(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_TRAPDOOR.get()), Ingredient.of(ItemTags.AXES), EDItems.CINNAMON_PLANKS.get()).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_DOOR.get()), Ingredient.of(ItemTags.AXES), EDItems.CINNAMON_PLANKS.get()).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_HANGING_SIGN.get()), Ingredient.of(ItemTags.AXES), EDItems.CINNAMON_PLANKS.get()).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_SIGN.get()), Ingredient.of(ItemTags.AXES), EDItems.CINNAMON_PLANKS.get()).save(output);

    }

    private static void crushingMaterials(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_LOG.get()), Ingredient.of(ItemTags.AXES), EDItems.CINNAMON_STICK.get(), 4).addResult(EDItems.CINNAMON_STRIPPED_LOG.get()).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_WOOD.get()), Ingredient.of(ItemTags.AXES), EDItems.CINNAMON_STICK.get(), 6).addResult(EDItems.CINNAMON_STRIPPED_WOOD.get()).save(output);

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.SUGAR_CANE), Ingredient.of(EDTags.CRUSHING_TOOLS), Items.SUGAR, 2).addResultWithChance(Items.SUGAR, 0.15f).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "sugar_cane"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.SALT_ROCK.get()), Ingredient.of(EDTags.CRUSHING_TOOLS), EDItems.SALT.get(), 2).addResultWithChance(EDItems.SALT.get(), 0.15f).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CINNAMON_STICK.get()), Ingredient.of(EDTags.CRUSHING_TOOLS), EDItems.CINNAMON.get(), 2).addResultWithChance(EDItems.CINNAMON.get(), 0.15f).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BLAZE_ROD), Ingredient.of(EDTags.CRUSHING_TOOLS), Items.BLAZE_POWDER, 3).addResultWithChance(Items.BLAZE_POWDER, 0.15f).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BONE), Ingredient.of(EDTags.CRUSHING_TOOLS), Items.BONE_MEAL, 4).addResultWithChance(Items.BONE_MEAL, 0.15f).save(output);

    }

    private static void cuttingFoods(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CHEESE_WHEEL.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.CHEESE_SLICE.get(), 4).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.GOAT_CHEESE_WHEEL.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.GOAT_CHEESE_SLICE.get(), 4).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.CRANBERRY_COBBLER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.CRANBERRY_COBBLER_SLICE.get(), 4).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.HONEYED_GOAT_CHEESE_TART.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get(), 4).save(output);

    }

    private static void cuttingFlowers(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.WILD_ASPARAGUS.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.ASPARAGUS.get(), 1)
                .addResultWithChance(EDItems.ASPARAGUS_SEEDS.get(), 0.5F).addResultWithChance(Items.BROWN_DYE, 0.1F, 2).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.WILD_SWEET_POTATO.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.SWEET_POTATO.get(), 1)
                .addResultWithChance(Items.GREEN_DYE, 0.1F, 2).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.WILD_CHILI_PEPPER.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.CHILI_PEPPER.get(), 1)
                .addResultWithChance(EDItems.CHILI_PEPPER_SEEDS.get(), 0.5F).addResultWithChance(Items.WHITE_DYE, 0.25F, 2).save(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(EDItems.WILD_PEANUTS.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), EDItems.PEANUT.get(), 1)
                .addResultWithChance(Items.YELLOW_DYE, 0.25F, 2).save(output);
    }
}
