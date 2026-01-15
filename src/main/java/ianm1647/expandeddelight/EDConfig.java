package ianm1647.expandeddelight;

import vectorwing.farmersdelight.refabricated.mlconfigs.ConfigBuilder;
import vectorwing.farmersdelight.refabricated.mlconfigs.ConfigType;
import vectorwing.farmersdelight.refabricated.mlconfigs.ModConfigHolder;

import java.util.function.Supplier;

public class EDConfig {
    public static ModConfigHolder COMMON_CONFIG;
    public static final String CATEGORY_RECIPE_BOOK = "recipe_book";
    public static Supplier<Boolean> ENABLE_RECIPE_BOOK_JUICER;

    public EDConfig() {
    }

    public static void bootstrap() {
    }

    static {
        ConfigBuilder builder = ConfigBuilder.create("expandeddelight", ConfigType.COMMON);
        builder.comment("Recipe book").push("recipe_book");
        ENABLE_RECIPE_BOOK_JUICER = builder.comment("Should the Juicer have a Recipe Book available on its interface?").define("enableRecipeBookJuicer", true);
        builder.pop();
        COMMON_CONFIG = builder.build();
    }
}
