package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.data.loot.EDBlockLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(
        modid = "expandeddelight",
        bus = EventBusSubscriber.Bus.MOD
)
public class EDDataGenerators {
    public EDDataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        EDBlockTags blockTags = new EDBlockTags(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new EDItemTags(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new EDRecipes(output, lookupProvider));
        generator.addProvider(event.includeServer(), new EDAdvancements(output, lookupProvider, helper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(EDBlockLoot::new, LootContextParamSets.BLOCK)), lookupProvider));
        EDBlockStates blockStates = new EDBlockStates(output, helper);
        EDItemModels itemModels = new EDItemModels(output, helper);
        generator.addProvider(event.includeClient(), blockStates);
        generator.addProvider(event.includeClient(), itemModels);

        generator.addProvider(event.includeServer(), new EDPackProvider(output, lookupProvider));
    }
}
