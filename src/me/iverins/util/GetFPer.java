package me.iverins.util;

import me.iverins.YYS;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;

public class GetFPer {
    static ConfigurationSection section;
    public static String getFper(String name){
        for (String x : YYS.getPlugin().getPermission().getKeys(false)){
            section = YYS.getPlugin().getPermission().getConfigurationSection(x);
            if (section.getString("sPer").equals(name)){
                return section.getString("fPer");
            }
        }
        return null;
    }
}
