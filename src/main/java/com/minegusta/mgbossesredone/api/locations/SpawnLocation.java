package com.minegusta.mgbossesredone.api.locations;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import org.bukkit.Location;

import java.util.Optional;

public class SpawnLocation {

    private Location location;
    private String name;
    private Boss boss;
    private Optional<AbstractBoss> bossInstance;
    private boolean spawned = false;

    public SpawnLocation(String name, Location l, Boss boss, AbstractBoss bossInstance)
    {
        this.bossInstance = Optional.of(bossInstance);
        this.name = name;
        this.location = l;
        this.boss = boss;
    }

    public void setInstance(AbstractBoss boss)
    {
        this.bossInstance = Optional.of(boss);
    }

    public Boss getBoss()
    {
        return boss;
    }

    public Optional<AbstractBoss> getBossInstance()
    {
        return bossInstance;
    }

    public Location getLocation()
    {
        return location;
    }

    public boolean getIfSpawned()
    {
        return spawned;
    }

    public void setIfSpawned(Boolean b)
    {
        spawned = b;
    }

    public String getName()
    {
        return name;
    }
}
