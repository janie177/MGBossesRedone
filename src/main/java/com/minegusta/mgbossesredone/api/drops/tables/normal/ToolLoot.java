package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class ToolLoot extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.YELLOW + "Pickaxe", 1, 0, Material.DIAMOND_PICKAXE, null, "A pickaxe."),
            new MGItem(ChatColor.YELLOW + "Hoe", 1, 0, Material.DIAMOND_HOE, null, "A hoe."),
            new MGItem(ChatColor.YELLOW + "Axe", 1, 0, Material.DIAMOND_AXE, null, "An axe."),
            new MGItem(ChatColor.YELLOW + "Spade", 1, 0, Material.DIAMOND_SPADE, null, "A shovel."),
            new MGItem(ChatColor.YELLOW + "Sword", 1, 0, Material.DIAMOND_SWORD, null, "A sword."),
            new MGItem(ChatColor.YELLOW + "Pickaxe", 1, 0, Material.DIAMOND_PICKAXE, null, "A pickaxe."),
            new MGItem(ChatColor.YELLOW + "Hoe", 1, 0, Material.DIAMOND_HOE, null, "A hoe."),
            new MGItem(ChatColor.YELLOW + "Axe", 1, 0, Material.DIAMOND_AXE, null, "An axe."),
            new MGItem(ChatColor.YELLOW + "Spade", 1, 0, Material.DIAMOND_SPADE, null, "A shovel."),
            new MGItem(ChatColor.YELLOW + "Sword", 1, 0, Material.GOLD_SWORD, null, "A sword."),
            new MGItem(ChatColor.YELLOW + "Pickaxe", 1, 0, Material.IRON_PICKAXE, null, "A pickaxe."),
            new MGItem(ChatColor.YELLOW + "Hoe", 1, 0, Material.DIAMOND_HOE, null, "A hoe."),
            new MGItem(ChatColor.YELLOW + "Axe", 1, 0, Material.DIAMOND_AXE, null, "An axe."),
            new MGItem(ChatColor.YELLOW + "Spade", 1, 0, Material.DIAMOND_SPADE, null, "A shovel."),
            new MGItem(ChatColor.YELLOW + "Sword", 1, 0, Material.DIAMOND_SWORD, null, "A sword."),
            new MGItem(ChatColor.YELLOW + "Pickaxe", 1, 0, Material.IRON_PICKAXE, null, "A pickaxe."),
            new MGItem(ChatColor.YELLOW + "Hoe", 1, 0, Material.IRON_HOE, null, "A hoe."),
            new MGItem(ChatColor.YELLOW + "Axe", 1, 0, Material.IRON_AXE, null, "An axe."),
            new MGItem(ChatColor.YELLOW + "Spade", 1, 0, Material.IRON_SPADE, null, "A shovel."),
            new MGItem(ChatColor.YELLOW + "Sword", 1, 0, Material.IRON_SWORD, null, "A sword."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }
}