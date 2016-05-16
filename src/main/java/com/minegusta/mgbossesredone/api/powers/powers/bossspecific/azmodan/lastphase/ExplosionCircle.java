package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.lastphase;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ExplosionCircle implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Explosion Circle";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

		final Location center = boss.getLocation();
		List<Location> locations = Lists.newArrayList();

		for (int degrees = 0; degrees < 361; degrees = degrees + 15)
		{
			locations.add(calculateCircle(center, degrees, 30));
		}

		for(int i = 0; i <= locations.size() / 2; i++)
		{
			final int k = i;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()-> {
				Location l = locations.get(k);
				boss.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 4, false, false);
			},20 * i);
		}

		for(int i = locations.size() - 1; i >= locations.size() / 2; i--)
		{
			final int k = i;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()-> {
				Location l = locations.get(k);
				boss.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 4, false, false);
			},20 * i);
		}

	}

	private static Location calculateCircle(Location l, int angle, double radius) {
		return new Location(l.getWorld(), l.getX() + radius * Math.sin(angle), l.getY(), l.getZ() + radius * Math.cos(angle));
	}
}
