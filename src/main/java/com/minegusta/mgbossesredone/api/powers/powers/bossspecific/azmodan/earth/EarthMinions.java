package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class EarthMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}