package net.Kelsoncraft.KBP.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

/**
 * @author kelson8
 *
 */

public class KbpCommands implements CommandExecutor {

	KbpMain plugin;

	public KbpCommands(KbpMain passedPlugin){
		this.plugin = passedPlugin;
	}

		@SuppressWarnings("deprecation")
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kbp")) {
			if(args.length == 0) {
			sender.sendMessage("Command usage: /kbp <reload>, /kbp <version>");
			}

			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reload")) {

					if(!(sender instanceof Player)) {
						plugin.reloadConfig();
						sender.sendMessage(Messages.KBP_Main() + "You have reloaded the KBP config.");

						if(plugin.getConfig().getBoolean("config_message") == true) {
						plugin.getServer().broadcastMessage(Messages.KBP_Main() + "Console has reloaded the KBP config.");
						return true;
						}
						
					}
					if(sender instanceof Player) {
						if(sender.hasPermission("kbp.reload")) {
						
							Player player = (Player) sender;
							plugin.reloadConfig();
							player.sendMessage(Messages.KBP_Main() + "You have reloaded the KBP config.");
							
							if(plugin.getConfig().getBoolean("config_message") == true) {
								plugin.getServer().broadcastMessage(Messages.KBP_Main() + player.getName() + " has reloaded the KBP config.");
								return true;
							}
							
							
						
						} else {
							sender.sendMessage(Messages.NoPermissionError());
						}
					}
				}
					if(args[0].equalsIgnoreCase("version")) {
						sender.sendMessage(Messages.KBP_Main() + "KBP Version: " + plugin.getDescription().getVersion());
					}
				}
			}
		return false;
		}
}
