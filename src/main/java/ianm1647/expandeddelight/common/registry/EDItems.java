package ianm1647.expandeddelight.common.registry;

import com.google.common.collect.Sets;
import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.entity.CinnamonBoat;
import ianm1647.expandeddelight.common.item.CinnamonBoatItem;
import ianm1647.expandeddelight.common.item.JuicerItem;
import ianm1647.expandeddelight.common.item.LilypadCropItem;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class EDItems {

    public static final DeferredRegister<Item> ITEMS;
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS;

    public static Supplier<Item> CINNAMON_SAPLING;
    public static Supplier<Item> CINNAMON_LEAVES;
    public static Supplier<Item> CINNAMON_LOG;
    public static Supplier<Item> CINNAMON_WOOD;
    public static Supplier<Item> CINNAMON_STRIPPED_LOG;
    public static Supplier<Item> CINNAMON_STRIPPED_WOOD;
    public static Supplier<Item> CINNAMON_PLANKS;
    public static Supplier<Item> CINNAMON_STAIRS;
    public static Supplier<Item> CINNAMON_SLAB;
    public static Supplier<Item> CINNAMON_FENCE;
    public static Supplier<Item> CINNAMON_FENCE_GATE;
    public static Supplier<Item> CINNAMON_DOOR;
    public static Supplier<Item> CINNAMON_TRAPDOOR;
    public static Supplier<Item> CINNAMON_PRESSURE_PLATE;
    public static Supplier<Item> CINNAMON_BUTTON;
    public static Supplier<Item> CINNAMON_SIGN;
    public static Supplier<Item> CINNAMON_HANGING_SIGN;
    public static Supplier<Item> CINNAMON_CABINET;
    public static Supplier<Item> CINNAMON_BOAT;
    public static Supplier<Item> CINNAMON_CHEST_BOAT;

    public static Supplier<Item> JUICER;

    public static Supplier<Item> ASPARAGUS_CRATE;
    public static Supplier<Item> SWEET_POTATO_CRATE;
    public static Supplier<Item> CHILI_PEPPER_CRATE;
    public static Supplier<Item> CRANBERRY_BAG;

    public static Supplier<Item> WILD_ASPARAGUS;
    public static Supplier<Item> WILD_SWEET_POTATO;
    public static Supplier<Item> WILD_CHILI_PEPPER;

    public static Supplier<Item> CRUSHING_MALLET;

    public static Supplier<Item> CINNAMON_STICK;
    public static Supplier<Item> CINNAMON;

    public static Supplier<Item> ASPARAGUS;
    public static Supplier<Item> ASPARAGUS_SEEDS;
    public static Supplier<Item> SWEET_POTATO;
    public static Supplier<Item> BAKED_SWEET_POTATO;
    public static Supplier<Item> CHILI_PEPPER;
    public static Supplier<Item> CHILI_PEPPER_SEEDS;

    public static Supplier<Item> ANCIENT_FRUIT;
    public static Supplier<Item> ANCIENT_SEEDS;
    public static Supplier<Item> CRANBERRIES;
    public static Supplier<Item> CRANBERRY_PLANT;
    public static Supplier<Item> LEMON;
    public static Supplier<Item> LEMON_SEEDS;

    public static Supplier<Item> CHOCOLATE_COOKIE;
    public static Supplier<Item> SUGAR_COOKIE;
    public static Supplier<Item> SNICKERDOODLE;

    public static Supplier<Item> CINNAMON_RICE;
    public static Supplier<Item> CINNAMON_APPLES;

    public static Supplier<Item> APPLE_JUICE;
    public static Supplier<Item> SWEET_BERRY_JUICE;
    public static Supplier<Item> GLOW_BERRY_JUICE;
    public static Supplier<Item> CRANBERRY_JUICE;

    public static Supplier<Item> LEMONADE;
    public static Supplier<Item> SWEET_BERRY_LEMONADE;
    public static Supplier<Item> GLOW_BERRY_LEMONADE;
    public static Supplier<Item> CRANBERRY_LEMONADE;

    public static Supplier<Item> SWEET_ROLL;
    public static Supplier<Item> BERRY_SWEET_ROLL;
    public static Supplier<Item> GLOW_BERRY_SWEET_ROLL;

    public static Supplier<Item> CRANBERRY_COBBLER;
    public static Supplier<Item> CRANBERRY_COBBLER_SLICE;
    public static Supplier<Item> LEMON_MERINGUE_PIE;
    public static Supplier<Item> LEMON_MERINGUE_PIE_SLICE;

    public static Supplier<Item> SWEET_POTATO_SALAD;

    public static Supplier<Item> ASPARAGUS_SOUP;
    public static Supplier<Item> ASPARAGUS_SOUP_CREAMY;

    public static Supplier<Item> ASPARAGUS_BACON_MEAL;
    public static Supplier<Item> ASPARAGUS_MUSHROOM_PASTA;
    public static Supplier<Item> ASPARAGUS_FRITTATA;
    public static Supplier<Item> PEPERONATA;
    public static Supplier<Item> CHILI_PEPPER_SALMON;
    public static Supplier<Item> SWEET_POTATO_CASSEROLE;
    public static Supplier<Item> CRANBERRY_CHICKEN;

    //compat foods
        //brewin and chewin
    public static Supplier<Item> MAC_AND_CHEESE;

        //hearth and harvest
    public static Supplier<Item> CHERRY_JUICE;
    public static Supplier<Item> RASPBERRY_JUICE;
    public static Supplier<Item> BLUEBERRY_JUICE;
    public static Supplier<Item> GREEN_GRAPE_JUICE;
    public static Supplier<Item> RED_GRAPE_JUICE;

    public static Supplier<Item> CRANBERRY_GOAT_CHEESE_TOAST;
    public static Supplier<Item> GOAT_CHEESE_SOUFFLE;
    public static Supplier<Item> HONEYED_GOAT_CHEESE_TART;
    public static Supplier<Item> HONEYED_GOAT_CHEESE_TART_SLICE;
    public static Supplier<Item> PEANUT_SALAD;
    public static Supplier<Item> GOAT_CHEESE_BEETROOT_SALAD;
    public static Supplier<Item> PEANUT_HONEY_SOUP;
    public static Supplier<Item> CHICKEN_GOAT_CHEESE_SOUP;
    public static Supplier<Item> GOAT_CHEESE_RATATOUILLE;

    public static Supplier<Item> CRANBERRY_WINE;
    public static Supplier<Item> CRANBERRY_JAM;

        //cultural delights
    public static Supplier<Item> CHILI_CUCUMBER_SALAD;

        //neapolitan
    public static Supplier<Item> CRANBERRY_ICE_CREAM;


    static {
        ITEMS = DeferredRegister.create(Registries.ITEM, ExpandedDelight.MODID);
        CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

        CINNAMON_SAPLING = registerWithTab("cinnamon_sapling", () -> new BlockItem(EDBlocks.CINNAMON_SAPLING.get(), basicItem()));
        CINNAMON_LEAVES = registerWithTab("cinnamon_leaves", () -> new BlockItem(EDBlocks.CINNAMON_LEAVES.get(), basicItem()));
        CINNAMON_LOG = registerWithTab("cinnamon_log", () -> new BlockItem(EDBlocks.CINNAMON_LOG.get(), basicItem()));
        CINNAMON_WOOD = registerWithTab("cinnamon_wood", () -> new BlockItem(EDBlocks.CINNAMON_WOOD.get(), basicItem()));
        CINNAMON_STRIPPED_LOG = registerWithTab("stripped_cinnamon_log", () -> new BlockItem(EDBlocks.CINNAMON_STRIPPED_LOG.get(), basicItem()));
        CINNAMON_STRIPPED_WOOD = registerWithTab("stripped_cinnamon_wood", () -> new BlockItem(EDBlocks.CINNAMON_STRIPPED_WOOD.get(), basicItem()));
        CINNAMON_PLANKS = registerWithTab("cinnamon_planks", () -> new BlockItem(EDBlocks.CINNAMON_PLANKS.get(), basicItem()));
        CINNAMON_STAIRS = registerWithTab("cinnamon_stairs", () -> new BlockItem(EDBlocks.CINNAMON_STAIRS.get(), basicItem()));
        CINNAMON_SLAB = registerWithTab("cinnamon_slab", () -> new BlockItem(EDBlocks.CINNAMON_SLAB.get(), basicItem()));
        CINNAMON_FENCE = registerWithTab("cinnamon_fence", () -> new BlockItem(EDBlocks.CINNAMON_FENCE.get(), basicItem()));
        CINNAMON_FENCE_GATE = registerWithTab("cinnamon_fence_gate", () -> new BlockItem(EDBlocks.CINNAMON_FENCE_GATE.get(), basicItem()));
        CINNAMON_DOOR = registerWithTab("cinnamon_door", () -> new BlockItem(EDBlocks.CINNAMON_DOOR.get(), basicItem()));
        CINNAMON_TRAPDOOR = registerWithTab("cinnamon_trapdoor", () -> new BlockItem(EDBlocks.CINNAMON_TRAPDOOR.get(), basicItem()));
        CINNAMON_PRESSURE_PLATE = registerWithTab("cinnamon_pressure_plate", () -> new BlockItem(EDBlocks.CINNAMON_PRESSURE_PLATE.get(), basicItem()));
        CINNAMON_BUTTON = registerWithTab("cinnamon_button", () -> new BlockItem(EDBlocks.CINNAMON_BUTTON.get(), basicItem()));
        CINNAMON_SIGN = registerWithTab("cinnamon_sign", () -> new SignItem(basicItem(), EDBlocks.CINNAMON_SIGN.get(), EDBlocks.CINNAMON_WALL_SIGN.get()));
        CINNAMON_HANGING_SIGN = registerWithTab("cinnamon_hanging_sign", () -> new HangingSignItem(EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get(), EDBlocks.CINNAMON_WALL_HANGING_SIGN.get(), basicItem()));
        CINNAMON_CABINET = registerWithTab("cinnamon_cabinet", () -> new BlockItem(EDBlocks.CINNAMON_CABINET.get(), basicItem()));
        CINNAMON_BOAT = registerWithTab("cinnamon_boat", () -> new CinnamonBoatItem(false, CinnamonBoat.Type.CINNAMON, new Item.Properties().stacksTo(1)));
        CINNAMON_CHEST_BOAT = registerWithTab("cinnamon_chest_boat", () -> new CinnamonBoatItem(true, CinnamonBoat.Type.CINNAMON, new Item.Properties().stacksTo(1)));

        JUICER = registerWithTab("juicer", () -> new JuicerItem(EDBlocks.JUICER.get(), basicItem()));

        ASPARAGUS_CRATE = registerWithTab("asparagus_crate", () -> new BlockItem(EDBlocks.ASPARAGUS_CRATE.get(), basicItem()));
        SWEET_POTATO_CRATE = registerWithTab("sweet_potato_crate", () -> new BlockItem(EDBlocks.SWEET_POTATO_CRATE.get(), basicItem()));
        CHILI_PEPPER_CRATE = registerWithTab("chili_pepper_crate", () -> new BlockItem(EDBlocks.CHILI_PEPPER_CRATE.get(), basicItem()));
        CRANBERRY_BAG = registerWithTab("cranberry_bag", () -> new BlockItem(EDBlocks.CRANBERRY_BAG.get(), basicItem()));

        WILD_ASPARAGUS = registerWithTab("wild_asparagus", () -> new BlockItem(EDBlocks.WILD_ASPARAGUS.get(), basicItem()));
        WILD_SWEET_POTATO = registerWithTab("wild_sweet_potato", () -> new BlockItem(EDBlocks.WILD_SWEET_POTATO.get(), basicItem()));
        WILD_CHILI_PEPPER = registerWithTab("wild_chili_pepper", () -> new BlockItem(EDBlocks.WILD_CHILI_PEPPER.get(), basicItem()));
        CRANBERRY_PLANT = ITEMS.register("cranberry_plant", () -> new BlockItem(EDBlocks.CRANBERRY_PLANT.get(), basicItem()));

        CRUSHING_MALLET = registerWithTab("crushing_mallet", () -> new Item(basicItem().durability(64).stacksTo(1)));

        CINNAMON_STICK = registerWithTab("cinnamon_stick", () -> new Item(basicItem()));
        CINNAMON = registerWithTab("cinnamon", () -> new Item(basicItem()));

        ASPARAGUS_SEEDS = registerWithTab("asparagus_seeds", () -> new ItemNameBlockItem(EDBlocks.ASPARAGUS_CROP.get(), basicItem()));
        ASPARAGUS = registerWithTab("asparagus", () -> new Item(foodItem(2, 0.2f)));
        SWEET_POTATO = registerWithTab("sweet_potato", () -> new BlockItem(EDBlocks.SWEET_POTATO_CROP.get(), foodItem(2, 0.2f)));
        CHILI_PEPPER_SEEDS = registerWithTab("chili_pepper_seeds", () -> new ItemNameBlockItem(EDBlocks.CHILI_PEPPER_CROP.get(), basicItem()));
        CHILI_PEPPER = registerWithTab("chili_pepper", () -> new Item(foodItem(2, 0.1f)));

        CRANBERRIES = registerWithTab("cranberries", () -> new LilypadCropItem(EDBlocks.CRANBERRY_PLANT.get(), foodItem(2, 0.5f)));

        BAKED_SWEET_POTATO = registerWithTab("baked_sweet_potato", () -> new Item(foodItem(6, 0.4f)));

        SWEET_ROLL = registerWithTab("sweet_roll", () -> new Item(foodItem(5, 0.3f)));
        BERRY_SWEET_ROLL = registerWithTab("berry_sweet_roll", () -> new Item(foodItem(6, 0.5f)));
        GLOW_BERRY_SWEET_ROLL = registerWithTab("glow_berry_sweet_roll", () -> new Item(foodItem(6, 0.5f)));

        CRANBERRY_COBBLER = registerWithTab("cranberry_cobbler", () -> new BlockItem(EDBlocks.CRANBERRY_COBBLER.get(), basicItem()));
        CRANBERRY_COBBLER_SLICE = registerWithTab("cranberry_cobbler_slice", () -> new Item(pieSliceItem(3, 0.3f)));

        CHOCOLATE_COOKIE = registerWithTab("chocolate_cookie", () -> new Item(foodItem(2, 0.3f)));
        SUGAR_COOKIE = registerWithTab("sugar_cookie", () -> new Item(foodItem(2, 0.3f)));
        SNICKERDOODLE = registerWithTab("snickerdoodle", () -> new Item(foodItem(2, 0.4f)));

        CINNAMON_RICE = registerWithTab("cinnamon_rice", () -> new Item(foodItem(7, 0.5f).craftRemainder(Items.BOWL)));
        CINNAMON_APPLES = registerWithTab("cinnamon_apples", () -> new Item(foodItem(7, 0.5f).craftRemainder(Items.BOWL)));

        APPLE_JUICE = registerWithTab("apple_juice", () -> new DrinkableItem(drinkItem(1, 1.2f, MobEffects.MOVEMENT_SPEED), true));
        SWEET_BERRY_JUICE = registerWithTab("sweet_berry_juice", () -> new DrinkableItem(drinkItem(1, 1.2f, MobEffects.HEALTH_BOOST), true));
        GLOW_BERRY_JUICE = registerWithTab("glow_berry_juice", () -> new DrinkableItem(drinkItem(1, 1.2f, MobEffects.NIGHT_VISION), true));
        CRANBERRY_JUICE = registerWithTab("cranberry_juice", () -> new DrinkableItem(drinkItem(1, 1.2f, MobEffects.ABSORPTION), true));

        SWEET_POTATO_SALAD = registerWithTab("sweet_potato_salad", () -> new ConsumableItem(saladItem(8, 0.4f)));

        ASPARAGUS_SOUP = registerWithTab("asparagus_soup", () -> new ConsumableItem(stewItem(10, 0.8f)));
        ASPARAGUS_SOUP_CREAMY = registerWithTab("asparagus_soup_creamy", () -> new ConsumableItem(stewItem(11, 0.9f)));

        ASPARAGUS_BACON_MEAL = registerWithTab("asparagus_and_bacon", () -> new ConsumableItem(mealItem(10, 0.8f)));
        ASPARAGUS_MUSHROOM_PASTA = registerWithTab("asparagus_mushroom_pasta", () -> new ConsumableItem(mealItem(12, 0.9f)));
        PEPERONATA = registerWithTab("peperonata", () -> new ConsumableItem(mealItem(12, 0.9f)));
        CHILI_PEPPER_SALMON = registerWithTab("chili_pepper_salmon", () -> new ConsumableItem(mealItem(13, 1.0f)));
        CRANBERRY_CHICKEN = registerWithTab("cranberry_chicken", () -> new ConsumableItem(mealItem(10, 0.8f)));
        SWEET_POTATO_CASSEROLE = registerWithTab("sweet_potato_casserole", () -> new ConsumableItem(mealItem(11, 0.8f)));

        if (ModList.get().isLoaded("hearthandharvest")) {
            CRANBERRY_GOAT_CHEESE_TOAST = registerWithTab("cranberry_goat_cheese_toast", () -> new Item(foodItem(4, 0.6f)));

            PEANUT_SALAD = registerWithTab("peanut_salad", () -> new ConsumableItem(saladItem(8, 0.6f)));
            GOAT_CHEESE_BEETROOT_SALAD = registerWithTab("goat_cheese_beetroot_salad", () -> new ConsumableItem(saladItem(7, 0.3f)));

            PEANUT_HONEY_SOUP = registerWithTab("peanut_honey_soup", () -> new ConsumableItem(stewItem(10, 0.8f)));
            MAC_AND_CHEESE = registerWithTab("mac_and_cheese", () -> new ConsumableItem(stewItem(12, 0.8f)));

            HONEYED_GOAT_CHEESE_TART = registerWithTab("honeyed_goat_cheese_tart", () -> new BlockItem(EDBlocks.HONEYED_GOAT_CHEESE_TART.get(), basicItem()));
            HONEYED_GOAT_CHEESE_TART_SLICE = registerWithTab("honeyed_goat_cheese_tart_slice", () -> new Item(pieSliceItem(4, 0.5f)));

            ASPARAGUS_FRITTATA = registerWithTab("asparagus_frittata", () -> new ConsumableItem(mealItem(11, 0.8f)));
        }
    }

    public static Supplier<Item> registerWithTab(String name, Supplier<Item> supplier) {
        Supplier<Item> block = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;
    }

    public static Item.Properties basicItem() {
        return (new Item.Properties());
    }

    public static Item.Properties foodItem(int nutrition, float saturation) {
        return (new Item.Properties().food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build()));
    }

    public static Item.Properties drinkItem(int nutrition, float saturation, Holder<MobEffect> effect) {
        return (new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)
                .food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)
                .effect(() -> new MobEffectInstance(effect, 200, 0), 1.0f).build()));
    }

    public static Item.Properties pieSliceItem(int nutrition, float saturation) {
        return (new Item.Properties()).food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).fast()
                        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0f).build());
    }

    public static Item.Properties stewItem(int nutrition, float saturation) {
        return (new Item.Properties()).craftRemainder(Items.BOWL).stacksTo(16)
                .food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)
                        .effect(() -> new MobEffectInstance(ModEffects.COMFORT, 2400, 0), 1.0f).build());
    }

    public static Item.Properties saladItem(int nutrition, float saturation) {
        return (new Item.Properties()).craftRemainder(Items.BOWL).stacksTo(16)
                .food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0f).build());
    }

    public static Item.Properties mealItem(int nutrition, float saturation) {
        return (new Item.Properties()).craftRemainder(Items.BOWL).stacksTo(16)
                .food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)
                        .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1.0f).build());
    }

}
