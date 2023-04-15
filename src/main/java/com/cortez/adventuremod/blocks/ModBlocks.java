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

public class ModBlocks
{
    public static final Block RUBBER_TREE_LEAVES = registerBlock("rubber_tree_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModGroups.ADVENTUREMOD);


    public static final Block RUBBER_TREE_LOG_LATEX = registerBlock("rubber_tree_log_latex", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F)), null);

    public static final Block RUBBER_TREE_WOOD_LATEX = registerBlock("rubber_tree_wood_latex", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F)), null);

    public static final Block RUBBER_TREE_LOG = registerBlock("rubber_tree_log", new RubberTreeLog(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)), ModGroups.ADVENTUREMOD);

    public static final Block RUBBER_TREE_WOOD = registerBlock("rubber_tree_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0F)), ModGroups.ADVENTUREMOD);

    public static final Block RUBBER_TREE_SAPLING = registerBlock("rubber_tree_sapling",new SaplingBlock(new RubberSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModGroups.ADVENTUREMOD);

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(AdventureMod.MODID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(AdventureMod.MODID, name), block);
    }



    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(AdventureMod.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
        if (group != null){
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }

        return item;
    }

    public static void registerBlocks() {
    }
}