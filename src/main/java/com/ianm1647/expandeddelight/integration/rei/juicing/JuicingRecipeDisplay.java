package com.ianm1647.expandeddelight.integration.rei.juicing;

import com.google.common.collect.ImmutableList;
import com.ianm1647.expandeddelight.integration.rei.ExpandedDelightREI;
import com.ianm1647.expandeddelight.util.recipe.JuicerRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.*;

@Environment(EnvType.CLIENT)
public class JuicingRecipeDisplay extends BasicDisplay {
    private final EntryIngredient bottleOutput;
    private final int cookTime;

    public JuicingRecipeDisplay(JuicerRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput(null))), Optional.ofNullable(recipe.getId()));
        this.bottleOutput = EntryIngredients.of(recipe.getBottle());
        this.cookTime = recipe.getCookTime();
    }

    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ExpandedDelightREI.JUICING;
    }

    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList(super.getInputEntries());
        inputEntryList.add(this.bottleOutput);
        return ImmutableList.copyOf(inputEntryList);
    }

    public List<EntryIngredient> getIngredientEntries() {
        return super.getInputEntries();
    }

    public EntryIngredient getContainerOutput() {
        return this.bottleOutput;
    }

    public int getCookTime() {
        return this.cookTime;
    }
}