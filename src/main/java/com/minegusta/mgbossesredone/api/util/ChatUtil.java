package com.minegusta.mgbossesredone.api.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.LivingEntity;

public class ChatUtil {

    public static void sendBossMessage(String bossName, LivingEntity target, String message)
    {
        target.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.GOLD + bossName + ChatColor.DARK_RED + "] " + ChatColor.YELLOW + message);
    }
}
