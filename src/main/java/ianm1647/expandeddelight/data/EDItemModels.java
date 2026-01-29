package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class EDItemModels extends ItemModelProvider {
    public EDItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExpandedDelight.MODID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        registerItemModels();
        registerBlockItemModels();
    }

    protected void registerItemModels() {
        EDItems.ITEMS.getEntries().forEach((item) -> {
            String name = item.getId().getPath();
            if (item.get() instanceof Item && !(item.get() instanceof BlockItem)) {
                if (!name.contains("mallet")) {
                    this.basicItem(ExpandedDelight.loc(name));
                }
            }
        });

        basicItem(EDItems.CINNAMON_DOOR.get());
        basicItem(EDItems.CINNAMON_SIGN.get());
        basicItem(EDItems.CINNAMON_HANGING_SIGN.get());
        basicItem(EDItems.CINNAMON_BOAT.get());
        basicItem(EDItems.CINNAMON_CHEST_BOAT.get());

        basicItem(EDItems.JUICER.get());

        plantItem(EDBlocks.CINNAMON_SAPLING.get());
        plantItem(EDBlocks.WILD_ASPARAGUS.get());
        plantItem(EDBlocks.WILD_SWEET_POTATO.get());
        plantItem(EDBlocks.WILD_CHILI_PEPPER.get());
        plantItem(EDBlocks.WILD_PEANUTS.get());
        itemBlockItem(EDBlocks.CRANBERRY_PLANT.get(), EDItems.CRANBERRIES.get());

        handheldItem(EDItems.CRUSHING_MALLET.get());

        basicItem(EDItems.ASPARAGUS_SEEDS.get());
        basicItem(EDItems.SWEET_POTATO.get());
        basicItem(EDItems.CHILI_PEPPER_SEEDS.get());
        basicItem(EDItems.PEANUT.get());
        basicItem(EDItems.CHEESE_WHEEL.get());
        basicItem(EDItems.GOAT_CHEESE_WHEEL.get());
        basicItem(EDItems.CRANBERRY_COBBLER.get());
        basicItem(EDItems.HONEYED_GOAT_CHEESE_TART.get());
    }

    protected void registerBlockItemModels() {
        simpleBlockItem(EDBlocks.CINNAMON_LEAVES.get());
        simpleBlockItem(EDBlocks.CINNAMON_LOG.get());
        simpleBlockItem(EDBlocks.CINNAMON_WOOD.get());
        simpleBlockItem(EDBlocks.CINNAMON_STRIPPED_LOG.get());
        simpleBlockItem(EDBlocks.CINNAMON_STRIPPED_WOOD.get());
        simpleBlockItem(EDBlocks.CINNAMON_PLANKS.get());
        simpleBlockItem(EDBlocks.CINNAMON_STAIRS.get());
        simpleBlockItem(EDBlocks.CINNAMON_SLAB.get());
        fenceItem(EDBlocks.CINNAMON_FENCE.get(), EDBlocks.CINNAMON_PLANKS.get());
        simpleBlockItem(EDBlocks.CINNAMON_FENCE_GATE.get());
        simpleBlockItem(EDBlocks.CINNAMON_PRESSURE_PLATE.get());
        buttonItem(EDBlocks.CINNAMON_BUTTON.get(), EDBlocks.CINNAMON_PLANKS.get());
        simpleBlockItem(EDBlocks.CINNAMON_CABINET.get());

        simpleBlockItem(EDBlocks.CASK.get());
        simpleBlockItem(EDBlocks.MILK_CASK.get());
        simpleBlockItem(EDBlocks.CHEESE_CASK.get());
        simpleBlockItem(EDBlocks.GOAT_MILK_CASK.get());
        simpleBlockItem(EDBlocks.GOAT_CHEESE_CASK.get());

        simpleBlockItem(EDBlocks.ASPARAGUS_CRATE.get());
        simpleBlockItem(EDBlocks.SWEET_POTATO_CRATE.get());
        simpleBlockItem(EDBlocks.CHILI_PEPPER_CRATE.get());
        simpleBlockItem(EDBlocks.CRANBERRY_BAG.get());

        simpleBlockItem(EDBlocks.SALT_ORE.get());
        simpleBlockItem(EDBlocks.DEEPSLATE_SALT_ORE.get());
    }

    private void itemBlockItem(Block block, Item item) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "item/" + BuiltInRegistries.ITEM.getKey(item).getPath()));
    }

    private void plantItem(Block item) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(item).getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "block/" + BuiltInRegistries.BLOCK.getKey(item).getPath()));
    }

    public void buttonItem(Block block, Block baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID,
                        "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock).getPath()));
    }

    public void fenceItem(Block block, Block baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID,
                        "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock).getPath()));
    }
}
