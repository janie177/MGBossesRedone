package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.warg;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public class Howl  implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Howl";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		boss.getWorld().playSound(boss.getLocation(), Sound.ENTITY_WOLF_HOWL, 1, 1);
		target.stream().forEach(t ->
		{
			Vector v  = t.getLocation().toVector().subtract(boss.getLocation().toVector());
			t.setVelocity(v);
			t.sendMessage(ChatColor.RED + "The boss howls and pushes you back!");
		});
	}
}
