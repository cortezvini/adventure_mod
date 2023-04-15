package com.cortez.adventuremod.world.tree;

import com.cortez.adventuremod.world.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class RubberSaplingGenerator extends SaplingGenerator
{

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees)
    {
        return ModConfiguredFeatures.RUBBER_TREE_KEY;
    }
}
