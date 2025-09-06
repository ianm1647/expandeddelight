package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCompatTags;
import ianm1647.expandeddelight.common.tag.EDCommonTags;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class EDItemTags extends ItemTagsProvider {
    public EDItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, ExpandedDelight.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        registerModTags();
        registerDelightTags();
        registerMinecraftTags();
        registerNeoForgeTags();
        registerCommonTags();
        registerCompatibilityTags();
    }

    private void registerModTags() {
        tag(EDTags.CINNAMON_LOGS).add(
                EDItems.CINNAMON_LOG.get(),
                EDItems.CINNAMON_WOOD.get(),
                EDItems.CINNAMON_STRIPPED_LOG.get(),
                EDItems.CINNAMON_STRIPPED_WOOD.get());
        tag(EDTags.CRUSHING_TOOLS).add(
                EDItems.CRUSHING_MALLET.get());
    }

    private void registerDelightTags() {
        tag(ModTags.WOODEN_CABINETS).add(
                EDItems.CINNAMON_CABINET.get());
        tag(ModTags.WILD_CROPS_ITEM).add(
                EDItems.WILD_ASPARAGUS.get(),
                EDItems.WILD_SWEET_POTATO.get(),
                EDItems.WILD_CHILI_PEPPER.get(),
                EDItems.WILD_PEANUTS.get());
        tag(ModTags.SERVING_CONTAINERS).add(EDItems.GLASS_JAR.get());
    }

    private void registerMinecraftTags() {
        tag(ItemTags.SAPLINGS).add(
                EDItems.CINNAMON_SAPLING.get());
        tag(ItemTags.LEAVES).add(
                EDItems.CINNAMON_LEAVES.get());
        tag(ItemTags.LOGS_THAT_BURN).addTag(
                EDTags.CINNAMON_LOGS);
        tag(ItemTags.PLANKS).add(
                EDItems.CINNAMON_PLANKS.get());
        tag(ItemTags.WOODEN_STAIRS).add(
                EDItems.CINNAMON_STAIRS.get());
        tag(ItemTags.WOODEN_SLABS).add(
                EDItems.CINNAMON_SLAB.get());
        tag(ItemTags.WOODEN_FENCES).add(
                EDItems.CINNAMON_FENCE.get());
        tag(ItemTags.FENCE_GATES).add(
                EDItems.CINNAMON_FENCE_GATE.get());
        tag(ItemTags.WOODEN_DOORS).add(
                EDItems.CINNAMON_DOOR.get());
        tag(ItemTags.WOODEN_TRAPDOORS).add(
                EDItems.CINNAMON_TRAPDOOR.get());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(
                EDItems.CINNAMON_PRESSURE_PLATE.get());
        tag(ItemTags.WOODEN_BUTTONS).add(
                EDItems.CINNAMON_BUTTON.get());
        tag(ItemTags.SIGNS).add(
                EDItems.CINNAMON_SIGN.get());
        tag(ItemTags.HANGING_SIGNS).add(
                EDItems.CINNAMON_HANGING_SIGN.get());
        tag(ItemTags.BOATS).add(
                EDItems.CINNAMON_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(
                EDItems.CINNAMON_CHEST_BOAT.get());
        tag(ItemTags.SMALL_FLOWERS).add(
                EDItems.WILD_ASPARAGUS.get(),
                EDItems.WILD_SWEET_POTATO.get(),
                EDItems.WILD_CHILI_PEPPER.get(),
                EDItems.WILD_PEANUTS.get());
        tag(ItemTags.PIG_FOOD).add(EDItems.CHILI_PEPPER.get());
        tag(ItemTags.CHICKEN_FOOD).add(EDItems.ASPARAGUS_SEEDS.get(), EDItems.CHILI_PEPPER_SEEDS.get());
        tag(ItemTags.PARROT_FOOD).add(EDItems.ASPARAGUS_SEEDS.get(), EDItems.CHILI_PEPPER_SEEDS.get());
        tag(ItemTags.FOX_FOOD).add(EDItems.CRANBERRIES.get());
    }

    private void registerNeoForgeTags() {
        tag(Tags.Items.STRIPPED_LOGS).add(
                EDItems.CINNAMON_STRIPPED_LOG.get());
        tag(Tags.Items.STRIPPED_WOODS).add(
                EDItems.CINNAMON_STRIPPED_WOOD.get());
        tag(Tags.Items.FENCE_GATES_WOODEN).add(
                EDItems.CINNAMON_FENCE_GATE.get());
        //ores
        tag(Tags.Items.ORES).addTag(EDCommonTags.ORES_SALT);
        //dusts
        tag(Tags.Items.DUSTS)
                .addTag(EDCommonTags.DUSTS_SALT)
                .addTag(EDCommonTags.DUSTS_CINNAMON);
        //buckets
        tag(Tags.Items.BUCKETS_MILK)
                .add(EDItems.GOAT_MILK_BUCKET.get());

        //foods
        tag(Tags.Items.CROPS)
                .addTag(EDCommonTags.CROPS_ASPARAGUS)
                .addTag(EDCommonTags.CROPS_SWEET_POTATO)
                .addTag(EDCommonTags.CROPS_CHILI_PEPPER)
                .addTag(EDCommonTags.CROPS_PEANUT);
        tag(Tags.Items.FOODS_VEGETABLE)
                .addTag(EDCommonTags.FOODS_ASPARAGUS)
                .addTag(EDCommonTags.FOODS_SWEET_POTATO)
                .addTag(EDCommonTags.FOODS_CHILI_PEPPER);
        tag(Tags.Items.FOODS_BERRY)
                .add(EDItems.CRANBERRIES.get());
        tag(Tags.Items.FOODS_COOKIE)
                .add(EDItems.CHOCOLATE_COOKIE.get())
                .add(EDItems.SUGAR_COOKIE.get())
                .add(EDItems.SNICKERDOODLE.get());
        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
                .add(EDItems.CHEESE_WHEEL.get())
                .add(EDItems.GOAT_CHEESE_WHEEL.get())
                .add(EDItems.CRANBERRY_COBBLER.get())
                .add(EDItems.HONEYED_GOAT_CHEESE_TART.get());
        tag(Tags.Items.FOODS_SOUP)
                .add(EDItems.ASPARAGUS_SOUP.get())
                .add(EDItems.ASPARAGUS_SOUP_CREAMY.get())
                .add(EDItems.PEANUT_HONEY_SOUP.get());
        tag(Tags.Items.FOODS)
                .addTag(EDCommonTags.FOODS_CHEESE);
        tag(CommonTags.FOODS_MILK)
                .add(EDItems.GOAT_MILK_BUCKET.get())
                .add(EDItems.GOAT_MILK_BOTTLE.get());
        //seeds
        tag(Tags.Items.SEEDS)
                .add(EDItems.ASPARAGUS_SEEDS.get())
                .add(EDItems.CHILI_PEPPER_SEEDS.get());
    }

    public void registerCommonTags() {
        //ores
        tag(EDCommonTags.ORES_SALT).add(EDItems.SALT_ORE.get(), EDItems.DEEPSLATE_SALT_ORE.get());
        //dusts
        tag(EDCommonTags.DUSTS_SALT).add(EDItems.SALT.get());
        tag(EDCommonTags.DUSTS_CINNAMON).add(EDItems.CINNAMON.get());
        //crops
        tag(EDCommonTags.CROPS_ASPARAGUS).add(EDItems.ASPARAGUS.get());
        tag(EDCommonTags.CROPS_SWEET_POTATO).add(EDItems.SWEET_POTATO.get());
        tag(EDCommonTags.CROPS_CHILI_PEPPER).add(EDItems.CHILI_PEPPER.get());
        tag(EDCommonTags.CROPS_PEANUT).add(EDItems.PEANUT.get());
        //foods
        tag(EDCommonTags.FOODS_ASPARAGUS).add(EDItems.ASPARAGUS.get());
        tag(EDCommonTags.FOODS_SWEET_POTATO).add(EDItems.SWEET_POTATO.get());
        tag(EDCommonTags.FOODS_CHILI_PEPPER).add(EDItems.CHILI_PEPPER.get());
        tag(EDCommonTags.FOODS_PEANUT).add(EDItems.PEANUT.get());
        tag(EDCommonTags.FOODS_CHEESE)
                .add(EDItems.CHEESE_SLICE.get())
                .add(EDItems.GOAT_CHEESE_SLICE.get());
        //jams
        tag(EDCommonTags.JAMS)
                .addTag(EDCommonTags.JAMS_SWEET_BERRY)
                .addTag(EDCommonTags.JAMS_GLOW_BERRY)
                .addTag(EDCommonTags.JAMS_CRANBERRY);
        tag(EDCommonTags.JAMS_SWEET_BERRY).add(EDItems.SWEET_BERRY_JELLY.get());
        tag(EDCommonTags.JAMS_GLOW_BERRY).add(EDItems.GLOW_BERRY_JELLY.get());
        tag(EDCommonTags.JAMS_CRANBERRY).add(EDItems.CRANBERRY_JELLY.get());
        //juices
        tag(EDCommonTags.JUICES)
                .addTag(EDCommonTags.JUICES_APPLE)
                .addTag(EDCommonTags.JUICES_SWEET_BERRY)
                .addTag(EDCommonTags.JUICES_GLOW_BERRY)
                .addTag(EDCommonTags.JUICES_CRANBERRY);
        tag(EDCommonTags.JUICES_APPLE).add(EDItems.APPLE_JUICE.get());
        tag(EDCommonTags.JUICES_SWEET_BERRY).add(EDItems.SWEET_BERRY_JUICE.get());
        tag(EDCommonTags.JUICES_GLOW_BERRY).add(EDItems.GLOW_BERRY_JUICE.get());
        tag(EDCommonTags.JUICES_CRANBERRY).add(EDItems.CRANBERRY_JUICE.get());
    }

    public void registerCompatibilityTags() {
        tag(EDCompatTags.CREATE_UPRIGHT_ON_BELT).add(
                EDItems.GLASS_JAR.get(),
                EDItems.CHEESE_WHEEL.get(),
                EDItems.GOAT_CHEESE_WHEEL.get(),
                EDItems.GOAT_MILK_BUCKET.get(),
                EDItems.GOAT_MILK_BOTTLE.get(),
                EDItems.APPLE_JUICE.get(),
                EDItems.SWEET_BERRY_JUICE.get(),
                EDItems.SWEET_BERRY_JELLY.get(),
                EDItems.GLOW_BERRY_JUICE.get(),
                EDItems.GLOW_BERRY_JELLY.get(),
                EDItems.CRANBERRY_JUICE.get(),
                EDItems.CRANBERRY_JELLY.get(),
                EDItems.CRANBERRY_COBBLER.get(),
                EDItems.HONEYED_GOAT_CHEESE_TART.get());
        tag(EDCompatTags.SUPP_COOKIES).add(
                EDItems.CHOCOLATE_COOKIE.get(),
                EDItems.SUGAR_COOKIE.get(),
                EDItems.SNICKERDOODLE.get());
        tag(EDCompatTags.TAN_DRINKS).add(
                EDItems.GOAT_MILK_BOTTLE.get(),
                EDItems.GOAT_MILK_BUCKET.get(),
                EDItems.APPLE_JUICE.get(),
                EDItems.SWEET_BERRY_JUICE.get(),
                EDItems.GLOW_BERRY_JUICE.get(),
                EDItems.CRANBERRY_JUICE.get());
        tag(EDCompatTags.SERENE_SEASONS_AUTUMN_CROPS).add(
                EDItems.SWEET_POTATO.get(),
                EDItems.CRANBERRIES.get());
        tag(EDCompatTags.SERENE_SEASONS_SPRING_CROPS).add(
                EDItems.ASPARAGUS_SEEDS.get(),
                EDItems.PEANUT.get());
        tag(EDCompatTags.SERENE_SEASONS_SUMMER_CROPS).add(
                EDItems.CHILI_PEPPER_SEEDS.get());
    }
}
