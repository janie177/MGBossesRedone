package com.minegusta.mgbossesredone.api.powers;

public enum Power {

    EXAMPLE();

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
