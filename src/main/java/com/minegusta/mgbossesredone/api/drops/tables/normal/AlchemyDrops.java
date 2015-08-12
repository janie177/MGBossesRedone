package com.minegusta.mgbossesredone.api.drops.tables.normal;

import com.minegusta.mgbossesredone.api.drops.MGItem;
import com.minegusta.mgbossesredone.api.drops.Table;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class AlchemyDrops extends Table {

    private static final MGItem[] items = new MGItem[]{
            new MGItem(ChatColor.YELLOW + "Tear", 2, 0, Material.GHAST_TEAR, null, "cri cri"),
            new MGItem(ChatColor.YELLOW + "Fancy Melon", 2, 0, Material.SPECKLED_MELON, null, "All gold and stuff"),
            new MGItem(ChatColor.YELLOW + "Spider Eye", 2, 0, Material.SPIDER_EYE, null, "Atleast it's not fermented."),
            new MGItem(ChatColor.YELLOW + "Fermented Spider Eye", 2, 0, Material.FERMENTED_SPIDER_EYE, null, "Atleast it's n- nvm."),
            new MGItem(ChatColor.YELLOW + "Sugar", 2, 0, Material.SUGAR, null, "Sweet!"),
            new MGItem(ChatColor.YELLOW + "Pufferfish", 1, 3, Material.RAW_FISH, null, "Wont be handing out boat licenses anymore."),
            new MGItem(ChatColor.YELLOW + "Blaze Rod", 2, 0, Material.BLAZE_ROD, null, "Hot."),
            new MGItem(ChatColor.YELLOW + "Blaze Powder", 2, 0, Material.BLAZE_POWDER, null, "Powdered."),
            new MGItem(ChatColor.YELLOW + "Slime Ball", 2, 0, Material.SLIME_BALL, null, "It's a ball of slime."),
            new MGItem(ChatColor.YELLOW + "Sulphur", 5, 0, Material.SULPHUR, null, "Explosive."),
            new MGItem(ChatColor.YELLOW + "Sulphur", 2, 0, Material.SULPHUR, null, "Explosive."),
            new MGItem(ChatColor.YELLOW + "Glowstone Dust", 15, 0, Material.GLOWSTONE_DUST, null, "Glowy!"),
            new MGItem(ChatColor.YELLOW + "Redstone", 15, 0, Material.REDSTONE, null, "Electrifying.")
    };

    @Override
    public MGItem[] getItems() {
        return items;
    }
}
