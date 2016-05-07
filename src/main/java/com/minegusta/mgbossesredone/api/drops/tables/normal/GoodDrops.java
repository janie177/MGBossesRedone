package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class GoodDrops extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.YELLOW + "Diamond", 2, 0, Material.DIAMOND, null, "Shiny gem!"),
            new MGItem(ChatColor.YELLOW + "Emerald", 2, 0, Material.EMERALD, null, "Shiny green gem!"),
            new MGItem(ChatColor.YELLOW + "Iron", 6, 0, Material.IRON_INGOT, null, "Oh the irony."),
            new MGItem(ChatColor.YELLOW + "Diamond", 1, 0, Material.DIAMOND, null, "Shiny gem!"),
            new MGItem(ChatColor.YELLOW + "Emerald", 1, 0, Material.EMERALD, null, "Shiny green gem!"),
            new MGItem(ChatColor.YELLOW + "Iron", 3, 0, Material.IRON_INGOT, null, "Oh the irony."),
            new MGItem(ChatColor.YELLOW + "Ender Chest", 1, 0, Material.ENDER_CHEST, null, "Ender Chest"),
            new MGItem(ChatColor.YELLOW + "Beacon", 1, 0, Material.BEACON, null, "Signalish."),
            new MGItem(ChatColor.YELLOW + "Enchantment Table", 1, 0, Material.ENCHANTMENT_TABLE, null, "Tably!"),
            new MGItem(ChatColor.YELLOW + "Anvil", 1, 0, Material.ANVIL, null, "Good for throwing at cartoon characters."),
            new MGItem(ChatColor.YELLOW + "Cauldron", 1, 0, Material.CAULDRON_ITEM, null, "Wart on nose not included."),
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
