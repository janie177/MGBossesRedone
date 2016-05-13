package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.hydra;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

import java.util.List;

public class Duplicate implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Duplicate";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		for(int i = 0; i < 3; i++)
		{
			Zombie z = (Zombie) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.ZOMBIE);
			z.setCustomName(ChatColor.GREEN + "Hydra Clone");
			z.setBaby(true);
			z.setVillagerProfession(null);
			z.setCanPickupItems(false);
			z.setCustomNameVisible(true);
		}
	}
}
