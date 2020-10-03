package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
	Commands plugin;

	public FlyCommand(Commands passedPlugin) {
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("fly")) {
				final Player player = (Player) sender;
				if (args.length == 0) {
					if (player.hasPermission("kelson.fly")) {
						if (!player.getAllowFlight()) {
							player.sendMessage(ChatColor.GREEN + "Fly Enabled");
							player.setAllowFlight(true);
						} else {
							sender.sendMessage(ChatColor.GREEN + "Fly Disabled");
							player.setAllowFlight(false);
						}
					} else {
						sender.sendMessage(ChatColor.RED + "No permissions");
					}
				}
				if (args.length == 1) {
					if (player.hasPermission("kelson.fly.others")) {
						final Player player2 = Bukkit.getPlayer(args[0]);
						if (player2 == null) {
							sender.sendMessage(ChatColor.RED + "Player offline");
							return true;
						}
						if (!player2.getAllowFlight()) {
							sender.sendMessage(ChatColor.GREEN + "Fly Enabled for " + player2.getName());
							player2.setAllowFlight(true);
							player2.sendMessage(ChatColor.GREEN + "Fly Enabled by " + player.getName());
						} else {
							sender.sendMessage(ChatColor.GREEN + "Fly Disabled for " + player2.getName());
							player2.setAllowFlight(false);
							player2.sendMessage(ChatColor.GREEN + "Fly Disabled by " + player.getName());
						}
					} else {
						sender.sendMessage(ChatColor.RED + "No permissions");
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Console cannot use this command!"); //Might add console usage later on
			}







		/*
		Player player = (Player) sender;

		if (args.length == 0) {
			sender.sendMessage("Error: not enough arguments, use the command with either /tempfly off or /tempfly on");

		} if (args[0].equalsIgnoreCase("on")) {
			player.setAllowFlight(true);
			sender.sendMessage(ChatColor.GREEN + "[" + ChatColor.BLUE + "Your fly mode is now enabled!" + ChatColor.GREEN + "]");

		} if (args[0].equalsIgnoreCase("off")) {
			player.setAllowFlight(false);
			sender.sendMessage(ChatColor.GREEN + "[" + ChatColor.BLUE + "Your fly mode is now disabled!" + ChatColor.GREEN + "]");

				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(args[0] + " is not online!");

				}

			      if (args[1].equals(target) && args[0].equalsIgnoreCase("on")) {
					target.setAllowFlight(true);
					target.sendMessage(Commands.main + "Your flying has been enabled by " + sender.getName() + "!");
					sender.sendMessage(Commands.main + "You have enabled flying for " + target.getName() + "!");

				}
			      if (args[1].equals(target) && args[0].equalsIgnoreCase("off")) {
					target.setAllowFlight(false);
					target.sendMessage(Commands.main + "Your flying has been disabled by " + sender.getName() + "!");
					sender.sendMessage(Commands.main + "You have disabled flying for " + target.getName() + "!");


				}

		}*/

		}
		return false;
	}
}