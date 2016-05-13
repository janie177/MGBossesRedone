package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class SpewLava implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Spew Lava";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
