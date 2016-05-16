package com.minegusta.mgbossesredone.tasks;

import com.minegusta.mgbossesredone.main.Main;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import org.bukkit.Bukkit;

public class BossEffectTask
{
    private static int id = -1;

    public static void start()
    {
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), ()-> LocationRegistry.getLocations().stream().filter(l -> l.getBossInstance().isPresent()).forEach(boss ->
        {
            if(boss.getBossInstance().get().getEntity().isValid())
            {
                boss.getBossInstance().get().getEntity().getWorld().spigot().playEffect(boss.getBossInstance().get().getEntity().getLocation(), boss.getBossInstance().get().getEffectType(), 0, 0, 0.5F, 1.3F, 0.5F, 1/5, 10, 35);
            }
            else {
                boss.getBossInstance().get().onDeath(false, false, false);
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
