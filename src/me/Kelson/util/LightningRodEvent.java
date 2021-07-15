package me.Kelson.util;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.Kelson.Main;

public class LightningRodEvent implements Listener{

    private Main plugin;
	
	public LightningRodEvent(Main passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	public LightningRodEvent() {
		
	}
	
	@EventHandler
	public void LightningRodCheck(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.getInventory().getItemInMainHand() == null){
			event.setCancelled(true);
		}
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§b§lPosiden's");
		lore.add("§b§lFury");
		
		if(player.getInventory().getItemInMainHand().getType() == (Material.STICK) && 
				player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§b§lLightning §b§lRod")
			      && player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lore)
				  //TODO make this work with getting the lore and the name, for now the lore part breaks it and it gives a null pointer when using stick without the lore.
				&& player.hasPermission("kelson.lightning_rod")) {
			
			for (int i=0; i<100 ; i++) { // Change int i to  however many lightning strikes i want, cannot get it to work with config for now.
				// Loops the code below as many times as i is less then number above
			    //for (int i=0; i < lstrike_int; i++) {
				
				player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
				}
			
		}
			
			//int lstrike_int = plugin.getConfig().getInt("lightning_strikes"); //This code gives null pointer, try to fix.
		
		    

		/*if (player.getInventory().getItemInMainHand().getType() == (Material.STICK) 
		    && !(player.getInventory().getItemInMainHand().getItemMeta().getLore() == lore)) {
			event.setCancelled(true);
		}*/
		if(!player.hasPermission("kelson.lightning_rod")) {
			event.setCancelled(true);
		}
	}
	
	
}
