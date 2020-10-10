package me.Kelson.util;
import me.Kelson.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class KelsonReloadCommand implements CommandExecutor{
	
	Main plugin;
			public KelsonReloadCommand(Main passedPlugin) {
				this.plugin = passedPlugin;
			}

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
		{
		if(cmd.getName().equalsIgnoreCase("kelson-reload")){
			
			}if(!(sender instanceof Player)){
			  plugin.reloadConfig();
			  plugin.getServer().broadcastMessage(ChatColor.WHITE + "Console" + ChatColor.YELLOW + " has reloaded kelsons plugin's config!");
			  return true;
	         } 
			Player player = (Player) sender;
			if(sender instanceof Player){

		    	   plugin.reloadConfig();
		    	   plugin.getServer().broadcastMessage(ChatColor.WHITE + player.getName() + ChatColor.YELLOW + " has reloaded kelsons plugin's config!");
          }
		  return false;
		}

}
