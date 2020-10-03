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
							player.sendMessage(Commands.main + ChatColor.GREEN + "Flying enabled");
							player.setAllowFlight(true);
						} else {
							sender.sendMessage(Commands.main + ChatColor.GREEN + "Flying disabled");
							player.setAllowFlight(false);
						}
					} else {
						sender.sendMessage(Commands.main + ChatColor.RED + "You don't have permission to use this command!");
					}
				}
				if (args.length == 1) {
					if (player.hasPermission("kelson.fly.others")) {
						final Player target = Bukkit.getPlayer(args[0]);
						if (target == null) {
							sender.sendMessage(Commands.main + ChatColor.RED + "Player offline");
							return true;
						}
						if (!target.getAllowFlight()) {
							sender.sendMessage(Commands.main + ChatColor.GREEN + "Fly Enabled for " + target.getName());
							target.setAllowFlight(true);
							target.sendMessage(Commands.main + ChatColor.GREEN + "Fly Enabled by " + player.getName());
						} else {
							sender.sendMessage(Commands.main + ChatColor.GREEN + "Fly Disabled for " + target.getName());
							target.setAllowFlight(false);
							target.sendMessage(Commands.main + ChatColor.GREEN + "Fly Disabled by " + player.getName());
						}
					} else {
						sender.sendMessage(Commands.main + ChatColor.RED + "You don't have permission to use this command on others!");
					}
				}
			} else {
				sender.sendMessage(Commands.main + ChatColor.RED + "Console cannot use this command!"); //Might add console usage later on
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