package ianm1647.expandeddelight.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EDCommonTags {
    //ores
    public static final TagKey<Item> ORES_SALT = itemTag("ores/salt");

    //dusts
    public static final TagKey<Item> DUSTS_SALT = itemTag("dusts/salt");
    public static final TagKey<Item> DUSTS_CINNAMON = itemTag("dusts/cinnamon");

    //crops
    public static final TagKey<Item> CROPS_ASPARAGUS = itemTag("crops/asparagus");
    public static final TagKey<Item> CROPS_SWEET_POTATO = itemTag("crops/sweet_potato");
    public static final TagKey<Item> CROPS_CHILI_PEPPER = itemTag("crops/chili_pepper");
    public static final TagKey<Item> CROPS_PEANUT = itemTag("crops/peanut");

    //foods
    public static final TagKey<Item> FOODS_ASPARAGUS = itemTag("foods/asparagus");
    public static final TagKey<Item> FOODS_SWEET_POTATO = itemTag("foods/sweet_potato");
    public static final TagKey<Item> FOODS_CHILI_PEPPER = itemTag("foods/chili_pepper");
    public static final TagKey<Item> FOODS_PEANUT = itemTag("foods/peanut");
    public static final TagKey<Item> FOODS_CHEESE = itemTag("foods/cheese");
    public static final TagKey<Item> FOODS_GOAT_CHEESE = itemTag("foods/goat_cheese");

    //jams
    public static final TagKey<Item> JAMS = itemTag("jams");
    public static final TagKey<Item> JAMS_SWEET_BERRY = itemTag("jams/sweet_berry");
    public static final TagKey<Item> JAMS_GLOW_BERRY = itemTag("jams/glow_berry");
    public static final TagKey<Item> JAMS_CRANBERRY = itemTag("jams/cranberry");

    //juices
    public static final TagKey<Item> JUICES = itemTag("juices");
    public static final TagKey<Item> JUICES_APPLE = itemTag("juices/apple");
    public static final TagKey<Item> JUICES_SWEET_BERRY = itemTag("juices/sweet_berry");
    public static final TagKey<Item> JUICES_GLOW_BERRY = itemTag("juices/glow_berry");
    public static final TagKey<Item> JUICES_CRANBERRY = itemTag("juices/cranberry");

    public EDCommonTags() {
    }

    private static TagKey<Block> blockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> itemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
