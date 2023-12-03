package com.cortez.adventuremod.fluids;

import com.cortez.adventuremod.AdventureMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid COFFEE_FLUID;
    public static FlowableFluid FLOWING_COFFEE_FLUID;
    public static Block COFFEE_FLUID_BLOCK;
    public static Item COFFEE_FLUID_BUCKET;

    public static void register() {
        COFFEE_FLUID = Registry.register(Registries.FLUID,
                new Identifier(AdventureMod.MODID, "coffee_fluid_still"), new CoffeeFluid.Still());
        FLOWING_COFFEE_FLUID = Registry.register(Registries.FLUID,
                new Identifier(AdventureMod.MODID, "flowing_coffee_fluid"), new CoffeeFluid.Flowing());

        COFFEE_FLUID_BLOCK = Registry.register(Registries.BLOCK, new Identifier(AdventureMod.MODID, "coffee_fluid_block"),
                new FluidBlock(ModFluids.COFFEE_FLUID, FabricBlockSettings.copyOf(Blocks.WATER)){ });

        COFFEE_FLUID_BUCKET = Registry.register(Registries.ITEM, new Identifier(AdventureMod.MODID,
                "coffee_fluid_bucket"), new BucketItem(ModFluids.COFFEE_FLUID,
                new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}