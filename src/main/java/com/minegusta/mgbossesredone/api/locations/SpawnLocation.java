package com.minegusta.mgbossesredone.api.locations;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import org.bukkit.Location;

import java.util.Optional;

public class SpawnLocation {

    private Location location;
    private String name;
    private Boss boss;
    private int taskId = -1;
    private Optional<AbstractBoss> instance;
    private boolean spawned = false;

    public SpawnLocation(String name, Location l, Boss boss, AbstractBoss instance)
    {
        this.instance = Optional.ofNullable(instance);
        this.name = name;
        this.location = l;
        this.boss = boss;
    }

    public void setInstance(AbstractBoss instance)
    {
        this.instance = Optional.ofNullable(instance);
    }

    public int getTaskId()
    {
        return taskId;
    }

    public void setTaskId(int id)
    {
        this.taskId = id;
    }

    public Boss getBoss()
    {
        return boss;
    }

    public Optional<AbstractBoss> getBossInstance()
    {
        return instance;
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
