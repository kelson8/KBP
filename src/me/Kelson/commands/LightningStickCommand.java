package me.Kelson.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.w3c.dom.events.Event;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class LightningStickCommand implements CommandExecutor{
    Main plugin;

    public LightningStickCommand(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	
    	if(!(sender instanceof Player)) {
    		if(cmd.getName().equalsIgnoreCase("lightningstick") && args.length == 0) {
    		sender.sendMessage(Messages.KBP_Main + "Console cannot use this command on itself!");
    		}
    		
    		if(args.length == 1) {
    			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
    			
    			if(targetPlayer == null) {
    				sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
    				return true;
    			}
    			
    			PlayerInventory targetPlayerInv = targetPlayer.getInventory();
    			ItemStack item = new ItemStack(Material.STICK);
    			ItemMeta meta = item.getItemMeta();
    			
    			targetPlayer.sendMessage(Messages.KBP_Main + "You have been given a lightning stick from console.");
    			sender.sendMessage(Messages.KBP_Main + "You have given a lightning stick to " + targetPlayer.getName() + "!");
    			
    			meta.setDisplayName("§b§lLightning §b§lRod");
    			meta.setLore(Arrays.asList("§4§lPosiden's", "§4§lFury"));
    			item.setItemMeta(meta);
    			
    			targetPlayerInv.addItem(item);
    		if(args.length > 1) {
    			sender.sendMessage(Messages.KBP_errormsg() + "Invalid usage, command usage: /ls <player>");
    			}
    		}
    	}
    		
    		if(sender instanceof Player) {
    		Player player = (Player) sender;
    		
    		if(cmd.getName().equalsIgnoreCase("lightningstick") && args.length == 0 && sender.hasPermission("kelson.lightning_rod.self")) {
    			PlayerInventory playerInv = player.getInventory();
    			
    			ItemStack item = new ItemStack(Material.STICK);
    			ItemMeta meta = item.getItemMeta();
    			
    			meta.setDisplayName("§b§lLightning §b§lRod");
    			
    			meta.setLore(Arrays.asList("§4§lPosiden's", "§4§lFury"));
    			item.setItemMeta(meta);
    			
    			playerInv.addItem(item);
    			
    			sender.sendMessage(Messages.KBP_Main + "You have given yourself a lightning rod!");
    			
    			return true;
    		}
    			
    			if (args.length == 1 && sender.hasPermission("kelson.lightning_rod")) {
    				Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
    				
        			if(targetPlayer == null) {
        				sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
        				return true;
        			}
        			ItemStack item = new ItemStack(Material.STICK);
        			ItemMeta meta = item.getItemMeta();
        			PlayerInventory targetPlayerInv = targetPlayer.getInventory();
        			
        			targetPlayer.sendMessage(Messages.KBP_Main + sender.getName() + " has given you a lightning stick!");
        			sender.sendMessage(Messages.KBP_Main + "You have given a lightning stick to " + targetPlayer.getName() + "!");
        			
        			meta.setDisplayName("§b§lLightning §b§lRod");
        			meta.setLore(Arrays.asList("§4§lPosiden's", "§4§lFury"));
        			item.setItemMeta(meta);

        			targetPlayerInv.addItem(item);
        			
        			return true;
    			}
        			
        		if(args.length > 1) {
        			sender.sendMessage(Messages.KBP_errormsg() + "Invalid usage, command usage: /ls <player>");
        			
        			return true;
        		}
        		
        		if(!(sender.hasPermission("kelson.lightning_rod"))) {
        			sender.sendMessage(Messages.NoPermissionError());
        			}
    		
    		
    	}
    	
    	
    	return false;
    }
}
