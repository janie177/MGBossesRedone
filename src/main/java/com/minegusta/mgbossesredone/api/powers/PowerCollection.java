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
    private List<Power> specials = Lists.newArrayList();

    public PowerCollection(List<Power> actives, List<Power> passives, List<Power> specials)
    {
        this.actives = actives;
        this.passives = passives;
        this.specials = specials;
    }

    public PowerCollection()
    {

    }

    public List<Power> getActives()
    {
        return actives;
    }

    public List<Power> getSpecials()
    {
        return specials;
    }

    public Optional<Power> getRandomPower(IPower.PowerType type)
    {
        if(type == IPower.PowerType.SPECIAL && !specials.isEmpty())
        {
            return Optional.of(specials.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(specials.size())));
        }
        if(type == IPower.PowerType.ACTIVE && !actives.isEmpty())
        {
            return Optional.of(actives.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(actives.size())));
        }
        else if(type == IPower.PowerType.PASSIVE && !passives.isEmpty())
        {
            return Optional.of(passives.get(RandomUtil.randomNumberZeroIncludedMaxExcluded(passives.size())));
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
        else if(type == IPower.PowerType.SPECIAL)
        {
            specials.add(power);
        }
    }

    public void clearPowers()
    {
        actives.clear();
        passives.clear();
        specials.clear();
    }

    public List<Power> getPassives()
    {
        return passives;
    }
}
