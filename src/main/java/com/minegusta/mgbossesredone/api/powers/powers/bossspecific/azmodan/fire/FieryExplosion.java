package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class FieryExplosion implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Fiery Explosion";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
