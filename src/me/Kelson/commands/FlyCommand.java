package me.Kelson.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class FlyCommand implements CommandExecutor {
	Main plugin;

	public FlyCommand(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		/*
		 * ArrayList<UUID> playersFlying = new ArrayList<UUID>();
		 * playersFlying.add(player.getUniqueId());
		*/
		
		 // Custom fly command for the KelsonCraft server. 
		 
		
		
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("fly") && sender.hasPermission("kelson.fly")) {
				final Player player = (Player) sender;
				if (args.length == 0) {
						sender.sendMessage(Messages.KBP_errormsg() + "Invalid command usage: /fly <on/off> [player]");
						return true;
				}
				
					Location location = player.getLocation();
					int highesty = location.getWorld().getHighestBlockYAt(location);
					
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("on") && !player.getAllowFlight()) {
							player.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying enabled");
							player.setAllowFlight(true);

						} 
						else if (args[0].equalsIgnoreCase("on") && player.getAllowFlight()) {
							sender.sendMessage(Messages.KBP_Main + "You already have flying enabled!"); //test
						}
						
						/* Testing fly already enabled message.
						 * if (playersFlying.contains(player.getUniqueId())) {
							sender.sendMessage("Fly already enabled!");
						See if i can get a flying already enabled/disabled message to work.
						}*/
						
						if (args[0].equalsIgnoreCase("off") && player.getAllowFlight() && !(args.length == 2) && location.getBlockY() > highesty){
							sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying disabled");
							
							//Put the player on the ground so they don't die.
							location.setY(highesty + 1); //Add 1 so the player doesn't get stuck in the ground.
							player.teleport(location);
							
							//Disable flying.
							player.setAllowFlight(false);
						
						}	
						else if (args[0].equalsIgnoreCase("off") && !player.getAllowFlight()) {
							sender.sendMessage(Messages.KBP_Main + "You already have flying disabled!");
						}
					}
				
				} else {
					sender.sendMessage(Messages.NoPermissionError());
					return true;
				}
					
				if (args.length == 2) {
					if (sender.hasPermission("kelson.fly.others")) {
						final Player target = Bukkit.getPlayer(args[1]);
						
						
						
						if (target == null) {
							sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
							return true;
						}
						Location location = target.getLocation();
						int highesty = location.getWorld().getHighestBlockYAt(location);
						
						if (args[0].equalsIgnoreCase("on") && args[1].equals(target.getName()) && !target.getAllowFlight()) {
							sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been enabled for " + target.getName());
							target.setAllowFlight(true);
							target.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been enabled by " + sender.getName());
						} 
						
						if (args[0].equalsIgnoreCase("off") && target.getAllowFlight() && location.getBlockY() > highesty){
							sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been disabled for " + target.getName());
							
							//Put the target on the ground so they don't die.
							location.setY(highesty +1);
							target.teleport(location);
							
							target.setAllowFlight(false);
							target.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been disabled by " + sender.getName());
						}
					} else {
						sender.sendMessage(Messages.KBP_Main + ChatColor.RED + "You don't have permission to use this command on others!");
						}
					}
				
			
			} 
			
			if (!(sender instanceof Player)) {
				if(cmd.getName().equalsIgnoreCase("fly")){
				if (args.length == 0) {
					sender.sendMessage(Messages.KBP_errormsg() + "Console command usage: /fly [on/off] [player]");
					return true;
				}
				if (args.length == 1) {
					sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this on itself!");
					return true;
				}
				if (args.length == 2) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
						return true;
					}
					
					Location location = target.getLocation();
					int highesty = location.getWorld().getHighestBlockYAt(location);
					
					if (args[0].equalsIgnoreCase("on") && args[1].equals(target.getName()) && !target.getAllowFlight()) {
						sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been enabled for " + target.getName());
						target.setAllowFlight(true);
						target.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been enabled by Console.");
					}
					
					if (args[0].equalsIgnoreCase("off") && args[1].equals(target.getName()) && target.getAllowFlight() && location.getBlockY() > highesty) {
						sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been disabled for " + target.getName());
						
						//Put the target on the ground so they don't die.
						location.setY(highesty +1);
						target.teleport(location);
						
						target.setAllowFlight(false);
						target.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been disabled by Console.");
						}
					}
				}
			} 

		return false;
	}

}