package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGEnchantment;
import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class HydraLoot extends Table {

	private static final MGItem[] items = new MGItem[]{
			new MGItem(ChatColor.DARK_PURPLE + "Undead Scythe", 1, 0, Material.DIAMOND_HOE, new MGEnchantment[]{new MGEnchantment(Enchantment.KNOCKBACK, 4), new MGEnchantment(Enchantment.DAMAGE_ALL, 2), new MGEnchantment(Enchantment.MENDING, 1)}, ChatColor.LIGHT_PURPLE + "The scythe of the dead."),
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