package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.warg;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;

import java.util.List;

public class WolfMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(!EntityUtil.canSpawnLivingEntity(boss.getLocation(), 40, 25)) return;
		for(int i = 0; i < 2; i++)
		{
			Wolf w = (Wolf) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.WOLF);
			w.setCustomName(ChatColor.YELLOW + "Warg Pack Hound");
			w.setCustomNameVisible(true);
			w.setAngry(true);
			w.setBaby();
		}
	}
}
