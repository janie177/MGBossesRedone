package com.minegusta.mgbossesredone.api.powers;

import org.bukkit.entity.LivingEntity;

import java.util.List;

public interface IPower
{
    PowerType getType();

    String getName();

    void run(LivingEntity boss, List<LivingEntity> target);

    enum PowerType
    {
        ACTIVE,PASSIVE, SPECIAL;
    }
}
