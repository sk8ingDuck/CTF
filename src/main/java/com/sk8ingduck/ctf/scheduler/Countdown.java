package com.sk8ingduck.ctf.scheduler;

import com.sk8ingduck.ctf.CTF;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.atomic.AtomicInteger;

public class Countdown implements Runnable {

    @Getter
    private boolean isRunning;

    @Getter
    private final AtomicInteger countdown;

    private BukkitTask bukkitTask;

    public Countdown(int seconds) {
        countdown = new AtomicInteger(seconds + 1);
    }

    @Override
    public void run() { }

    public void start() {
        bukkitTask = Bukkit.getScheduler().runTaskTimer(CTF.getInstance(), this, 0, 20);
        isRunning = true;
    }

    public void stop() {
        bukkitTask.cancel();
        isRunning = false;
    }
}