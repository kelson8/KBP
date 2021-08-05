package net.Kelsoncraft.KBP.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

public class TestCommands {

    KbpMain plugin;

    public TestCommands(KbpMain passedPlugin) {
        this.plugin = passedPlugin;
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.KBP_errormsg() + "This is only for players!");
		}
		
		
		Inventory myinv = Bukkit.createInventory(null, 9, ChatColor.RED + "Inventory test");
		
		myinv.setItem(0, new ItemStack(Material.DIAMOND, 64));
		
		
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("inv_test") && player.hasPermission("kelson.inv_test")) {
				player.sendMessage(Messages.KBP_Main + "Here have some diamonds!");
				player.openInventory(myinv);
			}
			
			
		} 
		
		
		
		return false;
	}
	
}
