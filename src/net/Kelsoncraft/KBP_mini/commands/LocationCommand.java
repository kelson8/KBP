package net.Kelsoncraft.KBP_mini.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.Kelsoncraft.KBP_mini.KbpMain;
import net.Kelsoncraft.KBP_mini.util.Messages;

public class LocationCommand implements CommandExecutor {
	
   KbpMain plugin;

   public LocationCommand(KbpMain passedPlugin) {
	this.plugin = passedPlugin;
   }

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

	if(!(sender instanceof Player)){
		if(args.length == 0){
			sender.sendMessage(Messages.ConsolePlayerError());
			return true;
		}
		if(args.length == 1){
			Player target = Bukkit.getServer().getPlayer(args[0]);
			//if the targetplayer is offline then this says "<playername> is not online!"
			if (target == null) {
				sender.sendMessage(Messages.KBP_Main() + args[0] + " is not online!");
				return true;
			}
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);

			Location loc1 = targetPlayer.getLocation();
			sender.sendMessage(ChatColor.GREEN + "The world " + targetPlayer.getName() + " is in is " + ChatColor.AQUA + "'" + targetPlayer.getWorld().getName() + "'"
					+ ChatColor.GREEN + "\nThe coords are" + "\nX: " + ChatColor.AQUA + loc1.getBlockX()
					+ ChatColor.GREEN + "\nY: " + ChatColor.AQUA + loc1.getBlockY()
					+ ChatColor.GREEN + "\nZ: " + ChatColor.AQUA + loc1.getBlockZ()
					+ ChatColor.GREEN + "\nYaw: " + ChatColor.AQUA + loc1.getYaw() + ChatColor.GREEN + " (Rotation)"
					+ ChatColor.GREEN + "\nPitch: " + ChatColor.AQUA + loc1.getPitch() + ChatColor.GREEN + " (Head angle)");
		}
	}
	
  	  if(sender instanceof Player) {
		  Player player = (Player) sender;
		  if (cmd.getName().equalsIgnoreCase("location") && player.hasPermission("kelson.location")) {
			  if (args.length == 0) {
				  Location loc = player.getLocation();
				  sender.sendMessage(ChatColor.GREEN + "The world you are in is " + ChatColor.AQUA + "'" + player.getWorld().getName() + "'" +
						  ChatColor.GREEN + " \nYour coordinates are " + "\nX: " + ChatColor.AQUA + loc.getBlockX()
						  + ChatColor.GREEN + " \nY: " + ChatColor.AQUA + loc.getBlockY()
						  + ChatColor.GREEN + " \nZ: " + ChatColor.AQUA + loc.getBlockZ()
						  + ChatColor.GREEN + "\nYaw: " + ChatColor.AQUA + loc.getYaw() + ChatColor.GREEN + " (Rotation)"
						  + ChatColor.GREEN + "\nPitch: " + ChatColor.AQUA + loc.getPitch() + ChatColor.GREEN + " (Head angle)");
				  return true;
			  }
			  if (args.length == 1 && player.hasPermission("kelson.location.others")) {

				  Player target = Bukkit.getServer().getPlayer(args[0]);
				  //if the targetplayer is offline then this says "<playername> is not online!"
				  if (target == null) {
					  sender.sendMessage(Messages.KBP_errormsg() + args[0] + " is not online!");
					  return true;
				  }
				  Player targetPlayer = player.getServer().getPlayer(args[0]);

				  Location loc1 = targetPlayer.getLocation();
				  sender.sendMessage(ChatColor.GREEN + "The world " + targetPlayer.getName() + " is in is " + ChatColor.AQUA + "'" + targetPlayer.getWorld().getName() + "'"
						  + ChatColor.GREEN + "\nThe coords are" + "\nX: " + ChatColor.AQUA + loc1.getBlockX()
						  + ChatColor.GREEN + "\nY: " + ChatColor.AQUA + loc1.getBlockY()
						  + ChatColor.GREEN + "\nZ: " + ChatColor.AQUA + loc1.getBlockZ()
						  + ChatColor.GREEN + "\nYaw: " + ChatColor.AQUA + loc1.getYaw() + ChatColor.GREEN + " (Rotation)"
						  + ChatColor.GREEN + "\nPitch: " + ChatColor.AQUA + loc1.getPitch() + ChatColor.GREEN + " (Head angle)");
			  } else {
			  	sender.sendMessage(Messages.KBP_Main() + ChatColor.RED + "Error: You do not have permission to use this on others!");
			  }
		  }
	  }
	return false;
   }
}
