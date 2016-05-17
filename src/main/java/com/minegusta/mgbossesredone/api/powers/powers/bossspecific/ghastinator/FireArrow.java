package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.ghastinator;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class FireArrow  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Fire Arrow";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty())return;
		LivingEntity t = target.get(0);

		Vector v = t.getLocation().toVector().subtract(boss.getLocation().clone().add(0,2,0).toVector());
		Arrow a = t.getWorld().spawnArrow(boss.getLocation().clone().add(0,2,0), v, 1.2F, 0);
		a.setFireTicks(500);
		a.setCritical(true);
		a.setShooter(boss);
	}
}
