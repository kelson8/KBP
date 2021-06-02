package me.Kelson;

import org.bukkit.Bukkit;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.util.Messages;

public class LightningCommand implements CommandExecutor {

    Main plugin;

    public LightningCommand(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

    	
    	if(!(sender instanceof Player)) {
    		
    		if(args.length == 0) {
    			sender.sendMessage(Messages.KBP_Main + "Error: Console must specify a player.");
    			return true;
    		}
    		if (args.length == 1) {
    			Player target = Bukkit.getServer().getPlayer(args[0]);
    			World world = target.getWorld();
    			//world.strikeLightning(target.getLocation());
    			//Too annoying, was disabled. target.sendMessage(Main.main + "Oh no, someone has struck you with lightning");
    			world.strikeLightning(target.getTargetBlock(null, 600).getLocation());
    		}
    	}
    	if (sender instanceof Player) {
        Player player = (Player) sender;
        World world = player.getWorld();
        if(args.length == 0 && cmd.getName().equalsIgnoreCase("lightning") && sender.hasPermission("kelson.smite")) {
            
            //world.strikeLightning(player.getLocation());
            world.strikeLightning(player.getTargetBlock(null, 600).getLocation());
        	
        	//world.createExplosion(player.getTargetBlock(null, 600).getLocation(), 20);
        }
           
            if(args.length == 1 && sender.hasPermission("kelson.smite.others")){
            	Player targetPlayer = Bukkit.getPlayerExact(args[0]);
                //targetPlayer.sendMessage(Commands.main + "You have been struck by lightning!");
                world.strikeLightning(targetPlayer.getLocation());
            }
            //TODO make this command strike lightning to a X Y Z.
            if(!sender.hasPermission("kelson.smite")){
                sender.sendMessage(Messages.NoPermissionError());
            }
    	}




        return false;
    }
}
