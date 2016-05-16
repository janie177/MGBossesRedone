package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.warg;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Howl  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Howl";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
