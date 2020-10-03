package me.Kelson;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    Commands plugin;

    public GodCommand(Commands passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

       /* if (!(sender instanceof Player)) {
            if (cmd.getName().equalsIgnoreCase("god")) {
                sender.sendMessage(ChatColor.RED + "Error: Console cannot use this command!");
                return true;
            }*/


            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("god") && sender.hasPermission("kelson.god")) {
                    if (args.length == 0) {
                        sender.sendMessage(Commands.main + "Error in command usage: /god <on/off>");
                        return true;
                    }

                    if(args.length == 1) {
                        if (args[0].equalsIgnoreCase("on")) {
                            player.setHealth(20);
                            player.setFoodLevel(20);
                            player.setInvulnerable(true);
                            player.sendMessage(Commands.main + "You now have god mode enabled!");
                        } else if (args[0].equalsIgnoreCase("off")) {
                            player.setInvulnerable(false);
                            player.sendMessage(Commands.main + "You now have god mode disabled!");

                        } else {
                            sender.sendMessage(Commands.main + ChatColor.RED + "Error: Console cannot use this command!");
                        }
                    }
                }
            }



        return false;
    }
}



