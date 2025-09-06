package ianm1647.expandeddelight.data;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        basicItem(EDItems.GLASS_JAR.get());

        basicItem(EDItems.CINNAMON_STICK.get());
        basicItem(EDItems.CINNAMON.get());
        basicItem(EDItems.SALT_ROCK.get());
        basicItem(EDItems.SALT.get());

        basicItem(EDItems.GOAT_MILK_BUCKET.get());
        basicItem(EDItems.GOAT_MILK_BOTTLE.get());

        basicItem(EDItems.ASPARAGUS_SEEDS.get());
        basicItem(EDItems.ASPARAGUS.get());
        basicItem(EDItems.SWEET_POTATO.get());
        basicItem(EDItems.CHILI_PEPPER_SEEDS.get());
        basicItem(EDItems.CHILI_PEPPER.get());
        basicItem(EDItems.PEANUT.get());
        basicItem(EDItems.CRANBERRIES.get());

        basicItem(EDItems.BAKED_SWEET_POTATO.get());

        basicItem(EDItems.CHEESE_WHEEL.get());
        basicItem(EDItems.CHEESE_SLICE.get());
        basicItem(EDItems.GOAT_CHEESE_WHEEL.get());
        basicItem(EDItems.GOAT_CHEESE_SLICE.get());

        basicItem(EDItems.CHEESE_SANDWICH.get());
        basicItem(EDItems.GRILLED_CHEESE.get());
        basicItem(EDItems.CRANBERRY_GOAT_CHESE_TOAST.get());

        basicItem(EDItems.PEANUT_BUTTER.get());
        basicItem(EDItems.PEANUT_BUTTER_SANDWICH.get());
        basicItem(EDItems.PEANUT_BUTTER_HONEY_SANDWICH.get());
        basicItem(EDItems.SWEET_BERRY_JELLY_SANDWICH.get());
        basicItem(EDItems.GLOW_BERRY_JELLY_SANDWICH.get());

        basicItem(EDItems.SWEET_ROLL.get());
        basicItem(EDItems.BERRY_SWEET_ROLL.get());
        basicItem(EDItems.GLOW_BERRY_SWEET_ROLL.get());

        basicItem(EDItems.CRANBERRY_COBBLER.get());
        basicItem(EDItems.CRANBERRY_COBBLER_SLICE.get());
        basicItem(EDItems.HONEYED_GOAT_CHEESE_TART.get());
        basicItem(EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get());

        basicItem(EDItems.CHOCOLATE_COOKIE.get());
        basicItem(EDItems.SUGAR_COOKIE.get());
        basicItem(EDItems.SNICKERDOODLE.get());

        basicItem(EDItems.CINNAMON_RICE.get());
        basicItem(EDItems.CINNAMON_APPLES.get());

        basicItem(EDItems.APPLE_JUICE.get());
        basicItem(EDItems.SWEET_BERRY_JUICE.get());
        basicItem(EDItems.GLOW_BERRY_JUICE.get());
        basicItem(EDItems.CRANBERRY_JUICE.get());

        basicItem(EDItems.SWEET_BERRY_JELLY.get());
        basicItem(EDItems.GLOW_BERRY_JELLY.get());
        basicItem(EDItems.CRANBERRY_JELLY.get());

        basicItem(EDItems.PEANUT_SALAD.get());
        basicItem(EDItems.SWEET_POTATO_SALAD.get());

        basicItem(EDItems.ASPARAGUS_SOUP.get());
        basicItem(EDItems.ASPARAGUS_SOUP_CREAMY.get());
        basicItem(EDItems.PEANUT_HONEY_SOUP.get());
        basicItem(EDItems.MAC_AND_CHEESE.get());

        basicItem(EDItems.ASPARAGUS_BACON_MEAL.get());
        basicItem(EDItems.ASPARAGUS_MUSHROOM_PASTA.get());
        basicItem(EDItems.PEPERONATA.get());
        basicItem(EDItems.CRANBERRY_CHICKEN.get());
        basicItem(EDItems.SWEET_POTATO_CASSEROLE.get());

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
