package com.ianm1647.expandeddelight.world.feature;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static RegistryKey<ConfiguredFeature<?, ?>> WILD_ASPARAGUS = registerConfiguredKey("wild_asparagus");
    public static RegistryKey<ConfiguredFeature<?, ?>> WILD_SWEET_POTATO = registerConfiguredKey("wild_sweet_potato");
    public static RegistryKey<ConfiguredFeature<?, ?>> WILD_CHILI_PEPPER = registerConfiguredKey("wild_chili_pepper");
    public static RegistryKey<ConfiguredFeature<?, ?>> WILD_PEANUTS = registerConfiguredKey("wild_peanuts");
    public static RegistryKey<ConfiguredFeature<?, ?>> SALT_ORE = registerConfiguredKey("salt_ore");
    public static RegistryKey<ConfiguredFeature<?, ?>> CINNAMON_TREE = registerConfiguredKey("cinnamon_tree");
    public static RegistryKey<ConfiguredFeature<?, ?>> CINNAMON_TREE_SPAWN = registerConfiguredKey("cinnamon_tree_spawn");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> saltOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, BlockList.SALT_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, BlockList.DEEPSLATE_SALT_ORE.getDefaultState()));

        register(context, SALT_ORE, Feature.ORE, new OreFeatureConfig(saltOres, 8));

        register(context, CINNAMON_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(BlockList.CINNAMON_LOG),
                new StraightTrunkPlacer(6, 2, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, CINNAMON_TREE_SPAWN, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CINNAMON_TREE_PLACED),
                        0.25f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.CINNAMON_TREE_PLACED)));

        register(context, WILD_ASPARAGUS, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockList.WILD_ASPARAGUS)))));
        register(context, WILD_SWEET_POTATO, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockList.WILD_SWEET_POTATO)))));
        register(context, WILD_CHILI_PEPPER, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockList.WILD_CHILI_PEPPER)))));
        register(context, WILD_PEANUTS, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockList.WILD_PEANUTS)))));

    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerConfiguredKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ExpandedDelight.MODID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
