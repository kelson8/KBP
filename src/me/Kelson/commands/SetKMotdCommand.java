package me.Kelson.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class SetKMotdCommand implements CommandExecutor{

	Main plugin;
	
	public SetKMotdCommand(Main passedPlugin){
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
	        if (cmd.getName().equalsIgnoreCase("setkmotd") && sender.hasPermission("kelson.setkmotd")) {

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
	        if (!sender.hasPermission("kelson.setmotd")){
	    	sender.sendMessage(Messages.NoPermissionError());
	    }
	     return false;
	}


}

