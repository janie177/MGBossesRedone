package com.minegusta.mgbossesredone.api.powers.powers;

import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.util.ChatUtil;
import com.minegusta.mgbossesredone.api.util.RandomUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class Taunt implements IPower {
    @Override
    public PowerType getType() {
        return PowerType.ACTIVE;
    }

    @Override
    public String getName() {
        return "Taunt";
    }

    @Override
    public void run(Entity boss, List<LivingEntity> target) {

        target.stream().forEach(t -> ChatUtil.sendBossMessage(boss.getName(), t, taunts[RandomUtil.randomNumberZeroIncludedMaxExcluded(taunts.length)]));
    }

    private static final String[] taunts = new String[]{"You suck!", "My grandmother hits harder than that!", "Lol you are just as bad as Kennon.", "Why even bother?", "Are you even trying?", "I used to be an adventurer like you...", "Kappa Kappa Kappa", "(? ?� ??? ?�)?"};
}
