package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ZombieKingMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Call For Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
