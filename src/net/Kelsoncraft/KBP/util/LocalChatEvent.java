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
    
    public LocalChatEvent(final KbpMain plugin) {
        this.plugin = plugin;
    }
    
    public LocalChatEvent() {
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final String localChatFormat = ChatColor.GOLD + "[LocalChat] " + ChatColor.AQUA + player.getName() + ": " + ChatColor.GREEN;
        final String message = event.getMessage();
        final String messageColor = ChatColor.translateAlternateColorCodes('&', message).replaceFirst("@", "");
        
        if (message.length() > 1 && message.startsWith("@")) {
            if (player.hasPermission("kelson.localchat.color")) {
                event.setFormat(localChatFormat + messageColor);
                
            } else {
                event.setFormat(localChatFormat + event.getMessage().replaceFirst("@", ""));
            }
            
            final Location playerLoc = event.getPlayer().getLocation();
            
            final List<Player> recipients = new ArrayList<Player>();
            
            for (final Player recipient : Bukkit.getServer().getOnlinePlayers()) {
                final Location recipientLoc = recipient.getLocation();
                
                if (recipientLoc.getWorld().equals(playerLoc.getWorld()) && recipient.getLocation().distance(playerLoc) <= 50.0 
                		&& !recipient.getName().equals(player.getName()) 
                		&& recipient.getWorld() == player.getWorld()) {
                    
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