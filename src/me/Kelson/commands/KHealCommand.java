package me.Kelson.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class KHealCommand implements CommandExecutor{

	Main plugin;

	public KHealCommand(Main passedPlugin) 
	{
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {


		if(!(sender instanceof Player)) {
			if(cmd.getName().equalsIgnoreCase("kheal")) {
				if(args.length == 0) {
					sender.sendMessage(Messages.ConsolePlayerError());
					return true;
				}
				if(args.length == 1){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				   if(target == null){
				   	sender.sendMessage(Messages.KBP_Main + args[0] + " is not online!");
				   	return true;
				   }
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					targetPlayer.setFireTicks(0);
					targetPlayer.setFoodLevel(20);
					targetPlayer.setHealth(20.0);
					sender.sendMessage(Messages.KBP_Main + "You have healed " + targetPlayer.getName() + "!");
					targetPlayer.sendMessage(Messages.KBP_Main + "You have been healed by Console!");



				}
			}
		}


		if(sender instanceof Player) {
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("kheal")) {
				if (args.length == 0) {
					player.setFireTicks(0);
					player.setFoodLevel(20);
					player.setHealth(20.0);
					player.sendMessage(Messages.KBP_Main + "You have been healed!");
				} else if (args.length == 1) {

					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null) {
						sender.sendMessage(Messages.KBP_Main + args[0] + " is not online!");
						return true;
					}

					Player targetPlayer = player.getServer().getPlayer(args[0]);
					targetPlayer.setFireTicks(0);
					targetPlayer.setFoodLevel(20);
					targetPlayer.setHealth(20.0);
					player.sendMessage(Messages.KBP_Main + "You have healed " + targetPlayer.getName() + "!");
					targetPlayer.sendMessage(Messages.KBP_Main + "You have been healed by " + player.getName() + "!");
				}
			}
		}
		return false;
    }

}
