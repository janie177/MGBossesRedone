package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.mausbaus;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class MausMinions2  implements IPower {
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
			Endermite m = (Endermite) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.ENDERMITE);
			m.setCustomName(ChatColor.DARK_PURPLE + "Purple Maus");
			m.setCustomNameVisible(true);
		}
	}
}
