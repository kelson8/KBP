package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionCommand implements CommandExecutor {
    Commands plugin;

    public NightVisionCommand(Commands passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("nv") && sender.hasPermission("kelson.nightvision")) {
            if (args.length == 0) {
                player.sendMessage(Commands.main + "Error: Command usage /nv <on/off>");
            }
            if (args.length > 0 && args[0].equalsIgnoreCase("on") && !(args.length == 2)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                //player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, plugin.getConfig().getInt("NightVisionTime"), 1));
                sender.sendMessage(Commands.main + "You have enabled your night vision!");



            } else if (args.length > 0 && args[0].equalsIgnoreCase("off") && !(args.length == 2)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                sender.sendMessage(Commands.main + "You have disabled your night vision!");

        }
            /*Player target = Bukkit.getPlayerExact(args[1]);
            if(target == null) {
                sender.sendMessage(ChatColor.GREEN + args[1] + ChatColor.RED + "is not online!");
                return true;
            }*/
            // old if (args.length > 1 && args[1].equals(targetPlayer) && args[0].equalsIgnoreCase("on")) {
                // old Player targetPlayer = (Player) plugin.getServer().getPlayer(args[1]);

                if (args.length == 2 && args[0].equalsIgnoreCase("on")) {
                    Player targetPlayer = Bukkit.getPlayerExact(args[1]);

                    targetPlayer.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, plugin.getConfig().getInt("NightVisionTime"), 1));
                    targetPlayer.sendMessage(Commands.main + "Your night vision has been enabled by " + sender.getName());
                    sender.sendMessage(Commands.main + "You have enabled night vision for " + targetPlayer.getName());


                }
                if (args.length == 2 && args[0].equalsIgnoreCase("off")) {
                    Player targetPlayer = Bukkit.getPlayerExact(args[1]);

                    targetPlayer.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    targetPlayer.sendMessage(Commands.main + "Your night vision has been disabled by " + sender.getName());
                    sender.sendMessage(Commands.main + "You have disabled night vision for " + targetPlayer.getName());

                }



        } //TODO make the nightvision command run on others, /nv <on/off> [player]
        if(cmd.getName().equalsIgnoreCase("cleareff") && sender.hasPermission("kelson.effect.clear")){
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }


        return false;
    }
}

