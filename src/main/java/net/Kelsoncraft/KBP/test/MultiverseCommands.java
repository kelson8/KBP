package net.Kelsoncraft.KBP.test;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.ChatColorUtil;
import net.Kelsoncraft.KBP.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MultiverseCommands implements CommandExecutor {

    private final KbpMain plugin;

    public MultiverseCommands(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args){
        MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        assert core != null;
        MVWorldManager worldManager = core.getMVWorldManager();

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("getworld")) {

                if(worldManager.getMVWorld(player.getWorld()) !=null){
                    sender.sendMessage(ChatColorUtil.format(Messages.KBP_Main() + "Your current world is &6" + player.getWorld().getName() + "&r."));
                }
            }

            if(cmd.getName().equalsIgnoreCase("listworlds")){
            }

            if(cmd.getName().equalsIgnoreCase("createworld")){
                if(args.length <= 2) {
                    player.sendMessage(Messages.KBP_errormsg() + "Command usage: /createworld [name] [enviornment type {overworld, nether, end}] <seed> <structureGen>");
                }
                if(args.length == 3){
//                    sender.sendMessage("All args filled.");
                    sender.sendMessage(args[0] + " " + args[1] + " " + args[2]);
                }// Not working.
                else if (args.length >4) {
                    sender.sendMessage(Messages.KBP_errormsg() + "Too many args!");
                }
            }

        } else {
            sender.sendMessage(Messages.ConsoleCommandError());
        }

        return false;
    }

}
