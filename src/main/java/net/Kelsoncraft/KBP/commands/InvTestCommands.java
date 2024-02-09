package net.Kelsoncraft.KBP.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.EnumTest;
import net.Kelsoncraft.KBP.util.Messages;

public class InvTestCommands implements CommandExecutor {

	EnumTest enumTest;
    KbpMain plugin;

    public InvTestCommands(KbpMain passedPlugin) {
        this.plugin = passedPlugin;
    }
    public void test(EnumTest enumTest) {
    	this.enumTest = enumTest;
    }
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		/*
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.KBP_errormsg() + "This is only for players!");
		}*/
		
		Inventory myinv = Bukkit.createInventory(null, 9, ChatColor.RED + "Inventory test");
		
		myinv.setItem(0, new ItemStack(Material.DIAMOND, 64));
		
		
		//TODO set inv_test command to need a permission to get items out of it, this should have something to do with the InventoryClickEvent.
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("inv_test") && player.hasPermission("kbp.inv_test")) {
				player.sendMessage(Messages.KBP_Main + "Here have some diamonds!");
				player.openInventory(myinv);
			}
			
			if(cmd.getName().equalsIgnoreCase("test1")) {
				//sender.sendMessage(Messages.KBP_Main + "You have " + player.getArrowsInBody() + " arrows stuck to you.");
				//it works!
				player.openWorkbench(null, true);
			}
			
			//public String toString(String EnumTest.rankNames());
			
			if(cmd.getName().equals("ranklist")) {
				/*
				 * Works like this, next try to hook into LuckPerms and get the players rank, then print it to them 
				if(player.isOp()) {
					sender.sendMessage("Your rank is " + EnumTest.ADMIN.name);
				} else {
					sender.sendMessage("Your rank is " + EnumTest.MEMBER.name);
				}*/

				ArrayList<String> getNames = EnumTest.getNames();

				sender.sendMessage("All ranks on the server: ");
				sender.sendMessage(getNames.toString().replace("[", "").replace("]", ""));
				//sender.sendMessage(EnumTest.getNames().toString().replace("[", "").replace("]", ""));
				
				//EnumTest et1 = null;
				//String names = "";
				//et1.getName(et1.ADMIN.name());
				/*
				for (EnumTest et : EnumTest.values()) {
					//String names1 = EnumTest.getNames();
				    if (!names.isEmpty()) {
				        names += " ";
				    }
				    

				    names += et.name();
				}
				sender.sendMessage(names);
			*/
		} else {
			sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use these test commands!");
			
			}

		}
		return false;
	}
	
}
