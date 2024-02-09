package net.Kelsoncraft.KBP.listeners;

import java.util.ArrayList;
import java.util.Objects;

import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.Kelsoncraft.KBP.KbpMain;

/**
 * @author kelson
 *
 */

public class LightningRodEvent implements Listener {

    KbpMain plugin;
	
	public LightningRodEvent(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	public LightningRodEvent() {
		
	}
	

	private String format(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	@EventHandler
	public void LightningRodCheck(PlayerInteractEvent event) {
		try {
			Player player = event.getPlayer();
			//ConsoleCommandSender cns = this.plugin.getServer().getConsoleSender();

			if(player.getInventory().getItemInMainHand() == null){
				event.setCancelled(true);
			}

			ArrayList<String> lore = new ArrayList<>();
			lore.add(format("&4&lPosiden's"));
			lore.add(format("&4&lFury"));

			if(player.getInventory().getItemInMainHand().getType() == (Material.STICK) &&
					// Replaced these with auto suggestions from IntelliJ
					Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals(format("&bLightning Rod"))
					&& Objects.equals(player.getInventory().getItemInMainHand().getItemMeta().getLore(), lore)
					&& player.hasPermission("kbp.lightning_rod")) {

				//TODO set message below where it randomly runs when the lightning stick is being used.
				//Bukkit.broadcastMessage(ChatColor.RED + "DEATH has been struck upon thee. I BLAME: " + player.getName());

				if(plugin.getConfig().getBoolean("lightning_message")){
				player.sendMessage("You have struck " + plugin.getConfig().getInt("lightning_strikes") + " lightning bolts!");
				
				//Useless line below, just for messing around with.
				//Bukkit.broadcastMessage(Messages.KBP_Main() + ChatColor.RED + "HAHA anything in " + ChatColor.WHITE + player.getName() + ChatColor.RED "'s path will be struck down by thor himself!!");
				}
			
				for (int i=0; i<plugin.getConfig().getInt("lightning_strikes"); i++) {
					player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
				}
		}
	} catch (NullPointerException e){
		e.printStackTrace();
		}
	}
}
