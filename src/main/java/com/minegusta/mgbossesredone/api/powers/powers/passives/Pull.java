package com.minegusta.mgbossesredone.api.powers.powers.passives;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Pull implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.PASSIVE;
	}

	@Override
	public String getName() {
		return "Pull";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
