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

public class ZombieKing extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.DARK_GREEN + "Zombie King";
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
		return 5;
	}

	@Override
	public EntityType getType() {
		return EntityType.GIANT;
	}

	@Override
	public Boss getBossType() {
		return Boss.ZOMBIEKING;
	}

	@Override
	public int getPowerChance() {
		return 40;
	}

	@Override
	public int respawnTime() {
		return 50;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList(Power.EXPLODINGPIGMEN, Power.JUMP, Power.ZOMBIEKINGMINIONS, Power.PULL);
	}

	@Override
	public Effect getEffectType() {
		return Effect.SLIME;
	}

	@Override
	public double getMaxHealth() {
		return 130;
	}

	@Override
	public void onSpawn() {

	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.ZOMBIE_KING_SPECIAL, DropTable.MEDIUM, DropTable.BONES, DropTable.ORE);
	}

	@Override
	public String deathMessage() {
		return ChatColor.DARK_GREEN + "Blaaaarghhh...";
	}

	@Override
	public int getStageInterval() {
		return 50;
	}

	@Override
	public void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow) {

	}

	@Override
	public void applyStageUpdate() {

	}
}
