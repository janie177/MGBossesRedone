package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ExplodingPigmen implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Exploding Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
