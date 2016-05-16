package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.ghastinator;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

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

	}
}
