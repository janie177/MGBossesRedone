package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class PoisonPool implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Poison Pool";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
