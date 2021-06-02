package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.Kelson.util.Messages;

public class LightningRodCommand {
    Main plugin;

    public LightningRodCommand(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	
    	if(!(sender instanceof Player)) {
    		if(cmd.getName().equalsIgnoreCase("lightningstick") && args.length == 0) {
    		sender.sendMessage(Messages.KBP_Main + "Console cannot use this command on itself!");
    		}
    		
    		if(args.length == 1) {
    			Player player = (Player) sender;
    			
    			
    			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
    			PlayerInventory inv = targetPlayer.getInventory();
    			ItemStack lightningstick = new ItemStack(Material.STICK);
    			
    			targetPlayer.sendMessage(Messages.KBP_Main + "You have been given a lightning stick from console.");
    			inv.addItem(lightningstick); //TODO figure out how to set the item display name when given to player...
    			
    			
    		}
    		
    	}
    	
    	
    	return false;
    }
}
