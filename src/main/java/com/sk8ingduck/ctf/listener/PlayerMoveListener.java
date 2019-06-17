package com.sk8ingduck.ctf.listener;

import com.sk8ingduck.ctf.CTF;
import com.sk8ingduck.ctf.event.PlayerEnterRegionEvent;
import com.sk8ingduck.ctf.event.PlayerLeaveRegionEvent;
import com.sk8ingduck.ctf.region.Region;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location loc1 = event.getFrom();
        Location loc2 = event.getTo();

        for (String regionName : CTF.getInstance().getRegions().keySet()) {

            Region region = CTF.getInstance().getRegions().get(regionName);
            if (region.isInside(loc2) && !region.isInside(loc1))
                Bukkit.getPluginManager().callEvent(new PlayerEnterRegionEvent(player, region));
            else if (region.isInside(loc1) && !region.isInside(loc2))
                Bukkit.getPluginManager().callEvent(new PlayerLeaveRegionEvent(player, region));

        }
    }
}
