package com.minegusta.mgbossesredone.api.drops;

import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.inventory.ItemStack;

public abstract class Table
{
    public abstract MGItem[] getItems();

    public ItemStack getRandomItem()
    {
        int get = RandomUtil.randomNumber(getItems().length - 1);
        return getItems()[get].getItemStack();
    }
}
