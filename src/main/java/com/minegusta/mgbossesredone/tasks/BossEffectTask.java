package com.minegusta.mgbossesredone.tasks;

import com.minegusta.mgbossesredone.main.Main;
import com.minegusta.mgbossesredone.registry.BossRegistry;
import org.bukkit.Bukkit;

public class BossEffectTask
{
    private static int id = -1;

    public static void start()
    {
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), ()-> BossRegistry.getBosses().stream().forEach(boss ->
        {
            if(!boss.getEntity().isDead())
            {
                boss.getEntity().getWorld().spigot().playEffect(boss.getEntity().getLocation(), boss.getEffectType(), 0, 0, 0.5F, 1.3F, 0.5F, 1/5, 10, 35);
            }
        }),10,10);
    }

    public static void stop()
    {
        if(id != -1)
        {
            Bukkit.getScheduler().cancelTask(id);
        }
    }
}
