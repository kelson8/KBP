package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningCommand implements CommandExecutor {

    Commands plugin;

    public LightningCommand(Commands passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if(args.length == 0 && cmd.getName().equalsIgnoreCase("lightning") && sender.hasPermission("kelson.smite")) {
            World world = player.getWorld();
            //world.strikeLightning(player.getLocation());
            world.strikeLightning(player.getTargetBlock(null, 600).getLocation());
            //world.createExplosion(player.getTargetBlock(null, 600).getLocation(), 20);
        }
           World world = player.getWorld();
           Player targetPlayer = Bukkit.getPlayerExact(args[0]);
            if(args.length == 1 && sender.hasPermission("kelson.smite.others")){

                //targetPlayer.sendMessage(Commands.main + "You have been struck by lightning!");
                world.strikeLightning(targetPlayer.getLocation());
            }
            //TODO make this command strike lightning to a X Y Z.
            if(!sender.hasPermission("kelson.smite")){
                sender.sendMessage(ChatColor.RED + "Error: You do not have permission to use this command!");
            }





        return false;
    }
}
