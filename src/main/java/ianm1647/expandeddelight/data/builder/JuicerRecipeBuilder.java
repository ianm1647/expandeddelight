package ianm1647.expandeddelight.data.builder;

import ianm1647.expandeddelight.client.recipebook.JuicerRecipeBookTab;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class JuicerRecipeBuilder implements RecipeBuilder {
    private JuicerRecipeBookTab tab;
    private final NonNullList<Ingredient> ingredients;
    private final Item result;
    private final ItemStack resultStack;
    private final int juiceTime;
    private final float experience;
    private final ItemStack container;
    private final Map<String, Criterion<?>> criteria;

    public JuicerRecipeBuilder(ItemLike result, int count, int juiceTime, float experience, @Nullable ItemLike container) {
        this(new ItemStack(result, count), juiceTime, experience, container);
    }

    public JuicerRecipeBuilder(ItemStack resultIn, int juiceTime, float experience, @Nullable ItemLike container) {
        this.ingredients = NonNullList.create();
        this.criteria = new LinkedHashMap<>();
        this.result = resultIn.getItem();
        this.resultStack = resultIn;
        this.juiceTime = juiceTime;
        this.experience = experience;
        this.container = container != null ? new ItemStack(container) : ItemStack.EMPTY;
        this.tab = null;
    }

    public static JuicerRecipeBuilder juicerRecipe(ItemLike mainResult, int count, int juiceTime, float experience) {
        return new JuicerRecipeBuilder(mainResult, count, juiceTime, experience, null);
    }

    public static JuicerRecipeBuilder juicerRecipe(ItemLike mainResult, int count, int juiceTime, float experience, ItemLike container) {
        return new JuicerRecipeBuilder(mainResult, count, juiceTime, experience, container);
    }

    public JuicerRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public JuicerRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public JuicerRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }

    public JuicerRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient(ingredientIn, 1);
    }

    public JuicerRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }

        return this;
    }

    public RecipeBuilder group(@org.jetbrains.annotations.Nullable String p_176495_) {
        return this;
    }

    public JuicerRecipeBuilder setRecipeBookTab(JuicerRecipeBookTab tab) {
        this.tab = tab;
        return this;
    }

    public Item getResult() {
        return this.result;
    }

    public JuicerRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
        this.criteria.put(criterionName, criterionTrigger);
        return this;
    }

    public JuicerRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return this.unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public JuicerRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        this.criteria.put("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public void build(RecipeOutput output) {
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(this.result);
        this.save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", location.getPath()));
    }

    public void build(RecipeOutput outputIn, String save) {
        ResourceLocation resourcelocation = BuiltInRegistries.ITEM.getKey(this.result);
        if (ResourceLocation.parse(save).equals(resourcelocation)) {
            throw new IllegalStateException("Juicing Recipe " + save + " should remove its 'save' argument");
        } else {
            this.save(outputIn, ResourceLocation.parse(save));
        }
    }

    public void save(RecipeOutput output, ResourceLocation id) {
        ResourceLocation recipeId = id.withPrefix("juicing/");
        Advancement.Builder advancementBuilder = output.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancementBuilder::addCriterion); 
        Objects.requireNonNull(advancementBuilder);
        JuicerRecipe recipe = new JuicerRecipe("", this.tab, this.ingredients, this.resultStack, this.container, this.experience, this.juiceTime);
        output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("recipes/juicing/")));
    }
}
