package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class Freeze implements IPower {

	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Freeze";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty())return;
		List<Location> locations = Lists.newArrayList();
		LivingEntity t = target.get(0);
		if(!(t instanceof Player)) return;
		final Block center = t.getLocation().getBlock();
		for(int x2 = -7; x2 < 8; x2++)
		{
			for(int z2 = -7; z2 < 8; z2++)
			{
				Location l = center.getRelative(x2, center.getY(), z2).getLocation();
				if(l.getBlock().getType() == Material.AIR) locations.add(l);
			}

		}

		center.getWorld().getPlayers().stream().filter(pl -> pl.getLocation().distance(center.getLocation()) < 70).forEach(pl ->
		{
			if(pl.getLocation().distance(t.getLocation()) < 15) pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 6, 1));
			locations.stream().forEach(loc ->pl.sendBlockChange(loc, Material.SNOW.getId(), (byte) 1));
		});

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
		{
			center.getWorld().getPlayers().stream().filter(pl -> pl.getLocation().distance(center.getLocation()) < 70).forEach(pl -> locations.stream().forEach(loc ->pl.sendBlockChange(loc, loc.getBlock().getType().getId(), (byte) 0)));
		}, 20 * 6);

	}
}
