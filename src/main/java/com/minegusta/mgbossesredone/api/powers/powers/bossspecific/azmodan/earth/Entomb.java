package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Entomb implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Entomb";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {

		List<Block> blocks = Lists.newArrayList();

		target.stream().forEach(t ->
		{
			t.sendMessage(ChatColor.RED + "You are entombed!");
			Location center = t.getLocation();
			for(int x2 = -6; x2 < 6; x2++)
			{
				for(int y2 = -6; y2 < 6; y2++)
				{
					for(int z2 = -6; z2 < 6; z2++)
					{
						Location l = center.getBlock().getRelative(x2, y2, z2).getLocation();
						if(l.getBlock().getType() == Material.AIR && l.distance(center) > 2 && l.distance(center) < 5)
						{
							l.getBlock().setType(Material.STONE);
							blocks.add(l.getBlock());
						}

					}
				}
			}
		});

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()->
		{
			blocks.stream().forEach(b -> {
				if(b.getType() == Material.STONE) b.setType(Material.AIR);
			});
		}, 20 * 40);
	}
}
