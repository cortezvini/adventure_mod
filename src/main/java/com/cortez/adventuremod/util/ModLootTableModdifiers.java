package com.cortez.adventuremod.util;

import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModdifiers
{
    // Cria duas constantes que representam os identificadores dos Loot Tables dos mobs
    private static final Identifier WITHER_SKELETON = new Identifier("minecraft", "entities/wither_skeleton");

    private static final Identifier SHULKER = new Identifier("minecraft", "entities/shulker");

    // Método que modifica os Loot Tables dos mobs
    public static void modifyLootTables() {
        // Registra um evento que é chamado sempre que um Loot Table é carregado
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Verifica se o Loot Table é do Wither Skeleton
            if(WITHER_SKELETON.equals(id)){
                // Cria um novo Loot Pool para o Wither Skeleton
                LootPool.Builder poolBuilder = LootPool.builder()
                        // Define que o Loot Pool sempre vai dropar pelo menos 1 item
                        .rolls(ConstantLootNumberProvider.create(1))
                        // Define uma condição para o Loot Pool, que só permite o drop se o jogador matou o mob com uma mão vazia
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
                                new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
                                        .mainhand(ItemPredicate.Builder.create().build()).build()).build()))
                        // Adiciona o item de drop do Wither Skeleton ao Loot Pool
                        .with(ItemEntry.builder(ModItems.WITHERINGPOWDER))
                        // Define uma condição de chance aleatória para o item de drop, que tem 80% de chance de dropar
                        .conditionally(RandomChanceLootCondition.builder(0.8F))
                        // Define uma função que define a quantidade de itens de drop, que pode variar entre 1 e 2
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                // Adiciona o Loot Pool criado ao Loot Table
                tableBuilder.pool(poolBuilder.build());
            }

            // Verifica se o Loot Table é do Shulker
            if(SHULKER.equals(id)) {
                // Cria um novo Loot Pool para o Shulker
                LootPool.Builder poolBuilder = LootPool.builder()
                        // Define que o Loot Pool sempre vai dropar pelo menos 1 item
                        .rolls(ConstantLootNumberProvider.create(1))
                        // Define uma condição para o Loot Pool, que só permite o drop se o jogador matou o mob com uma mão vazia
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
                                new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
                                        .mainhand(ItemPredicate.Builder.create().build()).build()).build()))
                        // Adiciona o item de drop do Wither Skeleton ao Loot Pool
                        .with(ItemEntry.builder(ModItems.LEVITATIONPOWDER))
                        // Define uma condição de chance aleatória para o item de drop, que tem 80% de chance de dropar
                        .conditionally(RandomChanceLootCondition.builder(0.8F))
                        // Define uma função que define a quantidade de itens de drop, que pode variar entre 1 e 2
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                // Adiciona o Loot Pool criado ao Loot Table
                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}