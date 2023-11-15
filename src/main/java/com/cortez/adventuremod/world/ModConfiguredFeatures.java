package com.cortez.adventuremod.world;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?,?>> RUBBER_TREE_KEY = registerKey("rubber_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TIN_ORE_KEY = registerKey("nether_tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_TIN_ORE_KEY = registerKey("end_tin_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = registerKey("nether_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_COAL_ORE_KEY = registerKey("end_coal_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = registerKey("nether_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_IRON_ORE_KEY = registerKey("end_iron_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = registerKey("nether_copper_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_COPPER_ORE_KEY = registerKey("end_copper_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_GOLD_ORE_KEY = registerKey("end_gold_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_REDSTONE_ORE_KEY = registerKey("nether_redstone_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_REDSTONE_ORE_KEY = registerKey("end_redstone_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_LAPISLAZULI_ORE_KEY = registerKey("nether_lapislazuli_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_LAPISLAZULI_ORE_KEY = registerKey("end_lapislazuli_ore");


    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE_KEY = registerKey("nether_diamond_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_DIAMOND_ORE_KEY = registerKey("end_diamond_ore");


    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = registerKey("nether_emerald_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_EMERALD_ORE_KEY = registerKey("end_emerald_ore");




    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldTinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherTinOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_TIN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endTinOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_TIN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherCoalOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_COAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endCoalOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_COAL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherIronOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_IRON_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endIronOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_IRON_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherCopperOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_COPPER_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> endCopperOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_COPPER_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endGoldOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_GOLD_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherRedstoneOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_REDSTONE_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> endRedstoneOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_REDSTONE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherLapislazuliOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_LAPISLAZULI_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> endLapislazuliOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_LAPISLAZULI_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> netherDiamondOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_DIAMOND_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> endDiamondOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_DIAMOND_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> netherEmeraldOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_EMERALD_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> endEmeraldOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_EMERALD_ORE.getDefaultState()));



        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 8));
        register(context, NETHER_TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTinOres, 8));
        register(context, END_TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(endTinOres, 8));
        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCoalOres, 17));
        register(context, END_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCoalOres, 17));
        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherIronOres, 8));
        register(context, END_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(endIronOres, 8));
        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCopperOres, 8));
        register(context, END_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCopperOres, 8));
        register(context, END_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(endGoldOres, 9));
        register(context, NETHER_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRedstoneOres, 8));
        register(context, END_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRedstoneOres, 8));
        register(context, NETHER_LAPISLAZULI_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherLapislazuliOres, 7));
        register(context, END_LAPISLAZULI_ORE_KEY, Feature.ORE, new OreFeatureConfig(endLapislazuliOres, 7));
        register(context, NETHER_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherDiamondOres, 8));
        register(context, END_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(endDiamondOres, 8));
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherEmeraldOres, 4));
        register(context, END_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(endEmeraldOres, 4));
        //Arvores

        register(context, RUBBER_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.RUBBER_TREE_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.RUBBER_TREE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2))
                .build()
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(AdventureMod.MODID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
