package me.Kelson;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.util.Messages;

public class TestCommands implements CommandExecutor
{
	Main plugin;
	
	public TestCommands(Main passedPlugin){
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = (Player) sender;
		String playerName = "";
		playerName = player.getName();

		if(sender instanceof Player){

		if(cmd.getName().equalsIgnoreCase("test1") && sender.hasPermission("kelson.testcommands")) {
		   sender.sendMessage("Hello " + playerName + " testing this out");
		   }
		} else {
			// Need to figure out how to make this part run..
			sender.sendMessage(Messages.KBP_Main + ChatColor.DARK_RED + "Error:" + ChatColor.RED + "Console cannot use this command!");
		}
		
		/*if(!(sender instanceof Player)){
		if(cmd.getName().equalsIgnoreCase("kelson")) {
			sender.sendMessage(ServerInfo + "\n");

		}
		if(cmd.getName().equalsIgnoreCase("kelson")){
			  
			   if(args.length == 0){
				   sender.sendMessage(main + "\nCommand Usage: \n"
						   + ChatColor.YELLOW + "/kelson version\n"
						   + ChatColor.YELLOW + "/kelson reload (You have to have permission)");
				          return true;
			        }

			   if(args.length == 1 && args[0].equalsIgnoreCase("version")){
				   sender.sendMessage(version);
				   return true;
			     }
			   String Version = Bukkit.getServer().getVersion();
			   if(cmd.getName().equals("version")){
				   sender.sendMessage(Version);
				   return true;
			   }
			   /* TODO Make this command work like this
			   if(args.length == 1 && args[0].equalsIgnoreCase("reload") && sender.hasPermission("kelson.reload")){
			   	plugin.reloadConfig();
			   	Bukkit.broadcastMessage(ChatColor.WHITE + sender.getName() + ChatColor.YELLOW + " has reloaded kelsons plugin's config!");
			   }*/ 
		
		
		/*
			   if(args.length >1){
				   sender.sendMessage("Too many arguments! Command help: \n" + Messages.KelsonCommandUsage());
				   return false;
			     }
		       }
		}

		Player player = (Player) sender;
		
		   if(cmd.getName().equalsIgnoreCase("serverinfo")){
	    	   sender.sendMessage(ServerInfo);
	       }
		   if(cmd.getName().equalsIgnoreCase("kelson")){
			  
			   if(args.length == 0){
				   sender.sendMessage(main + ChatColor.AQUA + "======Command Usage====== \n"
						   + ChatColor.YELLOW + "/kelson version\n"
						   + ChatColor.YELLOW + "/kelson cmdsNotWorking (Shows the commands not working in this plugin)\n"
						   + ChatColor.YELLOW + "/kelson testCommands (Shows the test commands in this plugin)\n"
						   + ChatColor.YELLOW + "/kelson-reload (You have to have permission)"
						   + ChatColor.AQUA + "=====Command Usage====="
						   
						   
						   );
				          return true;
			        }

			   if(args[0].equalsIgnoreCase("version")){
				   sender.sendMessage(version);
			     }
			   if(args[0].equalsIgnoreCase("cmdsNotWorking")){
				   sender.sendMessage("These are the commands that are not working: " + Messages.CommandsThatAreNotWorking());
			     }
			   if(args[0].equalsIgnoreCase("TestCommands")){
				   sender.sendMessage("These are the test commands: " + Messages.TestCommands());
			     }//If the player has too much arguments it sends them the help message
			   if(args.length >1){
				   sender.sendMessage("Too many arguments! Command help: \n" + Messages.KelsonCommandUsage());
			     }
			   String Version = Bukkit.getServer().getVersion();
			   String kbpCommandUsage = "/kbp version\n/kbp help\n";
			   if(cmd.getName().equals("kbp")){
				   if(args.length <1){
					   sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "not enough arguments! Command usage: " + kbpCommandUsage);
				   }
				   if(args.length == 1 && args[0].equalsIgnoreCase("version")){
				   sender.sendMessage(Version);
				   }
				   if(args.length >1){
					   sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "too many arguments! Command usage: " + plugin.getConfig().getString("KBPUsage")
							   .replace("%s", player.getName()));
					   
				   }
			     }
		       }
		       */

		            /* Test switch statements and learn to code with them later on.
            TODO get night vision command to work with switch statements.
            String nv = "";
            switch (nv){

                // case "nvon":

                case: off
                  do nightvision off for player and others

                case: on
                  do nightvision on for player and others..


            }
            */


		return false;
	}

}
