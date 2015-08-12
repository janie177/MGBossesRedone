package com.minegusta.mgbossesredone.api.drops;

import org.bukkit.enchantments.Enchantment;

public class MGEnchantment {

    private int level;
    private Enchantment enchantment;

    public MGEnchantment(Enchantment enchantment, int level)
    {
        this.enchantment = enchantment;
        this.level = level;
    }

    public int getLevel()
    {
        return level;
    }

    public Enchantment getEnchantment()
    {
        return enchantment;
    }
}
