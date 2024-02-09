package net.Kelsoncraft.KBP.listeners;

import java.util.ArrayList;
import java.util.Objects;

import net.Kelsoncraft.KBP.util.ChatColorUtil;
import net.Kelsoncraft.KBP.util.Messages;
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
import org.checkerframework.checker.units.qual.A;

public class Events implements Listener{
KbpMain plugin;
	
	public Events(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	public Events(){

	}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("motd"))
            		.replace("%w", player.getWorld().getName())
            		.replace("%s", player.getName()));
    }
	
	//Test this event later.
	@EventHandler
	public void holdItem(PlayerItemHeldEvent event) {
		// This just spams the console and doesn't output the text
//		Player player = event.getPlayer();
//		ItemStack poppy = new ItemStack(Material.POPPY);
//		ArrayList<String> lore = new ArrayList<>();
//		lore.add("&bSpecial");
//		lore.add("&bFlower");
//
////		if(Objects.equals(Objects.requireNonNull(Objects.requireNonNull(event.getPlayer().getItemInUse()).getItemMeta()).getLore(), lore)
//		if(event.getPlayer().getItemInUse().getItemMeta().getLore().equals(lore)
//		&& event.getPlayer().getItemInUse().getType() == Material.POPPY){
//			player.sendMessage("You are holding the special flower!");
//		}
	}
	
	@EventHandler
	public void godModeEnable(FoodLevelChangeEvent event){

		//If the player has permission and they have night vision, no hunger works. 
		// This is needed to be changed to something else later on.
		if (event.getEntity().isInvulnerable()) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
		}

	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		// Todo Try to add this as a command toggle
		if(e.getEntity().hasPermission("kbp.no.hunger") && e.getEntity().hasPotionEffect(PotionEffectType.NIGHT_VISION)) {

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
		
		if (player.getAllowFlight() && gameMode.equals(GameMode.ADVENTURE) && !player.hasPermission("kbp.fly.adventure")) {
			e.setCancelled(true);
		}
		if(player.getAllowFlight() && gameMode.equals(GameMode.SURVIVAL) && !player.hasPermission("kbp.fly.survival")) {
			e.setCancelled(true);
		}
		*/
	}
	
	@EventHandler
	//This code makes it to where the lightning stick won't break blocks.
	
	public void lightningStickBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		
		ArrayList<String> lore = new ArrayList<>();
		lore.add("&4&lPosiden's");
		lore.add("&4&lFury");
		
		if(player.getInventory().getItemInMainHand().getType() == Material.STICK
				&& Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals(ChatColorUtil.format("&bLightning Rod"))
				&& Objects.equals(player.getInventory().getItemInMainHand().getItemMeta().getLore(), lore)
				&& player.hasPermission("kbp.lightning_rod")) {
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
			if(inv.getType() == Material.BEDROCK && !player.hasPermission("kbp.place.bedrock") && player.getGameMode().equals(GameMode.SURVIVAL)) {
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

		if(event.getMessage().contains(".help") && player.hasPermission("kbp.secret.commands.help")){
			player.sendMessage("Secret command usage: .help");
			event.setCancelled(true);
		}
	}

}
