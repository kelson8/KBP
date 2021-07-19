package me.Kelson.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.util.Messages;

public class SpecialStickCommands implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
	//Setup class to make a stick have knockback <int>, damage<int> or anything else.
	// @name: stick 
	// @param 1 enchantment
	// @param 2 int Amount of enchantment
	// @param 3 targetPlayer
		
	if(sender instanceof Player) {
		//Player player = (Player) sender;
		//ItemStack stick = new ItemStack(Material.STICK);
		
		if(cmd.getName().equalsIgnoreCase("stick")) {
			if(args.length == 0) {
				sender.sendMessage(Messages.KBP_errormsg() + "Invalid command usage! /stick <enchantment> <value> [player]");
				return true;
			}
			//Figure out how to add an enchantment to an item, any enchantment name
			if(args.length == 1) {
				
			}
		}
	}
	return false;
	}
}
