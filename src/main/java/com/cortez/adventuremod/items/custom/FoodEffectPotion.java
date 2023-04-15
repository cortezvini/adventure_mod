package com.cortez.adventuremod.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


/**
 * Classe que representa um item de alimento com efeito especial.
 */
public class FoodEffectPotion extends Item {
    private StatusEffect effect;
    private int effectDuration;
    private int hunger;
    private float saturation;
    private int timeUsage;

    /**
     * Construtor da classe.
     * @param effect Efeito a ser aplicado ao consumir o item.
     * @param effectDuration Duração do efeito em ticks.
     * @param hunger Quantidade de fome que será preenchida ao consumir o item.
     * @param saturation Quantidade de saturação que será adicionada ao consumir o item.
     * @param timeUsage Tempo em ticks que o item leva para ser consumido.
     * @param settings Configurações do item.
     */
    public FoodEffectPotion(@NotNull StatusEffect effect, @NotNull int effectDuration, @NotNull int hunger, @NotNull float saturation, @NotNull int timeUsage, Settings settings) {
        super(settings);
        this.effect = effect;
        this.effectDuration = effectDuration;
        this.hunger = hunger;
        this.saturation = saturation;
        this.timeUsage = timeUsage;
    }

    /**
     * Define a ação de usar como "comer".
     */
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    /**
     * Define o tempo máximo de uso como o tempo definido no construtor.
     */
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return timeUsage;
    }

    /**
     * Define a mão atual do jogador como a mão usada para consumir o item.
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.setCurrentHand(hand);
        return super.use(world, playerEntity, hand);
    }

    /**
     * Aplica o efeito do item ao jogador que o consumiu, preenchendo a fome, adicionando o efeito, tocando o som de comer e decrementando a pilha do item, caso não esteja no modo criativo.
     */
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
        PlayerEntity player = (PlayerEntity) entity;
        fillHunger(player);
        addEffect(player);
        playEatSound(player);
        decrementStack(stack, player);
        return super.finishUsing(stack, world, entity);
    }

    /**
     * Decrementa a pilha do item em 1, caso o jogador não esteja no modo criativo.
     */
    private void decrementStack(ItemStack stack, PlayerEntity player) {
        if (!player.isCreative()) {
            stack.decrement(1);
        }
    }

    /**
     * Toca o som de comer para o jogador que consumiu o item.
     */
    private void playEatSound(PlayerEntity player) {
        player.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
    }

    /**
     * Adiciona o efeito definido no construtor ao jogador que consumiu o item.
     */
    private void addEffect(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(effect, effectDuration));
    }

    /**
     * Preenche a fome do jogador que consumiu o item com o valor definido no construtor.
     */
    private void fillHunger(PlayerEntity player) {
        player.getHungerManager().add(hunger, saturation);
    }
}