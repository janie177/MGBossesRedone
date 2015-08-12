package com.minegusta.mgbossesredone.api.tasks;

import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;

public class SpawnTask
{
    private SpawnLocation location;
    private Boss boss;
    private int time;

    public SpawnTask(int time, Boss boss, SpawnLocation location)
    {
        this.boss = boss;
        this.time = time;
        this.location = location;
        location.setIfSpawned(true);
    }

    public void startTimer()
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
        {
            boss.spawnBoss(location);
        }, time * 20);
    }
}
