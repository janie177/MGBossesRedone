package com.minegusta.mgbossesredone.api.drops;

import com.minegusta.mgbossesredone.api.drops.tables.Bones;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.inventory.ItemStack;

public enum DropTable {

    BONES(new Bones(), 1000);

    private Table table;
    private int chance;

    DropTable(Table table, int chance)
    {
        this.table = table;
        this.chance = chance;
    }

    public boolean rolledPositive()
    {
        return RandomUtil.promillage(chance);
    }

    public Table getTable()
    {
        return table;
    }

    public ItemStack getRandomItem()
    {
        return table.getRandomItem();
    }

}
