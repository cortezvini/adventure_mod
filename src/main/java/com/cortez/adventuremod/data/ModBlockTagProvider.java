package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.NETHER_TIN_ORE)
                .add(ModBlocks.END_TIN_ORE)
                .add(ModBlocks.NETHER_COAL_ORE)
                .add(ModBlocks.END_COAL_ORE)
                .add(ModBlocks.NETHER_IRON_ORE)
                .add(ModBlocks.END_IRON_ORE)
                .add(ModBlocks.NETHER_COPPER_ORE)
                .add(ModBlocks.END_COPPER_ORE)
                .add(ModBlocks.END_GOLD_ORE)
                .add(ModBlocks.NETHER_REDSTONE_ORE)
                .add(ModBlocks.END_REDSTONE_ORE)
                .add(ModBlocks.NETHER_LAPISLAZULI_ORE)
                .add(ModBlocks.END_LAPISLAZULI_ORE)
                .add(ModBlocks.NETHER_DIAMOND_ORE)
                .add(ModBlocks.END_DIAMOND_ORE)
                .add(ModBlocks.NETHER_EMERALD_ORE)
                .add(ModBlocks.END_EMERALD_ORE);



        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.NETHER_TIN_ORE)
                .add(ModBlocks.END_TIN_ORE)
                .add(ModBlocks.NETHER_IRON_ORE)
                .add(ModBlocks.END_IRON_ORE)
                .add(ModBlocks.NETHER_COPPER_ORE)
                .add(ModBlocks.END_COPPER_ORE)
                .add(ModBlocks.NETHER_LAPISLAZULI_ORE)
                .add(ModBlocks.END_LAPISLAZULI_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.END_GOLD_ORE)
                .add(ModBlocks.NETHER_REDSTONE_ORE)
                .add(ModBlocks.END_REDSTONE_ORE)
                .add(ModBlocks.NETHER_DIAMOND_ORE)
                .add(ModBlocks.END_DIAMOND_ORE)
                .add(ModBlocks.NETHER_EMERALD_ORE)
                .add(ModBlocks.END_EMERALD_ORE);


    }
}
