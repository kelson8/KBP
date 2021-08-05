package net.Kelsoncraft.KBP.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

public class SpecialStickCommands implements CommandExecutor{

    KbpMain plugin;

    public SpecialStickCommands(KbpMain passedPlugin) {
        this.plugin = passedPlugin;
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
    //Do not commit anymore changes from this class.
		
	//Setup class to make a stick have knockback <int>, damage<int> or anything else.
	// @name: stick 
	// @param 1 enchantment
	// @param 2 int Amount of enchantment
	// @param 3 targetPlayer [optional]
		
	if(sender instanceof Player) {
		Player player = (Player) sender;
		//ItemStack stick = new ItemStack(Material.STICK);
		
		if(cmd.getName().equalsIgnoreCase("stick")) {
			if(args.length == 0) {
				sender.sendMessage(Messages.KBP_errormsg() + "Invalid command usage! /stick <enchantment> <value> [player]");
				return true;
			}
			//Figure out how to add an enchantment to an item, any enchantment name
			if(args.length == 1) {
				if(args[0].equals("sharpness")) {
					ItemStack mainHand = player.getInventory().getItemInMainHand();
				
				if(mainHand == null || mainHand.getType().equals(Material.AIR)) {
					sender.sendMessage(Messages.KBP_errormsg() + "You cannot enchant your hand!");
				} else {
					mainHand.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);
					}
				}
			} 	
			}
		}
	return false;
	}
}
