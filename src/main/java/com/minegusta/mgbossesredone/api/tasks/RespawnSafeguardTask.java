package com.minegusta.mgbossesredone.api.tasks;

import com.minegusta.mgbossesredone.main.Main;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import org.bukkit.Bukkit;

public class RespawnSafeguardTask {
	private static int id = -1;

	//Run every 30 seconds, check if bosses are stuck and respawn if so.
	public static void start()
	{
		id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () ->
		{
			LocationRegistry.getLocations().stream()
					.filter(l -> !l.getIfSpawned() && l.getTaskId() == -1 && !l.getBossInstance().isPresent() && l.getLocation().getChunk().isLoaded())
					.forEach(l -> l.getBoss().spawnBoss(l));
		}, 20 * 30, 20 * 30);
	}

	public static void stop()
	{
		if(id != -1)
		{
			Bukkit.getScheduler().cancelTask(id);
		}
	}
}
