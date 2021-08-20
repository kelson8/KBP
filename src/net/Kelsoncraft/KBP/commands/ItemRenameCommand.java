package net.Kelsoncraft.KBP.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import net.md_5.bungee.api.chat.hover.content.Item;

public class ItemRenameCommand implements CommandExecutor{

	KbpMain plugin;
	
	public ItemRenameCommand(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		
		//TODO make this into a working item rename command that works with colors using the & symbol.
		
		if (sender instanceof Player) {
			
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("itemrename") && sender.hasPermission("kelson.rename")) {
			//sender.sendMessage(Messages.KBP_Main + "Not implemented yet!");
			
			 //Failure, doesn't work at all.
			if (args.length == 0) {
				sender.sendMessage(Messages.KBP_errormsg() + "Invalid usage, /itemrename <name>");
				return true;
			}
			
			if (args.length == 1){// && args[0].equals(player.getInventory().getItemInMainHand().getType().toString())) {
				PlayerInventory playerinv = player.getInventory();
				ItemMeta meta = playerinv.getItemInMainHand().getItemMeta();
				ItemStack item = player.getInventory().getItemInMainHand();
				InventoryType invtype = playerinv.getType();
				
				
				//player.getInventory().getItemInMainHand().setItemMeta(meta);
				
				meta.setDisplayName(args[0]);
				return true;
				}
			
				
			if(player.getInventory().getItemInMainHand().getType() == Material.AIR) {
				sender.sendMessage(Messages.KBP_errormsg() + "You cannot use this command on air!");
			}
		
			
			//sender.sendMessage(Messages.KBP_Main + "Not implemented yet!");
		} else {
			sender.sendMessage(Messages.NoPermissionError());
			}
	}
	if (!(sender instanceof Player)) {
	
		sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this command yet!");
			
			}
		
		
		return false;
	}

}
