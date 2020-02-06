package me.iverins.commands;

import me.iverins.YYS;
import me.iverins.util.GetPlayerStatus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;


public class Iverban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("iban")){
            if (strings.length == 0){
                commandSender.sendMessage("§k| §eIverBan §fMake by Iverins! v1.0");
                commandSender.sendMessage("§k| §e/iban help §f- §7See IverBan's help.");
                return true;
            }
            if (strings.length == 1){
                if (strings[0].equalsIgnoreCase("help")){
                    commandSender.sendMessage("§8----------------------------------------");
                    commandSender.sendMessage("§8§k| §e/iban help §f- §7See IverBan's help.");
                    commandSender.sendMessage("§8§k| §e/iban add [Name] §f- §7Ban a player.");
                    commandSender.sendMessage("§8§k| §e/iban list §f- §7See ban List.");
                    commandSender.sendMessage("§8§k| §e/iban unban [Name] §f- §7Unban a player.");
                    commandSender.sendMessage("§8----------------------------------------");
                    return true;
                }
                if (strings[0].equalsIgnoreCase("list")){
                    commandSender.sendMessage("§7已 封 禁 玩 家 列 表:");
                    commandSender.sendMessage("§f    罪 人 名 单");
                    for (String x : YYS.getPlugin().getBanlist().getKeys(false)){
                        commandSender.sendMessage("§c" + x + "\n");
                    }
                    return true;
                }
            }
            if (strings.length == 2 && strings[0].equalsIgnoreCase("add")){
                if (!GetPlayerStatus.isBanned(strings[1])){
                    Player target = Bukkit.getPlayer(strings[1]);
                    for (String x : YYS.getPlugin().getPermission().getKeys(false)){
                        ConfigurationSection all = YYS.getPlugin().getPermission().getConfigurationSection(x);
                        if (commandSender.hasPermission(all.getString("fPer"))){
                            if (target.hasPermission(all.getString("sPer"))){
                                commandSender.sendMessage("§a成功封禁§f" + strings[1] + "§a!");
                                return true;
                            }
                            commandSender.sendMessage("§c你没有权限喔.");
                            return true;
                        }
                    }
                    return true;
                } else {
                    commandSender.sendMessage("§c该玩家已被封禁了诶.");
                    return true;
                }
            }
            if (strings.length == 2 && strings[0].equalsIgnoreCase("unban")){
                if (commandSender.hasPermission(GetPlayerStatus.getPlayerPer(strings[1]))){
                    YYS.getPlugin().getBanlist().set(strings[1],null);
                    commandSender.sendMessage("§a玩家已被解封.");
                    return true;
                }
                commandSender.sendMessage("§c玩家未被封禁喔.");
                return true;
            }
        }
        return false;
    }
}
