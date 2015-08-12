package com.minegusta.mgbossesredone.main;

import com.minegusta.mgbossesredone.tasks.BossEffectTask;
import com.minegusta.mgbossesredone.tasks.StageTask;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

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

        //Tasks
        BossEffectTask.start();
        StageTask.start();

        //Config
        ConfigManager.loadLocationsConfig();

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
        BossEffectTask.stop();
        StageTask.stop();
    }

    public static Plugin getPlugin()
    {
        return PLUGIN;
    }
}
