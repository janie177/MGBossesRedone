package com.minegusta.mgbossesredone.api.drops.tables.special;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class WargLoot extends Table {
	@Override
	public MGItem[] getItems() {
		return new MGItem[]{
				new MGItem(ChatColor.RED + "Man Beef", 15, 0, Material.RAW_BEEF, null, ChatColor.DARK_RED + "Man Food."),
				new MGItem(ChatColor.GRAY + "Wolf Egg", 1, 95, Material.MONSTER_EGG, null, ChatColor.GREEN + "Use to summon a wolf."),
				new MGItem(ChatColor.DARK_GRAY + "Wolf Bone", 1, 0, Material.BONE, null, ChatColor.GRAY + "This bone seems drawn to the moon...")
		};
	}

	@Override
	public int getPromillage() {
		return 80;
	}
}
