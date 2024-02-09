package net.Kelsoncraft.KBP.commands;
import org.bukkit.ChatColor;
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

public class SetKMotdCommand implements CommandExecutor{

	KbpMain plugin;
	
	public SetKMotdCommand(KbpMain passedPlugin){
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

	        if(!(sender instanceof Player)){
	                if (cmd.getName().equalsIgnoreCase("setkmotd")) {
	                   if (args.length == 0) {
	                   sender.sendMessage(ChatColor.RED + "Please specify a message!");
                return true;
	      }

	                   StringBuilder str = new StringBuilder();
	                   for (int i = 0; i < args.length; i++) {
	                	   str.append(args[i] + " ");
	                   }
	                   
	                   String motd = str.toString();
	                   plugin.getConfig().set("motd", motd);
	                   plugin.saveConfig();
	                   sender.sendMessage(ChatColor.GREEN + "MOTD set to: " + motd);
	                }
	        }

	        if(sender instanceof Player){
	        	if (cmd.getName().equalsIgnoreCase("setkmotd") && sender.hasPermission("kbp.setkmotd")) {

	        		if (args.length == 0) {
	        			sender.sendMessage(ChatColor.RED + "Please specify a message!");
	        			return true;
	        		}

	        		StringBuilder str = new StringBuilder();
	        		for (int i = 0; i < args.length; i++) {
	        			str.append(args[i] + " ");
	        		}
	        		
	        		String motd = str.toString();
	        		plugin.getConfig().set("motd", motd);
	        		plugin.saveConfig();
	        		sender.sendMessage(ChatColor.GREEN + "MOTD set to: " + motd);
	        	}
	        }
	        if (!sender.hasPermission("kbp.setmotd")){
	        	sender.sendMessage(Messages.NoPermissionError());
	        }
	     return false;
	}


}

