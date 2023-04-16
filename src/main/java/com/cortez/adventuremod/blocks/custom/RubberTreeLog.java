package com.cortez.adventuremod.blocks.custom;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class RubberTreeLog extends Block {

    public static final int MAX_DAYS = 3;
    public static final int MIN_DAYS = 0;
    public static final int DAYS_INCREMENT = 1;
    public static final int DEFAULT_DAYS = 0;

    public static final IntProperty DAYS_PASSED = IntProperty.of("days_passed", MIN_DAYS, MAX_DAYS);

    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;


    public RubberTreeLog(Settings settings) {
        super(settings.ticksRandomly());
        this.setDefaultState(this.getStateManager().getDefaultState().with(AXIS, Direction.Axis.Y).with(DAYS_PASSED, DEFAULT_DAYS));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        AdventureMod.LOGGER.info("Chamado");
        // Obtenha a hora atual do mundo em dias.
        int daysPassed = state.get(DAYS_PASSED);

        if (daysPassed < MAX_DAYS) {
            world.setBlockState(pos, state.with(DAYS_PASSED, daysPassed + DAYS_INCREMENT));
        } else {
            world.setBlockState(pos, ModBlocks.RUBBER_TREE_LOG_LATEX.getDefaultState()); // substitui o bloco RubberTreeLog por um bloco de carvalho
        }
    }



    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DAYS_PASSED);
        builder.add(AXIS);
    }
}
