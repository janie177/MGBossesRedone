package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Oink implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Oink";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
