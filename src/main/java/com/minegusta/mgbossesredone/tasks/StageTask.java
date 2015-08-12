package com.minegusta.mgbossesredone.tasks;

import com.minegusta.mgbossesredone.main.Main;
import com.minegusta.mgbossesredone.registry.BossRegistry;
import org.bukkit.Bukkit;

public class StageTask
{
    private static int id = -1;
    private static int stageTick = 0;

    public static void stop()
    {
        if(id != -1)
        {
            Bukkit.getScheduler().cancelTask(id);
        }
    }

    public static void start()
    {
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), ()->
        {
            BossRegistry.getBosses().stream().forEach(boss -> boss.updateStage(stageTick));

            stageTick++;
            if(stageTick > 9000) stageTick = 0;
        }, 20, 20);
    }
}
