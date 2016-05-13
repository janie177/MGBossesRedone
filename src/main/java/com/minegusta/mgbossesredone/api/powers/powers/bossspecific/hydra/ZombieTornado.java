package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.hydra;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ZombieTornado implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Zombie Tornado";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
