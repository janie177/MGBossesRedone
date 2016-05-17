package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.mausbaus;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.List;

public class Cheesify  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Cheesify";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		final Block center = boss.getLocation().getBlock();
		target.stream().forEach(ent ->
		{
			if(ent instanceof Player)
			{
				for(int x = -15; x < 15; x++)
				{
					for(int y = -15; y < 15; y++)
					{
						for(int z = -15; z < 15; z++)
						{
							Block b = center.getRelative(x, y, z);
							if(b.getType() != Material.AIR)
							{
								((Player)ent).sendBlockChange(b.getLocation(), Material.SPONGE, (byte) 0);
							}
						}
					}
				}
			}

		});
	}
}
