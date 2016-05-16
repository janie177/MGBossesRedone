package com.minegusta.mgbossesredone.api.powers;

import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth.EarthMinions;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth.Entomb;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth.PoisonPool;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.earth.Quake;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire.FieryExplosion;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire.FireStorm;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.fire.BlazeStorm;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice.Freeze;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice.IceMinions;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.ice.TidalWave;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.azmodan.lastphase.*;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.hydra.Duplicate;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.hydra.ZombieTornado;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw.JWTaunt;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw.Oink;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.jw.ShootArrow;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor.ArrowRain;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor.ArrowSpray;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor.ExplodingBats;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.skeletor.Taunt;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking.ExplodingPigmen;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking.Jump;
import com.minegusta.mgbossesredone.api.powers.powers.bossspecific.zombieking.ZombieKingMinions;
import com.minegusta.mgbossesredone.api.powers.powers.passives.Pull;

public enum Power {

    ARROWRAIN(new ArrowRain()),
    PULL(new Pull()),
    EARTHMINIONS(new EarthMinions()),
    ENTOMB(new Entomb()),
    POISONPOOL(new PoisonPool()),
    QUAKE(new Quake()),
    FIERYEXPLOSION(new FieryExplosion()),
    FIRESTORM(new FireStorm()),
    SPEWLAVA(new BlazeStorm()),
    FREEZE(new Freeze()),
    ICEMINIONS(new IceMinions()),
    TIDALWAVE(new TidalWave()),
    EXPLOSIONCIRCLE(new ExplosionCircle()),
    NUKE(new Nuke()),
    REMOVEARMOUR(new RemoveArmour()),
    AZMODANMINIONS(new AzmodanMinions()),
    WEAKEN(new Weaken()),
    DUPLICATE(new Duplicate()),
    ZOMBIETORNADO(new ZombieTornado()),
    JWTAUNT(new JWTaunt()),
    OINK(new Oink()),
    SHOOTARROW(new ShootArrow()),
    ARROWSPRAY(new ArrowSpray()),
    EXPLODINGBATS(new ExplodingBats()),
    EXPLODINGPIGMEN(new ExplodingPigmen()),
    JUMP(new Jump()),
    ZOMBIEKINGMINIONS(new ZombieKingMinions()),
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
