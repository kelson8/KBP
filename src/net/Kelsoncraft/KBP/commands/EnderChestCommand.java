package net.Kelsoncraft.KBP.commands;

import org.bukkit.Bukkit;
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

public class EnderChestCommand implements CommandExecutor {

	KbpMain plugin;
	
	public EnderChestCommand(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			//Basic function of the ender chest command is working.
			if(cmd.getName().equalsIgnoreCase("enderchest")) {
				
				if(args.length == 0) {
				player.openInventory(player.getEnderChest());
				
				return true;
				}
			}
				if(args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null) {
						sender.sendMessage(Messages.KBP_errormsg() + "is not online!");
						return true;
					}
					
					player.openInventory(target.getEnderChest());
				}
			
		} else {
			sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this command!");
		}
		
		
		return false;
		
	}
	
	
}
