package com.minegusta.mgbossesredone.api.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.powers.Power;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.List;

public abstract class AbstractBoss
{
    private List<Power> powers = Lists.newArrayList();

    abstract String getName();

    abstract EntityType getType();

    abstract int getPowerChance();

    abstract Effect getEffectType();

    abstract double getHealth();

    abstract String deathMessage();

    public List<Power> getPowers()
    {
        return powers;
    }

    abstract void spawn(Location l);

    abstract void updateStage();

    public void runAbility()
    {
        getPowers().size();
    }
}
