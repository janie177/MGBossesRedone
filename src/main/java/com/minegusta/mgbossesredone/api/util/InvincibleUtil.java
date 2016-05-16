package com.minegusta.mgbossesredone.api.util;

import com.google.common.collect.Maps;
import org.bukkit.entity.LivingEntity;

import java.util.concurrent.ConcurrentMap;

public class InvincibleUtil {

	private static ConcurrentMap<String, Long> invincibles = Maps.newConcurrentMap();

	public static void setInvincible(LivingEntity ent, long duration)
	{
		invincibles.put(ent.getUniqueId().toString(), System.currentTimeMillis() + (duration * 1000));
	}

	public static boolean isInvincible(LivingEntity ent)
	{
		return invincibles.containsKey(ent.getUniqueId().toString()) && invincibles.get(ent.getUniqueId().toString()) > System.currentTimeMillis();
	}
}
