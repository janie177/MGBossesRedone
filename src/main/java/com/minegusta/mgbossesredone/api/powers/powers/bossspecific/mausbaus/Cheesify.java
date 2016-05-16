package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.mausbaus;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Cheesify  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Cheesify";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

	}
}
