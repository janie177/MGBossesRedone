package com.minegusta.mgbossesredone.registry;

import com.google.common.collect.Maps;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

public class LocationRegistry
{
    public static ConcurrentMap<String, SpawnLocation> locations = Maps.newConcurrentMap();

    public static void add(String name, SpawnLocation spawn)
    {
        locations.put(name, spawn);
        if(!spawn.getIfSpawned() && spawn.getLocation().getChunk().isLoaded())
        {
            spawn.getBoss().spawnBoss(spawn);
        }
    }

    public static void remove(String name)
    {
        if(contains(name))locations.remove(name);
    }

    public static boolean contains(String name)
    {
        return locations.containsKey(name);
    }

    public static Collection<SpawnLocation> getLocations()
    {
        return locations.values();
    }

    public static Collection<String> getKeys()
    {
        return locations.keySet();
    }

    public static boolean isSpawned(String name)
    {
        return locations.containsKey(name) && locations.get(name).getIfSpawned();
    }

    public static SpawnLocation getSpawnLocation(String name)
    {
        return locations.get(name);
    }

}
