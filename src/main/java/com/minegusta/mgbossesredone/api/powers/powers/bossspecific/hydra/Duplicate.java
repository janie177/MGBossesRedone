package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.hydra;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Duplicate implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Duplicate";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
