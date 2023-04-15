package com.cortez.adventuremod.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

/**
 * Representa a fruta mágica do mod AdventureMod.
 * Quando usada, adiciona 8 pontos de fome e 0.8 de saturação ao jogador.
 */
public class MagicFruit extends Item {

    /**
     * Construtor da classe MagicFruit.
     * @param settings as configurações para a fruta mágica
     */
    public MagicFruit(Settings settings) {
        super(settings);
    }

    /**
     * Método chamado quando o jogador usa o item.
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);

        return super.use(world, player, hand);
    }

    /**
     * Retorna o tempo máximo de uso do item em ticks.
     */
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    /**
     * Retorna a ação de uso do item.
     */
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    /**
     * Método chamado quando o jogador termina de usar o item.
     */
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
        if (entity == null || !(entity instanceof PlayerEntity)) {
            throw new IllegalArgumentException("Entity must be a player entity");
        }

        PlayerEntity player = (PlayerEntity) entity;

        // Adiciona 8 pontos de fome e 0.8 de saturação.
        player.getHungerManager().add(8, 0.8F);


        // Toca o som de comer.
        player.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);

        return super.finishUsing(stack, world, entity);
    }
}
