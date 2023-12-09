package com.cortez.adventuremod.blocks.custom;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class FruitCoffeeBlock extends Block {
    private static VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0);

    public static final IntProperty AGE = IntProperty.of("age", 0, 2);


    public FruitCoffeeBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                world.setBlockState(pos, this.withAge(i + 1), 2);
            }
        }
        // Obtenha a hora atual do mundo em dias.

    }

    public BlockState withAge(int age) {
        return (BlockState)this.getDefaultState().with(AGE, age);
    }



    public int getMaxAge() {
        return 2;
    }


    public int getAge(BlockState state) {
        return (Integer)state.get(AGE);
    }







    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE});
    }
}
