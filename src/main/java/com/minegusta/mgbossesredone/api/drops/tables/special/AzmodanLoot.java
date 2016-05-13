package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGEnchantment;
import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class AzmodanLoot extends Table {

	private static final MGItem[] items = new MGItem[]{
			new MGItem(ChatColor.DARK_PURPLE + "Azmodan's Chestplate", 1, 0, Material.DIAMOND_CHESTPLATE, new MGEnchantment[]{new MGEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4), new MGEnchantment(Enchantment.DURABILITY, 3), new MGEnchantment(Enchantment.MENDING, 1)}, ChatColor.RED + "A chestplate obtained from Azmodan."),
			new MGItem(ChatColor.DARK_PURPLE + "Azmodan's Leggings", 1, 0, Material.DIAMOND_LEGGINGS, new MGEnchantment[]{new MGEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4), new MGEnchantment(Enchantment.DURABILITY, 3), new MGEnchantment(Enchantment.MENDING, 1)}, ChatColor.RED + "Leggings obtained from Azmodan."),
			new MGItem(ChatColor.DARK_PURPLE + "Azmodan's Boots", 1, 0, Material.DIAMOND_BOOTS, new MGEnchantment[]{new MGEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4), new MGEnchantment(Enchantment.DURABILITY, 3), new MGEnchantment(Enchantment.MENDING, 1)}, ChatColor.RED + "Boots obtained from Azmodan."),
			new MGItem(ChatColor.DARK_PURPLE + "Azmodan's Helmet", 1, 0, Material.DIAMOND_HELMET, new MGEnchantment[]{new MGEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4), new MGEnchantment(Enchantment.DURABILITY, 3), new MGEnchantment(Enchantment.MENDING, 1)}, ChatColor.RED + "A helmet obtained from Azmodan."),
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