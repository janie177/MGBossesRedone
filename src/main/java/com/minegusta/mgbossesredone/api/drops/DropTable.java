package com.minegusta.mgbossesredone.api.drops;

import com.minegusta.mgbossesredone.api.drops.tables.normal.*;
import com.minegusta.mgbossesredone.api.drops.tables.special.SkeletorLoot;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.inventory.ItemStack;

public enum DropTable {

    ALCHEMY(new AlchemyDrops(), 250),
    GOOD(new GoodDrops(), 100),
    MEDIUM(new MediumDrops(), 250),
    ORE(new OreDrops(), 100),
    JUNK(new Junk(), 900),
    SKELETOR_SPECIAL(new SkeletorLoot(), 80),
    ARMOUR(new ArmourLoot(), 120),
    TOOL(new ToolLoot(), 150),
    BUILDBLOCKS(new BuildBlockLoot(), 200),
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
