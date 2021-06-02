package me.Kelson.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.Kelson.Main;

public class LightningRodEvent implements Listener{

    Main plugin;
	
	public LightningRodEvent(Main passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	public LightningRodEvent() {
		
	}
	
	@EventHandler
	public void LightningRodCheck(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(player.getInventory().getItemInMainHand() == null){
			return;
		}
		
		if(player.getInventory().getItemInMainHand().getType() == (Material.STICK) && 
				player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Lightning Stick")
				&& player.hasPermission("kelson.lightning_rod")) {
			
			player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
		}
		if(!player.hasPermission("kelson.lightning_rod")) {
			event.setCancelled(true);
		}
	}
	
	
}
