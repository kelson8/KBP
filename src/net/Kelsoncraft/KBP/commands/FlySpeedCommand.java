package net.Kelsoncraft.KBP.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

public class FlySpeedCommand implements CommandExecutor {
	
	KbpMain plugin;
	
	public FlySpeedCommand(KbpMain passedPlugin) {
		this.plugin = passedPlugin;
	}

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	
    	 //There has to be a better way to do the fly speed then doing it like this.
    	
    	if(sender instanceof Player) {
    		Player player = (Player) sender;
    		
    		if(cmd.getName().equalsIgnoreCase("flyspeed") && sender.hasPermission("kelson.flyspeed")) {
    			if(args.length == 0) {
    				sender.sendMessage(Messages.KBP_errormsg() + "Command usage: /flyspeed <number> [player]"); // Player part not implemented yet
    				return true;
    			}
    			if(args.length == 1 && args.length <2) {
    				float flyspeed = Float.parseFloat(args[0]);
    				
    				if (flyspeed > 10 || flyspeed < 1) {
    					sender.sendMessage(Messages.KBP_errormsg() + "Cannot use number above 10 or below 1!");
    					return true;
    				}
    				
    				float val = (float) (flyspeed / 10);
    				
    				player.setFlySpeed(val);
    				player.sendMessage(Messages.KBP_Main + "You have set your fly speed to: " + flyspeed);
    				
    			//Make this work later..
    			/*
    			if(args.length == 2) {
    				Player target = Bukkit.getServer().getPlayer(args[1]);
    				//if (!target.getName().equals(sender.getName())) {
    					
    				
    				target.setFlySpeed(val);
    				target.sendMessage(player.getName() + " Has set your fly speed set to: " + flyspeed);
    				
    				}*/
    			}
    		}
    	} else {
    		sender.sendMessage("Console cannot use this yet!");
    	}
    return false;
    }
	
}
