package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.ghastinator;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class Launch  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Launch";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty())return;
		target.stream().forEach(t ->
		{
			t.teleport(t.getLocation().add(0, 0.01, 0));
			t.setVelocity(new Vector(0, 3, 0));
			t.sendMessage(ChatColor.RED + "You got launched!");
		});
	}
}
