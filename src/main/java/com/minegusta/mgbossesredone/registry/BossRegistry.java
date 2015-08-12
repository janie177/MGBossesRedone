package com.minegusta.mgbossesredone.registry;

import com.google.common.collect.Maps;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

public class BossRegistry
{
    public static final ConcurrentMap<String, AbstractBoss> register = Maps.newConcurrentMap();

    public static boolean isBoss(String uuid)
    {
        return register.containsKey(uuid);
    }

    public static void removeBoss(String uuid)
    {
        if(isBoss(uuid))
        {
            register.remove(uuid);
        }
    }

    public static void createBoss(String uuid, AbstractBoss boss)
    {
        register.put(uuid, boss);
    }

    public static Collection<AbstractBoss> getBosses()
    {
        return register.values();
    }

    public static AbstractBoss getFromUuid(String uuid)
    {
        return register.getOrDefault(uuid, null);
    }
}
