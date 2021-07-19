package me.Kelson.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class FlySpeedCommand implements CommandExecutor {
	
	Main plugin;
	
	public FlySpeedCommand(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	
    	 //There has to be a better way to do the fly speed then doing it like this.
    	
    	if(sender instanceof Player) {
    		Player player = (Player) sender;
    		
    		if(cmd.getName().equalsIgnoreCase("flyspeed") && sender.hasPermission("kelson.flyspeed")) {
    			if(args.length == 0) {
    				sender.sendMessage(Messages.KBP_errormsg() + "Command usage: /flyspeed <number> [player]");
    				return true;
    			}
    			if(args.length == 1) {
    				//int flyspeed = 0;
    				/*for (flyspeed = 0; flyspeed <10; flyspeed++) {
    					
    				}*/
    				if(args[0].equalsIgnoreCase("1")) {
    					player.setFlySpeed(0.1f);	
    					return true;
    				}
    				
    				if(args[0].equalsIgnoreCase("2")) {
    					player.setFlySpeed(0.2f);
    				}
    				
    				if(args[0].equalsIgnoreCase("3")) {
    					player.setFlySpeed(0.3f);
    				}
    				
    				if(args[0].equalsIgnoreCase("4")) {
    					player.setFlySpeed(0.4f);
    				}
    				
    				if(args[0].equalsIgnoreCase("5")) {
    					player.setFlySpeed(0.5f);
    				}
    				
    				if(args[0].equalsIgnoreCase("6")) {
    					player.setFlySpeed(0.6f);
    				}
    				
    				if(args[0].equalsIgnoreCase("7")) {
    					player.setFlySpeed(0.7f);
    				}
    				if(args[0].equalsIgnoreCase("8")) {
    					player.setFlySpeed(0.8f);
    				}
    				if(args[0].equalsIgnoreCase("9")) {
    					player.setFlySpeed(0.9f);
    				}
    				if(args[0].equalsIgnoreCase("10")) {
    					player.setFlySpeed(1.0f);
    				}
    			}
    		}
    	} else {
    		
    	}
    return false;
    }
	
}
