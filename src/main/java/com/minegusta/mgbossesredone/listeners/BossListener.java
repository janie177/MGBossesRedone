package com.minegusta.mgbossesredone.listeners;

import com.minegusta.mgbossesredone.api.BossesPlugin;
import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class BossListener implements Listener
{

    @EventHandler
    public void onBossDeath(EntityDeathEvent e)
    {
        String uuid = e.getEntity().getUniqueId().toString();
        if(BossesPlugin.isBoss(uuid))BossesPlugin.getBossFromUuid(uuid).onDeath(true, true);
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
                boss.onDamage(e, (LivingEntity) e.getDamager(), false);
            }
            else if(e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof LivingEntity)
            {
                boss.onDamage(e, (LivingEntity) ((Arrow) e.getDamager()).getShooter(), true);
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
