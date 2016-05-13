package com.minegusta.mgbossesredone.api.bosses.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.powers.Power;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Optional;

public class Azmodan extends AbstractBoss {
	@Override
	public String getName() {
		return ChatColor.DARK_RED + "Azmodan";
	}

	@Override
	public int getSpecialAttackRadius() {
		return 25;
	}

	@Override
	public int getSpecialAttackInterval() {
		return 12;
	}

	@Override
	public int getExp() {
		return 10;
	}

	@Override
	public EntityType getType() {
		return EntityType.BLAZE;
	}

	@Override
	public Boss getBossType() {
		return Boss.AZMODAN;
	}

	@Override
	public int getPowerChance() {
		return 40;
	}

	@Override
	public int respawnTime() {
		return 0;
	}

	@Override
	public List<Power> getStartingPowers() {
		return Lists.newArrayList();
	}

	private Effect effect = Effect.MOBSPAWNER_FLAMES;
	private Stage stage = Stage.ICE;
	private List<Power> firePowers = Lists.newArrayList(Power.FIERYEXPLOSION, Power.FIRESTORM, Power.SPEWLAVA, Power.PULL);
	private List<Power> earthPowers = Lists.newArrayList(Power.EARTHMINIONS, Power.ENTOMB, Power.POISONPOOL, Power.QUAKE, Power.PULL);
	private List<Power> icePowers = Lists.newArrayList(Power.FREEZE, Power.ICEMINIONS, Power.ICEPROJECTILES, Power.TIDALWAVE, Power.PULL);
	private List<Power> finalPowers = Lists.newArrayList(Power.AZMODANMINIONS, Power.EXPLOSIONCIRCLE, Power.NUKE, Power.REMOVEARMOUR, Power.WEAKEN, Power.PULL);


	@Override
	public Effect getEffectType() {
		return effect;
	}

	@Override
	public double getMaxHealth() {
		return 1000;
	}

	@Override
	public void onSpawn() {
		updateStage();
	}

	@Override
	public List<DropTable> getDropTables() {
		return Lists.newArrayList(DropTable.AZMODAN_SPECIAL, DropTable.GOOD, DropTable.MEDIUM, DropTable.BONES, DropTable.ALCHEMY, DropTable.ARMOUR);
	}

	@Override
	public String deathMessage() {
		return ChatColor.DARK_RED + "I SHALL RETURN!";
	}

	@Override
	public int getStageInterval() {
		return 20;
	}

	@Override
	public void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow) {

	}

	@Override
	public void applyStageUpdate() {
		updateStage();
	}

	private void updateStage()
	{
		if(getEntity().getHealth() < 200)
		{
			//Make final stage
			if(stage != Stage.FINAL)
			{
				stage = Stage.FINAL;
				getPowers().clearPowers();
				finalPowers.stream().forEach(this::addPower);
			}
		}
		else if(stage == Stage.FIRE)
		{
			//Make earth stage
			getPowers().clearPowers();
			stage = Stage.EARTH;
			earthPowers.stream().forEach(this::addPower);
		}
		else if(stage == Stage.EARTH)
		{
			//Make ice stage
			getPowers().clearPowers();
			stage = Stage.ICE;
			icePowers.stream().forEach(this::addPower);
		}
		else if(stage == Stage.ICE)
		{
			//Make fire stage
			getPowers().clearPowers();
			stage = Stage.FIRE;
			firePowers.stream().forEach(this::addPower);
		}
	}

	private enum Stage {
		ICE, FIRE, EARTH, FINAL
	}
}
