package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.block.*;
import ianm1647.expandeddelight.common.world.tree.EDTreeGrowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class EDBlocks {

    public static final DeferredRegister<Block> BLOCKS;

    public static Supplier<Block> CINNAMON_SAPLING;
    public static Supplier<Block> CINNAMON_LEAVES;
    public static Supplier<Block> CINNAMON_LOG;
    public static Supplier<Block> CINNAMON_WOOD;
    public static Supplier<Block> CINNAMON_STRIPPED_LOG;
    public static Supplier<Block> CINNAMON_STRIPPED_WOOD;
    public static Supplier<Block> CINNAMON_PLANKS;
    public static Supplier<Block> CINNAMON_STAIRS;
    public static Supplier<Block> CINNAMON_SLAB;
    public static Supplier<Block> CINNAMON_FENCE;
    public static Supplier<Block> CINNAMON_FENCE_GATE;
    public static Supplier<Block> CINNAMON_DOOR;
    public static Supplier<Block> CINNAMON_TRAPDOOR;
    public static Supplier<Block> CINNAMON_PRESSURE_PLATE;
    public static Supplier<Block> CINNAMON_BUTTON;
    public static Supplier<Block> CINNAMON_SIGN;
    public static Supplier<Block> CINNAMON_WALL_SIGN;
    public static Supplier<Block> CINNAMON_CEILING_HANGING_SIGN;
    public static Supplier<Block> CINNAMON_WALL_HANGING_SIGN;
    public static Supplier<Block> CINNAMON_CABINET;

    public static Supplier<Block> JUICER;

    public static Supplier<Block> ASPARAGUS_CRATE;
    public static Supplier<Block> SWEET_POTATO_CRATE;
    public static Supplier<Block> CHILI_PEPPER_CRATE;
    public static Supplier<Block> CRANBERRY_BAG;

    public static Supplier<Block> WILD_ASPARAGUS;
    public static Supplier<Block> WILD_SWEET_POTATO;
    public static Supplier<Block> WILD_CHILI_PEPPER;

    public static Supplier<Block> ASPARAGUS_CROP;
    public static Supplier<Block> SWEET_POTATO_CROP;
    public static Supplier<Block> CHILI_PEPPER_CROP;

    public static Supplier<Block> CRANBERRY_PLANT;
    public static Supplier<Block> CRANBERRY_COBBLER;

    //compats
        //hearth and harvest
    public static Supplier<Block> HONEYED_GOAT_CHEESE_TART;

    static {
        BLOCKS = DeferredRegister.create(Registries.BLOCK, ExpandedDelight.MODID);

        CINNAMON_SAPLING = BLOCKS.register("cinnamon_sapling",
                () -> new SaplingBlock(EDTreeGrowers.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        CINNAMON_LEAVES = BLOCKS.register("cinnamon_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
        CINNAMON_LOG = BLOCKS.register("cinnamon_log",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
        CINNAMON_WOOD = BLOCKS.register("cinnamon_wood",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
        CINNAMON_STRIPPED_LOG = BLOCKS.register("stripped_cinnamon_log",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
        CINNAMON_STRIPPED_WOOD = BLOCKS.register("stripped_cinnamon_wood",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
        CINNAMON_PLANKS = BLOCKS.register("cinnamon_planks",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
        CINNAMON_STAIRS = BLOCKS.register("cinnamon_stairs",
                () -> new StairBlock(CINNAMON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
        CINNAMON_SLAB = BLOCKS.register("cinnamon_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
        CINNAMON_FENCE = BLOCKS.register("cinnamon_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
        CINNAMON_FENCE_GATE = BLOCKS.register("cinnamon_fence_gate",
                () -> new FenceGateBlock(EDWoodTypes.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
        CINNAMON_DOOR = BLOCKS.register("cinnamon_door",
                () -> new DoorBlock(EDWoodTypes.CINNAMON.setType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        CINNAMON_TRAPDOOR = BLOCKS.register("cinnamon_trapdoor",
                () -> new TrapDoorBlock(EDWoodTypes.CINNAMON.setType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
        CINNAMON_PRESSURE_PLATE = BLOCKS.register("cinnamon_pressure_plate",
                () -> new PressurePlateBlock(EDWoodTypes.CINNAMON.setType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
        CINNAMON_BUTTON = BLOCKS.register("cinnamon_button",
                () -> new ButtonBlock(EDWoodTypes.CINNAMON.setType(), 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
        CINNAMON_SIGN = BLOCKS.register("cinnamon_sign", CinnamonStandingSignBlock::new);
        CINNAMON_WALL_SIGN = BLOCKS.register("cinnamon_wall_sign", CinnamonWallSignBlock::new);
        CINNAMON_CEILING_HANGING_SIGN = BLOCKS.register("cinnamon_ceiling_hanging_sign", CinnamonCeilingHangingSignBlock::new);
        CINNAMON_WALL_HANGING_SIGN = BLOCKS.register("cinnamon_wall_hanging_sign", CinnamonWallHangingSignBlock::new);
        CINNAMON_CABINET = BLOCKS.register("cinnamon_cabinet", CinnamonCabinetBlock::new);

        JUICER = BLOCKS.register("juicer",
                () -> new JuicerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F, 1.0F).sound(SoundType.BAMBOO_WOOD)));

        ASPARAGUS_CRATE = BLOCKS.register("asparagus_crate",
                () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        SWEET_POTATO_CRATE = BLOCKS.register("sweet_potato_crate",
                () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        CHILI_PEPPER_CRATE = BLOCKS.register("chili_pepper_crate",
                () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        CRANBERRY_BAG = BLOCKS.register("cranberry_bag",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));

        WILD_ASPARAGUS  = BLOCKS.register("wild_asparagus",
                () -> new WildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
        WILD_SWEET_POTATO  = BLOCKS.register("wild_sweet_potato",
                () -> new WildCropBlock(MobEffects.OOZING, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
        WILD_CHILI_PEPPER  = BLOCKS.register("wild_chili_pepper",
                () -> new WildCropBlock(MobEffects.CONFUSION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));

        CRANBERRY_PLANT = BLOCKS.register("cranberry_plant",
                () -> new CranberryPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).mapColor(MapColor.PLANT).sound(SoundType.LILY_PAD)));
        CRANBERRY_COBBLER = BLOCKS.register("cranberry_cobbler",
                () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), EDItems.CRANBERRY_COBBLER_SLICE));

        ASPARAGUS_CROP = BLOCKS.register("asparagus_crop", EDCropBlock::new);
        SWEET_POTATO_CROP = BLOCKS.register("sweet_potato_crop", EDCropBlock::new);
        CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop", EDCropBlock::new);

        if (ModList.get().isLoaded("hearthandharvest")) {
            HONEYED_GOAT_CHEESE_TART = BLOCKS.register("honeyed_goat_cheese_tart",
                    () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), EDItems.HONEYED_GOAT_CHEESE_TART_SLICE));
        }
    }
}
