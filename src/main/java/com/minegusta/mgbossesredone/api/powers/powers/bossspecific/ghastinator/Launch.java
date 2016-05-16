package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.ghastinator;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Launch  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Launch";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
