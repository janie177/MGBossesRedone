package com.minegusta.mgbossesredone.api.bosses;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.drops.DropTable;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.powers.Power;
import com.minegusta.mgbossesredone.api.tasks.SpawnTask;
import com.minegusta.mgbossesredone.registry.BossRegistry;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;
import java.util.Optional;

public abstract class AbstractBoss
{

    private PowerCollection powers = new PowerCollection();
    private LivingEntity entity;
    private List<DropTable> tables = Lists.newArrayList();
    private String spawnLocationName;

    public void addPower(Power power, IPower.PowerType type)
    {
        powers.addPower(power, type);
    }

    public void removePower(Power power, IPower.PowerType type)
    {
        powers.removePower(power, type);
    }

    public LivingEntity getEntity()
    {
        return entity;
    }

    public abstract String getName();

    public abstract EntityType getType();

    public abstract Boss getBossType();

    public SpawnLocation getSpawnLocation()
    {
        return LocationRegistry.getSpawnLocation(spawnLocationName);
    }

    public abstract int getPowerChance();

    public abstract int respawnTime();

    public abstract List<Power> getStartingActivePowers();

    public abstract List<Power> getStartingPassivePowers();

    public abstract Effect getEffectType();

    public abstract double getHealth();

    public abstract void onSpawn();

    public abstract List<DropTable> getDropTables();

    public abstract String deathMessage();

    public abstract int getStageInterval();

    public PowerCollection getPowers()
    {
        return powers;
    }

    public void dropLoot()
    {
        tables.stream().forEach(table ->
        {
            if(table.rolledPositive())
            {
                entity.getWorld().dropItemNaturally(entity.getLocation(), table.getRandomItem());
            }
        });
    }

    public void sendDeathMessage(int radius) {
        entity.getWorld().getPlayers().stream().filter(p -> p.getLocation().distance(entity.getLocation()) < radius).forEach(p -> p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + getName() + ChatColor.DARK_RED + "]" + ChatColor.RESET + deathMessage()));
    }

    public void removeBoss()
    {
        BossRegistry.removeBoss(entity.getUniqueId().toString());
    }

    public abstract void onDamage(EntityDamageByEntityEvent e, LivingEntity attacker, boolean arrow);

    public void onDeath(boolean loot, boolean respawn)
    {
        sendDeathMessage(30);
        if(loot) dropLoot();
        getSpawnLocation().setIfSpawned(false);
        if(respawn) new SpawnTask(respawnTime(), getBossType(), getSpawnLocation()).startTimer();
        removeBoss();
    }

    public AbstractBoss spawn(SpawnLocation l)
    {
        if(LocationRegistry.isSpawned(l.getName()))return this;
        l.setInstance(this);

        LivingEntity boss = (LivingEntity) l.getLocation().getWorld().spawnEntity(l.getLocation(), getType());
        boss.setMaxHealth(getHealth());
        boss.setCustomNameVisible(true);
        boss.setCustomName(getName());
        boss.setRemoveWhenFarAway(false);
        spawnLocationName = l.getName();
        this.entity = boss;

        for(Power power : getStartingActivePowers())
        {
            addPower(power, IPower.PowerType.ACTIVE);
        }
        for(Power power : getStartingPassivePowers())
        {
            addPower(power, IPower.PowerType.PASSIVE);
        }

        BossRegistry.createBoss(boss.getUniqueId().toString(), this);

        this.tables = getDropTables();

        LocationRegistry.getSpawnLocation(l.getName()).setIfSpawned(true);

        onSpawn();

        return this;
    }

    public abstract void applyStageUpdate();

    public void updateStage(int ticks)
    {
        if(ticks % getStageInterval() == -0) applyStageUpdate();
    }

    public void runpower(Power power, Optional<List<Entity>> target)
    {
        power.getPower().run(entity, target);
    }

    public void runPower(IPower.PowerType type, Optional<List<Entity>> target)
    {
        Optional<Power> power = getPowers().getRandomPower(type);
        if(power.isPresent())
        {
            power.get().getPower().run(entity, target);
        }
    }


}
