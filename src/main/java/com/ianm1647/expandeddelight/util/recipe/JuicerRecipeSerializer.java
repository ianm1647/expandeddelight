package com.ianm1647.expandeddelight.util.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class JuicerRecipeSerializer implements RecipeSerializer<JuicerRecipe>  {

    @Override
    public JuicerRecipe read(Identifier id, JsonObject json) {
        final DefaultedList<Ingredient> inputs = readIngredients(JsonHelper.getArray(json, "ingredients"));
        if (inputs.isEmpty()) {
            throw new JsonParseException("No ingredients for juicing recipe");
        } else if (inputs.size() > JuicerRecipe.SLOTS) {
            throw new JsonParseException("Too many ingredients for juicing recipe! The max is " + JuicerRecipe.SLOTS);
        } else {
            final JsonObject jsonResult = JsonHelper.getObject(json, "output");
            final ItemStack output = new ItemStack(JsonHelper.getItem(jsonResult, "item"), JsonHelper.getInt(jsonResult, "count", 1));

            ItemStack container = ItemStack.EMPTY;
            if (JsonHelper.hasElement(json, "container")) {
                final JsonObject jsonContainer = JsonHelper.getObject(json, "container");
                container = new ItemStack(JsonHelper.getItem(jsonContainer, "item"), JsonHelper.getInt(jsonContainer, "count", 1));
            }

            int juiceTime = JsonHelper.getInt(json, "juiceTime", 200);
            return new JuicerRecipe(id, inputs, output, container, juiceTime);
        }
    }

    private static DefaultedList<Ingredient> readIngredients(JsonArray ingredientArray) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.of();
        for (int i = 0; i < ingredientArray.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
            if (!ingredient.isEmpty()) {
                defaultedList.add(ingredient);
            }
        }
        return defaultedList;
    }

    @Override
    public JuicerRecipe read(Identifier id, PacketByteBuf buf) {
        int i = buf.readVarInt();
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(i, Ingredient.EMPTY);

        inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));

        ItemStack output = buf.readItemStack();
        ItemStack container = buf.readItemStack();
        int juiceTime = buf.readVarInt();
        return new JuicerRecipe(id, inputs, output, container, juiceTime);
    }

    @Override
    public void write(PacketByteBuf buf, JuicerRecipe recipe) {
        buf.writeVarInt(recipe.getIngredients().size());

        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.write(buf);
        }

        buf.writeItemStack(recipe.getOutput(null));
        buf.writeItemStack(recipe.getContainer());
        buf.writeVarInt(recipe.getJuiceTime());
    }

    public static class JuicerRecipeType implements RecipeType<JuicerRecipe> {
        public JuicerRecipeType() { }
        public static final JuicerRecipeType INSTANCE = new JuicerRecipeType();
        public static final String ID = "juicing";
    }
}

