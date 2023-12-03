package com.cortez.adventuremod.items.custom;

import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.Stack;

public class CoffeeItem extends Item {
    public CoffeeItem(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);

        return super.use(world, player, hand);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
        if (entity == null || !(entity instanceof PlayerEntity)) {
            throw new IllegalArgumentException("Entity must be a player entity");
        }

        PlayerEntity player = (PlayerEntity) entity;

        // Adiciona 8 pontos de fome e 0.8 de saturação.
        player.getHungerManager().add(3, 0.7F);


        // Toca o som de comer.
        player.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);

        ItemStack newItemStack = new ItemStack(ModItems.EMPTY_CUP);

        stack = newItemStack;


        return super.finishUsing(stack, world, entity);
    }
}
