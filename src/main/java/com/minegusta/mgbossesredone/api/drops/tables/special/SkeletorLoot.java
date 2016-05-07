package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGEnchantment;
import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class SkeletorLoot extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.DARK_PURPLE + "Skeletor's Bow", 1, 0, Material.BOW, new MGEnchantment[]{new MGEnchantment(Enchantment.ARROW_DAMAGE, 3), new MGEnchantment(Enchantment.ARROW_INFINITE, 1), new MGEnchantment(Enchantment.ARROW_KNOCKBACK, 1)}, ChatColor.LIGHT_PURPLE + "The evil bow, obtained from Skeletor."),
            new MGItem(ChatColor.DARK_PURPLE + "Dark Menace", 1, 0, Material.IRON_SWORD, new MGEnchantment[]{new MGEnchantment(Enchantment.DAMAGE_UNDEAD, 6)}, ChatColor.LIGHT_PURPLE + "Darkness' weakness. Obtained from skeletor."),
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }

    @Override
    public int getPromillage() {
        return 70;
    }
}
