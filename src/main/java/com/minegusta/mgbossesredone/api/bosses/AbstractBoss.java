package com.minegusta.mgbossesredone.api.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.BossesPlugin;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.powers.Power;
import com.minegusta.mgbossesredone.api.powers.PowerCollection;
import com.minegusta.mgbossesredone.api.tasks.SpawnTask;
import com.minegusta.mgbossesredone.main.Main;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.Optional;

public abstract class AbstractBoss
{

    private PowerCollection powers = new PowerCollection();
    private LivingEntity entity;
    private List<DropTable> tables = Lists.newArrayList();
    private String spawnLocationName;
    private int stage = 0;

    public void addPower(Power power)
    {
        powers.addPower(power, power.getPower().getType());
    }

    public void removePower(Power power)
    {
        powers.removePower(power, power.getPower().getType());
    }

    public LivingEntity getEntity()
    {
        return entity;
    }

    public abstract String getName();

    public abstract int getSpecialAttackRadius();

	/**
	 * Amount of seconds it takes on average to run an attack.
     * @return
     */
    public abstract int getSpecialAttackInterval();

    public abstract int getExp();

    public String getUUID()
    {
        return getEntity().getUniqueId().toString();
    }

    public abstract EntityType getType();

    public abstract Boss getBossType();

    public SpawnLocation getSpawnLocation()
    {
        return LocationRegistry.getSpawnLocation(spawnLocationName);
    }

    public abstract int getPowerChance();

    public abstract int respawnTime();

    public int getPassiveChance()
    {
        return 10;
    }

    public abstract List<Power> getStartingPowers();

    public abstract Effect getEffectType();

    public abstract double getMaxHealth();

    public abstract void onSpawn();

    public abstract List<DropTable> getDropTables();

    public abstract String deathMessage();

    public abstract int getStageInterval();

    public double getCurrentHealth()
    {
        return getEntity().getHealth();
    }

    public PowerCollection getPowers()
    {
        return powers;
    }

    public int getStage()
    {
        return stage;
    }

    public void setStage(int stage)
    {
        this.stage = stage;
    }

    public abstract int getCredits();

    public abstract void extraOnDeath();

    private void dropLoot()
    {
        tables.stream().forEach(table ->
        {
            Block spawnBlock = getSpawnLocation().getLocation().getBlock();
            spawnBlock.setType(Material.CHEST);
            Chest chest = (Chest) spawnBlock.getState();

            if(table.rolledPositive())
            {
                if (chest.getInventory().firstEmpty() == -1) {
                    entity.getWorld().dropItemNaturally(entity.getLocation(), table.getRandomItem());
                    entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.CLOUD, 0, 0, 1, 1, 1, 1, 15, 30);
                } else
                {
                    chest.getInventory().addItem(table.getRandomItem());
                    chest.getWorld().spigot().playEffect(chest.getLocation(), Effect.CLOUD, 0, 0, 1, 1, 1, 1, 15, 40);
                }
            }
        });

        entity.getWorld().getPlayers().stream().filter(p -> p.getLocation().distance(entity.getLocation()) <= 30).forEach(p ->
        {
            p.sendMessage(ChatColor.DARK_PURPLE + "[" + org.bukkit.ChatColor.LIGHT_PURPLE + "MG" + org.bukkit.ChatColor.DARK_PURPLE + "] " + org.bukkit.ChatColor.YELLOW + "The boss dropped " + org.bukkit.ChatColor.LIGHT_PURPLE + getCredits() + org.bukkit.ChatColor.YELLOW + " credits.");
            p.sendMessage(ChatColor.DARK_PURPLE + "[" + org.bukkit.ChatColor.LIGHT_PURPLE + "MG" + org.bukkit.ChatColor.DARK_PURPLE + "] " + org.bukkit.ChatColor.YELLOW + "The boss loot has been placed in the chest at the spawn location.");
            Bukkit.getServer().dispatchCommand(Main.getPlugin().getServer().getConsoleSender(), "addcredits " + p.getName() + " " + getCredits());
        });
    }

    public void sendDeathMessage(int radius) {
        entity.getWorld().getPlayers().stream().filter(p -> p.getLocation().distance(entity.getLocation()) < radius).forEach(p -> p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + getName() + ChatColor.DARK_RED + "]" + ChatColor.RESET + deathMessage()));
    }

    public void removeBoss()
    {
        if(!entity.isDead())
        {
            getEntity().damage(getEntity().getMaxHealth() + 100);
        }
        getEntity().remove();
        getSpawnLocation().setInstance(null);
    }

    public boolean checkDeath(EntityDamageEvent e)
    {
        if(entity.getHealth() - e.getDamage() < 1)
        {
            onDeath(true, true, true);
            return true;
        }
        return false;
    }

    public abstract void onDamage(EntityDamageEvent e, Optional<LivingEntity> attacker, boolean arrow);

    public void onDeath(boolean loot, boolean respawn, boolean message)
    {
        if(message) sendDeathMessage(30);
        if(loot)
        {
            ((ExperienceOrb)entity.getWorld().spawnEntity(entity.getLocation(), EntityType.EXPERIENCE_ORB)).setExperience(getExp());
            dropLoot();
            extraOnDeath();
        }
        getSpawnLocation().setIfSpawned(false);
        if(respawn) getSpawnLocation().setTaskId(new SpawnTask(respawnTime(), getBossType(), getSpawnLocation()).startTimer());
        removeBoss();
    }

    public synchronized boolean spawn(SpawnLocation l)
    {
        if(!l.getLocation().getChunk().isLoaded() || LocationRegistry.getSpawnLocation(l.getName()).getIfSpawned())
        {
            return false;
        }

        LivingEntity boss = (LivingEntity) l.getLocation().getWorld().spawnEntity(l.getLocation(), getType());
        boss.setMaxHealth(getMaxHealth());
        boss.setHealth(boss.getMaxHealth());
        boss.setCustomNameVisible(true);
        boss.setCustomName(org.bukkit.ChatColor.DARK_RED  + "[" + org.bukkit.ChatColor.RED + "Boss" + org.bukkit.ChatColor.DARK_RED + "]" + getName());
        boss.setRemoveWhenFarAway(false);
        spawnLocationName = l.getName();
        this.entity = boss;

        l.setInstance(this);

        getStartingPowers().stream().forEach(this::addPower);

        this.tables = getDropTables();

        LocationRegistry.getSpawnLocation(l.getName()).setIfSpawned(true);
        l.setTaskId(-1);

        entity.getWorld().getLivingEntities().stream().filter(ent -> entity.getCustomName().equalsIgnoreCase(ent.getCustomName()) && ent.isValid() && ent.getLocation().distance(entity.getLocation()) < 100 && !ent.getUniqueId().toString().equalsIgnoreCase(entity.getUniqueId().toString()) && !BossesPlugin.isBoss(ent.getUniqueId().toString())).forEach(ent ->
        {
            ent.damage(ent.getMaxHealth() + 100);
            ent.remove();
        });

        onSpawn();

        return true;
    }

    public abstract void applyStageUpdate();

    public void updateStage(int ticks)
    {
        if(ticks % getStageInterval() == 0) applyStageUpdate();
    }

    public void runpower(Power power, List<LivingEntity> target)
    {
        power.getPower().run(entity, target);
    }

    public void runRandomPower(IPower.PowerType type, List<LivingEntity> target)
    {
        Optional<Power> power = getPowers().getRandomPower(type);
        if(power.isPresent())
        {
            power.get().getPower().run(entity, target);
        }
    }

    public void runRandomPower(List<LivingEntity> target)
    {
        Optional<Power> power = getPowers().getRandomPower();
        if(power.isPresent())
        {
            power.get().getPower().run(entity, target);
        }
    }
}
