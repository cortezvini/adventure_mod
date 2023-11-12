package com.cortez.adventuremod.blocks;


import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.custom.RubberTreeLog;
import com.cortez.adventuremod.groups.ModGroups;
import com.cortez.adventuremod.world.tree.RubberSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks
{
    public static final Block RUBBER_TREE_LEAVES = registerBlock("rubber_tree_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));


    public static final Block RUBBER_TREE_LOG_LATEX = registerBlock("rubber_tree_log_latex", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F)));

    public static final Block RUBBER_TREE_WOOD_LATEX = registerBlock("rubber_tree_wood_latex", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F)));

    public static final Block RUBBER_TREE_LOG = registerBlock("rubber_tree_log", new RubberTreeLog(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block RUBBER_TREE_WOOD = registerBlock("rubber_tree_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0F)));

    public static final Block RUBBER_TREE_SAPLING = registerBlock("rubber_tree_sapling",new SaplingBlock(new RubberSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(FabricBlockSettings.create().requiresTool().strength(4.0F, 5.0F).sounds(BlockSoundGroup.METAL)));

    public static final Block TIN_ORE = registerBlock("tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block NETHER_TIN_ORE = registerBlock("nether_tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_TIN_ORE = registerBlock("end_tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(AdventureMod.MODID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AdventureMod.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AdventureMod.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerBlocks() {
    }
}