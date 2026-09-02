package ianm1647.expandeddelight.common.world.tree.placer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import ianm1647.expandeddelight.common.world.tree.EDTreePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class CinnamonFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<CinnamonFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(foliagePlacerInstance
            -> foliagePlacerParts(foliagePlacerInstance).and(IntProvider.codec(0, 16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(foliagePlacerInstance, CinnamonFoliagePlacer::new));
    private final IntProvider height;

    public CinnamonFoliagePlacer(IntProvider pRadius, IntProvider pOffset, IntProvider height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EDTreePlacers.CINNAMON_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-2), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-1), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(1), 0, 0, pAttachment.doubleTrunk());
    }

    @Override
    public int foliageRadius(RandomSource random, int radius) {
        return super.foliageRadius(random, radius) + random.nextInt(Math.max(radius, 1));
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return this.height.sample(random);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pRange > 0) {
            return pLocalX == pRange && pLocalZ == pRange && (pRandom.nextInt(2) == 0 || pLocalY == 0);
        }
        return false;
    }
}
