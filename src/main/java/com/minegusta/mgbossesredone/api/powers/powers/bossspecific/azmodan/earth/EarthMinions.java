package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class EarthMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Exploding Cow";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty())return;
		if(!EntityUtil.canSpawnLivingEntity(boss.getLocation(), 40, 25)) return;

		LivingEntity ent = target.get(0);
		for(int i = 0; i < 2; i++)
		{
			Cow c = (Cow) boss.getWorld().spawnEntity(ent.getLocation(), EntityType.COW);
			c.setCustomName(ChatColor.GOLD + "Exploding Cow");
			c.setCustomNameVisible(true);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
			{
				boss.getWorld().createExplosion(c.getLocation().getX(), c.getLocation().getY(), c.getLocation().getZ(), 4, false, false);
				c.remove();
			}, 20*3);
		}
	}
}
