package net.Kelsoncraft.KBP.util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.Kelsoncraft.KBP.KbpMain;
public class KBPReloadCommand implements CommandExecutor{
	
	KbpMain plugin;
			public KBPReloadCommand(KbpMain passedPlugin){
				this.plugin = passedPlugin;
			}

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
		{
		if(cmd.getName().equalsIgnoreCase("kbp-reload")){
			
			}
		if(!(sender instanceof Player)){
			  plugin.reloadConfig();
			  plugin.getServer().broadcastMessage(ChatColor.WHITE + "Console" + ChatColor.YELLOW + " has reloaded the KBP config!");
			  return true;
	         } 
			Player player = (Player) sender;
			if(sender instanceof Player){

		    	   plugin.reloadConfig();
		    	   plugin.getServer().broadcastMessage(ChatColor.WHITE + player.getName() + ChatColor.YELLOW + " has reloaded the KBP config!");
          }
		  return false;
		}

}
