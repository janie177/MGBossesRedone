package com.minegusta.mgbossesredone.api.powers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public interface IPower
{
    PowerType getType();

    String getName();

    void run(Entity bosss, List<LivingEntity> target);

    enum PowerType
    {
        ACTIVE,PASSIVE
    }
}
