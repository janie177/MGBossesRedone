package com.minegusta.mgbossesredone.api.util;

import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;

public class ExplosionUtil {

	public static void nukeLocation(Location l)
	{
		final Location target = l;
		for (int i = 0; i < 60; i++) {
			final int k = i;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				@Override
				public void run() {
					nukeEffect(target, 110 + k, 30 * k, k / 4);
				}
			}, i);
		}
	}

	private static void nukeEffect(Location target, int range, int particles, int offSetY) {
		target.getWorld().createExplosion(target.getX(), target.getY() + 3 + offSetY, target.getZ(), 6F, false, false);
		target.getWorld().playSound(target, Sound.AMBIENT_CAVE, 1F, 1F);
		target.getWorld().spigot().playEffect(target, Effect.CLOUD, 1, 1, 0F, 3F + offSetY, 3F, 1F, particles, range);
		target.getWorld().spigot().playEffect(target, Effect.LAVA_POP, 1, 1, 0F, 3F, 0F, 1F, particles, range);
		target.getWorld().spigot().playEffect(target, Effect.SMOKE, 1, 1, 0F, 3F + offSetY, 0F, 1F, particles, range);
		target.getWorld().spigot().playEffect(target, Effect.FLAME, 1, 1, 0F, 3F + offSetY, 0F + offSetY, 1F, particles, range);
	}
}
