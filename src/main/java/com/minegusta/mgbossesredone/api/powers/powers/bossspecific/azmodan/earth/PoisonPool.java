package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LingeringPotion;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.List;

public class PoisonPool implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Poison Pool";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(target.isEmpty()) return;
		LivingEntity t = target.get(0);

		LingeringPotion p = (LingeringPotion) t.getWorld().spawnEntity(t.getLocation(), EntityType.LINGERING_POTION);
		PotionMeta meta = (PotionMeta) p.getItem().getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.POISON, false, false));
		meta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 120, 0), true);
		p.getItem().setItemMeta(meta);

	}
}
