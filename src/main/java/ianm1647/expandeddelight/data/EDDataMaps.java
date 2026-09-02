package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class EDDataMaps extends DataMapProvider {
    protected EDDataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    protected void gather(HolderLookup.@NotNull Provider provider) {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(EDItems.ASPARAGUS.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.ASPARAGUS_SEEDS.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.SWEET_POTATO.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.BAKED_SWEET_POTATO.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.CHILI_PEPPER.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.CHILI_PEPPER_SEEDS.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.CRANBERRIES.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.CHOCOLATE_COOKIE.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.SUGAR_COOKIE.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.SNICKERDOODLE.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.WILD_ASPARAGUS.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.WILD_CHILI_PEPPER.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false)
                .add(EDItems.WILD_SWEET_POTATO.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
    }
}
