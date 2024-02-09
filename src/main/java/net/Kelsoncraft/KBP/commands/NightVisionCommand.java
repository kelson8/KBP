package net.Kelsoncraft.KBP.commands;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionCommand implements CommandExecutor {
    KbpMain plugin;

    public NightVisionCommand(KbpMain passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        //TODO make this command /effects and add different effects under it, also make /effects all to give you everything together.

        // This part of the command allows the console to give players nightvision
        if(!(sender instanceof Player)) {
        	
            if (cmd.getName().equalsIgnoreCase("nightvision")) {
                if(args.length == 0){
                    sender.sendMessage(Messages.KBP_errormsg() + "Command usage: /nightvision <on/off> [player]");
                }
                if(args.length == 1){
                    sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this on itself!");
                }
                
                if (args.length == 2 && args[0].equalsIgnoreCase("on")){
                	Player targetPlayer = Bukkit.getPlayerExact(args[1]);
                    
                	if (targetPlayer == null) {
						sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
						return true;
					}
                	
                    targetPlayer.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, plugin.getConfig().getInt("NightVisionTime"), 1, 
                    		false, plugin.getConfig().getBoolean("nv_particles")));
                    
                    sender.sendMessage(Messages.KBP_Main + "You have enabled night vision for " + targetPlayer.getName());
                    
                    targetPlayer.sendMessage(Messages.KBP_Main + "Your night vision has been enabled by " + sender.getName());
                }
                if(args.length == 2 && args[0].equalsIgnoreCase("off")){
                	Player targetPlayer = Bukkit.getPlayerExact(args[1]);
                	
                    targetPlayer.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    
                    sender.sendMessage(Messages.KBP_Main + "You have disabled night vision for " + targetPlayer.getName());
                    targetPlayer.sendMessage(Messages.KBP_Main + "Your night vision has been disabled by " + sender.getName());
                } 
                if (args.length > 2) {
                	sender.sendMessage(Messages.KBP_errormsg() + "Too mant arguments! Command usage: /nightvision <on/off> [player]");
                }
            }
        }

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("nightvision") && sender.hasPermission("kbp.nightvision")) {
                if (args.length == 0) {
                    player.sendMessage(Messages.KBP_errormsg() + "Command usage: /nightvision <on/off> [player]");
                }

                // If the args = 2 this part doesn't run, prevents it from being run on yourself when specifying players.
                if (args.length > 0 && args[0].equalsIgnoreCase("on") && !(args.length == 2)) {
                	
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    //player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, plugin.getConfig().getInt("NightVisionTime"), 1, 
                    		false, plugin.getConfig().getBoolean("nv_particles")));
                    sender.sendMessage(Messages.KBP_Main + "You have enabled your night vision!");


                } 
                if (args.length > 0 && args[0].equalsIgnoreCase("off") && !(args.length == 2)) {
                	
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    sender.sendMessage(Messages.KBP_Main + "You have disabled your night vision!");

                    // old if (args.length > 1 && args[1].equals(targetPlayer) && args[0].equalsIgnoreCase("on")) {
                    // old Player targetPlayer = (Player) plugin.getServer().getPlayer(args[1]);

                } 
                if (args.length == 2 && sender.hasPermission("kbp.nightvision.others")) {
                	
                	if (args[0].equalsIgnoreCase("on")) {
                		Player targetPlayer = Bukkit.getPlayerExact(args[1]);
					
                		if (targetPlayer == null) {
                			sender.sendMessage(Messages.KBP_Main + args[1] + " is not online!");
                			return true;
                		}

                		targetPlayer.removePotionEffect(PotionEffectType.NIGHT_VISION);
                		targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, plugin.getConfig().getInt("NightVisionTime"), 1, 
                				false, plugin.getConfig().getBoolean("nv_particles")));
                    
                		sender.sendMessage(Messages.KBP_Main + "You have enabled night vision for " + targetPlayer.getName());
                		targetPlayer.sendMessage(Messages.KBP_Main + "Your night vision has been enabled by " + sender.getName());


                	  }
                	if (args[0].equalsIgnoreCase("off")) {
                		Player targetPlayer = Bukkit.getPlayerExact(args[1]);

                		targetPlayer.removePotionEffect(PotionEffectType.NIGHT_VISION);
                		sender.sendMessage(Messages.KBP_Main + "You have disabled night vision for " + targetPlayer.getName());
                		targetPlayer.sendMessage(Messages.KBP_Main + "Your night vision has been disabled by " + sender.getName());

                	 }
                /* This is sending the error when i type, /nv <player> instead of /nv <on/off> [player] like it should.. disabled for now
                } else {
                    // Test to make sure this is giving the error when it should.
                    sender.sendMessage(Messages.NoPermissionErrorOth());*/
                }
            } else {
                // Test to make sure this is giving the error when it should.
                sender.sendMessage(Messages.NoPermissionError());
            }
        }
        return false;
    }
}

