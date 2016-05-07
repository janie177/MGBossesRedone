package com.minegusta.mgbossesredone.api;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.registry.LocationRegistry;

import java.util.Optional;

public class BossesPlugin {
    public static void createBoss(Boss boss, SpawnLocation l) {
        if(!l.getIfSpawned()) boss.spawnBoss(l);
    }

    public static boolean isBoss(String uuid)
    {
        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            if(l.getBossInstance().isPresent() && l.getBossInstance().get().getUUID().equalsIgnoreCase(uuid))
            {
                return true;
            }
        }
        return false;
    }

    public static void removeBoss(String uuid)
    {
        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            if(l.getBossInstance().isPresent() && l.getBossInstance().get().getUUID().equalsIgnoreCase(uuid))
            {
                l.getBossInstance().get().removeBoss();
            }
        }
    }

    public static Optional<AbstractBoss> getBossFromUuid(String uuid)
    {
        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            if(l.getBossInstance().isPresent() && l.getBossInstance().get().getUUID().equalsIgnoreCase(uuid))
            {
                return Optional.of(l.getBossInstance().get());
            }
        }
        return Optional.empty();
    }
}
