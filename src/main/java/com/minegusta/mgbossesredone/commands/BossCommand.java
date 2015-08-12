package com.minegusta.mgbossesredone.commands;

import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.api.util.LocationUtil;
import com.minegusta.mgbossesredone.main.ConfigManager;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class BossCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args)
    {
        if(s instanceof ConsoleCommandSender || !s.isOp()) return false;
        Player p = (Player) s;

        if(args.length < 2)
        {
            sendHelp(p);
            return true;
        }

        Location l = p.getLocation();

        FileConfiguration f = ConfigManager.getLocationsConfig();

        if(args[0].equalsIgnoreCase("remove"))
        {
            if(LocationRegistry.getKeys().contains(args[1]))
            {
                f.set(args[1], null);
                LocationRegistry.getSpawnLocation(args[1]).getBossInstance().ifPresent(boss -> boss.onDeath(false, false));
                LocationRegistry.remove(args[1]);
                ConfigManager.saveLocationsConfig(f);
                p.sendMessage(ChatColor.GREEN + "You removed a boss location!");
            }
            else
            {
                p.sendMessage(ChatColor.RED + "That spawn could not be found.");
            }
            return true;
        }

        if(args.length < 3)
        {
            sendHelp(p);
            return true;
        }

        String stringLocation = LocationUtil.toString(l);

        if(args[0].equalsIgnoreCase("add"))
        {
            if(LocationRegistry.getKeys().contains(args[1]))
            {
                p.sendMessage(ChatColor.RED + "That name is already taken!");
                return true;
            }
            String key = args[1];
            try
            {
                f.set(key + ".boss", Boss.valueOf(args[2].toUpperCase()));
                f.set(key + ".location", stringLocation);
                LocationRegistry.add(key, new SpawnLocation(key, l, Boss.valueOf(args[2].toUpperCase()), null));
                ConfigManager.saveLocationsConfig(f);
            } catch (Exception ignored){
                p.sendMessage(ChatColor.RED + "That is not a valid boss.");
                p.sendMessage(ChatColor.YELLOW + "- - - Bosses: - - -");
                for(Boss boss : Boss.values())
                {
                    p.sendMessage(ChatColor.GRAY + " - " + ChatColor.LIGHT_PURPLE + boss.name());
                }
                return true;
            }

            p.sendMessage(ChatColor.GREEN + "You added a new boss location!");
            return true;
        }

        sendHelp(p);
        return true;
    }

    private void sendHelp(Player p)
    {
        p.sendMessage(ChatColor.YELLOW + "Usage:");
        p.sendMessage(ChatColor.LIGHT_PURPLE + "/Boss add <name> <boss>");
        p.sendMessage(ChatColor.LIGHT_PURPLE + "/Boss remove <name>");
        p.sendMessage(ChatColor.DARK_RED + "- - - Boss Locations - - -");
        for(String s : LocationRegistry.getKeys())
        {
            p.sendMessage(ChatColor.GRAY + " - " + ChatColor.YELLOW + s);
        }
    }
}
