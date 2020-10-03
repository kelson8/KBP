package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisablewhitelistCommand implements CommandExecutor 
{
		Commands plugin;
		
		public DisablewhitelistCommand(Commands passedPlugin)
		{
			this.plugin = passedPlugin;
		}
        
		public boolean onCommand(CommandSender sender, Command cmd, 
				String CommandLabel, String[] args) {
			
		        if(sender.hasPermission("kelson.disablewhitelist"))
		        {
        	    plugin.getServer().setWhitelist(false);
                Bukkit.broadcastMessage("The whitelist has been disabled!");
		        }
			
			return false;
		}
}
