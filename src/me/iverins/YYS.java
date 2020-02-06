package me.iverins;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class YYS extends JavaPlugin{
    static YYS plugin;
    File ban;
    File per;
    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("§f查询到有yys，尝试迫害中···");
        plugin = this;
        ban = new File(getDataFolder(),"banSave.yml");
        per = new File(getDataFolder(),"perList.yml");
        if (ban.exists()){
            getLogger().info("Find the ban list!");
        } else {
            saveResource("banSave.yml",true);
            getLogger().info("Create the ban list!");
        }
        if (per.exists()){
            getLogger().info("Find the per list!");
        } else {
            saveResource("perList.yml",true);
            getLogger().info("Create the per list!");
        }
        saveDefaultConfig();
    }
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§a迫害yys中，被yys同化，成为yys的粉丝.");
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§f不要迫害yys yys天下第一.");
    }
    /**
     * @return Plugin
     */
    public static YYS getPlugin(){
        return plugin;
    }
    public File getBan(){
        ban = new File(getDataFolder(),"banSave.yml");
        return ban;
    }
    public YamlConfiguration getBanlist(){
        YamlConfiguration list = YamlConfiguration.loadConfiguration(ban);
        return list;
    }
    public YamlConfiguration getPermission(){
        YamlConfiguration perr = YamlConfiguration.loadConfiguration(per);
        return perr;
    }
}
