package com.minegusta.mgbossesredone.api.tasks;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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

    public int startTimer()
    {
       return Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
        {
            location.setIfSpawned(false);
            boss.spawnBoss(location);
        }, time * 20);
    }
}
