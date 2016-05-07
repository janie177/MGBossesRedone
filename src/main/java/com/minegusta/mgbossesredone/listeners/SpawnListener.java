package com.minegusta.mgbossesredone.listeners;

import com.minegusta.mgbossesredone.api.BossesPlugin;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.Arrays;

public class SpawnListener implements Listener
{
    @EventHandler
    public void onChunkLoad(ChunkLoadEvent e)
    {
        for(SpawnLocation l : LocationRegistry.getLocations())
        {
            if(l.getIfSpawned()) continue;
            Chunk chunk = l.getLocation().getChunk();
            Chunk eventChunk = e.getChunk();
            if(chunk.getX() == eventChunk.getX() && chunk.getZ() == eventChunk.getZ())
            {
                l.getBoss().spawnBoss(l);
            }
        }
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent e)
    {
        LocationRegistry.getLocations().stream().forEach(l ->
        {
            if(l.getLocation().getChunk().getZ() == e.getChunk().getZ() && e.getChunk().getX() == l.getLocation().getChunk().getX())
            {
                l.getBossInstance().ifPresent(b -> b.onDeath(false, false, false));
            }
        });
    }
}
