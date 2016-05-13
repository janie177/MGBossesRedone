package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGEnchantment;
import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class JWLoot extends Table {

	private static final MGItem[] items = new MGItem[]{
			new MGItem(ChatColor.DARK_PURPLE + "Dragon Lore", 1, 0, Material.BOW, new MGEnchantment[]{new MGEnchantment(Enchantment.ARROW_DAMAGE, 4), new MGEnchantment(Enchantment.ARROW_KNOCKBACK, 2)}, ChatColor.LIGHT_PURPLE + "JW's Weapon."),
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