package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GhastinatorLoot extends Table {
	@Override
	public MGItem[] getItems() {
		return new MGItem[]{new MGItem(ChatColor.RED + "Fire Charge", 5, 0, Material.FIREWORK_CHARGE, null, ChatColor.DARK_PURPLE + "Charged up."), new MGItem(ChatColor.WHITE + "Ghastinator Tear", 5, 0, Material.GHAST_TEAR, null, "Don't you cry no more...")};
	}

	@Override
	public int getPromillage() {
		return 400;
	}
}
