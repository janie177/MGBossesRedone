package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class OreDrops extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.RED + "Diamond ore", 1, 0, Material.DIAMOND_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Emerald ore", 1, 0, Material.EMERALD_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Iron ore", 3, 0, Material.IRON_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Gold ore", 2, 0, Material.GOLD_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Lapis ore", 3, 0, Material.LAPIS_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Quartz ore", 5, 0, Material.QUARTZ_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Coal ore", 5, 0, Material.COAL_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Iron ore", 3, 0, Material.IRON_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Redstone ore", 2, 0, Material.REDSTONE_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Lapis ore", 3, 0, Material.LAPIS_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Quartz ore", 5, 0, Material.QUARTZ_ORE, null, "Ore, fresh from the ground."),
            new MGItem(ChatColor.RED + "Coal ore", 5, 0, Material.COAL_ORE, null, "Ore, fresh from the ground."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }

    @Override
    public int getPromillage() {
        return 100;
    }
}
