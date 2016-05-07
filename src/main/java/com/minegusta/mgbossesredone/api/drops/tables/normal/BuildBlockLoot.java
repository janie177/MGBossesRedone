package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class BuildBlockLoot extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.LOG, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.BRICK, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.STONE_SLAB2, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.SMOOTH_BRICK, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.NETHER_BRICK, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 2, Material.LOG, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 3, Material.LOG, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 1, Material.LOG, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.STONE, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.FENCE, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.SMOOTH_BRICK, null, "Useful for building with."),
            new MGItem(ChatColor.GOLD + "Building Block", 25, 0, Material.SMOOTH_BRICK, null, "Useful for building with."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }

    @Override
    public int getPromillage() {
        return 200;
    }
}
