package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.block.custom.CinnamonLogBlock;
import com.ianm1647.expandeddelight.block.custom.DelightCropBlock;
import com.ianm1647.expandeddelight.block.custom.JuicerBlock;
import com.ianm1647.expandeddelight.block.custom.MortarPestleBlock;
import com.ianm1647.expandeddelight.world.feature.tree.CinnamonSaplingGenerator;
import com.nhoryzon.mc.farmersdelight.block.WildPatchBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BlockRegistry {

    public static void registerBlocks() {
        //blocks
        BlockList.CINNAMON_SAPLING = block("cinnamon_sapling",
                new SaplingBlock(new CinnamonSaplingGenerator(), blockSettings(0f, 0f, BlockSoundGroup.GRASS)));
        BlockList.CINNAMON_LOG = block("cinnamon_log",
                new CinnamonLogBlock(blockSettings(2.0f, 2.0f, BlockSoundGroup.WOOD)));
        BlockList.SALT_ORE = block("salt_ore",
                new ExperienceDroppingBlock(blockSettings(3.0f, 3.0f, BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(0, 2)));
        BlockList.DEEPSLATE_SALT_ORE = block("deepslate_salt_ore",
                new ExperienceDroppingBlock(blockSettings(4.5f, 3.0f, BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(0, 2)));

        //crates
        BlockList.ASPARAGUS_CRATE = block("asparagus_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));
        BlockList.SWEET_POTATO_CRATE = block("sweet_potato_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));
        BlockList.CHILI_PEPPER_CRATE = block("chili_pepper_crate",
                new Block(blockSettings(2.0f, 3.0f, BlockSoundGroup.WOOD)));

        //crops
        BlockList.WILD_ASPARAGUS = block("wild_asparagus",
                new WildPatchBlock());
        BlockList.WILD_SWEET_POTATO = block("wild_sweet_potatoes",
                new WildPatchBlock());
        BlockList.WILD_CHILI_PEPPER = block("wild_chili_pepper",
                new WildPatchBlock());
        BlockList.WILD_PEANUTS = block("wild_peanuts",
                new WildPatchBlock());

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
    public static final Block MORTAR_AND_PESTLE = withoutBlockItem("mortar_and_pestle",
            new MortarPestleBlock(blockSettings(2.0f, 3.0f, BlockSoundGroup.STONE).nonOpaque()));
    public static final Block JUICER = withoutBlockItem("juicer",
            new JuicerBlock(blockSettings(1.0f, 2.0f, BlockSoundGroup.WOOD).nonOpaque()));


    private static FabricBlockSettings blockSettings(float hardness, float resistance, BlockSoundGroup sound) {
        return FabricBlockSettings.create().strength(hardness, resistance).sounds(sound);
    }

    private static FabricBlockSettings cropSettings() {
        return FabricBlockSettings.copyOf(Blocks.WHEAT).sounds(BlockSoundGroup.CROP).breakInstantly().ticksRandomly().noCollision().nonOpaque();
    }

    private static Block block(String name, Block block) {
        blockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ExpandedDelight.MODID, name), block);
    }

    private static Item blockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Block withoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ExpandedDelight.MODID, name), block);
    }
}
