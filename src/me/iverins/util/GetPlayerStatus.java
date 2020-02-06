package me.iverins.util;

import me.iverins.YYS;
import org.bukkit.configuration.file.YamlConfiguration;

public class GetPlayerStatus {
    static YamlConfiguration banlist;
    public static boolean isBanned(String name){
        banlist = YamlConfiguration.loadConfiguration(YYS.getPlugin().getBan());
        for (String x : banlist.getKeys(false)){
            if (name.equalsIgnoreCase(x)){
                return true;
            }
        }
        return false;
    }
    public static String getPlayerPer(String player){
        if (isBanned(player)){
            YamlConfiguration save = YYS.getPlugin().getBanlist();
            for (String x : save.getKeys(false)){
                if (player.equalsIgnoreCase(x)){
                    return save.getString(x);
                }
            }
        }
        return "noPer";
    }
}
