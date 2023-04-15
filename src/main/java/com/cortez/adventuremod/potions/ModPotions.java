package com.cortez.adventuremod.potions;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.items.ModItems;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Classe que define as poções personalizadas do mod e suas receitas
 */
public class ModPotions
{
    // Declaração das variáveis das poções
    public static Potion WITHER;
    public static Potion LEVITATION;


    /**
     *  Método para registrar as poções
     */
    public static void registerPotions()
    {
        // Registra as poções e atribui a variável correspondente
        WITHER = registerPotion(AdventureMod.MODID+"_wither", StatusEffects.WITHER, 900, 0);
        LEVITATION = registerPotion(AdventureMod.MODID+"_levitation", StatusEffects.LEVITATION, 900, 0);

        // Registra as receitas de poções
        registerPotionsRecipe();
    }

    /**
     * Método auxiliar para registrar uma poção
     */
    private static Potion registerPotion(String name, StatusEffect effect, int duration, int amplifier)
    {
        // Cria um novo objeto Potion com a instância de StatusEffect fornecida e registra-o com o Registry
        return Registry.register(Registries.POTION, new Identifier(AdventureMod.MODID, name), new Potion(new StatusEffectInstance(effect, duration, amplifier)));
    }

    /**
     * Método auxiliar para registrar receitas de poções
     */
    private static void registerPotionsRecipe()
    {
        // Registra uma receita de poção usando o item AWKWARD como ingrediente base, o item WITHERINGPOWDER como catalisador e a poção WITHER como resultado
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ModItems.WITHERINGPOWDER, WITHER);
        // Registra uma receita de poção usando o item AWKWARD como ingrediente base, o item LEVITATIONPOWDER como catalisador e a poção LEVITATION como resultado
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ModItems.LEVITATIONPOWDER, LEVITATION);
    }
}