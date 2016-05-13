package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGEnchantment;
import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class ZombieKingLoot extends Table {

	private static final MGItem[] items = new MGItem[]{
			new MGItem(ChatColor.DARK_PURPLE + "Zombie King's Axe", 1, 0, Material.DIAMOND_AXE, new MGEnchantment[]{new MGEnchantment(Enchantment.DAMAGE_ALL, 3), new MGEnchantment(Enchantment.DAMAGE_ARTHROPODS, 3), new MGEnchantment(Enchantment.DAMAGE_UNDEAD, 3), new MGEnchantment(Enchantment.DIG_SPEED, 1), new MGEnchantment(Enchantment.DURABILITY, 2)}, ChatColor.LIGHT_PURPLE + "The great axe of the zombie king."),
			new MGItem(ChatColor.DARK_PURPLE + "Zombie's Bane", 1, 0, Material.IRON_SWORD, new MGEnchantment[]{new MGEnchantment(Enchantment.DAMAGE_UNDEAD, 8)}, ChatColor.LIGHT_PURPLE + "The bane of all zombies."),
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