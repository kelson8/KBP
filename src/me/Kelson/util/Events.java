package me.Kelson.util;

import me.Kelson.Main;
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
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Events implements Listener{
Main plugin;
	
	public Events(Main passedPlugin) {
		this.plugin = passedPlugin;
	}
	public Events(){
		//This is what goes in the onEnable() in the main class don't remove it!
	}


	//@SuppressWarnings("unused")
	/*
	@EventHandler
    public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		if(player.getName().equals("kelson8")){
			player.chat("Hello everyone!");
    	player.sendMessage("Read the rules at " + ServerRules + " or you can read the rules in /rules");
	    }
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event){
		Player player = event.getPlayer();
		if(player.getName().equals("kelson8")){
			player.chat("Hello everyone!");
		}
	}*/

	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event){
		Player player = event.getPlayer();
		// Possibly test this for something later.. Bukkit.getOfflinePlayers();

		//TODO possibly hook into vault and use that to give/remove a players permission on command, ex: /destroy <on/off>
		// Also add it for the hunger one, /nohunger <on/off>, on will give the permission and off will remove it

		// Chaos mode begins..
		if(player.getInventory().getItemInMainHand().getType() == Material.BARRIER && player.hasPermission("kelson.destroy")) {
			//player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
			player.getWorld().createExplosion(player.getTargetBlock(null, 50).getLocation(), 100);
		}
		if(player.getInventory().getItemInMainHand().getType() == Material.BEDROCK && player.hasPermission("kelson.destroy")){

			player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());

		}

	}

	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent event)
	{

		//If the player has permission or if the player is op it disables their hunger
		if ((event.getEntity().hasPermission("no.hunger")) || (event.getEntity().isOp())) {
			//event.setCancelled(true);

		} else {
			//event.setCancelled(false);
		}

	}

	@EventHandler
	public void onPlayerChat1(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();

		if(event.getMessage().contains(".help") && player.hasPermission("kelson.secret.commands.help")){
			player.sendMessage("Secret command usage: .help");
			event.setCancelled(true);
		}
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

	/*
	public void playerLocalChat(Player player, String message, ChatColor msgColor, boolean global){
		try {
			List<Player> nearby = new ArrayList<Player>(6);
			Location playerloc = player.getLocation();
			for(Player onlineplayer : plugin.getServer().getOnlinePlayers()){
				Location onlinePlayerLoc = onlineplayer.getLocation();

				if (global || onlinePlayerLoc.getWorld().equals(playerloc.getWorld())
				&& onlineplayer.getLocation().distance(playerloc) <= 50
				&& onlineplayer.getWorld().getWorldType() == player.getWorld().getWorldType()) {
					nearby.add(onlineplayer);

				}
			}

			boolean gotOne = false;
			// Innectis only, cannot use ChatMessage msg = new ChatMessage(message, msgColor);

			for(Player target : nearby){
				// Skip yourself.
				if(target.getName().equalsIgnoreCase(player.getName())){
					continue;
				}
				String printMsg = message;
				target.sendMessage(printMsg);
			}



		} catch (ConcurrentModificationException cme){
			player.sendMessage(Commands.main + ChatColor.DARK_RED + "Error!");
		}
	}
*/

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
