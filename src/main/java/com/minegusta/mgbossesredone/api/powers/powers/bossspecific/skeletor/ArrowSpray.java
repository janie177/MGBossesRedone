package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class ArrowSpray implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Arrow Spray";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty())return;
		LivingEntity t = target.get(0);
		for(int i = 0; i < 10; i++)
		{
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
			{
				if(t.getWorld().equals(boss.getWorld()) && t.isValid())
				{
					Vector v = t.getLocation().toVector().subtract(boss.getLocation().toVector());
					boss.getWorld().spawnArrow(boss.getLocation().clone().add(0,3,0), v, 0.6F, 0F);
				}
			}, i * 5);
		}
	}
}
