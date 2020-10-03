package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EnablewhitelistCommand implements CommandExecutor 
{
		Commands plugin;
		
		public EnablewhitelistCommand(Commands passedPlugin)
		{
			this.plugin = passedPlugin;
		}

		public boolean onCommand(CommandSender sender, Command cmd, 
				String CommandLabel, String[] args) {
			   
		        if(sender.hasPermission("kelson.enablewhitelist"))
		        {
        	    plugin.getServer().setWhitelist(true);
                Bukkit.broadcastMessage("The whitelist has been enabled!");
		        }
               
			return false;
		}
}
