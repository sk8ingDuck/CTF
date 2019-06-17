package com.sk8ingduck.ctf;

import com.google.common.reflect.ClassPath;
import com.sk8ingduck.ctf.region.Region;
import com.sk8ingduck.ctf.game.GameSession;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CTF extends JavaPlugin {

    @Getter
    private HashMap<String, Region> regions = new HashMap<>();

    @Getter
    private static CTF instance;

    @Getter
    private GameSession game;

    @Override
    public void onEnable() {
        instance = this;
        game = new GameSession();

        PluginManager pluginManager = Bukkit.getPluginManager();
        try {
            for (ClassPath.ClassInfo classInfo : ClassPath.from(getClassLoader()).getTopLevelClasses("com.sk8ingduck.ttt.listener")) {
                Class listener = Class.forName( classInfo.getName() );

                if (Listener.class.isAssignableFrom(listener)) {
                    pluginManager.registerEvents((Listener) listener.newInstance(), this);
                }
            }
        } catch ( IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e ) {
            e.printStackTrace();
        }



        File regions = new File("plugins/CTF", "regions.yml");
        try {
            if(!regions.exists()) {
                regions.createNewFile();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDisable() {

        File regions = new File("plugins/CTF", "regions.yml");
        FileConfiguration cfgRegions = YamlConfiguration.loadConfiguration(regions);

        for(String region : this.regions.keySet()) {
            cfgRegions.set(this.regions.get(region).getWorld().getName() + "." + region, this.regions.get(region).serialize());
        }

        try {
            cfgRegions.save(regions);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
