package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class ZombieKingMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Call For Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(!EntityUtil.canSpawnLivingEntity(boss.getLocation(), 40, 25)) return;
		for(int i = 0; i < 3; i++)
		{
			Zombie z = (Zombie) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.ZOMBIE);
			z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 600, 0, false));
			z.setCanPickupItems(false);
			z.setCustomNameVisible(true);
			z.setCustomName(ChatColor.GREEN + "Zombie King's Minion");
		}
	}
}
