package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConfigTest implements CommandExecutor {
    public KbpMain plugin;


    public ConfigTest(KbpMain passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        // Will this store multiple uuids or just one and keep replacing it?
        // I'm going to have to test this and see if i got this right when i get home using tlauncher and an alt.
        // This is storing the uuid but returning null on a server restart, I wonder why.


        if (cmd.getName().equalsIgnoreCase("configtest1")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                // This below didn't work.
                //PlayerInfo playerinfo = new PlayerInfo(UUID playerUUID);

                // I have no idea if the code below is the proper way to make an arraylist for players.
                ArrayList<String> playerUuidList = new ArrayList<String>();
                playerUuidList.add(player.getUniqueId().toString().replace("[", "").replace("]", ""));
                playerUuidList.add(player.getName().replace("[", "").replace("]", ""));
                //ArrayList<String> playerNameList = new ArrayList<String>();
                //playerUuidList.add(player.getUniqueId().toString().replace("[", "").replace("]", ""));
                //playerNameList.add(player.getName().replace("[", "").replace("]", ""));


                //sender.sendMessage(playerList.toString());

                sender.sendMessage(Messages.KBP_Main() + "Hello player %s".replace("%s", player.getName()));
                sender.sendMessage("Stored name and uuid: " + plugin.getCustomConfig().getString("player"));

                //sender.sendMessage(playerUuidList.toString().replace("[", "").replace("]", ""));

                plugin.getCustomConfig().set("player", playerUuidList);
                plugin.saveCustomConfig();

                //plugin.getCustomConfig().set("player.", player.getUniqueId().toString());

            } else {
                sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this command!");
            }
        }

        if (cmd.getName().equalsIgnoreCase("configtest2")) {
            Player player = (Player) sender;

            //List<String> bList = plugin.getConfig().getStringList("player");
            //player.sendMessage(Messages.KBP_Main() + "Stored uuid: " + bList);

            // This works but won't show up on a server restart
            player.sendMessage(Messages.KBP_Main() + "Stored uuid: " + plugin.getCustomConfig().getString("player"));

        }

        //if (plugin.getDataFolder().exists())
            //plugin.getDataFolder().createNewFile();
        //plugin.getDataFolder().createNewFile()

        return false;
    }
}
