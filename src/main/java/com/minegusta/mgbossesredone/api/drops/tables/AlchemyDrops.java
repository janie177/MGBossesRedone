package com.minegusta.mgbossesredone.api.drops.tables;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class AlchemyDrops extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.GRAY + "Bone", 1, 0, Material.BONE, null, "Good calcium has come to you!", "Thank mr skeletal."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }
}
