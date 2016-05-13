package com.minegusta.mgbossesredone.api.powers.powers.passives;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class Pull implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.PASSIVE;
	}

	@Override
	public String getName() {
		return "Pull";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		target.stream().forEach(t ->
		{
			Vector velocity = boss.getLocation().toVector().subtract(t.getLocation().toVector());
			t.setVelocity(velocity.normalize().multiply(2.5));
			if(t instanceof Player)
			{
				t.sendMessage(ChatColor.RED + "The boss pulls you towards him!");
			}
		});
	}
}
