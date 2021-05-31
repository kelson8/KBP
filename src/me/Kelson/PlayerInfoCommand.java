package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Kelson.util.Messages;

public class PlayerInfoCommand implements CommandExecutor {


    Main plugin;

    public PlayerInfoCommand(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {



        if(!(sender instanceof Player)){
            if(args.length == 0) {
                sender.sendMessage(Messages.KBP_Main + "Error: Console must specify a player");
            return true;
            }
            if (args.length == 1) {
                Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);

                if (targetPlayer == null) {
                    sender.sendMessage(ChatColor.GREEN + args[0] + " is not online!");
                    return true;
                }
                sender.sendMessage(ChatColor.GREEN + targetPlayer.getName() + "'s info:\n"
                        + ChatColor.GREEN + "Gamemode: " + ChatColor.AQUA + targetPlayer.getGameMode() + "\n"
                        + ChatColor.GREEN + "Location: " + ChatColor.AQUA + targetPlayer.getWorld().getName() + "\n"
                        + ChatColor.GREEN + "Op: " + ChatColor.AQUA + targetPlayer.getPlayer().isOp() + "\n"
                        + ChatColor.GREEN + "Banned: " + ChatColor.AQUA + targetPlayer.getPlayer().isBanned() + "\n"
                        + ChatColor.GREEN + "Online: " + ChatColor.AQUA + targetPlayer.getPlayer().isOnline() + "\n"
                        + ChatColor.GREEN + "Ip Address: " + ChatColor.AQUA + targetPlayer.getAddress().getAddress() + "\n"
                        + ChatColor.GREEN + "Name: " + ChatColor.AQUA + targetPlayer.getName() + "\n"
                        + ChatColor.GREEN + "Health: " + ChatColor.AQUA + targetPlayer.getHealth()
                );
            }
          }

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("playerinfo") && sender.hasPermission("kelson.playerinfo")) {
                /*Coming soon, offline players ex: type a playername that is offline such as
                 * /playerinfo offlinePlayer would then work
                 */
                if (args.length == 0) {
                    sender.sendMessage("Your player info:\n"
                            + ChatColor.GREEN + "Gamemode: " + ChatColor.AQUA + player.getGameMode() + "\n"
                            + ChatColor.GREEN + "Location: " + ChatColor.AQUA + player.getWorld().getName() + "\n"
                            + ChatColor.GREEN + "Op: " + ChatColor.AQUA + player.getPlayer().isOp() + "\n"
                            + ChatColor.GREEN + "Banned: " + ChatColor.AQUA + player.getPlayer().isBanned() + "\n"
                            + ChatColor.GREEN + "Online: " + ChatColor.AQUA + player.getPlayer().isOnline() + "\n"
                            + ChatColor.GREEN + "Ip Address: " + ChatColor.AQUA + player.getAddress().getAddress() + "\n"
                            + ChatColor.GREEN + "Name: " + ChatColor.AQUA + player.getName() + "\n"
                            + ChatColor.GREEN + "Health: " + ChatColor.AQUA + player.getHealth());
                } else if (args.length == 1 && sender.hasPermission("kelson.playerinfo.others")) {

                    Player targetPlayer = player.getServer().getPlayer(args[0]);
                    if (targetPlayer == null) {
                        sender.sendMessage(Messages.KBP_Main + ChatColor.GREEN + args[0] + " is not online!");
                        return true;
                    }
                    sender.sendMessage(ChatColor.GREEN + targetPlayer.getName() + "'s info:\n"
                            + ChatColor.GREEN + "Gamemode: " + ChatColor.AQUA + targetPlayer.getGameMode() + "\n"
                            + ChatColor.GREEN + "Location: " + ChatColor.AQUA + targetPlayer.getWorld().getName() + "\n"
                            + ChatColor.GREEN + "Op: " + ChatColor.AQUA + targetPlayer.getPlayer().isOp() + "\n"
                            + ChatColor.GREEN + "Banned: " + ChatColor.AQUA + targetPlayer.getPlayer().isBanned() + "\n"
                            + ChatColor.GREEN + "Online: " + ChatColor.AQUA + targetPlayer.getPlayer().isOnline() + "\n"
                            + ChatColor.GREEN + "Ip Address: " + ChatColor.AQUA + targetPlayer.getAddress().getAddress() + "\n"
                            + ChatColor.GREEN + "Name: " + ChatColor.AQUA + targetPlayer.getName() + "\n"
                            + ChatColor.GREEN + "Health: " + ChatColor.AQUA + targetPlayer.getHealth()
                    );
                } else {
                    sender.sendMessage(Messages.KBP_Main + ChatColor.RED + "Error: You do not have permission to run this command on others!");
                }
            }
        }
        return false;
    }
}
