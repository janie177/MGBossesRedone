package com.minegusta.mgbossesredone.api.powers;

import org.bukkit.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface IPower
{
    PowerType getType();

    String getName();

    void run(Entity bosss, Optional<List<Entity>> target);

    enum PowerType
    {
        ACTIVE,PASSIVE;
    }
}
