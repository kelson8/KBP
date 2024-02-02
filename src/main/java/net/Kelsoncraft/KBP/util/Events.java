package net.Kelsoncraft.KBP.util;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import net.Kelsoncraft.KBP.KbpMain;


@SuppressWarnings("deprecation") //Why is almost everything deprecated in the latest 1.16.5 paper verisons?
public class Events implements Listener{
KbpMain plugin;
	
	public Events(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	public Events(){
		//This is what goes in the onEnable() in the main class don't remove it!
	}
	
	//Test this later.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("motd"))
            		.replace("%w", player.getWorld().getName())
            		.replace("%s", player.getName()));
    }
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
	}
	
	//Test this event later.
	@EventHandler
	public void holdItem(PlayerItemHeldEvent event) {
		
	}
	
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
		
		if(e.getEntity().hasPermission("kelson.no.hunger") && e.getEntity().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {

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
		//if(meta.getDisplayName().equals("§b§lLightning §b§lRod") && meta.getLore().equals(Arrays.asList§b§lPosiden's", "§b§lFury"))) {
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
				//plugin.logger.log(Level.WARNING, player.getName() + " Has somehow obtained bedrock in " + player.getGameMode().toString());
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

}
