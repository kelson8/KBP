package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.util.Messages;

public class GodCommand implements CommandExecutor {
    Main plugin;

    public GodCommand(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

    	if(!(sender instanceof Player)) {
			if(cmd.getName().equalsIgnoreCase("god")) {
				if(args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Error: Console must specify a player!");
				}
				if(args.length == 1){
					sender.sendMessage(Messages.KBP_Main + ChatColor.DARK_RED + "Error: " + ChatColor.RED + 
							"Console needs to specify a player!");
				
				}
                Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
                Player target = Bukkit.getServer().getPlayer(args[1]);
				//boolean targetPlGodMode = true;
				if(args.length == 2 && args[0].equalsIgnoreCase("on")){
				
					/*targetPlGodMode = true;
					if(targetPlGodMode = true) {
						sender.sendMessage("This user already has god mode enabled!");
					}*/
					targetPlayer.setFoodLevel(20);
					targetPlayer.setHealth(20);
					targetPlayer.setInvulnerable(true);
					sender.sendMessage(Messages.KBP_Main + "You have enabled god mode for: " + targetPlayer.getName() + "!");
					targetPlayer.sendMessage(Messages.KBP_Main + "You are now invincible, Console enabled god mode for you!");
				
				}
				if (args.length == 2 && args[0].equalsIgnoreCase("off")) {
					   targetPlayer.setInvulnerable(false);
						sender.sendMessage(Messages.KBP_Main + "You have disabled god mode for: " + targetPlayer.getName() + "!");
						targetPlayer.sendMessage(Messages.KBP_Main + "You are no longer invincible, Console disabled your god mode!");
				} if (target == null) {
					sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
				}
			}
		}
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("god") && sender.hasPermission("kelson.god")) {
                    if (args.length == 0) {
                        sender.sendMessage(Messages.KBP_Main + "Error in command usage: /god <on/off>");
                        return true;
                    }

                    if(args.length == 1) {
                        if (args[0].equalsIgnoreCase("on")) {
                            player.setHealth(20);
                            player.setFoodLevel(20);
                            player.setInvulnerable(true);
                            player.sendMessage(Messages.KBP_Main + "You now have god mode enabled!");
                        } else if (args[0].equalsIgnoreCase("off")) {
                            player.setInvulnerable(false);
                            player.sendMessage(Messages.KBP_Main + "You now have god mode disabled!");
                    }
                  }
                } if(!sender.hasPermission("kelson.god")) {
                	sender.sendMessage(Messages.NoPermissionError());
                }
            }
        return false;
    }
}



