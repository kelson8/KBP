package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BossBarCommandTest {
    KbpMain plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        // This is a work in progress, I need to play around with it more and figure out
        // how to properly do this and clear the boss bar.
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("bossbar") && player.hasPermission("kelson.bossbar")) {
                //BossBar bar = Bukkit.createBossBar(ChatColor.DARK_AQUA + "KelsonCraft Server", BarColor.BLUE, BarStyle.SOLID);

                //Bukkit.createBossBar(ChatColor.DARK_AQUA + "KelsonCraft Server" , BarColor.BLUE, BarStyle.SOLID);


            }
        } else {
            sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this command!");
        }
        return false;
    }
}
