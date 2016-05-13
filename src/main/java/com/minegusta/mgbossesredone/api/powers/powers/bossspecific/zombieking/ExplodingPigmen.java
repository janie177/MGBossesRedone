package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class ExplodingPigmen implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.SPECIAL;
	}

	@Override
	public String getName() {
		return "Exploding Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		List<LivingEntity> pigZombies = Lists.newArrayList();
		for(int i = 0; i < 3; i++)
		{
			PigZombie z = (PigZombie) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.PIG_ZOMBIE);
			z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 600, 0, false));
			z.setCanPickupItems(false);
			z.setCustomNameVisible(true);
			z.setCustomName(ChatColor.GREEN + "Exploding Minion");
			z.setAngry(true);
			if(!target.isEmpty()) z.setTarget(target.get(0));
			pigZombies.add(z);
		}

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), ()-> pigZombies.stream().filter(LivingEntity::isValid).forEach(pz ->
		{
			pz.getWorld().createExplosion(pz.getLocation().getX(), pz.getLocation().getY(), pz.getLocation().getZ(), 4, false, false);
			pz.getWorld().getLivingEntities().stream().filter(le -> le.getLocation().distance(pz.getLocation()) < 4).forEach(ent ->
			{
				ent.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 5, 0, false, true));
				ent.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 0, false, true));
			});
			if(pz.isValid())pz.remove();
		}), 20 * 6);
	}
}
