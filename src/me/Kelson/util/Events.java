package me.Kelson.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
	public void onFoodChange(FoodLevelChangeEvent event){

		//If the player has permission and they have night vision, no hunger works. 
		// This is needed to be changed to something else later on.
		
		if ((event.getEntity().hasPermission("no.hunger"))
				&& event.getEntity().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
			event.setCancelled(true);

		} else {
			event.setCancelled(false);
		}

	}
	
	
	@EventHandler
	public void flyListener(PlayerToggleFlightEvent e) {
		}
	
	
	@EventHandler
	//This code makes it to where the lightning stick won't break blocks.
	
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§b§lPosiden's");
		lore.add("§b§lFury");
		
		if(player.getInventory().getItemInMainHand().getType() == Material.STICK
				  && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§b§lLightning §b§lRod")
			      && player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lore)
				  && player.hasPermission("kelson.lightning_rod")) {
		//if(meta.getDisplayName().equals("§b§lLightning §b§lRod") && meta.getLore().equals(Arrays.asList("§b§lPosiden's", "§b§lFury"))) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
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
