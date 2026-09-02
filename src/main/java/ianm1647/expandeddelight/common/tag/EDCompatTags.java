package ianm1647.expandeddelight.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EDCompatTags {

    public static final String CREATE = "create";
    public static final TagKey<Item> CREATE_UPRIGHT_ON_BELT = externalItemTag(CREATE, "upright_on_belt");

    public static final String CREATE_CA = "createaddition";
    public static final TagKey<Item> CREATE_CA_PLANT_FOODS = externalItemTag(CREATE_CA, "plant_foods");
    public static final TagKey<Item> CREATE_CA_PLANTS = externalItemTag(CREATE_CA, "plants");

    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final TagKey<Item> SUPP_COOKIES = externalItemTag(SUPPLEMENTARIES, "cookies");

    public static final String TOUGH_AS_NAILS = "toughasnails";
    public static final TagKey<Item> TAN_DRINKS = externalItemTag(TOUGH_AS_NAILS, "drinks");

    public static final String SERENE_SEASONS = "sereneseasons";
    public static final TagKey<Block> SERENE_SEASONS_AUTUMN_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "autumn_crops");
    public static final TagKey<Block> SERENE_SEASONS_SPRING_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "spring_crops");
    public static final TagKey<Block> SERENE_SEASONS_SUMMER_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "summer_crops");
    public static final TagKey<Block> SERENE_SEASONS_WINTER_CROPS_BLOCK = externalBlockTag(SERENE_SEASONS, "winter_crops");
    public static final TagKey<Block> SERENE_SEASONS_UNBREAKABLE_FERTILE_CROPS = externalBlockTag(SERENE_SEASONS, "unbreakable_infertile_crops");
    public static final TagKey<Item> SERENE_SEASONS_AUTUMN_CROPS = externalItemTag(SERENE_SEASONS, "autumn_crops");
    public static final TagKey<Item> SERENE_SEASONS_SPRING_CROPS = externalItemTag(SERENE_SEASONS, "spring_crops");
    public static final TagKey<Item> SERENE_SEASONS_SUMMER_CROPS = externalItemTag(SERENE_SEASONS, "summer_crops");
    public static final TagKey<Item> SERENE_SEASONS_WINTER_CROPS = externalItemTag(SERENE_SEASONS, "winter_crops");

    public EDCompatTags() {
    }

    private static TagKey<Item> externalItemTag(String modId, String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
    }

    private static TagKey<Block> externalBlockTag(String modId, String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
    }

}
