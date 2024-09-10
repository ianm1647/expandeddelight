package com.ianm1647.expandeddelight.util;

import com.ianm1647.expandeddelight.registry.ItemRegistry;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableUtil {
    public static void modifyLootTables() {
        lootTable(LootTables.VILLAGE_DESERT_HOUSE_CHEST, ItemRegistry.ASPARAGUS_SEEDS, 0.5f, 1.0f, 3.0f);
        lootTable(LootTables.VILLAGE_DESERT_HOUSE_CHEST, ItemRegistry.ASPARAGUS, 0.25f, 1.0f, 2.0f);
        lootTable(LootTables.VILLAGE_SAVANNA_HOUSE_CHEST, ItemRegistry.SWEET_POTATO, 0.5f, 1.0f, 3.0f);
        lootTable(LootTables.VILLAGE_SNOWY_HOUSE_CHEST, ItemRegistry.CHILI_PEPPER, 0.5f, 1.0f, 3.0f);
        lootTable(LootTables.VILLAGE_SNOWY_HOUSE_CHEST, ItemRegistry.CHILI_PEPPER_SEEDS, 0.25f, 1.0f, 2.0f);
    }

    private static void lootTable(Identifier identifier, Item item, float chance, float min, float max) {
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (identifier.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance))
                        .with(ItemEntry.builder(item))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)).build());
                supplier.pool(poolBuilder.build());
            }
        }));
    }
}
