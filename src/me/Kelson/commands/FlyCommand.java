package me.Kelson.commands;

import me.Kelson.Main;
import me.Kelson.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
	Main plugin;

	public FlyCommand(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("fly") && sender.hasPermission("kelson.fly")) {
				final Player player = (Player) sender;
				if (args.length == 0) {
						sender.sendMessage(Messages.KBP_errormsg() + "Invalid command usage: /fly <on/off> [player]");
						return true;
				}
						if (args[0].equalsIgnoreCase("on") && !player.getAllowFlight() && !(args.length == 2)) {
							player.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying enabled");
							player.setAllowFlight(true);

						}
						
						if (args[0].equalsIgnoreCase("off") && player.getAllowFlight() && !(args.length == 2)){
							sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying disabled");
							player.setAllowFlight(false);
						
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
						if (args[0].equalsIgnoreCase("on") && args[1].equals(target.getName()) && !target.getAllowFlight()) {
							sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been enabled for " + target.getName());
							target.setAllowFlight(true);
							target.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been enabled by " + sender.getName());
						} 
						
						if (args[0].equalsIgnoreCase("off") && target.getAllowFlight()){
							sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been disabled for " + target.getName());
							target.setAllowFlight(false);
							target.sendMessage(Messages.KBP_Main + ChatColor.GREEN + "Flying has been disabled by " + sender.getName());
						}
					} else {
						sender.sendMessage(Messages.KBP_Main + ChatColor.RED + "You don't have permission to use this command on others!");
						}
					}
				
			
			} else {
				sender.sendMessage(Messages.KBP_Main + ChatColor.RED + "Console cannot use this command!"); //Might add console usage later on
		} 

		return false;
	}

}