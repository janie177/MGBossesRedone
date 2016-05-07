package com.minegusta.mgbossesredone.api.locations;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.registry.BossRegistry;
import org.bukkit.Location;
import org.bukkit.scoreboard.Team;

import java.util.Optional;

public class SpawnLocation {

    private Location location;
    private String name;
    private Boss boss;
    private int taskId = -1;
    private Optional<String> instanceUuid;
    private boolean spawned = false;

    public SpawnLocation(String name, Location l, Boss boss, String uuid)
    {
        this.instanceUuid = Optional.ofNullable(uuid);
        this.name = name;
        this.location = l;
        this.boss = boss;
    }

    public void setInstance(String uuid)
    {
        this.instanceUuid = Optional.ofNullable(uuid);
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
        return instanceUuid.isPresent() ? Optional.ofNullable(BossRegistry.register.getOrDefault(instanceUuid.get(), null)) : Optional.empty();
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
