package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ArrowSpray implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Arrow Spray";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
