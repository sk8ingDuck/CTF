package com.sk8ingduck.ctf.event;

import com.sk8ingduck.ctf.game.GameState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
@Getter
public class GameStateChangeEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private final GameState previousGameState;
    private final GameState newGameState;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}