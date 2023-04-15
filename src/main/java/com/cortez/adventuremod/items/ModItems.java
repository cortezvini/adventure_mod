package com.cortez.adventuremod.items;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.groups.ModGroups;
import com.cortez.adventuremod.items.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Classe responsável por registrar e gerenciar todos os itens do mod.
 */
public class ModItems
{
    /**
     * Criação de um item "Magic Fruit"
     */
    public static final Item MAGIC_FRUIT = registerItem("magic_fruit", new MagicFruit(new FabricItemSettings()));

    /**
     * Criação de um item "WITHERINGPOWDER"
     */
    public static final Item WITHERINGPOWDER = registerItem("witheringpowder", new FoodEffectPotion(StatusEffects.WITHER, 200, 0, 0F, 32,new FabricItemSettings()));
    /**
     * Criação de um item "LEVITATIONPOWDER"
     */
    public static final Item LEVITATIONPOWDER = registerItem("levitationpowder", new FoodEffectPotion(StatusEffects.LEVITATION, 200, 0, 0F, 32, new FabricItemSettings()));

    /**
     * Criação de um item "OREDETECTOR"
     */
    public static final Item OREDETECTOR = registerItem("oredetector", new OreDetector(false, new FabricItemSettings()));
    /**
     * Criação de um item "OREDETECTORGENERIC"
     */
    public static final Item OREDETECTORGENERIC = registerItem("oredetectorgeneric", new OreDetector(true, new FabricItemSettings()));

    /**
     *  Criação de um item "LATEX_EXTRACTOR"
     */
    public static final Item LATEX_EXTRACTOR = registerItem("latex_extractor", new LatexExtractor(new FabricItemSettings().maxDamage(20)));



    /**
     *  Criação de um item "LATEX"
     */
    public static Item LATEX = registerItem("latex", new Item(new FabricItemSettings()));

    /**
     *  Criação de um item "RUBBER"
     */
    public static Item RUBBER = registerItem("rubber", new Item(new FabricItemSettings()));

    /**
     *  Criação de um item "DIVINGSUIT_HELMET"
     */
    public static final Item DIVINGSUIT_HELMET = registerItem("divingsuit_helmet", new ModArmorItem(ModArmorMaterials.DIVINGSUIT, EquipmentSlot.HEAD, new FabricItemSettings()));
    /**
     *  Criação de um item "DIVINGSUIT_CHESTPLATE"
     */
    public static final Item DIVINGSUIT_CHESTPLATE = registerItem("divingsuit_chestplate", new ModArmorItem(ModArmorMaterials.DIVINGSUIT, EquipmentSlot.CHEST, new FabricItemSettings()));
    /**
     *  Criação de um item "DIVINGSUIT_LEGGINGS"
     */
    public static final Item DIVINGSUIT_LEGGINGS = registerItem("divingsuit_leggings", new ModArmorItem(ModArmorMaterials.DIVINGSUIT, EquipmentSlot.LEGS, new FabricItemSettings()));
    /**
     *  Criação de um item "DIVINGSUIT_BOOTS"
     */
    public static final Item DIVINGSUIT_BOOTS = registerItem("divingsuit_boots", new ModArmorItem(ModArmorMaterials.DIVINGSUIT, EquipmentSlot.FEET, new FabricItemSettings()));

    /**
     * Método para adicionar um item em um grupo de itens
     */
    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    /**
     * Adiciona todos os itens aos seus respectivos grupos de itens
     */
    public static void addItemsToItemGroups()
    {
        addToItemGroup(ModGroups.ADVENTUREMOD, MAGIC_FRUIT);
        addToItemGroup(ModGroups.ADVENTUREMOD, WITHERINGPOWDER);
        addToItemGroup(ModGroups.ADVENTUREMOD, LEVITATIONPOWDER);
        addToItemGroup(ModGroups.ADVENTUREMOD, OREDETECTOR);
        addToItemGroup(ModGroups.ADVENTUREMOD, OREDETECTORGENERIC);
        addToItemGroup(ModGroups.ADVENTUREMOD, LATEX_EXTRACTOR);
        addToItemGroup(ModGroups.ADVENTUREMOD, LATEX);
        addToItemGroup(ModGroups.ADVENTUREMOD, RUBBER);
        addToItemGroup(ModGroups.ADVENTUREMOD, DIVINGSUIT_HELMET);
        addToItemGroup(ModGroups.ADVENTUREMOD, DIVINGSUIT_CHESTPLATE);
        addToItemGroup(ModGroups.ADVENTUREMOD, DIVINGSUIT_LEGGINGS);
        addToItemGroup(ModGroups.ADVENTUREMOD, DIVINGSUIT_BOOTS);
    }

    /**
     *  Registra o item no jogo, associando-o a um nome identificador
     */
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AdventureMod.MODID, name), item);
    }

    /**
     * Registra todos os itens do mod
     */
    public static void registerItems(){
        addItemsToItemGroups();
    }
}