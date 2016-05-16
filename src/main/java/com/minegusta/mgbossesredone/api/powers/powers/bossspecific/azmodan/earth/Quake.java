package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class Quake implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Quake";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		task(boss.getLocation(), 8, 20, 2, boss);
		boss.getWorld().getPlayers().stream().filter(p -> p.getLocation().distance(boss.getLocation()) <= 30).forEach(p -> p.sendMessage(ChatColor.RED + "Earthquake!!"));
	}

	private void task(final Location l, int duration, final int radius, final double strength, LivingEntity boss) {
		for (int i = 0; i <= 20 * duration; i++) {
			if (i % 4 == 0) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
					shake(l, radius, strength, boss);
					if (RandomUtil.chance(30)) {
						double x = RandomUtil.randomNumberZeroIncludedMaxExcluded(2 * radius) - radius;
						double z = RandomUtil.randomNumberZeroIncludedMaxExcluded(2 * radius) - radius;
						column(new Location(l.getWorld(), l.getX() + x, l.getY(), l.getZ() + z));
					}
				}, i);
			}
		}
	}

	private void shake(final Location l, int radius, double strength, LivingEntity boss) {
		l.getWorld().getEntitiesByClasses(LivingEntity.class, Item.class).stream().
				filter(ent -> ent.getLocation().distance(l) <= radius && !ent.getUniqueId().toString().equalsIgnoreCase(boss.getUniqueId().toString())).
		        forEach(ent -> {
			double range = strength * 0.6;
			double min = range / 2;

			double x = RandomUtil.randomDouble(range, 0) - min;
			double z = RandomUtil.randomDouble(range, 0) - min;

			ent.setVelocity(ent.getVelocity().add(new Vector(x, ent.getVelocity().getY(), z)));
		});
	}

	private void column(final Location l) {
		final int duration = 6 * 20;
		final int delay = 6;

		final Block b = findAir(l);

		//Spawn them
		for (int i = 0; i < 5; i++) {
			final int up = i;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
				Block changed = b.getRelative(BlockFace.UP, up);
				if (changed.getType() == Material.AIR) {
					changed.setType(Material.STONE);
					removeBlock(changed, duration - up * 20);
				}
			}, i * delay);
		}
	}

	private void removeBlock(final Block b, int delay) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
			if (b.getType() == Material.STONE) {
				b.setType(Material.AIR);
			}
		}, delay);
	}

	private Block findAir(Location l) {
		if (l.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
			return l.getBlock();
		}
		for (int i = 2; i < 7; i++) {
			if (l.getBlock().getRelative(BlockFace.DOWN, i).getType() != Material.AIR) {
				return l.getBlock().getRelative(BlockFace.DOWN, i - 1);
			}
		}
		return l.getBlock().getRelative(BlockFace.DOWN, 3);
	}

}
