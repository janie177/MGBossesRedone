package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class MediumDrops extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.GRAY + "Iron Ingot", 3, 0, Material.IRON_INGOT, null, "An ingot."),
            new MGItem(ChatColor.GRAY + "Gold Ingot", 3, 0, Material.GOLD_INGOT, null, "An ingot."),
            new MGItem(ChatColor.GRAY + "Emerald", 1, 0, Material.EMERALD, null, "An Emerald."),
            new MGItem(ChatColor.GRAY + "Wool", 10, 0, Material.WOOL, null, "Fluffy."),
            new MGItem(ChatColor.GRAY + "Iron Ingot", 3, 0, Material.IRON_INGOT, null, "An ingot."),

    };

    @Override
    public MGItem[] getItems() {
        return items;
    }

    @Override
    public int getPromillage() {
        return 150;
    }
}
