package com.acidzero.villagerfollow;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.ai.goal.TemptGoal;
//import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("villagerfollow")
public class VillagerFollow
{
    public VillagerFollow() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void addVillagerFollowTask(final EntityJoinWorldEvent event) {
        if (!(event.getWorld().isClientSide) && (event.getEntity() instanceof Villager)) {
            Villager villager = (Villager) event.getEntity();

            // Villagers will follow players holding an Emerald, Emerald Block, Emerald Ore or Deepslate Emerald Ore at 0.5 speed
            TemptGoal followPlayerTask1 = new TemptGoal(villager, 0.5D, Ingredient.of(Items.EMERALD_BLOCK, Items.EMERALD, Items.EMERALD_ORE, Items.DEEPSLATE_EMERALD_ORE), false);
            villager.goalSelector.addGoal(5, followPlayerTask1);
        }
    }
}
