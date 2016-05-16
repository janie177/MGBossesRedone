package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.lastphase;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class Weaken implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Weaken";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		target.stream().forEach(e ->
		{
			e.sendMessage(ChatColor.DARK_GRAY + "You have been weakened...");
			e.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 0));
		});
	}
}
