package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.lastphase;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class AzmodanMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(!EntityUtil.canSpawnLivingEntity(boss.getLocation(), 40, 25)) return;
		for(int i = 0; i < 3; i++)
		{
			PigZombie z = (PigZombie) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.PIG_ZOMBIE);
			z.setCustomName(ChatColor.DARK_RED + "Azmodan's Minion");
			z.setCustomNameVisible(true);
			z.setCanPickupItems(false);
			z.setAngry(true);
			z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600 * 20, 0));
			z.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
			z.getEquipment().setItemInMainHandDropChance(0F);
			z.getEquipment().setItemInOffHand(new ItemStack(Material.IRON_SWORD));
			z.getEquipment().setItemInOffHandDropChance(0F);
			z.setBaby(false);
		}
	}
}
