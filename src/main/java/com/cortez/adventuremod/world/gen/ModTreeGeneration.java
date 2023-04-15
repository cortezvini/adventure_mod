package com.cortez.adventuremod.world.gen;

import com.cortez.adventuremod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration
{
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RUBBER_TREE_PLACED_KEY);
    }
}
