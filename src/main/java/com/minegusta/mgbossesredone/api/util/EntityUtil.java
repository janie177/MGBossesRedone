package com.minegusta.mgbossesredone.api.util;

import org.bukkit.Location;

public class EntityUtil {

	public static boolean canSpawnLivingEntity(Location l, int max, int radius)
	{
		return l.getWorld().getLivingEntities().stream().filter(ent -> ent.getLocation().distance(l) < radius).count() < max;
	}

}
