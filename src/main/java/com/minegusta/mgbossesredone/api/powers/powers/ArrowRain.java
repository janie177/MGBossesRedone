package com.minegusta.mgbossesredone.api.powers.powers;

import com.minegusta.mgbossesredone.api.powers.IPower;
import org.bukkit.entity.Entity;
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
    public void run(Entity bosss, List<LivingEntity> target) {



    }
}
