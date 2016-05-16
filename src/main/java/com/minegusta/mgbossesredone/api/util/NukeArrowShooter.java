package com.minegusta.mgbossesredone.api.util;

import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class NukeArrowShooter implements ProjectileSource {
	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		return null;
	}
}
