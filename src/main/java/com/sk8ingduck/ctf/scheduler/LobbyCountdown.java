package com.sk8ingduck.ctf.scheduler;

import com.sk8ingduck.ctf.CTF;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LobbyCountdown extends Countdown {


    public LobbyCountdown(int seconds) {
        super(seconds);
    }

    @Override
    public void run() {
        int counter = getCountdown().decrementAndGet();

        if (counter > 0) {
            Bukkit.getOnlinePlayers().forEach((Player p) -> p.setLevel(counter));
            if(counter % 5 == 0 || counter <= 3){
                Bukkit.broadcastMessage("§7> §eDas Spiel startet in §6" + counter + " Sekunden");
            }
        } else {
            CTF.getInstance().getGame().nextGameState();
            stop();
        }
    }
}