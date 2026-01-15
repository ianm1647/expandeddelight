package ianm1647.expandeddelight.common.world;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.world.tree.placer.CinnamonFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class EDConfiguredFeatures {
    private static String MODID = ExpandedDelight.MODID;

    public static ResourceKey<ConfiguredFeature<?, ?>> SALT_ORE;

    public static ResourceKey<ConfiguredFeature<?, ?>> CINNAMON_TREE;

    public static ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILD_ASPARAGUS;
    public static ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILD_SWEET_POTATO;
    public static ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILD_CHILI_PEPPER;
    public static ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILD_PEANUT;
    public static ResourceKey<ConfiguredFeature<?, ?>> PATCH_CRANBERRIES;

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> saltOres = List.of(
                OreConfiguration.target(stoneReplaceables, EDBlocks.SALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, EDBlocks.DEEPSLATE_SALT_ORE.get().defaultBlockState()));

        context.register(SALT_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(saltOres, 9)));

        context.register(CINNAMON_TREE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EDBlocks.CINNAMON_LOG.get()),
                new StraightTrunkPlacer(5, 3, 3),

                BlockStateProvider.simple(EDBlocks.CINNAMON_LEAVES.get()),
                new CinnamonFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), ConstantInt.of(3)),

                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(Blocks.DIRT))
                .build()));
    }

    static {
        SALT_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "salt_ore"));

        CINNAMON_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "cinnamon_tree"));

        PATCH_WILD_ASPARAGUS = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "patch_wild_asparagus"));
        PATCH_WILD_SWEET_POTATO = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "patch_wild_sweet_potato"));
        PATCH_WILD_CHILI_PEPPER = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "patch_wild_chili_pepper"));
        PATCH_WILD_PEANUT = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "patch_wild_peanuts"));
        PATCH_CRANBERRIES = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, "patch_cranberries"));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
