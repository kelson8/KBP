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

public class LocalChatEvent implements Listener{
	
	KbpMain plugin;
	
	public LocalChatEvent(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	public LocalChatEvent() {
		
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
	    /*if(plugin.getConfig().getString("localchat") == null) {
			event.setCancelled(true);
		}*/ //This should check if the localchat string in the config is null, not working right now.

		
		Player player = event.getPlayer();
		String message = event.getMessage();
		//This is the localchat in this plugin
	    if(message.length() > 1 && message.startsWith("@")){
	    	
	    //TODO make this below work with a value from config
		//if (message.length() > 1 && message.startsWith(plugin.getConfig().getString("localchat").toString())) {
	    	
	      event.setFormat(ChatColor.GOLD + "[LocalChat] " + ChatColor.AQUA + player.getName() + ": " + ChatColor.GREEN + event.getMessage()
	    		  .replace("@", ""));
	      event.getRecipients().clear();
	      
	      Location playerLoc = event.getPlayer().getLocation(); 
	      
	      List<Player> recipients = new ArrayList<Player>();
	      
	      for(Player recipient : Bukkit.getServer().getOnlinePlayers()) {
	    	  Location recipientLoc = recipient.getLocation();
	    	  
	        if(recipientLoc.getWorld().equals(playerLoc.getWorld()) 
	        		&& recipient.getLocation().distance(playerLoc) <= 50
	        		&& recipient.getWorld() == player.getWorld()) {

	        	recipients.add(recipient);
                event.getRecipients().addAll(recipients);
                event.setMessage(message);
                
	        } else { //Runs when no one else is nearby.
	        	event.getPlayer().sendMessage(Messages.KBP_errormsg() + "No one was around!");
                event.setCancelled(true);	
                }

	    	}
	    }
	}
}
