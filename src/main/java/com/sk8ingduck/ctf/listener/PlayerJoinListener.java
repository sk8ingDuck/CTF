package com.sk8ingduck.ctf.listener;

import com.sk8ingduck.ctf.CTF;
import com.sk8ingduck.ctf.game.GameSession;
import com.sk8ingduck.ctf.scheduler.LobbyCountdown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private GameSession game = CTF.getInstance().getGame();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(Bukkit.getOnlinePlayers().size() > 3) {
            if(game.getCurrentCountdown() == null || !game.getCurrentCountdown().isRunning()) {
                game.setCurrentCountdown(new LobbyCountdown(10));
                game.getCurrentCountdown().start();
            }
        }
    }
}
