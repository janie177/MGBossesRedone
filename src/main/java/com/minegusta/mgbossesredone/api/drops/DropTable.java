package com.minegusta.mgbossesredone.api.drops;

import com.minegusta.mgbossesredone.api.drops.tables.normal.*;
import com.minegusta.mgbossesredone.api.drops.tables.special.*;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.inventory.ItemStack;

public enum DropTable {

    ALCHEMY(new AlchemyDrops()),
    GOOD(new GoodDrops()),
    MEDIUM(new MediumDrops()),
    ORE(new OreDrops()),
    JUNK(new Junk()),
    SKELETOR_SPECIAL(new SkeletorLoot()),
    AZMODAN_SPECIAL(new AzmodanLoot()),
    HYDRA_SPECIAL(new HydraLoot()),
    JW_SPECIAL(new JWLoot()),
    ZOMBIE_KING_SPECIAL(new ZombieKingLoot()),
    ARMOUR(new ArmourLoot()),
    TOOL(new ToolLoot()),
    MAUS_BAUS_SPECIAL(new MausBausLoot()),
    GHASTINATOR_SPECIAL(new GhastinatorLoot()),
    WARG_SPECIAL(new WargLoot()),
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
