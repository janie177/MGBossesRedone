package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class ShootArrow implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Awp Shot";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		Vector v = target.get(0).getLocation().toVector().subtract(boss.getLocation().toVector());
		boss.getWorld().spawnArrow(boss.getLocation().clone().add(0,2,0), v, 0.6F, 0F);
	}
}
