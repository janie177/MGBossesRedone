package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Skeleton;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class IceMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Ice Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(!EntityUtil.canSpawnLivingEntity(boss.getLocation(), 40, 25)) return;
		for(int i = 0; i < 3; i++)
		{
			Skeleton z = (Skeleton) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.SKELETON);
			z.setCustomName(ChatColor.AQUA + "Azmodan's Minion");
			z.setCustomNameVisible(true);
			z.setCanPickupItems(false);
			z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600 * 20, 0));
		}
	}
}
