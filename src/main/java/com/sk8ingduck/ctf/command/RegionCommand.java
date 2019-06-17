package com.sk8ingduck.ctf.command;

import com.sk8ingduck.ctf.CTF;
import com.sk8ingduck.ctf.region.Region;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class RegionCommand implements CommandExecutor {

    private HashMap<String, Location> locs1 = new HashMap<>();
    private HashMap<String, Location> locs2 = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player player = (Player) cs;

        Location loc = player.getLocation();
        if(args.length == 0) {
            player.sendMessage("§cSyntax: /region [pos1|pos2|create] <Name>");
            return true;
        }

        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("pos1")) {
                player.sendMessage("§aPunkt 1 gesetzt");
                return true;
            }
            if(args[0].equalsIgnoreCase("pos2")) {
                player.sendMessage("§aPunkt 2 gesetzt");
                return true;
            }
        }

        if(args.length == 2) {
            if(args[0].equalsIgnoreCase("create")) {
                Location loc1 = this.locs1.get(player.getName());
                Location loc2 = this.locs2.get(player.getName());

                if (loc1 == null || loc2 == null) {
                    player.sendMessage("§cSetze zuerst 2 Punkte");
                    return true;
                }
                if (loc1.getWorld() != loc2.getWorld()) {
                    player.sendMessage("§cDie Punkte müssen in der gleichen Welt sein");
                    return true;
                }

                String region = args[1].toLowerCase();
                CTF.getInstance().getRegions().put(region, new Region(loc1, loc2));
                player.sendMessage("§aRegion §e" + region + " §aerstellt");
                return true;
            }
        }

        return false;
    }
}
