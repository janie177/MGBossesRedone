package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class MausBausLoot extends Table{
	@Override
	public MGItem[] getItems() {
		return new MGItem[]{
				new MGItem(ChatColor.YELLOW + "Cheese", 2, 0, Material.SPONGE, null, ChatColor.GOLD + "Tastes very gouda!"),
				new MGItem(ChatColor.YELLOW + "Maus Cookie", 5, 0, Material.COOKIE, null, ChatColor.LIGHT_PURPLE + "With extra 'Chocolate' ;)")
		};
	}

	@Override
	public int getPromillage() {
		return 250;
	}
}
