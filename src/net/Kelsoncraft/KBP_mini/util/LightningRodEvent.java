package net.Kelsoncraft.KBP_mini.util;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.Kelsoncraft.KBP_mini.KbpMain;

public class LightningRodEvent implements Listener {

    KbpMain plugin;
	
	public LightningRodEvent(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	public LightningRodEvent() {
		
	}
	
	
	@EventHandler
	public void LightningRodCheck(PlayerInteractEvent event) {
		try {
		Player player = event.getPlayer();
		//ConsoleCommandSender cns = this.plugin.getServer().getConsoleSender();
		
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
			
			//cns.sendMessage(player.getName() + " Has struck lightning!");
			
			for (int i=0; i<plugin.getConfig().getInt("lightning_strikes"); i++) {
				
				player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
				
				}
		}
	} catch (NullPointerException e){
		e.printStackTrace();
	}
	
	}

}