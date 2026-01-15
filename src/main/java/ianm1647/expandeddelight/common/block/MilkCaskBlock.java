package ianm1647.expandeddelight.common.block;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Iterator;

public class MilkCaskBlock extends Block {
    public static IntegerProperty FERMENTING = IntegerProperty.create("cheese_fermenting", 0, 7);

    public MilkCaskBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(super.defaultBlockState().setValue(FERMENTING, 0));
    }

    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FERMENTING);
        super.createBlockStateDefinition(builder);
    }

    public int getMaxFermentingStage() {
        return 7;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide) {
            float chance = 0.0F;
            boolean hasWater = false;
            int maxLight = 0;
            Iterator var8 = BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1)).iterator();

            while(var8.hasNext()) {
                BlockPos neighborPos = (BlockPos)var8.next();
                BlockState neighborState = level.getBlockState(neighborPos);
                if (neighborState.is(EDTags.MILK_ACTIVATORS)) {
                    chance += 0.02F;
                }
            }

            chance += maxLight < 5 ? 0.1F : 0.05F;
            chance += hasWater ? 0.1F : 0.0F;
            if (level.getRandom().nextFloat() <= chance) {
                if (state.getValue(FERMENTING) == this.getMaxFermentingStage()) {
                    if (this == EDBlocks.MILK_CASK.get()) {
                        level.setBlock(pos, EDBlocks.CHEESE_CASK.get().defaultBlockState(), 3);
                        level.playSound(null, pos, SoundEvents.SLIME_SQUISH_SMALL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                    if (this == EDBlocks.GOAT_MILK_CASK.get()) {
                        level.setBlock(pos, EDBlocks.GOAT_CHEESE_CASK.get().defaultBlockState(), 3);
                        level.playSound(null, pos, SoundEvents.SLIME_SQUISH_SMALL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                } else {
                    level.setBlock(pos, state.setValue(FERMENTING, state.getValue(FERMENTING) + 1), 3);
                }
            }

        }
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        return this.getMaxFermentingStage() + 1 - blockState.getValue(FERMENTING);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if (random.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.EGG_CRACK, (double)pos.getX() + (double)random.nextFloat(), (double)pos.getY() + 1.1, (double)pos.getZ() + (double)random.nextFloat(), 0.0, 0.0, 0.0);
        }

    }
}
