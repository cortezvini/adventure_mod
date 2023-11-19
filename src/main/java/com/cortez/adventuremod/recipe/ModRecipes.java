package com.cortez.adventuremod.recipe;

import com.cortez.adventuremod.AdventureMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(AdventureMod.MODID, CrasherRecipe.Serializer.ID),
                CrasherRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(AdventureMod.MODID, CrasherRecipe.Type.ID),
                CrasherRecipe.Type.INSTANCE);
    }
}
