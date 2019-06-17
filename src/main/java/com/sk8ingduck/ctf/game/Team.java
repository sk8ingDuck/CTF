package com.sk8ingduck.ctf.game;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public enum Team {

    RED ("R", "Rot", ChatColor.RED),
    BLUE ("B", "Blue", ChatColor.BLUE);

    @Getter
    private String shortName;

    @Getter
    private String fullName;

    @Getter
    private ChatColor chatColor;

    @Getter
    private final List<Player> members = new ArrayList<>();

    Team(String shortName, String fullName, ChatColor chatColor) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.chatColor = chatColor;
    }

    public boolean addMember(Player player) {
        if(members.contains(player)) {
            return false;
        }

        members.add(player);
        return true;
    }

    public boolean removeMember(Player player) {
        if(!members.contains(player)) {
            return false;
        }

        members.remove(player);
        return true;
    }
}
