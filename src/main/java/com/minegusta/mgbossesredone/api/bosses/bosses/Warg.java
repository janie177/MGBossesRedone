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
import org.bukkit.entity.Wolf;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Optional;

public class Warg extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.DARK_GRAY + "Warg";
	}

	@Override
	public int getSpecialAttackRadius() {
		return 12;
	}

	@Override
	public int getSpecialAttackInterval() {
		return 8;
	}

	@Override
	public int getExp() {
		return 5;
	}

	@Override
	public EntityType getType() {
		return EntityType.WOLF;
	}

	@Override
	public Boss getBossType() {
		return Boss.WARG;
	}

	@Override
	public int getPowerChance() {
		return 20;
	}

	@Override
	public int respawnTime() {
		return 40;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList(Power.PULL, Power.HOWL, Power.WOLFMINIONS, Power.SWITCH);
	}

	@Override
	public Effect getEffectType() {
		return Effect.LARGE_SMOKE;
	}

	@Override
	public double getMaxHealth() {
		return 160;
	}

	@Override
	public void onSpawn() {
		Wolf wolf = (Wolf) getEntity();
		wolf.setAngry(true);
		wolf.setAdult();
	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.WARG_SPECIAL, DropTable.MEDIUM, DropTable.JUNK);
	}

	@Override
	public String deathMessage() {
		return ChatColor.DARK_GRAY + "WAAARGHHH";
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
