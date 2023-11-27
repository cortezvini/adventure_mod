package com.cortez.adventuremod.blocks;


import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.custom.CoffeeMachineBlock;
import com.cortez.adventuremod.blocks.custom.CornCropBlock;
import com.cortez.adventuremod.blocks.custom.CrusherMachineBlock;
import com.cortez.adventuremod.blocks.custom.RubberTreeLog;
import com.cortez.adventuremod.world.tree.RubberSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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


    public static final Block NETHER_COAL_ORE = registerBlock("nether_coal_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_COAL_ORE = registerBlock("end_coal_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block NETHER_IRON_ORE = registerBlock("nether_iron_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_IRON_ORE = registerBlock("end_iron_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block NETHER_COPPER_ORE = registerBlock("nether_copper_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_COPPER_ORE = registerBlock("end_copper_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block END_GOLD_ORE = registerBlock("end_gold_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore", new RedstoneOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool().ticksRandomly().luminance(Blocks.createLightLevelFromLitBlockState(9))));

    public static final Block END_REDSTONE_ORE = registerBlock("end_redstone_ore", new RedstoneOreBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool().ticksRandomly().luminance(Blocks.createLightLevelFromLitBlockState(9))));

    public static final Block NETHER_LAPISLAZULI_ORE = registerBlock("nether_lapislazuli_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_LAPISLAZULI_ORE = registerBlock("end_lapislazuli_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));


    public static final Block NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_DIAMOND_ORE = registerBlock("end_diamond_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(0, 1)));

    public static final Block END_EMERALD_ORE = registerBlock("end_emerald_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block CRUSHER_MACHINE = registerBlock("crusher_machine", new CrusherMachineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(AdventureMod.MODID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));


    public static final Block COFFEE_MACHINE = registerBlock("coffee_machine", new CoffeeMachineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

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