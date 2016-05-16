package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.lastphase;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.NukeArrowShooter;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Nuke implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Nuke";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty()) return;
		LivingEntity t = target.get(0);
		final Location l = t.getLocation();

		t.getWorld().getPlayers().stream().filter(p -> p.getLocation().distance(t.getLocation()) < 20).forEach(p ->	p.sendMessage(ChatColor.DARK_RED + "WARNING: Azmodan is nuking " + ChatColor.YELLOW + t.getName() + ChatColor.DARK_RED + " in 6 seconds."));

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
		{
			Arrow a = (Arrow) l.getWorld().spawnEntity(l.add(0,15,0), EntityType.ARROW);
			a.setShooter(new NukeArrowShooter());
			a.getWorld().spigot().playEffect(a.getLocation(), Effect.CLOUD, 0, 0, 1, 1, 1, 1, 40, 50);
		}, 20 * 4);
	}
}
