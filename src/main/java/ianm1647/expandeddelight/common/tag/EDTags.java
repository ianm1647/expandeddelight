package ianm1647.expandeddelight.common.tag;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EDTags {

    public static final TagKey<Item> CINNAMON_LOGS = modItemTag("cinnamon_logs");
    public static final TagKey<Item> CRUSHING_TOOLS = modItemTag("crushing_tools");
    public static final TagKey<Item> GOAT_CHEESES = modItemTag("goat_cheeses");

    public static final TagKey<Block> MILK_ACTIVATORS = modBlockTag("milk_activators");
    public static final TagKey<Block> CINNAMON_LOGS_BLOCK = modBlockTag("cinnamon_logs");

    private static TagKey<Item> modItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, path));
    }

    private static TagKey<Block> modBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, path));
    }

    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, path));
    }

}
