package com.sk8ingduck.ctf.event;

import com.sk8ingduck.ctf.region.Region;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
@Getter
public class PlayerLeaveRegionEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    @Getter
    private final Player player;

    @Getter
    private final Region region;


    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
