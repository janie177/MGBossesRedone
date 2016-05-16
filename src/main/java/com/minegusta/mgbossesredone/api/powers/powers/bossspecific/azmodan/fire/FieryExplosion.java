package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.InvincibleUtil;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class FieryExplosion implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Fiery Explosion";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		target.stream().forEach(t -> t.sendMessage(ChatColor.RED + "Azmodan is starting an explosion! RUN!"));

		for(int i = 0; i < 50; i++)
		{
			final int k = i;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
			{
				boss.getWorld().spigot().playEffect(boss.getLocation(), Effect.MOBSPAWNER_FLAMES, 0, 0, k / 5, k/5, k/5, 1, k/2, 50);
			},i * 2);

			if(i == 49)
			{
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
				{
					InvincibleUtil.setInvincible(boss, 3);
					boss.getWorld().createExplosion(boss.getLocation().getX(), boss.getLocation().getY(), boss.getLocation().getZ(), 10, false, false);
				},i * 2);
			}
		}
	}
}
