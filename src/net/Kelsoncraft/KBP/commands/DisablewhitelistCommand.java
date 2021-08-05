package net.Kelsoncraft.KBP.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

public class DisablewhitelistCommand implements CommandExecutor {
		KbpMain plugin;
		
		public DisablewhitelistCommand(KbpMain passedPlugin){
			this.plugin = passedPlugin;
		}
        
		public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
			
		        if(cmd.getName().equalsIgnoreCase("disablewhitelist") && sender.hasPermission("kelson.disablewhitelist")) {
        	    plugin.getServer().setWhitelist(false);
                Bukkit.broadcastMessage(Messages.KBP_Main + sender.getName() + " Has disabled the whitelist!");
		        }
			
			return false;
		}
}
