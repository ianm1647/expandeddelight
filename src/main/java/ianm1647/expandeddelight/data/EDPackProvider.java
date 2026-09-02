package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.world.EDBiomeModifiers;
import ianm1647.expandeddelight.common.world.EDConfiguredFeatures;
import ianm1647.expandeddelight.common.world.EDPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EDPackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER;

    public EDPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ExpandedDelight.MODID));
    }

    static {
        BUILDER = new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, EDConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, EDPlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, EDBiomeModifiers::bootstrap);
    }
}
