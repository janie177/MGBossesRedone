package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class Junk extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.GRAY + "CobbleStone", 4, 0, Material.COBBLESTONE, null, ":("),
            new MGItem(ChatColor.GRAY + "Stick", 4, 0, Material.STICK, null, "Stick with it."),
            new MGItem(ChatColor.GRAY + "Grass", 4, 0, Material.GRASS, null, "Grassy."),
            new MGItem(ChatColor.GRAY + "Dirt", 4, 0, Material.DIRT, null, "Dirty."),
            new MGItem(ChatColor.GRAY + "Mycelium", 4, 0, Material.MYCEL, null, "Moo."),
            new MGItem(ChatColor.GRAY + "Ice", 4, 0, Material.ICE, null, "Icy."),
            new MGItem(ChatColor.GRAY + "Egg", 4, 0, Material.EGG, null, "Eggy."),
            new MGItem(ChatColor.GRAY + "Bread", 4, 0, Material.BREAD, null, "Bready."),
            new MGItem(ChatColor.GRAY + "Melon Seeds", 4, 0, Material.MELON_SEEDS, null, "Seedy."),
            new MGItem(ChatColor.GRAY + "Seeds", 4, 0, Material.SEEDS, null, "Seedy."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }

    @Override
    public int getPromillage() {
        return 650;
    }
}
