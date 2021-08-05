package net.Kelsoncraft.KBP.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

public class EnablewhitelistCommand implements CommandExecutor {
		KbpMain plugin;
		
		public EnablewhitelistCommand(KbpMain passedPlugin){
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
