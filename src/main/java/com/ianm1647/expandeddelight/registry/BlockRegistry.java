package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.block.custom.*;
import com.ianm1647.expandeddelight.world.feature.tree.CinnamonSaplingGenerator;
import com.nhoryzon.mc.farmersdelight.block.WildPatchBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static void registerBlocks() {
        //blocks
        BlockList.CINNAMON_SAPLING = block("cinnamon_sapling",
                new SaplingBlock(new CinnamonSaplingGenerator(), blockSettings(Material.PLANT, 0f, 0f, BlockSoundGroup.GRASS)));
        BlockList.CINNAMON_LOG = block("cinnamon_log",
                new CinnamonLogBlock(blockSettings(Material.WOOD, 2.0f, 2.0f, BlockSoundGroup.WOOD)));
        BlockList.CINNAMON_PLANKS = block("cinnamon_planks",
                new Block(AbstractBlock.Settings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        BlockList.SALT_ORE = block("salt_ore",
                new OreBlock(blockSettings(Material.STONE, 3.0f, 3.0f, BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(0, 2)));
        BlockList.DEEPSLATE_SALT_ORE = block("deepslate_salt_ore",
                new OreBlock(blockSettings(Material.STONE, 4.5f, 3.0f, BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(0, 2)));

        //crates
        BlockList.ASPARAGUS_CRATE = block("asparagus_crate",
                new Block(blockSettings(Material.WOOD, 2.0f, 3.0f, BlockSoundGroup.WOOD)));
        BlockList.SWEET_POTATO_CRATE = block("sweet_potato_crate",
                new Block(blockSettings(Material.WOOD, 2.0f, 3.0f, BlockSoundGroup.WOOD)));
        BlockList.CHILI_PEPPER_CRATE = block("chili_pepper_crate",
                new Block(blockSettings(Material.WOOD, 2.0f, 3.0f, BlockSoundGroup.WOOD)));

        //crops
        BlockList.WILD_ASPARAGUS = block("wild_asparagus",
                new WildPatchBlock());
        BlockList.WILD_SWEET_POTATO = block("wild_sweet_potatoes",
                new WildPatchBlock());
        BlockList.WILD_CHILI_PEPPER = block("wild_chili_pepper",
                new WildPatchBlock());
        BlockList.WILD_PEANUTS = block("wild_peanuts",
                new WildPatchBlock());

        //entities
        BlockList.COOLER = block("cooler",
                new CoolerBlock(blockSettings(Material.STONE, 2.0f, 3.0f, BlockSoundGroup.STONE).nonOpaque()));

        //ExpandedDelight.LOGGER.info("ExpandedDelight blocks loaded");
    }

    //crops
    public static final Block ASPARAGUS_CROP = withoutBlockItem("asparagus_crop",
            new DelightCropBlock(cropSettings()));
    public static final Block SWEET_POTATO_CROP = withoutBlockItem("sweet_potatoes_crop",
            new DelightCropBlock(cropSettings()));
    public static final Block CHILI_PEPPER_CROP = withoutBlockItem("chili_pepper_crop",
            new DelightCropBlock(cropSettings()));
    public static final Block PEANUT_CROP = withoutBlockItem("peanut_crop",
            new DelightCropBlock(cropSettings()));

    //entities
    public static final Block JUICER = withoutBlockItem("juicer",
            new JuicerBlock(blockSettings(Material.WOOD, 2.0f, 3.0f, BlockSoundGroup.WOOD).nonOpaque()));

    private static FabricBlockSettings blockSettings(Material material, float hardness, float resistance, BlockSoundGroup sound) {
        return FabricBlockSettings.of(material).strength(hardness, resistance).sounds(sound);
    }

    private static FabricBlockSettings cropSettings() {
        return FabricBlockSettings.copyOf(Blocks.WHEAT).sounds(BlockSoundGroup.CROP).breakInstantly().ticksRandomly().noCollision().nonOpaque();
    }

    private static Block block(String name, Block block) {
        blockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ExpandedDelight.MOD_ID, name), block);
    }

    private static Item blockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ExpandedDelight.GROUP)));
    }

    private static Block withoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ExpandedDelight.MOD_ID, name), block);
    }
}
