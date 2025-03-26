package ianm1647.expandeddelight.data.loot;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDDataComponents;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModDataComponents;

import java.util.HashSet;
import java.util.Set;

public class EDBlockLoot extends BlockLootSubProvider {
    protected static final float[] CINNAMON_SAPLING_CHANCES = new float[]{0.15f, 0.25f, 0.35F, 0.45F};
    private final Set<Block> generatedLootTables = new HashSet();

    public EDBlockLoot(HolderLookup.Provider holder) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), holder);
    }

    protected void generate() {

        this.dropSelf(EDBlocks.CINNAMON_SAPLING.get());
        this.add(EDBlocks.CINNAMON_LEAVES.get(), block ->
                createLeavesDrops(block, EDBlocks.CINNAMON_SAPLING.get(), CINNAMON_SAPLING_CHANCES));
        this.dropSelf(EDBlocks.CINNAMON_LOG.get());
        this.dropSelf(EDBlocks.CINNAMON_WOOD.get());
        this.dropSelf(EDBlocks.CINNAMON_STRIPPED_LOG.get());
        this.dropSelf(EDBlocks.CINNAMON_STRIPPED_WOOD.get());
        this.dropSelf(EDBlocks.CINNAMON_PLANKS.get());
        this.add(EDBlocks.CINNAMON_DOOR.get(), block ->
                createDoorTable(EDBlocks.CINNAMON_DOOR.get()));
        this.dropSelf(EDBlocks.CINNAMON_SIGN.get());
        this.dropSelf(EDBlocks.CINNAMON_WALL_SIGN.get());
        this.dropSelf(EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get());
        this.dropSelf(EDBlocks.CINNAMON_WALL_HANGING_SIGN.get());
        this.dropNamedContainer(EDBlocks.CINNAMON_CABINET.get());

        this.add(EDBlocks.JUICER.get(),
                (block) -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                        .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                        .include(DataComponents.CUSTOM_NAME).include(EDDataComponents.DRINK.get())
                        .include(ModDataComponents.CONTAINER.get()))))));
        this.dropSelf(EDBlocks.CASK.get());
        this.dropOther(EDBlocks.MILK_CASK.get(), EDItems.CASK.get());
        this.dropOther(EDBlocks.CHEESE_CASK.get(), EDItems.CASK.get());
        this.dropOther(EDBlocks.GOAT_MILK_CASK.get(), EDItems.CASK.get());
        this.dropOther(EDBlocks.GOAT_CHEESE_CASK.get(), EDItems.CASK.get());
        this.dropSelf(EDBlocks.GOAT_CHEESE_WHEEL.get());
        this.dropSelf(EDBlocks.CHEESE_WHEEL.get());

        this.dropSelf(EDBlocks.ASPARAGUS_CRATE.get());
        this.dropSelf(EDBlocks.SWEET_POTATO_CRATE.get());
        this.dropSelf(EDBlocks.CHILI_PEPPER_CRATE.get());
        this.dropSelf(EDBlocks.CRANBERRY_BAG.get());
    }

    protected void dropNamedContainer(Block block) {
        this.add(block, this::createNameableBlockEntityTable);
    }

    protected void add(Block block, LootTable.Builder builder) {
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }

    protected Iterable<Block> getKnownBlocks() {
        return this.generatedLootTables;
    }
}