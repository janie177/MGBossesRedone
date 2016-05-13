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
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Optional;

public class JW extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.LIGHT_PURPLE + "JW";
	}

	@Override
	public int getSpecialAttackRadius() {
		return 30;
	}

	@Override
	public int getSpecialAttackInterval() {
		return 5;
	}

	@Override
	public int getExp() {
		return 4;
	}

	@Override
	public EntityType getType() {
		return EntityType.PIG;
	}

	@Override
	public Boss getBossType() {
		return Boss.JW;
	}

	@Override
	public int getPowerChance() {
		return 100;
	}

	@Override
	public int respawnTime() {
		return 30;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList(Power.OINK, Power.JWTAUNT, Power.PULL, Power.SHOOTARROW);
	}

	@Override
	public Effect getEffectType() {
		return Effect.POTION_SWIRL;
	}

	@Override
	public double getMaxHealth() {
		return 100;
	}

	@Override
	public void onSpawn() {

	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.JW_SPECIAL, DropTable.JUNK, DropTable.BUILDBLOCKS, DropTable.BONES);
	}

	@Override
	public String deathMessage() {
		return ChatColor.LIGHT_PURPLE + "Oink.";
	}

	@Override
	public int getStageInterval() {
		return 30;
	}

	@Override
	public void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow) {

	}

	@Override
	public void applyStageUpdate() {

	}
}
