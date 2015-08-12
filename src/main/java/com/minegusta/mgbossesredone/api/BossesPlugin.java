package com.minegusta.mgbossesredone.api;

import com.minegusta.mgbossesredone.api.bosses.AbstractBoss;
import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.registry.BossRegistry;
import org.bukkit.Location;

public class BossesPlugin {
    public static void createBoss(Boss boss, SpawnLocation l) {
        boss.spawnBoss(l);
    }

    public static void removeBoss(String uuid) {
        if (BossRegistry.isBoss(uuid)) {
            BossRegistry.getFromUuid(uuid).removeBoss();
        }
    }

    public static boolean isBoss(String uuid) {
        return BossRegistry.isBoss(uuid);
    }

    public static AbstractBoss getBossFromUuid(String uuid)
    {
        return BossRegistry.getFromUuid(uuid);
    }
}
