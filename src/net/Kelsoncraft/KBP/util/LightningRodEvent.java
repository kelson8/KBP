package net.Kelsoncraft.KBP.util;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.Kelsoncraft.KBP.KbpMain;

public class LightningRodEvent implements Listener{

    KbpMain plugin;
	
	public LightningRodEvent(KbpMain passedPlugin) {
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
		lore.add("§4§lPosiden's");
		lore.add("§4§lFury");
		
		if(player.getInventory().getItemInMainHand().getType() == (Material.STICK) && 
				player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§b§lLightning §b§lRod")
			      && player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lore)
				&& player.hasPermission("kelson.lightning_rod")) {
			
			//TODO set message below where it randomly runs when the lightning stick is being used.
			//Bukkit.broadcastMessage(ChatColor.RED + "DEATH has been struck upon thee. I BLAME: " + player.getName());
		
			//Main instance = Main.getInstance();
			for (int i=0; i<5 ; i++) { // Change int i to however many lightning strikes i want, cannot get it to work with config for now.
				// Loops the code below as many times as i is less then number above
				
				player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
				
				}
			
			
			//int lstrike_int = plugin.getConfig().getInt("lightning_strikes"); //This code gives null pointer, try to fix.
			//for (int i=0; i < lstrike_int; i++) {
		}		
	}
	
	
}
