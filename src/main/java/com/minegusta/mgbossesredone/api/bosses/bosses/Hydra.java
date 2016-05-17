package com.minegusta.mgbossesredone.api.bosses.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.powers.Power;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Optional;

public class Hydra extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.DARK_AQUA + "Hydra";
	}

	@Override
	public int getSpecialAttackRadius() {
		return 30;
	}

	@Override
	public int getSpecialAttackInterval() {
		return 20;
	}

	@Override
	public int getExp() {
		return 2;
	}

	@Override
	public EntityType getType() {
		return EntityType.ZOMBIE;
	}

	@Override
	public Boss getBossType() {
		return Boss.HYDRA;
	}

	@Override
	public int getPowerChance() {
		return 50;
	}

	@Override
	public int respawnTime() {
		return 3;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList(Power.PULL, Power.DUPLICATE, Power.ZOMBIETORNADO);
	}

	@Override
	public Effect getEffectType() {
		return Effect.SLIME;
	}

	@Override
	public double getMaxHealth() {
		return 150;
	}

	@Override
	public void onSpawn() {
		((Zombie)getEntity()).setVillagerProfession(null);
	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.HYDRA_SPECIAL, DropTable.ALCHEMY, DropTable.JUNK, DropTable.BONES, DropTable.MEDIUM);
	}

	@Override
	public String deathMessage() {
		return ChatColor.GREEN + "Hail Hydra!";
	}

	@Override
	public int getStageInterval() {
		return 10;
	}

	@Override
	public void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow) {

	}

	@Override
	public void applyStageUpdate() {

	}
}
