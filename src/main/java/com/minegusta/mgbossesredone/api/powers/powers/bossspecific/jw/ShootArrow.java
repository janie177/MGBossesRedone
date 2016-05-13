package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ShootArrow implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Awp Shot";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
