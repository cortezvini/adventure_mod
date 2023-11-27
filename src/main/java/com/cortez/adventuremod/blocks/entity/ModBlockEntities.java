package com.cortez.adventuremod.blocks.entity;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {
    public static final BlockEntityType<CrusherMachineBlockEntity> CRUSHER_MACHINE_BLOCK_ENTITY_BLOCK =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AdventureMod.MODID, "crusher_be"),
                    FabricBlockEntityTypeBuilder.create(CrusherMachineBlockEntity::new,
                            ModBlocks.CRUSHER_MACHINE).build());

    public static final BlockEntityType<CoffeeMachineBlockEntity> COFFEE_MACHINE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AdventureMod.MODID, "coffee_machine_be"),
                    FabricBlockEntityTypeBuilder.create(CoffeeMachineBlockEntity::new,
                            ModBlocks.COFFEE_MACHINE).build(null));
    public static void registerBlockEntities() {
        AdventureMod.LOGGER.info("Registering Block Entities for " + AdventureMod.MODID);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, COFFEE_MACHINE_BE);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, COFFEE_MACHINE_BE);
    }
}