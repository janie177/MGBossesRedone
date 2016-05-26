package com.minegusta.mgbossesredone.listeners;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.BossesPlugin;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
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
        if(!(e instanceof Player) && e.getEntity().isCustomNameVisible() && ChatColor.stripColor(e.getEntity().getCustomName()).startsWith("[Boss]"))
        {
            e.setDroppedExp(0);
            e.getDrops().clear();
        }
    }

    @EventHandler
    public void onBossDamage(EntityDamageByEntityEvent e)
    {
        String uuid = e.getEntity().getUniqueId().toString();

        Optional<AbstractBoss> boss = BossesPlugin.getBossFromUuid(uuid);
        if(!boss.isPresent())return;
        if(e.getDamager() instanceof LivingEntity)
        {
            boss.get().onDamage(e, Optional.of((LivingEntity) e.getDamager()), false);
            if(RandomUtil.chance(boss.get().getPowerChance()))
            {
                boss.get().runRandomPower(IPower.PowerType.ACTIVE, Lists.newArrayList((LivingEntity) e.getDamager()));
            }
        }
        else if(e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof LivingEntity)
        {
            if(((LivingEntity)((Arrow) e.getDamager()).getShooter()).getLocation().distance(e.getEntity().getLocation()) > 30)
            {
                e.setCancelled(true);
                ((LivingEntity)((Arrow) e.getDamager()).getShooter()).sendMessage(ChatColor.RED + "You are too far away to damage that boss!");
                return;
            }
            boss.get().onDamage(e, Optional.of((LivingEntity) ((Arrow) e.getDamager()).getShooter()), true);
            if(RandomUtil.chance(boss.get().getPowerChance()))
            {
                boss.get().runRandomPower(IPower.PowerType.ACTIVE, Lists.newArrayList(((LivingEntity) ((Arrow) e.getDamager()).getShooter())));
            }
        }
        else if(e.getCause() == EntityDamageEvent.DamageCause.MAGIC)
        {
            if(e.getDamager() instanceof ThrownPotion)
            {
                ThrownPotion p = (ThrownPotion) e.getDamager();
                if(p.getShooter() instanceof LivingEntity && RandomUtil.chance(boss.get().getPowerChance()))
                {
                    boss.get().runRandomPower(IPower.PowerType.ACTIVE, Lists.newArrayList((LivingEntity)((ThrownPotion) e.getDamager()).getShooter()));
                }
            }
        }

    }

    @EventHandler
    public void onBossDamage(EntityDamageEvent e)
    {
        String uuid = e.getEntity().getUniqueId().toString();

        if(e instanceof EntityDamageByBlockEvent)
        {
            return;
        }

        Optional<AbstractBoss> boss = BossesPlugin.getBossFromUuid(uuid);
        if(!boss.isPresent()) return;
        boss.get().checkDeath(e);
        if(e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK && e.getCause() != EntityDamageEvent.DamageCause.PROJECTILE && e.getCause() != EntityDamageEvent.DamageCause.MAGIC)
        {
            List<LivingEntity> entities = Lists.newArrayList();
            e.getEntity().getWorld().getLivingEntities().stream().filter(ent -> ent.getLocation().distance(e.getEntity().getLocation()) < 30 && !ent.getUniqueId().toString().equals(e.getEntity().getUniqueId().toString())).forEach(entities::add);
            boss.get().onDamage(e, Optional.empty(), false);
            if(RandomUtil.chance(boss.get().getPassiveChance()))
            {
                boss.get().runRandomPower(IPower.PowerType.PASSIVE, entities);
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
