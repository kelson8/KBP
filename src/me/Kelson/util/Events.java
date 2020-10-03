package me.Kelson.util;

import me.Kelson.Commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Events implements Listener{
Commands plugin;
	
	public Events(Commands passedPlugin) {
		this.plugin = passedPlugin;
	}
	public Events(){
		//This is what goes in the onEnable() in the main class don't remove it!
	}


 

	@EventHandler
	public void EnchantItemEvent(EnchantItemEvent event){
	}
	@EventHandler
	public void PlayerLevelChangeEvent(PlayerLevelChangeEvent e){
		
	}
	public final HashMap<Location, String> signs = new HashMap<Location, String>();
	//This is used to block TNT, Lava blocks and Lava buckets from working in a dispenser
	@EventHandler
	public void onBlockDispense(BlockDispenseEvent event) {
	  if(event.getItem().equals(Material.TNT)){
		  event.setItem(null);
	  }
	  if(event.getItem().equals(Material.LAVA)){
		  event.setItem(null);
	  }
	  if(event.getItem().equals(Material.LAVA_BUCKET)){
		  event.setItem(null);
	  }
	  if(event.getBlock().equals(Material.TNT)){
		  event.setItem(null);
	  }
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if(event.getBlockPlaced().equals(Material.TNT)){
			//event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to use " + ChatColor.YELLOW + "TNT" + ChatColor.RED + " in this server!");
			event.setCancelled(true);
		}
		if(event.getBlockPlaced().equals(Material.LAVA)){
			//event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to use " + ChatColor.YELLOW + "Lava_Block" + ChatColor.RED + " in this server!");
			event.setCancelled(true);
		}
		if(event.getBlockPlaced().equals(Material.LAVA_BUCKET)){
			//event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to use " + ChatColor.YELLOW + "Lava_Bucket" + ChatColor.RED + " in this server!");
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		//This is the localchat in this plugin
	    if(message.length() > 1 && message.startsWith("@"))
	    {
	      event.setFormat(ChatColor.GOLD + "[LocalChat] " + ChatColor.AQUA + player.getName() + ": " + ChatColor.GREEN + event.getMessage()
	    		  .replace("@", ""));
	      event.getRecipients().clear();
	      Location playerLocation = event.getPlayer().getLocation();
	      List<Player> recipients = new ArrayList<Player>();
	      int squaredDistance = 64 * 64;
	      for(Player recipient : Bukkit.getServer().getOnlinePlayers())
	      {
	    		  
	        if(recipient.getWorld().equals(event.getPlayer().getWorld().getPlayers()))
	        {
	          if(playerLocation.distanceSquared(recipient.getLocation()) <= squaredDistance)
	          {
	            recipients.add(recipient);
	          }
	          if (recipient.getLocation().distanceSquared(player.getLocation()) < squaredDistance || recipient.hasPermission("kelson.localchat.spy")) {
	                recipient.sendMessage(message);
	          // to localchat use a @ in front of your message like this "@hi"
	      event.getRecipients().addAll(recipients);
	      event.setMessage(message);
	    	 
	          }
	      }
	  }
    } 
  }
}
