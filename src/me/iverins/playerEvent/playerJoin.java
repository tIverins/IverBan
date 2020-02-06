package me.iverins.playerEvent;

import me.iverins.util.GetPlayerStatus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerLoginEvent e){
        if (GetPlayerStatus.isBanned(e.getPlayer().getName())){
            e.setResult(PlayerLoginEvent.Result.KICK_BANNED);
            e.setKickMessage("§a你已被封禁!");
        }
    }
}
