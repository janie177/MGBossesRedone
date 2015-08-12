package com.minegusta.mgbossesredone.api.drops;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MGItem{

    public ItemStack itemStack;

    public MGItem(String name, int amount, int data, Material material, MGEnchantment[] enchantments , String... lore)
    {
        itemStack = new ItemStack(material, amount, (short) data)
        {
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName(name);
                meta.setLore(Arrays.asList(lore));
                setItemMeta(meta);

                if(enchantments != null)
                {
                    for(MGEnchantment ench : enchantments)
                    {
                        addUnsafeEnchantment(ench.getEnchantment(), ench.getLevel());
                    }
                }
            }
        };
    }

    public ItemStack getItemStack()
    {
        return itemStack;
    }
}
