package com.minegusta.mgbossesredone.main;


import com.minegusta.mgbossesredone.api.bosses.Boss;
import com.minegusta.mgbossesredone.api.locations.SpawnLocation;
import com.minegusta.mgbossesredone.api.util.LocationUtil;
import com.minegusta.mgbossesredone.api.util.YamlUtil;
import com.minegusta.mgbossesredone.registry.LocationRegistry;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {


    public static void loadLocationsConfig()
    {
        for(String key : YamlUtil.getConfiguration("/locations/", "locations.yml").getKeys(false))
        {
            ConfigurationSection section = getLocationsConfig().getConfigurationSection(key);
            SpawnLocation l = new SpawnLocation(key, LocationUtil.toLocation(section.getString("location")), Boss.valueOf(section.getString("boss").toUpperCase()), null);
            LocationRegistry.add(key, l);
        }
    }

    public static FileConfiguration getLocationsConfig()
    {
        return YamlUtil.getConfiguration("/locations/", "locations.yml");
    }

    public static void saveLocationsConfig(FileConfiguration conf)
    {
        YamlUtil.saveFile("/locations/", "locations.yml", conf);
    }
}
