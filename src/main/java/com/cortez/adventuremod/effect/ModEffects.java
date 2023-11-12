package com.cortez.adventuremod.effect;

import com.cortez.adventuremod.AdventureMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect FREEZE;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AdventureMod.MODID, name),
                new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        FREEZE = registerStatusEffect("freeze");
    }
}
