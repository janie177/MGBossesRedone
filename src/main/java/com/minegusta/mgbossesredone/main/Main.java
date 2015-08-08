package com.minegusta.mgbossesredone.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Plugin PLUGIN;

    @Override
    public void onEnable()
    {
        PLUGIN = this;
    }

    @Override
    public void onDisable()
    {

    }

    public static Plugin getPlugin()
    {
        return PLUGIN;
    }
}
