package com.minegusta.mgbossesredone.listeners;

import com.minegusta.mgbossesredone.api.util.ExplosionUtil;
import com.minegusta.mgbossesredone.api.util.InvincibleUtil;
import com.minegusta.mgbossesredone.api.util.NukeArrowShooter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class PowerListener implements Listener {

	@EventHandler
	public void onNukeArrow(ProjectileHitEvent e)
	{
		if(e.getEntity().getShooter() instanceof NukeArrowShooter)
		{
			//Create a nuke on location
			ExplosionUtil.nukeLocation(e.getEntity().getLocation());
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e)
	{
		if(e.getEntity() instanceof LivingEntity && InvincibleUtil.isInvincible((LivingEntity) e.getEntity()))
		{
			e.setCancelled(true);
		}
	}
}
