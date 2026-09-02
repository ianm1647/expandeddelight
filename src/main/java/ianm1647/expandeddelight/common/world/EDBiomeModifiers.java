package ianm1647.expandeddelight.common.world;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class EDBiomeModifiers {
    public static final ResourceKey<BiomeModifier> CINNAMON_TREE;

    public static final ResourceKey<BiomeModifier> WILD_ASPARAGUS;
    public static final ResourceKey<BiomeModifier> WILD_SWEET_POTATO;
    public static final ResourceKey<BiomeModifier> WILD_CHILI_PEPPER;
    public static final ResourceKey<BiomeModifier> CRANBERRIES;

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(CINNAMON_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(EDPlacedFeatures.CINNAMON_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_ASPARAGUS, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(EDPlacedFeatures.PATCH_WILD_ASPARAGUS)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(WILD_SWEET_POTATO, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(EDPlacedFeatures.PATCH_WILD_SWEET_POTATO)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(WILD_CHILI_PEPPER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DESERT),
                HolderSet.direct(placedFeatures.getOrThrow(EDPlacedFeatures.PATCH_WILD_CHILI_PEPPER)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(CRANBERRIES, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                HolderSet.direct(placedFeatures.getOrThrow(EDPlacedFeatures.PATCH_CRANBERRIES)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    static {
        CINNAMON_TREE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "cinnamon_tree"));

        WILD_ASPARAGUS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "wild_asparagus"));
        WILD_SWEET_POTATO = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "wild_sweet_potato"));
        WILD_CHILI_PEPPER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "wild_chili_pepper"));
        CRANBERRIES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "cranberries"));
    }
}
