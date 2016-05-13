package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.ChatUtil;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class JWTaunt implements IPower {
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

	private static final String[] taunts = new String[]{"Boosmeister.", "Oink.", "Wonderpig.", "Do I smell bacon?"};
}
