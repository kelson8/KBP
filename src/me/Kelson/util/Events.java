package me.Kelson.util;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.Kelson.Main;

public class Events implements Listener{
Main plugin;
	
	public Events(Main passedPlugin) {
		this.plugin = passedPlugin;
	}
	public Events(){
		//This is what goes in the onEnable() in the main class don't remove it!
	}

	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event){
		Player player = event.getPlayer();
		// Possibly test this for something later.. Bukkit.getOfflinePlayers();

		//TODO possibly hook into vault and use that to give/remove a players permission on command, ex: /destroy <on/off> [player]
		// Also add it for the hunger one, /nohunger <on/off>, on will give the permission and off will remove it

		// Chaos mode begins..
		if(player.getInventory().getItemInMainHand().getType() == Material.BARRIER && player.hasPermission("kelson.destroy")) {
			//player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
			//for (int i=0; i<3; i++) {
			player.getWorld().createExplosion(player.getTargetBlock(null, 50).getLocation(), 100);
			//}
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
	
	public final HashMap<Location, String> signs = new HashMap<Location, String>();
	//This is used to block TNT, Lava blocks and Lava buckets from working in a dispenser
	@EventHandler
	public void onBlockDispense(BlockDispenseEvent event) {
		ItemStack isTnt = new ItemStack(Material.TNT);
		ItemStack isLava = new ItemStack(Material.LAVA);
		ItemStack isLava_Bucket = new ItemStack(Material.LAVA_BUCKET);

	  if(event.getItem() == isTnt){
		  event.setCancelled(true);
	  }
	  if(event.getItem() == isLava){
		  event.setCancelled(true);
	  }
	  if(event.getItem() == isLava_Bucket){
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
	/* 
	//Can no longer test due to not having an alt anymore.
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		List<Player> nearby = new ArrayList<Player>(6);
		Player player = event.getPlayer();
		String message = event.getMessage();
		//This is the localchat in this plugin
	    if(message.length() > 1 && message.startsWith("@")){
	    	
	      event.setFormat(ChatColor.GOLD + "[LocalChat] " + ChatColor.AQUA + player.getName() + ": " + ChatColor.GREEN + event.getMessage()
	    		  .replace("@", ""));
	      event.getRecipients().clear();
	      
	      Location playerLoc = event.getPlayer().getLocation(); 
	      
	      List<Player> recipients = new ArrayList<Player>();
	      int squaredDistance = 64 * 64;
	      
	      for(Player recipient : Bukkit.getServer().getOnlinePlayers()) {
	    	  Location recipientLoc = recipient.getLocation();
	    	  
	        if(recipientLoc.getWorld().equals(playerLoc.getWorld()) 
	        		&& recipient.getLocation().distance(playerLoc) <= 50
	        		&& recipient.getWorld().getWorldType() == player.getWorld().getWorldType()) {
	        	recipients.add(recipient);
	        	
	          /*if(playerLoc.distanceSquared(recipient.getLocation()) <= squaredDistance) {
	            recipients.add(recipient);
	          
	          if (recipient.getLocation().distanceSquared(player.getLocation()) < squaredDistance || recipient.hasPermission("kelson.localchat.spy")) {
	                recipient.sendMessage(message);
	          // to localchat use a @ in front of your message like this "@hi"
	                event.getRecipients().addAll(recipients);
	                event.setMessage(message);
	    	 
	            }
	          }
	        }
	      }
	    } */
	}
