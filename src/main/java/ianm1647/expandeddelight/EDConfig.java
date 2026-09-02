package ianm1647.expandeddelight;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = ExpandedDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EDConfig {
    public static ModConfigSpec COMMON_CONFIG;
    private static final Map<String, ModConfigSpec.BooleanValue> ITEMS = new HashMap<>();
    public static final String CATEGORY_RECIPE_BOOK = "recipe_book";
    public static ModConfigSpec.BooleanValue ENABLE_RECIPE_BOOK_JUICER;

    public static boolean enableRecipeBookJuicer;

    public EDConfig() {
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        ENABLE_RECIPE_BOOK_JUICER.get();
    }

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
        COMMON_BUILDER.comment("Recipe book").push("recipe_book");
        ENABLE_RECIPE_BOOK_JUICER = COMMON_BUILDER.comment("Should the Juicer have a Recipe Book available on its interface?").define("enableRecipeBookJuicer", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    private static void put(ModConfigSpec.Builder builder, String name) {
        ITEMS.put(name, builder.define(name, true));
    }

    private static boolean contains(String item) {
        return ITEMS.containsKey(item);
    }
}
