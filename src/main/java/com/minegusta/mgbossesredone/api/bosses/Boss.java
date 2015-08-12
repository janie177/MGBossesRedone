package com.minegusta.mgbossesredone.api.bosses;

import com.minegusta.mgbossesredone.api.bosses.bosses.Skeletor;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;

public enum Boss {

    SKELETOR(Skeletor.class);

    private Class<? extends AbstractBoss> boss;

    private Boss(Class<? extends AbstractBoss> boss)
    {
        this.boss = boss;
    }

    public AbstractBoss spawnBoss(SpawnLocation l)
    {
        try {
            return boss.newInstance().spawn(l);
        } catch (Exception oopsiefloopsie){
            oopsiefloopsie.printStackTrace();
        }
        return null;
    }

}
