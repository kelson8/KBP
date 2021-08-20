package net.Kelsoncraft.KBP.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.Kelsoncraft.KBP.KbpMain;

public class KMotdCommand implements CommandExecutor{

	KbpMain plugin;
	
	public KMotdCommand(KbpMain passedPlugin){
		this.plugin = passedPlugin;
	}
       
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        	      if(!(sender instanceof Player)){
        	    	if (cmd.getName().equalsIgnoreCase("kmotd")) {
                            sender.sendMessage("MOTD: " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("motd"))
                            		.replace("*new_line*", "\n")
                            		.replace("%s", "Console")
                            	    .replace("%w", "")
                            	    .replace("player", ""));
                            return true;
        	    	}
        	      }
        		Player player = (Player) sender;
        		
        		//This part is the player version of the kmotd command
        		if(sender instanceof Player){
        			if (cmd.getName().equalsIgnoreCase("kmotd")) {
                        sender.sendMessage("MOTD: " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("motd"))
                        		.replace("%s", player.getName())
                        		.replace("%w", player.getWorld().getName())
                        		.replace("*new_line*", "\n"));
                        return true;
        			}
        		}
				return false;
				
        }

}