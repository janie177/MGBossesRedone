package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class TidalWave implements IPower {

	public static ConcurrentMap<Location, Boolean> blockMap = Maps.newConcurrentMap();


	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Tidal Wave";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		start(14, true, boss);
	}

	private void start(int radius, final boolean damage, LivingEntity p) {
		//Add all blocks for the wave in a row here.
		final Location center = p.getTargetBlock(Sets.newHashSet(Material.AIR), 7).getLocation();
		final Vector v = p.getLocation().getDirection();
		v.normalize();
		v.multiply(1.25);

		for (int i = 0; i <= radius; i++) {
			final Location start = new Location(center.getWorld(), center.getX() + i * v.getX(), center.getY() + i * v.getY(), center.getZ() + i * v.getZ());

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
				final List<Block> blocks = Lists.newArrayList();

				//Do the wave stuff
				for (int x = -5; x < 6; x++) {
					for (int y = -5; y < 6; y++) {
						for (int z = -5; z < 6; z++) {
							Block target = start.getWorld().getBlockAt((int) start.getX() + x, (int) start.getY() + y, (int) start.getZ() + z);
							if (target.getLocation().distance(start) < 3 && target.getType() == Material.AIR) {
								blockMap.put(target.getLocation(), true);
								blocks.add(target);
							}
						}
					}
				}

				//Set to water and then task to make it air again

				start.getWorld().getEntitiesByClass(Player.class).stream().filter(player -> player.getLocation().distance(start) <= 100).forEach(player -> {
					blocks.stream().filter(b -> b.getType() == Material.AIR).forEach(b -> {
						player.sendBlockChange(b.getLocation(), Material.STATIONARY_WATER, (byte) 0);
						// b.setType(Material.STATIONARY_WATER);

						//Return to normal after 2/3 second.
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
							player.sendBlockChange(b.getLocation(), Material.AIR, (byte) 0);
							blockMap.remove(b.getLocation());
						}, 10);
					});
				});

				//Apply the effects
				start.getWorld().getEntitiesByClass(LivingEntity.class).stream().
						filter(le -> le.getLocation().distance(start) <= 4).forEach(le -> {
					double x = le.getLocation().getX() - start.getX();
					double y = le.getLocation().getY() - start.getY();
					double z = le.getLocation().getZ() - start.getZ();
					Vector v1 = new Vector(x, y, z);
					v1.normalize();
					le.setVelocity(le.getVelocity().add(v1.multiply(1.4)));

					EntityDamageEvent e = new EntityDamageEvent(le, EntityDamageEvent.DamageCause.DROWNING, 4);

					if (damage && !e.isCancelled()) {
						le.damage(4);
					}
				});
			}, 6 * i);
		}
	}
}
