package com.minegusta.mgbossesredone.main;

import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.api.util.LocationUtil;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import com.minegusta.mgbossesredone.tasks.ActivePowerTask;
import com.minegusta.mgbossesredone.tasks.BossEffectTask;
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
        ConfigManager.loadLocationsConfig();

        //Tasks
        BossEffectTask.start();
        StageTask.start();
        ActivePowerTask.start();

        //Commands
        for(Commands c : Commands.values())
        {
            getCommand(c.getCommand()).setExecutor(c.getExecutor());
        }

        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            for(Entity f : l.getLocation().getChunk().getEntities())
            {
                if(f instanceof LivingEntity)
                {
                    LivingEntity le = (LivingEntity) f;
                    Optional<String> name = l.getBoss().getName();
                    if(name.isPresent() && le.getCustomName() != null && le.getCustomName().equalsIgnoreCase(name.get()))
                    {
                        le.remove();
                    }
                }
            }
        }


    }

    @Override
    public void onDisable()
    {
        //Cancel tasks
        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            l.getBossInstance().ifPresent(b -> b.onDeath(false, false));
        }

        ActivePowerTask.stop();
        BossEffectTask.stop();
        StageTask.stop();
    }

    public static Plugin getPlugin()
    {
        return PLUGIN;
    }
}
