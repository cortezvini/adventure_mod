package com.cortez.adventuremod.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent CORN_COB = new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent ROASTED_CORN = new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).build();

}
