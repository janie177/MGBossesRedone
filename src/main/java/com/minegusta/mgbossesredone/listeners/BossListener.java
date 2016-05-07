package com.minegusta.mgbossesredone.listeners;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.BossesPlugin;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;
import java.util.Optional;

public class BossListener implements Listener
{

    @EventHandler
    public void onBossDeath(EntityDeathEvent e)
    {
        String uuid = e.getEntity().getUniqueId().toString();
        if(BossesPlugin.isBoss(uuid))
        {
            e.setDroppedExp(0);
            BossesPlugin.getBossFromUuid(uuid).onDeath(true, true);
        }
    }

    @EventHandler
    public void onBossDamage(EntityDamageByEntityEvent e)
    {
        String uuid = e.getEntity().getUniqueId().toString();
        if(BossesPlugin.isBoss(uuid))
        {
            AbstractBoss boss = BossesPlugin.getBossFromUuid(uuid);
            if(e.getDamager() instanceof LivingEntity)
            {
                boss.onDamage(e, Optional.of((LivingEntity) e.getDamager()), false);
                if(RandomUtil.chance(boss.getPowerChance()))
                {
                    boss.runRandomPower(Lists.newArrayList((LivingEntity) e.getDamager()));
                }
            }
            else if(e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof LivingEntity)
            {
                boss.onDamage(e, Optional.of((LivingEntity) ((Arrow) e.getDamager()).getShooter()), true);
                if(RandomUtil.chance(boss.getPowerChance()))
                {
                    boss.runRandomPower(Lists.newArrayList(((LivingEntity) ((Arrow) e.getDamager()).getShooter())));
                }
            }
        }
    }

    @EventHandler
    public void onBossDamage(EntityDamageEvent e)
    {
        String uuid = e.getEntity().getUniqueId().toString();
        if(BossesPlugin.isBoss(uuid))
        {
            AbstractBoss boss = BossesPlugin.getBossFromUuid(uuid);
            if(e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
            {
                List<LivingEntity> entities = Lists.newArrayList();
                e.getEntity().getWorld().getLivingEntities().stream().filter(ent -> ent.getLocation().distance(e.getEntity().getLocation()) < 10 && !ent.getUniqueId().toString().equals(e.getEntity().getUniqueId().toString())).forEach(entities::add);
                boss.onDamage(e, Optional.empty(), false);
                if(RandomUtil.chance(boss.getPowerChance()))
                {
                    boss.runRandomPower(IPower.PowerType.PASSIVE, entities);
                }
            }
        }
    }

    @EventHandler
    public void onBlockDamager(EntityDamageByBlockEvent e)
    {
        if(BossesPlugin.isBoss(e.getEntity().getUniqueId().toString()))
        {
            e.getEntity().teleport(e.getEntity().getLocation().clone().add(0,1.3,0));
            e.setCancelled(true);
        }
    }
}
