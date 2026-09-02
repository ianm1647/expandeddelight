package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCompatTags;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class EDBlockTags extends BlockTagsProvider {
    public EDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExpandedDelight.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        registerModTags();
        registerDelightTags();
        registerMinecraftTags();
        registerNeoForgeTags();
        registerCompatibilityTags();
        registerBlockMineables();
    }

    protected void registerBlockMineables() {
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                EDBlocks.CINNAMON_CABINET.get(),
                EDBlocks.JUICER.get(),
                EDBlocks.ASPARAGUS_CRATE.get(),
                EDBlocks.SWEET_POTATO_CRATE.get(),
                EDBlocks.CHILI_PEPPER_CRATE.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(
                EDBlocks.CINNAMON_LEAVES.get(),
                EDBlocks.CRANBERRY_BAG.get());
    }

    protected void registerModTags() {
        tag(EDTags.CINNAMON_LOGS_BLOCK).add(
                EDBlocks.CINNAMON_LOG.get(),
                EDBlocks.CINNAMON_WOOD.get(),
                EDBlocks.CINNAMON_STRIPPED_LOG.get(),
                EDBlocks.CINNAMON_STRIPPED_WOOD.get());
    }

    protected void registerDelightTags() {
        tag(ModTags.Blocks.WILD_CROPS).add(
                EDBlocks.WILD_ASPARAGUS.get(),
                EDBlocks.WILD_SWEET_POTATO.get(),
                EDBlocks.WILD_CHILI_PEPPER.get());
        tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).add(
                EDBlocks.CRANBERRY_COBBLER.get())
            .addOptional(builtInBlock(EDBlocks.HONEYED_GOAT_CHEESE_TART.get()));
    }

    protected void registerMinecraftTags() {
        tag(BlockTags.SAPLINGS).add(
                EDBlocks.CINNAMON_SAPLING.get());
        tag(BlockTags.LEAVES).add(
                EDBlocks.CINNAMON_LEAVES.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(
                EDTags.CINNAMON_LOGS_BLOCK);
        tag(BlockTags.SNAPS_GOAT_HORN).add(
                EDBlocks.CINNAMON_LOG.get());
        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(
                EDBlocks.CINNAMON_LOG.get());
        tag(BlockTags.PLANKS).add(
                EDBlocks.CINNAMON_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(
                EDBlocks.CINNAMON_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(
                EDBlocks.CINNAMON_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(
                EDBlocks.CINNAMON_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(
                EDBlocks.CINNAMON_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(
                EDBlocks.CINNAMON_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(
                EDBlocks.CINNAMON_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                EDBlocks.CINNAMON_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(
                EDBlocks.CINNAMON_BUTTON.get());
        tag(BlockTags.STANDING_SIGNS).add(
                EDBlocks.CINNAMON_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(
                EDBlocks.CINNAMON_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(
                EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(
                EDBlocks.CINNAMON_WALL_HANGING_SIGN.get());
        tag(BlockTags.CROPS).add(
                EDBlocks.ASPARAGUS_CROP.get(),
                EDBlocks.SWEET_POTATO_CROP.get(),
                EDBlocks.CHILI_PEPPER_CROP.get());
        tag(BlockTags.SMALL_FLOWERS).add(
                EDBlocks.WILD_ASPARAGUS.get(),
                EDBlocks.WILD_SWEET_POTATO.get(),
                EDBlocks.WILD_CHILI_PEPPER.get());
        tag(BlockTags.BEE_GROWABLES).add(
                EDBlocks.CRANBERRY_PLANT.get());
        tag(BlockTags.SWORD_EFFICIENT).add(
                EDBlocks.CRANBERRY_PLANT.get());
    }

    protected void registerNeoForgeTags() {
        tag(Tags.Blocks.STRIPPED_LOGS).add(
                EDBlocks.CINNAMON_STRIPPED_LOG.get());
        tag(Tags.Blocks.STRIPPED_WOODS).add(
                EDBlocks.CINNAMON_STRIPPED_WOOD.get());
        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(
                EDBlocks.CINNAMON_FENCE_GATE.get());
    }

    private void registerCompatibilityTags() {
        tag(EDCompatTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK).add(EDBlocks.SWEET_POTATO_CROP.get(), EDBlocks.CRANBERRY_PLANT.get());
        tag(EDCompatTags.SERENE_SEASONS_SPRING_CROPS_BLOCK).add(EDBlocks.ASPARAGUS_CROP.get());
        tag(EDCompatTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK).add(EDBlocks.CHILI_PEPPER_CROP.get());
    }

    public static ResourceLocation builtInBlock(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

}
