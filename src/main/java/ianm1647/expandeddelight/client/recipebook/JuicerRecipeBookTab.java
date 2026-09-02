package ianm1647.expandeddelight.client.recipebook;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import java.util.EnumSet;

public enum JuicerRecipeBookTab {
    DRINKS("drinks"),
    MISC("misc");

    public static final Codec<JuicerRecipeBookTab> CODEC = Codec.STRING.flatXmap((s) -> {
        JuicerRecipeBookTab tab = findByName(s);
        return tab == null ? DataResult.error(
                () -> "Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: "
                        + EnumSet.allOf(JuicerRecipeBookTab.class)) : DataResult.success(tab);
    }, (tab) -> DataResult.success(tab.toString()));
    public final String name;

    private JuicerRecipeBookTab(String name) {
        this.name = name;
    }

    public static JuicerRecipeBookTab findByName(String name) {
        JuicerRecipeBookTab[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            JuicerRecipeBookTab value = var1[var3];
            if (value.name.equals(name)) {
                return value;
            }
        }

        return null;
    }

    public String toString() {
        return this.name;
    }
}