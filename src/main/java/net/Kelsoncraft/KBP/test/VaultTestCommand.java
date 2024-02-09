package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VaultTestCommand implements CommandExecutor, TabCompleter {

    private final KbpMain plugin;
    private static Economy econ;

    public VaultTestCommand(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args) {
        econ = KbpMain.getEconomy();

        if (sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("kbal") && player.hasPermission("kbp.kbal")){
                sender.sendMessage(String.format("%sYou have %s", Messages.KBP_Main(), econ.format(econ.getBalance(player))));
            }

            if(cmd.getName().equalsIgnoreCase("keco")) {
                if (sender.hasPermission("kbp.eco")) {
                    // Todo Add other player support and console support.
                    if (args.length == 0) {
                        sender.sendMessage(Messages.KBP_errormsg() + "Command usage: /keco [add/remove/reset] [amount]");
                    }

                    if (args.length == 1 && args[0].equalsIgnoreCase("reset")) {
                        try {
                            EconomyResponse remove = econ.withdrawPlayer(player, econ.getBalance(player));
                            sender.sendMessage(String.format("%s you have removed %s! You now have %s", Messages.KBP_Main(), econ.format(remove.amount), econ.format(remove.balance)));

                        } catch (NumberFormatException e) {
                            sender.sendMessage(Messages.KBP_errormsg() + "That's not a number!");
                        }
                    } else if (args.length == 1) {
                        sender.sendMessage(Messages.KBP_errormsg() + "Command usage: /keco [add/remove/reset] [amount]");
                    }

                    if (args.length == 2) {
                        try {
                            if (args[0].equalsIgnoreCase("add")) {
                                EconomyResponse deposit = econ.depositPlayer(player, Double.parseDouble(args[1]));
                                sender.sendMessage(String.format("%s you have been given %s! You now have %s", Messages.KBP_Main(), econ.format(deposit.amount), econ.format(deposit.balance)));
                            }
                            if (args[0].equalsIgnoreCase("remove")) {
                                EconomyResponse remove = econ.withdrawPlayer(player, Double.parseDouble(args[1]));
                                sender.sendMessage(String.format("%s you have removed %s! You now have %s", Messages.KBP_Main(), econ.format(remove.amount), econ.format(remove.balance)));
                            }

                        } catch (NumberFormatException e) {
                            sender.sendMessage(Messages.KBP_errormsg() + "That's not a number!");
                        }
                    }
                } else {
                    player.sendMessage(Messages.NoPermissionError());
                }
            }

        } else {
            sender.sendMessage(Messages.ConsoleCommandError());
        }

        return false;
    }

    // https://www.youtube.com/watch?v=rQce_yEXSOE&list=PLfu_Bpi_zcDNEKmR82hnbv9UxQ16nUBF7&index=63
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args) {

        if(args.length == 1) {
            List<String> vaultCompletion = new ArrayList<>();
            vaultCompletion.add("give");
            vaultCompletion.add("remove");
            vaultCompletion.add("reset");
            return vaultCompletion;
        }

        return null;
    }

}
