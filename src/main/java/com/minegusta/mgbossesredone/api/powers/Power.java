package com.minegusta.mgbossesredone.api.powers;

import com.minegusta.mgbossesredone.api.powers.powers.ArrowRain;
import com.minegusta.mgbossesredone.api.powers.powers.Taunt;

public enum Power {

    ARROWRAIN(new ArrowRain()),
    TAUNT(new Taunt());

    IPower power;

    Power(IPower power)
    {
        this.power = power;
    }

    public IPower getPower()
    {
        return power;
    }
}
