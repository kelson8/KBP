package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class LuckpermsTest implements CommandExecutor {
    // https://luckperms.net/wiki/Developer-API
    // https://luckperms.net/wiki/Developer-API-Usage

    // Not sure how to use this yet.

    private final KbpMain plugin;

    public LuckpermsTest(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    public static String getPlayerGroup(Player player, Collection<String> possibleGroups) {
        for (String group : possibleGroups) {
            if (player.hasPermission("group." + group)) {
                return group;
            }
        }
        return null;
    }

    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args){

        LuckPerms lp = (LuckPerms) Bukkit.getServer().getPluginManager().getPlugin("LuckPerms");

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("getgroup")){
//                getPlayerGroup(player, );

                isPlayerInGroup(player, "Owner");
//                lp.getUserManager().getUser(player.getUniqueId());

            }
        } else {
            sender.sendMessage(Messages.ConsoleCommandError());
        }

        return false;
    }

}
