package com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ArrowRain implements IPower {
    @Override
    public PowerType getType() {
        return PowerType.ACTIVE;
    }

    @Override
    public String getName() {
        return "Arrow Rain";
    }

    @Override
    public void run(LivingEntity boss, List<LivingEntity> target) {

        final World world = boss.getWorld();
        for(LivingEntity ent : target)
        {
            for (int i = 0; i < 20 * 8; i++)
            {
                if(i % 5 == 0)
                {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {

                        @Override
                        public void run() {
                            if(ent.isValid()) world.spawnEntity(ent.getLocation().clone().add(0, 12, 0), EntityType.ARROW);

                        }

                    }, i);
                }
            }
        }
    }
}
