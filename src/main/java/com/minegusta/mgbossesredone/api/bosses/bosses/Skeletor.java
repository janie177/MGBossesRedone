package com.minegusta.mgbossesredone.api.bosses.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.powers.Power;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Optional;

public class Skeletor extends AbstractBoss {

    @Override
    public String getName() {
        return ChatColor.GRAY + "Skeletor";
    }

    @Override
    public int getActiveAttackRadius() {
        return 20;
    }

    @Override
    public int getActiveAttackInterval() {
        return 3;
    }

    @Override
    public int getExp() {
        return 6;
    }

    @Override
    public EntityType getType() {
        return EntityType.SKELETON;
    }

    @Override
    public Boss getBossType() {
        return Boss.SKELETOR;
    }

    @Override
    public int getPowerChance() {
        return 30;
    }

    @Override
    public int respawnTime() {
        return 30;
    }

    @Override
    public List<Power> getStartingPowers() {
        return Lists.newArrayList(Power.TAUNT);
    }

    @Override
    public Effect getEffectType() {
        return Effect.FLAME;
    }

    @Override
    public double getMaxHealth() {
        return 250;
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public List<DropTable> getDropTables() {
        return Lists.newArrayList(DropTable.BONES);
    }

    @Override
    public String deathMessage() {
        return "You have defeated me!!";
    }

    @Override
    public int getStageInterval() {
        return 15;
    }

    @Override
    public void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow) {

    }

    @Override
    public void applyStageUpdate() {

    }
}