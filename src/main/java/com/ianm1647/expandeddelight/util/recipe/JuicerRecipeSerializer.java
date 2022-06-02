package com.ianm1647.expandeddelight.util.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class JuicerRecipeSerializer implements RecipeSerializer<JuicerRecipe>  {

    @Override
    public JuicerRecipe read(Identifier id, JsonObject json) {
        ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

        JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
        }
        return new JuicerRecipe(id, output, inputs);
    }

    @Override
    public JuicerRecipe read(Identifier id, PacketByteBuf buf) {
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromPacket(buf));
        }

        ItemStack output = buf.readItemStack();

        return new JuicerRecipe(id, output, inputs);
    }

    @Override
    public void write(PacketByteBuf buf, JuicerRecipe recipe) {
        buf.writeInt(recipe.getIngredients().size());
        for (Ingredient ing : recipe.getIngredients()) {
            ing.write(buf);
        }
        buf.writeItemStack(recipe.getOutput());
    }

    public static class JuicerRecipeType implements RecipeType<JuicerRecipe> {
        public JuicerRecipeType() { }
        public static final JuicerRecipeSerializer.JuicerRecipeType INSTANCE = new JuicerRecipeSerializer.JuicerRecipeType();
        public static final String ID = "juicing";
    }
}
