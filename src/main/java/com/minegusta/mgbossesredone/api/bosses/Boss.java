package com.minegusta.mgbossesredone.api.bosses;

import com.minegusta.mgbossesredone.api.bosses.bosses.Skeletor;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;

import java.util.Optional;

public enum Boss {

    SKELETOR(Skeletor.class);

    private Class<? extends AbstractBoss> boss;

    private Boss(Class<? extends AbstractBoss> boss)
    {
        this.boss = boss;
    }

    public synchronized boolean spawnBoss(SpawnLocation l)
    {
        try {
            return boss.newInstance().spawn(l);
        } catch (Exception oopsiefloopsie){
            oopsiefloopsie.printStackTrace();
        }
        return false;
    }

    public Optional<String> getName()
    {
        try
        {
            return Optional.of(boss.newInstance().getName());
        } catch (Exception ignored)
        {

        }
        return Optional.empty();
    }
}
