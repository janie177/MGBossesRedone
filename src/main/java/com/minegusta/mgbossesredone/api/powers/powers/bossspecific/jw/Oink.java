package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.util.Vector;

import java.util.List;

public class Oink implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Oink";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		Vector v = target.get(0).getLocation().toVector().subtract(boss.getLocation().toVector());
		Pig pig = (Pig) boss.getWorld().spawnEntity(boss.getLocation().clone().add(0,3,0), EntityType.PIG);
		pig.setBaby();
		pig.setVelocity(v.multiply(2.6));

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
		{
			if(pig.isValid())
			{
				boss.getWorld().playSound(pig.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1, 1);
				pig.getWorld().createExplosion(pig.getLocation().getX(), pig.getLocation().getY(), pig.getLocation().getZ(), 4, false, false);
				pig.remove();
			}
		}, 40);
	}
}
