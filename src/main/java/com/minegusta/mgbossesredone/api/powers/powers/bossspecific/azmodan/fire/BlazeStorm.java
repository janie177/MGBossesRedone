package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.ChatColor;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class BlazeStorm implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Blaze Storm";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		for(int i = 0; i < 3; i++)
		{
			Blaze b = (Blaze) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.BLAZE);
			b.setCustomName(ChatColor.DARK_RED + "Azmodan's Minion");
			b.setCustomNameVisible(true);
		}
	}
}
