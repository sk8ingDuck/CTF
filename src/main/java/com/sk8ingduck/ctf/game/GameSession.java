package com.sk8ingduck.ctf.game;

import com.sk8ingduck.ctf.event.GameStateChangeEvent;
import com.sk8ingduck.ctf.scheduler.Countdown;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameSession {

    @Getter
    private GameState currentGameState;

    @Getter
    @Setter
    private Countdown currentCountdown;


    public void sendTeamMessage(Team team, String message) {
        team.getMembers().forEach((Player player) -> player.sendMessage(message));
    }

    public void nextGameState() {
        int index = 0;
        for (int i = 0; i < GameState.values().length; i++) {
            if (GameState.values()[i] == currentGameState) {
                index = i;
            }
        }

        GameState nextGameState;
        if (index >= GameState.values().length) {
            index = 0;
        } else {
            index++;
        }

        changeGameState(GameState.values()[index]);
    }

    public void changeGameState(GameState gameState) {
        Bukkit.getPluginManager().callEvent(new GameStateChangeEvent(currentGameState, gameState));

        currentGameState = gameState;
    }
}
