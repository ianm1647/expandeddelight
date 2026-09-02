package ianm1647.expandeddelight.data;

import alabaster.hearthandharvest.common.registry.HHModItems;
import alabaster.hearthandharvest.common.tag.HHCommonTags;
import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCompatTags;
import ianm1647.expandeddelight.common.tag.EDCommonTags;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.codehaus.plexus.util.Expand;
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
        registerModCompatTags();
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
        tag(EDTags.VALID_JUICER_CONTAINERS).add(
                Items.GLASS_BOTTLE);
    }

    private void registerDelightTags() {
        tag(ModTags.Items.CABINETS_WOODEN).add(
                EDItems.CINNAMON_CABINET.get());
        tag(ModTags.Items.WILD_CROPS).add(
                EDItems.WILD_ASPARAGUS.get(),
                EDItems.WILD_SWEET_POTATO.get(),
                EDItems.WILD_CHILI_PEPPER.get());
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
                EDItems.WILD_CHILI_PEPPER.get());
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
        //dusts
        tag(Tags.Items.DUSTS)
                .addTag(EDCommonTags.DUSTS_CINNAMON);
        //foods
        tag(Tags.Items.CROPS)
                .addTag(EDCommonTags.CROPS_ASPARAGUS)
                .addTag(EDCommonTags.CROPS_SWEET_POTATO)
                .addTag(EDCommonTags.CROPS_CHILI_PEPPER);
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
                .add(EDItems.CRANBERRY_COBBLER.get())
                .addOptional(builtInItem(EDItems.HONEYED_GOAT_CHEESE_TART.get()));
        tag(Tags.Items.FOODS_PIE)
                .add(EDItems.CRANBERRY_COBBLER.get())
                .addOptional(builtInItem(EDItems.HONEYED_GOAT_CHEESE_TART.get()));
        tag(Tags.Items.FOODS_SOUP)
                .add(EDItems.ASPARAGUS_SOUP.get())
                .add(EDItems.ASPARAGUS_SOUP_CREAMY.get())
                .addOptional(builtInItem(EDItems.PEANUT_HONEY_SOUP.get()));

        //seeds
        tag(Tags.Items.SEEDS)
                .add(EDItems.ASPARAGUS_SEEDS.get())
                .add(EDItems.CHILI_PEPPER_SEEDS.get());
    }

    public void registerCommonTags() {
        //fruits
        tag(EDCommonTags.FRUITS).addTag(EDCommonTags.FRUITS_CRANBERRY);
        tag(EDCommonTags.FRUITS_CRANBERRY).add(EDItems.CRANBERRIES.get());
        tag(Tags.Items.FOODS_FRUIT).add(EDItems.CRANBERRIES.get());
        //dusts
        tag(EDCommonTags.DUSTS_CINNAMON).add(EDItems.CINNAMON.get());
        //crops
        tag(EDCommonTags.CROPS_ASPARAGUS).add(EDItems.ASPARAGUS.get());
        tag(EDCommonTags.CROPS_SWEET_POTATO).add(EDItems.SWEET_POTATO.get());
        tag(EDCommonTags.CROPS_CHILI_PEPPER).add(EDItems.CHILI_PEPPER.get());
        //foods
        tag(EDCommonTags.FOODS_ASPARAGUS).add(EDItems.ASPARAGUS.get());
        tag(EDCommonTags.FOODS_SWEET_POTATO).add(EDItems.SWEET_POTATO.get());
        tag(EDCommonTags.FOODS_CHILI_PEPPER).add(EDItems.CHILI_PEPPER.get());
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

    public void registerModCompatTags() {
        tag(EDCommonTags.FOODS_CHEESE)
                .addOptional(builtInItem(HHModItems.CHEDDAR_CHEESE_SLICE.get()))
                .addOptional(builtInItem(HHModItems.GOAT_CHEESE_SLICE.get()));
        tag(EDCommonTags.FOODS_GOAT_CHEESE)
                .addOptional(builtInItem(HHModItems.GOAT_CHEESE_SLICE.get()));
    }

    public void registerCompatibilityTags() {
        tag(EDCompatTags.CREATE_UPRIGHT_ON_BELT).add(
                EDItems.APPLE_JUICE.get(),
                EDItems.SWEET_BERRY_JUICE.get(),
                EDItems.GLOW_BERRY_JUICE.get(),
                EDItems.CRANBERRY_JUICE.get(),
                EDItems.CRANBERRY_COBBLER.get())
            .addOptional(builtInItem(EDItems.HONEYED_GOAT_CHEESE_TART.get()));
        tag(EDCompatTags.SUPP_COOKIES).add(
                EDItems.CHOCOLATE_COOKIE.get(),
                EDItems.SUGAR_COOKIE.get(),
                EDItems.SNICKERDOODLE.get());
        tag(EDCompatTags.TAN_DRINKS).add(
                EDItems.APPLE_JUICE.get(),
                EDItems.SWEET_BERRY_JUICE.get(),
                EDItems.GLOW_BERRY_JUICE.get(),
                EDItems.CRANBERRY_JUICE.get());
        tag(EDCompatTags.SERENE_SEASONS_AUTUMN_CROPS).add(
                EDItems.SWEET_POTATO.get(),
                EDItems.CRANBERRIES.get());
        tag(EDCompatTags.SERENE_SEASONS_SPRING_CROPS).add(
                EDItems.ASPARAGUS_SEEDS.get());
        tag(EDCompatTags.SERENE_SEASONS_SUMMER_CROPS).add(
                EDItems.CHILI_PEPPER_SEEDS.get());
    }

    public static ResourceLocation builtInItem(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
