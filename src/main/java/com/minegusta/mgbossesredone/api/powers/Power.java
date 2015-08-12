package com.minegusta.mgbossesredone.api.powers;

import com.minegusta.mgbossesredone.api.powers.powers.Taunt;

public enum Power {

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
