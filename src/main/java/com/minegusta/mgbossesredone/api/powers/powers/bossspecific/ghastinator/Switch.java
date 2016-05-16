package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.ghastinator;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Switch  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Switch";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
