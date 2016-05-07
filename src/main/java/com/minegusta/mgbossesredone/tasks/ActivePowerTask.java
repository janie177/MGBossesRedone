package com.minegusta.mgbossesredone.tasks;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import com.minegusta.mgbossesredone.main.Main;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import org.bukkit.Bukkit;

import java.util.stream.Collectors;

public class ActivePowerTask {
	private static int id = -1;

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
			LocationRegistry.getLocations().stream().filter(l -> l.getIfSpawned() && (l.getBossInstance().isPresent() && (l.getBossInstance().get().getEntity().getHealth() > 0) && RandomUtil.randomNumberZeroIncludedMaxExcluded(l.getBossInstance().get().getActiveAttackInterval()) == 0))
					.forEach(l -> l.getBossInstance().get().runRandomPower(IPower.PowerType.ACTIVE,
							Bukkit.getOnlinePlayers().stream().filter(
									p -> p.getWorld() == l.getLocation().getWorld() && l.getLocation().distance(p.getLocation()) <= l.getBossInstance().get().getActiveAttackRadius())
							.collect(Collectors.toList())
					));
		}, 20, 20);
	}
}
