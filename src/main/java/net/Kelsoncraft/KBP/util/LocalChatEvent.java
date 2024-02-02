package net.Kelsoncraft.KBP.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.Kelsoncraft.KBP.KbpMain;

public class LocalChatEvent implements Listener
{
    KbpMain plugin;
    
    public LocalChatEvent(KbpMain plugin) {
        this.plugin = plugin;
    }

    // Is this even doing anything? It says it's not used.
    public LocalChatEvent() {
    }
    
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String localChatFormat = ChatColor.GOLD + "[LocalChat] " + ChatColor.AQUA + player.getName() + ": " + ChatColor.GREEN;
        String message = event.getMessage();
        String messageColor = ChatColor.translateAlternateColorCodes('&', message).replaceFirst("@", "");
        
        if (message.length() > 1 && message.startsWith("@")) {
            if (player.hasPermission("kelson.localchat.color")) {
                event.setFormat(localChatFormat + messageColor);
                
            } else {
                event.setFormat(localChatFormat + event.getMessage().replaceFirst("@", ""));
            }
            
            List<Player> recipients = new ArrayList<Player>();
            
            for (Player recipient : Bukkit.getServer().getOnlinePlayers()) {
                Location playerLoc = event.getPlayer().getLocation();
                Location recipientLoc = recipient.getLocation();
                
                if (recipientLoc.getWorld().equals(playerLoc.getWorld()) && recipient.getLocation().distance(playerLoc) <= 50.0) {
                    
                	recipients.add(recipient);
                    event.getRecipients().addAll(recipients);
                    event.setMessage(message);
                    
                } else {
                    event.getPlayer().sendMessage(Messages.KBP_errormsg() + "No one was around!");
                    event.setCancelled(true);
                }
            }
        }
    }
}