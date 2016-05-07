package com.minegusta.mgbossesredone.api.drops;

import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.inventory.ItemStack;

public abstract class Table
{
    public abstract MGItem[] getItems();

    public abstract int getPromillage();

    public ItemStack getRandomItem()
    {
        int get = RandomUtil.randomNumberZeroIncludedMaxExcluded(getItems().length);
        return getItems()[get].getItemStack();
    }
}
