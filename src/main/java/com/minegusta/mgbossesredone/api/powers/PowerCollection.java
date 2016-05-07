package com.minegusta.mgbossesredone.api.powers;

import com.google.common.collect.Lists;
import com.minegusta.mgbossesredone.api.powers.IPower;
import com.minegusta.mgbossesredone.api.powers.Power;
import com.minegusta.mgbossesredone.api.util.RandomUtil;

import java.util.List;
import java.util.Optional;

public class PowerCollection {

    private List<Power> actives = Lists.newArrayList();
    private List<Power> passives = Lists.newArrayList();

    public PowerCollection(List<Power> actives, List<Power> passives)
    {
        this.actives = actives;
        this.passives = passives;
    }

    public PowerCollection()
    {

    }

    public List<Power> getActives()
    {
        return actives;
    }

    public Optional<Power> getRandomPower(IPower.PowerType type)
    {
        if(type == IPower.PowerType.ACTIVE && !actives.isEmpty())
        {
            return Optional.of(actives.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(actives.size())));
        }
        else if(type == IPower.PowerType.PASSIVE && !passives.isEmpty())
        {
            return Optional.of(actives.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(passives.size())));
        }
        return Optional.empty();
    }

    public Optional<Power> getRandomPower()
    {
        if(RandomUtil.fiftyfifty() && !actives.isEmpty()) return Optional.of(actives.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(actives.size())));
        else if(!passives.isEmpty()) return Optional.of(passives.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(passives.size())));
        return Optional.empty();
    }

    public void removePower(Power power, IPower.PowerType type)
    {
        if(type == IPower.PowerType.ACTIVE)
        {
            if(actives.contains(power))
            {
                actives.remove(power);
            }
        }
        else if(type == IPower.PowerType.PASSIVE)
        {
            if(passives.contains(power))
            {
                passives.remove(power);
            }
        }
    }

    public void addPower(Power power, IPower.PowerType type)
    {
        if(type == IPower.PowerType.ACTIVE)
        {
            actives.add(power);
        }
        else if (type == IPower.PowerType.PASSIVE)
        {
            passives.add(power);
        }
    }

    public List<Power> getPassives()
    {
        return passives;
    }
}
