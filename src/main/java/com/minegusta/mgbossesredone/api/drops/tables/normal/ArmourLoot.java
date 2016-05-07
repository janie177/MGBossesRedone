package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class ArmourLoot extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.IRON_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.IRON_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.IRON_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.IRON_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.CHAINMAIL_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.CHAINMAIL_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.CHAINMAIL_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.CHAINMAIL_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.GOLD_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.GOLD_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.GOLD_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.GOLD_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.IRON_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.IRON_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.IRON_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.IRON_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.CHAINMAIL_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.CHAINMAIL_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.CHAINMAIL_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.CHAINMAIL_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.GOLD_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.GOLD_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.GOLD_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.GOLD_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.CHAINMAIL_BOOTS, null, "These will keep your feet warm."),
            new MGItem(ChatColor.YELLOW + "Helm", 1, 0, Material.DIAMOND_HELMET, null, "Every day is hat day."),
            new MGItem(ChatColor.YELLOW + "ChestPlate", 1, 0, Material.DIAMOND_CHESTPLATE, null, "For extra support."),
            new MGItem(ChatColor.YELLOW + "Legs", 1, 0, Material.DIAMOND_LEGGINGS, null, "Good for keeping legs in."),
            new MGItem(ChatColor.YELLOW + "Boots", 1, 0, Material.DIAMOND_BOOTS, null, "These will keep your feet warm."),
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
