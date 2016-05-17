package com.minegusta.mgbossesredone.api.bosses.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.powers.Power;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;
import java.util.Optional;

public class MausBaus extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.DARK_AQUA + "Maus" + ChatColor.AQUA + "Baus";
	}

	@Override
	public int getSpecialAttackRadius() {
		return 25;
	}

	@Override
	public int getSpecialAttackInterval() {
		return 16;
	}

	@Override
	public int getExp() {
		return 4;
	}

	@Override
	public EntityType getType() {
		return EntityType.ZOMBIE;
	}

	@Override
	public Boss getBossType() {
		return Boss.MAUSBAUS;
	}

	@Override
	public int getPowerChance() {
		return 20;
	}

	@Override
	public int respawnTime() {
		return 30;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList(Power.PULL, Power.CHEESIFY, Power.MAUSMINIONS, Power.MAUSMINIONS2, Power.MAUSTAUNT);
	}

	@Override
	public Effect getEffectType() {
		return Effect.CLOUD;
	}

	@Override
	public double getMaxHealth() {
		return 160;
	}

	@Override
	public void onSpawn() {
		Zombie z = (Zombie) getEntity();
		z.setVillagerProfession(null);
		z.setBaby(false);
		z.setCanPickupItems(false);
		z.getEquipment().setHelmet(new ItemStack(Material.SKULL_ITEM, 1, (short) 3)
		{
			{
				SkullMeta meta = (SkullMeta) getItemMeta();
				meta.setOwner("janie177");
				setItemMeta(meta);
			}
		});
		z.getEquipment().setHelmetDropChance(0.1F);
	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.MAUS_BAUS_SPECIAL, DropTable.JUNK, DropTable.TOOL);
	}

	@Override
	public String deathMessage() {
		return ChatColor.RED + "I will return! Also don't eat my cheese!";
	}

	@Override
	public int getStageInterval() {
		return 100;
	}

	@Override
	public void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow) {

	}

	@Override
	public void applyStageUpdate() {

	}
}
