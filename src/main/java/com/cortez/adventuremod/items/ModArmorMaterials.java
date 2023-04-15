package com.cortez.adventuremod.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;


public enum ModArmorMaterials implements ArmorMaterial {


    // Define um novo tipo de material de armadura com as propriedades abaixo
    DIVINGSUIT("divingsuit", 5, new int[]{1, 2, 3, 1}, 15,
    SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.LEATHER));

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    // Construtor do tipo de material de armadura
    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    // Retorna a durabilidade total da armadura para um determinado slot
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    // Retorna a quantidade de pontos de proteção da armadura para um determinado slot
    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    // Retorna a enchantability do tipo de material de armadura
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    // Retorna o som a ser tocado ao equipar a armadura
    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    // Retorna o ingrediente necessário para reparar a armadura
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    // Retorna o nome do tipo de material de armadura
    @Override
    public String getName() {
        return this.name;
    }

    // Retorna a resistência da armadura a danos
    @Override
    public float getToughness() {
        return this.toughness;
    }

    // Retorna a resistência da armadura a empurrões (knockback)
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    // Bloco estático que inicializa a variável BASE_DURABILITY com os valores padrão para cada slot de armadura
    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}
