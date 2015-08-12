package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGEnchantment;
import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class SkeletorLoot extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.DARK_PURPLE + "Skeletor's Bow", 1, 0, Material.BONE, new MGEnchantment[]{new MGEnchantment(Enchantment.ARROW_DAMAGE, 1)}, ChatColor.LIGHT_PURPLE + "The evil bow, obtained from Skeletor."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }
}
