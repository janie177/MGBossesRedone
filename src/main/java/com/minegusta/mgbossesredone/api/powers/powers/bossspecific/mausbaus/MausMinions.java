package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.mausbaus;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Silverfish;

import java.util.List;

public class MausMinions  implements IPower {
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
			Silverfish s = (Silverfish) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.SILVERFISH);
			s.setCustomName(ChatColor.GRAY + "Silver Maus");
			s.setCustomNameVisible(true);
		}
	}
}
