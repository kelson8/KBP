package me.Kelson.util;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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
	/*
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
	}*/

}
