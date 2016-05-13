package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor;

import com.google.common.collect.Maps;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class ExplodingBats implements IPower {

	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Exploding Bats";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty())return;
		ConcurrentMap<LivingEntity, LivingEntity> bats = Maps.newConcurrentMap();
		for(int i = 0; i < 3; i++)
		{
			Bat b = (Bat) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.BAT);
			b.setCustomNameVisible(true);
			b.setCustomName(ChatColor.RED + "Exploding Bat");
			bats.put(b, target.get(target.size() == 1 ? 0 : RandomUtil.randomNumberZeroIncludedMaxExcluded(target.size())));
		}

		for(int i = 0; i <= 20 * 5; i++)
		{
			//set velocity
			if(i % 4 == 0)
			{

				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
				{
					bats.keySet().stream().filter(LivingEntity::isValid).forEach(b ->
					{
						if(bats.get(b).isValid() && bats.get(b).getWorld().equals(b.getWorld()))
						{
							Vector v = bats.get(b).getLocation().toVector().subtract(b.getLocation().toVector());
							v.normalize();
							b.setVelocity(v);
						}
					});
				}, i);
			}

			//explode
			if(i == 20 * 5)
			{
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () ->
				{
					bats.keySet().stream().filter(LivingEntity::isValid).forEach(b ->
					{
						b.getWorld().createExplosion(b.getLocation().getX(), b.getLocation().getY(), b.getLocation().getZ(), 4, false, false);
						if(b.isValid())b.remove();
					});
				}, i);
			}
		}
	}
}
