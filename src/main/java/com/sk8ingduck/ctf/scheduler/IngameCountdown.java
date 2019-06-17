package com.sk8ingduck.ctf.scheduler;

import com.sk8ingduck.ctf.CTF;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class IngameCountdown extends Countdown {


    public IngameCountdown(int seconds) {
        super(seconds);
    }

    @Override
    public void run() {
        int counter = getCountdown().decrementAndGet();

        if (counter > 0) {
            Bukkit.getOnlinePlayers().forEach((Player p) -> p.setLevel(counter));
        } else {
            CTF.getInstance().getGame().nextGameState();
            stop();
        }
    }
}