package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class Jump implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Jump";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		Block b = boss.getLocation().getBlock().getRelative(BlockFace.DOWN);
		if(b.getType() == Material.AIR && b.getRelative(BlockFace.DOWN).getType() == Material.AIR)
		{
			return;
		}
		jump(boss);
	}

	private void jump(LivingEntity entity) {
		final Location center = entity.getLocation();
		entity.teleport(entity.getLocation().add(0, 0.1, 0));
		entity.setVelocity(new Vector(0, 2.1, 0));

		List<Location> close = Lists.newArrayList();
		List<Location> medium = Lists.newArrayList();
		List<Location> far = Lists.newArrayList();

		for (int degrees = 0; degrees < 361; degrees = degrees + 45)
		{
			close.add(calculateCircle(center, degrees, 3));
		}

		for (int degrees = 0; degrees < 361; degrees = degrees + 45)
		{
			medium.add(calculateCircle(center, degrees, 5));
		}

		for (int degrees = 0; degrees < 361; degrees = degrees + 45)
		{
			far.add(calculateCircle(center, degrees, 10));
		}

		explode(close, 6, 3);
		explode(medium, 8, 2);
		explode(far, 10, 1);
	}

	public void explode(final List<Location> locations, int delay, float strength)
	{
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
		{
			for(Location l : locations)
			{
				l.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), strength, false, false);
			}
		}, 10* delay);

	}

	private static Location calculateCircle(Location l, int angle, double radius) {
		return new Location(l.getWorld(), l.getX() + radius * Math.sin(angle), l.getY(), l.getZ() + radius * Math.cos(angle));
	}
}
