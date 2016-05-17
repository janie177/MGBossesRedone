package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.mausbaus;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.ChatUtil;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class MausTaunt  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Taunt";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

		target.stream().forEach(t -> ChatUtil.sendBossMessage(boss.getName(), t, taunts[RandomUtil.randomNumberZeroIncludedMaxExcluded(taunts.length)]));
	}

	private static final String[] taunts = new String[]{
			"Maaaus!",
			"Tch Tch Tch",
			"Mah cheese",
			"I am stinky and sticky",
			"RABIES *-o",
			"RHUBARB",
			"-sssssss-"};
}
