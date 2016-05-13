package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.hydra;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Zombie;
import org.bukkit.util.Vector;

import java.util.List;

public class ZombieTornado implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Zombie Tornado";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		createWind(boss.getLocation(), 4, target.get(0));
	}

	private void createWind(Location l, int duration, final LivingEntity target) {
		final Location center = l;
		for (int i = 0; i <= 20 * duration; i++) {
			if (i % 2 == 0) {
				final int k = i;

				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
					if (k % 20 == 0) {
						center.getWorld().playSound(center, Sound.ENTITY_ENDERDRAGON_FLAP, 10, 1);
					}
					center.getWorld().spigot().playEffect(center, Effect.PARTICLE_SMOKE, 0, 0, 1, 5, 1, 1 / 30, 50, 30);


					//The sucking people in effect
					center.getWorld().getEntitiesByClasses(Zombie.class).stream().
							filter(ent -> ent.getLocation().distance(center) <= 5 && ((Zombie)ent).isBaby()).forEach(ent ->
					{
						double angle = Math.toRadians(8);
						double radius = Math.abs(ent.getLocation().distance(center));

						if(radius < 1)
						{
							ent.setVelocity(new Vector(1,0,1));
						}

						double x = ent.getLocation().getX() - center.getX();
						double z = ent.getLocation().getZ() - center.getZ();

						double dx = x * Math.cos(angle) - z * Math.sin(angle);
						double dz = x * Math.sin(angle) + z * Math.cos(angle);

						Location target1 = new Location(ent.getWorld(), dx + center.getX(), ent.getLocation().getY(), dz + center.getZ());

						double ix = ent.getLocation().getX() - target1.getX();
						double iz = ent.getLocation().getZ() - target1.getZ();

						Vector v = new Vector(ix, -0.2, iz);
						v.normalize();

						double amplifier = 0.6;
						ent.setVelocity(ent.getVelocity().add(v).multiply(-amplifier));
					});
				}, i);
			}

			if(i == 20* duration)
			{
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
				{

					if(target.isValid() && target.getWorld().equals(l.getWorld()))
					{
						center.getWorld().getEntitiesByClasses(Zombie.class).stream().
								filter(ent -> ent.getLocation().distance(center) <= 5 && ((Zombie)ent).isBaby()).forEach(ent ->
						{
							Vector v = target.getLocation().toVector().subtract(ent.getLocation().toVector());
							ent.setVelocity(v.normalize().multiply(2.6));
						});
					}
				}, i);
			}
		}
	}
}
