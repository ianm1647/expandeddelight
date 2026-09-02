package ianm1647.expandeddelight.data;

import com.google.common.collect.Sets;
import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.block.EDCropBlock;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.block.*;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class EDBlockStates extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public EDBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExpandedDelight.MODID, existingFileHelper);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(this.blockName(block)), this.models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(path), this.models().existingFileHelper);
    }

    protected void registerStatesAndModels() {

        this.saplingBlock(EDBlocks.CINNAMON_SAPLING.get());
        this.leavesBlock(EDBlocks.CINNAMON_LEAVES.get());
        this.logBlock((RotatedPillarBlock) EDBlocks.CINNAMON_LOG.get());
        this.axisBlock((RotatedPillarBlock) EDBlocks.CINNAMON_WOOD.get(), blockTexture(EDBlocks.CINNAMON_LOG.get()), blockTexture(EDBlocks.CINNAMON_LOG.get()));
        this.logBlock((RotatedPillarBlock) EDBlocks.CINNAMON_STRIPPED_LOG.get());
        this.axisBlock((RotatedPillarBlock) EDBlocks.CINNAMON_STRIPPED_WOOD.get(), blockTexture(EDBlocks.CINNAMON_STRIPPED_LOG.get()), blockTexture(EDBlocks.CINNAMON_STRIPPED_LOG.get()));
        this.simpleBlock(EDBlocks.CINNAMON_PLANKS.get());
        this.stairsBlock((StairBlock) EDBlocks.CINNAMON_STAIRS.get(), blockTexture(EDBlocks.CINNAMON_PLANKS.get()));
        this.slabBlock((SlabBlock) EDBlocks.CINNAMON_SLAB.get(), blockTexture(EDBlocks.CINNAMON_PLANKS.get()), blockTexture(EDBlocks.CINNAMON_PLANKS.get()));
        this.fenceBlock((FenceBlock) EDBlocks.CINNAMON_FENCE.get(), blockTexture(EDBlocks.CINNAMON_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) EDBlocks.CINNAMON_FENCE_GATE.get(), blockTexture(EDBlocks.CINNAMON_PLANKS.get()));
        ResourceLocation doorTop = ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "block/cinnamon_door_top");
        ResourceLocation doorBottom = ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "block/cinnamon_door_bottom");
        this.doorBlockWithRenderType((DoorBlock) EDBlocks.CINNAMON_DOOR.get(), doorBottom, doorTop, "cutout");
        ResourceLocation trapdoor = ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "block/cinnamon_trapdoor");
        this.trapdoorBlockWithRenderType((TrapDoorBlock) EDBlocks.CINNAMON_TRAPDOOR.get(), trapdoor, true, "cutout");
        this.trapdoorItem(EDBlocks.CINNAMON_TRAPDOOR.get(), "_bottom");
        this.pressurePlateBlock((PressurePlateBlock) EDBlocks.CINNAMON_PRESSURE_PLATE.get(), blockTexture(EDBlocks.CINNAMON_PLANKS.get()));
        this.buttonBlock((ButtonBlock) EDBlocks.CINNAMON_BUTTON.get(), blockTexture(EDBlocks.CINNAMON_PLANKS.get()));
        Set<Block> signs = Sets.newHashSet(EDBlocks.CINNAMON_SIGN.get(), EDBlocks.CINNAMON_WALL_SIGN.get(), EDBlocks.CINNAMON_WALL_HANGING_SIGN.get(), EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get());
        Iterator var2 = signs.iterator();
        while(var2.hasNext()) {
            Block sign = (Block)var2.next();
            this.simpleBlock(sign, this.existingModel(EDBlocks.CINNAMON_SIGN.get()));
        }
        this.cabinetBlock(EDBlocks.CINNAMON_CABINET.get(), "cinnamon");

        this.customHorizontalBlock(EDBlocks.JUICER.get(),
                ($) -> this.existingModel(EDBlocks.JUICER.get()));
        this.pieBlock(EDBlocks.CRANBERRY_COBBLER.get());
        this.pieBlock(EDBlocks.HONEYED_GOAT_CHEESE_TART.get());

        this.crateBlock(EDBlocks.ASPARAGUS_CRATE.get(), "asparagus");
        this.crateBlock(EDBlocks.SWEET_POTATO_CRATE.get(), "sweet_potato");
        this.crateBlock(EDBlocks.CHILI_PEPPER_CRATE.get(), "chili_pepper");
        this.bagBlock(EDBlocks.CRANBERRY_BAG.get(), "cranberry");

        this.wildCropBlock(EDBlocks.WILD_ASPARAGUS.get());
        this.wildCropBlock(EDBlocks.WILD_SWEET_POTATO.get());
        this.wildCropBlock(EDBlocks.WILD_CHILI_PEPPER.get());

        this.customStageBlock(EDBlocks.ASPARAGUS_CROP.get(), this.mcLoc("crop"), "crop", EDCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        this.customStageBlock(EDBlocks.SWEET_POTATO_CROP.get(), this.mcLoc("crop"), "crop", EDCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        this.customStageBlock(EDBlocks.CHILI_PEPPER_CROP.get(), this.mcLoc("crop"), "crop", EDCropBlock.AGE, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));

    }

    public ConfiguredModel[] cubeRandomRotation(Block block, String suffix) {
        String var10000 = this.blockName(block);
        String formattedName = var10000 + (suffix.isEmpty() ? "" : "_" + suffix);
        return ConfiguredModel.allYRotations(this.models().cubeAll(formattedName, this.resourceBlock(formattedName)), 0, false);
    }

    public void customDirectionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction dir = state.getValue(BlockStateProperties.FACING);
            return ConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationX(dir == Direction.DOWN ? 180 : (dir.getAxis().isHorizontal() ? 90 : 0)).rotationY(dir.getAxis().isVertical() ? 0 : ((int)dir.toYRot() + 180) % 360).build();
        }, ignored);
    }

    public void customHorizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept(
                (state) -> ConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360).build(), ignored);
    }

    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int ageSuffix = state.getValue(ageProperty);
            String var10000 = this.blockName(block);
            String stageName = var10000 + "_stage" + ageSuffix;
            return ConfiguredModel.builder().modelFile((this.models().cross(stageName, this.resourceBlock(stageName))).renderType("cutout")).build();
        }, ignored);
    }

    public void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int ageSuffix = (Integer)state.getValue(ageProperty);
            String var10000 = this.blockName(block);
            String stageName = var10000 + "_stage";
            stageName = stageName + (suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix)));
            return parent == null ? ConfiguredModel.builder().modelFile((this.models().cross(stageName, this.resourceBlock(stageName))).renderType("cutout")).build() : ConfiguredModel.builder().modelFile((this.models().singleTexture(stageName, parent, textureKey, this.resourceBlock(stageName))).renderType("cutout")).build();
        }, ignored);
    }

    public void wildCropBlock(Block block) {
        this.wildCropBlock(block, false);
    }

    public void wildCropBlock(Block block, boolean isBushCrop) {
        if (isBushCrop) {
            this.simpleBlock(block, (this.models().singleTexture(this.blockName(block), this.resourceBlock("bush_crop"), "crop", this.resourceBlock(this.blockName(block)))).renderType("cutout"));
        } else {
            this.simpleBlock(block, (this.models().cross(this.blockName(block), this.resourceBlock(this.blockName(block)))).renderType("cutout"));
        }

    }

    public void cabinetBlock(Block block, String woodType) {
        this.horizontalBlock(block, (state) -> {
            String suffix = state.getValue(CabinetBlock.OPEN) ? "_open" : "";
            return this.models().orientable(this.blockName(block) + suffix, this.resourceBlock(woodType + "_cabinet_side"), this.resourceBlock(woodType + "_cabinet_front" + suffix), this.resourceBlock(woodType + "_cabinet_top"));
        });
    }

    public void feastBlock(FeastBlock block) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            IntegerProperty servingsProperty = block.getServingsProperty();
            int servings = state.getValue(servingsProperty);
            String suffix = "_stage" + (block.getMaxServings() - servings);
            if (servings == 0) {
                suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
            }

            ConfiguredModel.Builder var10000 = ConfiguredModel.builder();
            String var10002 = this.blockName(block);
            return var10000.modelFile(this.existingModel(var10002 + suffix)).rotationY(((int)(state.getValue(FeastBlock.FACING)).toYRot() + 180) % 360).build();
        });
    }

    public void doublePlantBlock(Block block) {
        ConfiguredModel.Builder var10000 = this.getVariantBuilder(block).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).modelForState();
        BlockModelProvider var10001 = this.models();
        String var10002 = this.blockName(block) + "_bottom";
        String var10004 = this.blockName(block);
        var10000 = ((VariantBlockStateBuilder)var10000.modelFile((var10001.cross(var10002, this.resourceBlock(var10004 + "_bottom"))).renderType("cutout")).addModel()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).modelForState();
        var10001 = this.models();
        var10002 = this.blockName(block) + "_top";
        var10004 = this.blockName(block);
        var10000.modelFile((var10001.cross(var10002, this.resourceBlock(var10004 + "_top"))).renderType("cutout")).addModel();
    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block, this.models().cubeBottomTop(this.blockName(block), this.resourceBlock(cropName + "_crate_side"), this.resourceBlock("crate_bottom"), this.resourceBlock(cropName + "_crate_top")));
    }

    public void bagBlock(Block block, String cropName) {
        this.simpleBlock(block, ((BlockModelBuilder)this.models().cube(this.blockName(block), this.resourceBlock("bag_bottom"), this.resourceBlock(cropName + "_bag_top"), this.resourceBlock("bag_side_tied"), this.resourceBlock("bag_side_tied"), this.resourceBlock("bag_side"), this.resourceBlock("bag_side"))).texture("particle", this.resourceBlock(cropName + "_bag_top")));
    }

    public void pieBlock(Block block) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            int bites = (Integer)state.getValue(PieBlock.BITES);
            String suffix = bites > 0 ? "_slice" + bites : "";
            ConfiguredModel.Builder var10000 = ConfiguredModel.builder();
            String var10002 = this.blockName(block);
            return var10000.modelFile(this.existingModel(var10002 + suffix)).rotationY(((int)((Direction)state.getValue(PieBlock.FACING)).toYRot() + 180) % 360).build();
        });
    }

    private void saplingBlock(Block block) {
        simpleBlock(block,
                models().cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), blockTexture(block)).renderType("cutout"));
    }

    private void leavesBlock(Block block) {
        simpleBlockWithItem(block,
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(block).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(block)).renderType("cutout"));
    }

    public void trapdoorItem(Block block, String appendix) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(ExpandedDelight.MODID + ":block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + appendix));
    }
}
