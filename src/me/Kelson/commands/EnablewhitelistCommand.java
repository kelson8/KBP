package me.Kelson.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class EnablewhitelistCommand implements CommandExecutor {
		Main plugin;
		
		public EnablewhitelistCommand(Main passedPlugin){
			this.plugin = passedPlugin;
		}

		public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
			   
		        if(cmd.getName().equalsIgnoreCase("enablewhitelist") && sender.hasPermission("kelson.enablewhitelist")) {
        	    plugin.getServer().setWhitelist(true);
                Bukkit.broadcastMessage(Messages.KBP_Main + sender.getName() + " Has enabled the whitelist!");
		        }
               
			return false;
		}
}
