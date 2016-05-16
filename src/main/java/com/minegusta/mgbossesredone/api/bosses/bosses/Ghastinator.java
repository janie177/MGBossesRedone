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

public class Ghastinator extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.WHITE + "Ghastinaror";
	}

	@Override
	public int getSpecialAttackRadius() {
		return 20;
	}

	@Override
	public int getSpecialAttackInterval() {
		return 15;
	}

	@Override
	public int getExp() {
		return 6;
	}

	@Override
	public EntityType getType() {
		return EntityType.GHAST;
	}

	@Override
	public Boss getBossType() {
		return Boss.GHASTINATOR;
	}

	@Override
	public int getPowerChance() {
		return 30;
	}

	@Override
	public int respawnTime() {
		return 30;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList(Power.PULL, Power.FIREARROW, Power.LAUNCH, Power.SWITCH);
	}

	@Override
	public Effect getEffectType() {
		return Effect.FLYING_GLYPH;
	}

	@Override
	public double getMaxHealth() {
		return 140;
	}

	@Override
	public void onSpawn() {

	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.GHASTINATOR_SPECIAL, DropTable.JUNK, DropTable.ALCHEMY);
	}

	@Override
	public String deathMessage() {
		return ChatColor.GRAY + "*Ghast noises*";
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
