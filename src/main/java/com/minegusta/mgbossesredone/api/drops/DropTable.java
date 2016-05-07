package com.minegusta.mgbossesredone.api.drops;

import com.minegusta.mgbossesredone.api.drops.tables.normal.*;
import com.minegusta.mgbossesredone.api.drops.tables.special.SkeletorLoot;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.inventory.ItemStack;

public enum DropTable {

    ALCHEMY(new AlchemyDrops()),
    GOOD(new GoodDrops()),
    MEDIUM(new MediumDrops()),
    ORE(new OreDrops()),
    JUNK(new Junk()),
    SKELETOR_SPECIAL(new SkeletorLoot()),
    ARMOUR(new ArmourLoot()),
    TOOL(new ToolLoot()),
    BUILDBLOCKS(new BuildBlockLoot()),
    BONES(new Bones());

    private Table table;
    private int chance;

    DropTable(Table table)
    {
        this.table = table;
        this.chance = table.getPromillage();
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
