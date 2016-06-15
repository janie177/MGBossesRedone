package com.minegusta.mgbossesredone.main;

import com.minegusta.mgbossesredone.api.BossesPlugin;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.api.tasks.RespawnSafeguardTask;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import com.minegusta.mgbossesredone.tasks.BossEffectTask;
import com.minegusta.mgbossesredone.tasks.SpecialPowerTask;
import com.minegusta.mgbossesredone.tasks.StageTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public class Main extends JavaPlugin {

    private static Plugin PLUGIN;

    @Override
    public void onEnable()
    {
        PLUGIN = this;

        //Listeners
        for(Listeners l : Listeners.values())
        {
            l.register();
        }

        //Config
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, ()-> {
            ConfigManager.loadLocationsConfig();
            for(SpawnLocation l : LocationRegistry.getLocations())
            {
                for(Entity f : l.getLocation().getChunk().getEntities())
                {
                    if(f instanceof LivingEntity)
                    {
                        LivingEntity le = (LivingEntity) f;
                        Optional<String> name = l.getBoss().getName();
                        if(name.isPresent() && le.getCustomName() != null && le.getCustomName().equalsIgnoreCase(name.get()) && !BossesPlugin.isBoss(le.getUniqueId().toString()))
                        {
                            le.remove();
                        }
                    }
                }
            }

        }, 200);

        //Tasks
        BossEffectTask.start();
        StageTask.start();
        SpecialPowerTask.start();
        RespawnSafeguardTask.start();

        //Commands
        for(Commands c : Commands.values())
        {
            getCommand(c.getCommand()).setExecutor(c.getExecutor());
        }

    }

    @Override
    public void onDisable()
    {
        //Cancel tasks
        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            l.getBossInstance().ifPresent(b -> b.onDeath(false, false, false));
        }

        SpecialPowerTask.stop();
        BossEffectTask.stop();
        StageTask.stop();
        RespawnSafeguardTask.stop();
    }

    public static Plugin getPlugin()
    {
        return PLUGIN;
    }
}
