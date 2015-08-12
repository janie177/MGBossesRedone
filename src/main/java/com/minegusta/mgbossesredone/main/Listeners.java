package com.minegusta.mgbossesredone.main;

import com.minegusta.mgbossesredone.listeners.BossListener;
import com.minegusta.mgbossesredone.listeners.PowerListener;
import com.minegusta.mgbossesredone.listeners.SpawnListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public enum Listeners {
    BOSSLISTENER(new BossListener()),
    POWELISTENER(new PowerListener()),
    SPAWNLISTENER(new SpawnListener());

    Listener listener;

    Listeners(Listener listener)
    {
        this.listener = listener;
    }

    public void register()
    {
        Bukkit.getPluginManager().registerEvents(listener, Main.getPlugin());
    }
}
