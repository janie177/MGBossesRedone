package com.minegusta.mgbossesredone.api.drops.tables;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class BuildBlockLoot extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.GRAY + "Bone", 1, 0, Material.BONE, null, "Good calcium has come to you!", "Thank mr skeletal."),
            new MGItem(ChatColor.GRAY + "Funny Bone", 1, 0, Material.BONE, null, "Hahahahaha"),
            new MGItem(ChatColor.GRAY + "Boner", 1, 0, Material.BONE, null, "What do you get if you dissolve", "this bone in water?", ChatColor.DARK_GRAY + "Hard water."),
            new MGItem(ChatColor.GRAY + "Ben", 1, 0, Material.BONE, null, "A bone named ben."),
            new MGItem(ChatColor.GRAY + "Skull", 1, 0, Material.SKULL_ITEM, null, "Spooky scary skeletins,", "send shivers down your spine.")
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }
}
