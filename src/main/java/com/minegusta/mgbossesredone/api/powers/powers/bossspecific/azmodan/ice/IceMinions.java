package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.EntityUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class IceMinions implements IPower {
	@Override
	public PowerType getType() {
		return PowerType.ACTIVE;
	}

	@Override
	public String getName() {
		return "Ice Minions";
	}

	@Override
	public void run(LivingEntity boss, List<LivingEntity> target) {
		if(!EntityUtil.canSpawnLivingEntity(boss.getLocation(), 40, 25)) return;
		for(int i = 0; i < 5; i++)
		{
			Skeleton z = (Skeleton) boss.getWorld().spawnEntity(boss.getLocation(), EntityType.SKELETON);
			z.setCustomName(ChatColor.AQUA + "Azmodan's Minion");
			z.setCustomNameVisible(true);
			z.setCanPickupItems(false);
			z.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
			z.getEquipment().setItemInMainHandDropChance(0F);
			z.getEquipment().setItemInOffHand(new ItemStack(Material.IRON_SWORD));
			z.getEquipment().setItemInOffHandDropChance(0F);
			z.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600 * 20, 0));
			z.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600 * 20, 1));
		}
	}
}
