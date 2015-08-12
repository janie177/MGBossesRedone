package com.minegusta.mgbossesredone.api.bosses.bosses;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.powers.Power;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class Skeletor extends AbstractBoss {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public EntityType getType() {
        return null;
    }

    @Override
    public Boss getBossType() {
        return null;
    }

    @Override
    public int getPowerChance() {
        return 0;
    }

    @Override
    public int respawnTime() {
        return 0;
    }

    @Override
    public List<Power> getStartingActivePowers() {
        return null;
    }

    @Override
    public List<Power> getStartingPassivePowers() {
        return null;
    }

    @Override
    public Effect getEffectType() {
        return null;
    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public List<DropTable> getDropTables() {
        return null;
    }

    @Override
    public String deathMessage() {
        return null;
    }

    @Override
    public int getStageInterval() {
        return 0;
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e, LivingEntity attacker, boolean arrow) {

    }

    @Override
    public void applyStageUpdate() {

    }
}