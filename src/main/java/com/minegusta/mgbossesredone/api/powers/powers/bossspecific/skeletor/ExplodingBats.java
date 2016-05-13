package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ExplodingBats implements IPower {

	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Exploding Bats";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
