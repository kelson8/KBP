package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.UUID;

public class PlayerInfo implements Serializable {

    KbpMain plugin;


    private UUID playerUUID;
    private String playerName;

    public PlayerInfo(UUID playerUUID, String playerName) {
        this.playerUUID = playerUUID;
        this.playerName = playerName;
    }

    public UUID getPlayerUUID(){
        return playerUUID;
    }

    public String getPlayerName(){
        return playerName;
    }

    // Possibly add offline player option
    public void storePlayerInfo(UUID playerUUID) {
        String path = "players." + playerUUID.toString();
        plugin.getCustomConfig().set(path, playerUUID);
    }

    public PlayerInfo getPlayerInfo(UUID playerUUID) {
        String path = "players." + playerUUID.toString();
        if(plugin.getCustomConfig().contains(path)){
            return (PlayerInfo) plugin.getCustomConfig().get(path);
        } else {
            return null; // Player data not found
        }



    }
}
