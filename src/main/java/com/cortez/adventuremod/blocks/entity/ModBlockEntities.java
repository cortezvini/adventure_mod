package com.cortez.adventuremod.blocks.entity;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<CrusherMachineBlockEntity> CRUSHER_MACHINE_BLOCK_ENTITY_BLOCK =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AdventureMod.MODID, "crusher_be"),
                    FabricBlockEntityTypeBuilder.create(CrusherMachineBlockEntity::new,
                            ModBlocks.CRUSHER_MACHINE).build());

    public static void registerBlockEntities() {
        AdventureMod.LOGGER.info("Registering Block Entities for " + AdventureMod.MODID);
    }
}