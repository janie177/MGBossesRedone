package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class FireStorm implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Fire Storm";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		target.stream().forEach(t -> callStorm(t.getLocation().clone().add(0,12,0)));
	}

	private void callStorm(Location location)
	{
		int duration = 6;
		int interval = 8;
		for (int i = 0; i <= duration * 20; i++) {
			if (i % interval == 0) {
				double offsetX = RandomUtil.randomNumberZeroIncludedMaxExcluded(16) - 8;
				double offsetZ = RandomUtil.randomNumberZeroIncludedMaxExcluded(16) - 8;
				final Location spawnLocation = new Location(location.getWorld(), location.getX() + offsetX, location.getY(), location.getZ() + offsetZ);

				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
					Fireball ball = (Fireball) location.getWorld().spawnEntity(spawnLocation, EntityType.FIREBALL);
					ball.setDirection(new Vector(0, -1, 0));
					ball.setYield(4);
				}, i);
			}
		}
	}
}
