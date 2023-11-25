package com.cortez.adventuremod.world.village;

import com.cortez.adventuremod.AdventureMod;
import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import net.minecraft.util.Identifier;

public class VillageAdditions
{
    public static void registerNewVillageStructures()
    {
        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/plains/houses"),
                new Identifier(AdventureMod.MODID, "small_corn_farm_plains"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/plains/houses"),
                new Identifier(AdventureMod.MODID, "large_corn_farm_plains"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/desert/houses"),
                new Identifier(AdventureMod.MODID, "desert_corn_farm_1"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/desert/houses"),
                new Identifier(AdventureMod.MODID, "desert_corn_farm_2"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/desert/houses"),
                new Identifier(AdventureMod.MODID, "desert_large_corn_farm_1"),
                11
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/savanna/houses"),
                new Identifier(AdventureMod.MODID, "savanna_corn_farm"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/savanna/houses"),
                new Identifier(AdventureMod.MODID, "savanna_large_corn_farm_1"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/savanna/houses"),
                new Identifier(AdventureMod.MODID, "savanna_large_corn_farm_2"),
                4
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/snowy/houses"),
                new Identifier(AdventureMod.MODID, "snowy_corn_farm_1"),
                3
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/snowy/houses"),
                new Identifier(AdventureMod.MODID, "snowy_corn_farm_2"),
                3
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/taiga/houses"),
                new Identifier(AdventureMod.MODID, "taiga_large_corn_farm_1"),
                6
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/taiga/houses"),
                new Identifier(AdventureMod.MODID, "taiga_large_corn_farm_2"),
                6
        );

        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/taiga/houses"),
                new Identifier(AdventureMod.MODID, "taiga_small_corn_farm_1"),
                1
        );
    }
}
