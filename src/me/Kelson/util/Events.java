package me.Kelson.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;

import me.Kelson.Main;

@SuppressWarnings("unused")
public class Events implements Listener{
Main plugin;
	
	public Events(Main passedPlugin) {
		this.plugin = passedPlugin;
	}
	public Events(){
		//This is what goes in the onEnable() in the main class don't remove it!
	}

	/*
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
	*/

	@EventHandler
	public void godModeEnable(FoodLevelChangeEvent event){

		//If the player has permission and they have night vision, no hunger works. 
		// This is needed to be changed to something else later on.
		// old if (event.getEntity().hasPermission("no.hunger") && event.getEntity().hasPotionEffect(PotionEffectType.NIGHT_VISION)
		if (event.getEntity().isInvulnerable()) {
			event.setCancelled(true);

		} else {
			event.setCancelled(false);
		}

	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		
		if(e.getEntity().hasPermission("kelson.no.hunger")) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}
	
	
	@EventHandler
	public void flyListener(PlayerToggleFlightEvent e) {
		/*
		 * This works like this, see if I can use this event for something useful sometime.
		Player player = e.getPlayer();
		GameMode gameMode = player.getGameMode();
		
		if (player.getAllowFlight() && gameMode.equals(GameMode.ADVENTURE) && !player.hasPermission("kelson.fly.adventure")) {
			e.setCancelled(true);
		}
		if(player.getAllowFlight() && gameMode.equals(GameMode.SURVIVAL) && !player.hasPermission("kelson.fly.survival")) {
			e.setCancelled(true);
		}
		*/
		
	}
	
	
	@EventHandler
	//This code makes it to where the lightning stick won't break blocks.
	
	public void lightningStickBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§4§lPosiden's");
		lore.add("§4§lFury");
		
		if(player.getInventory().getItemInMainHand().getType() == Material.STICK
				  && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§b§lLightning §b§lRod")
			      && player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lore)) {
				  //&& player.hasPermission("kelson.lightning_rod")) {
		//if(meta.getDisplayName().equals("§b§lLightning §b§lRod") && meta.getLore().equals(Arrays.asList("§b§lPosiden's", "§b§lFury"))) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
			}
		}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		ItemStack inv = player.getInventory().getItemInMainHand();
		
		if(e.getBlock().getType().equals(Material.BEDROCK)) {
			//Add survival check so that bedrock can still be placed in creative.
			if(inv.getType() == Material.BEDROCK && !player.hasPermission("kelson.place.bedrock") && player.getGameMode().equals(GameMode.SURVIVAL)) {
				e.setCancelled(true);
				player.sendMessage(Messages.KBP_errormsg() + "You cannot place bedrock in survival!");
			} else {
				e.setCancelled(false);
			}
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
	
	public final HashMap<Location, String> signs = new HashMap<Location, String>(); //? I have no idea what this does.

}
