package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VaultTestCommand implements CommandExecutor {

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
            if(cmd.getName().equalsIgnoreCase("kbal") && player.hasPermission("kelson.kbal")){
                sender.sendMessage(String.format("%sYou have %s", Messages.KBP_Main(), econ.format(econ.getBalance(player))));
            }

            if(cmd.getName().equalsIgnoreCase("givemoney")) {
                if(player.hasPermission("kelson.givemoney")) {
                    // I completely forgot about the args.length lol, no wonder this kept giving me errors.
                    if (args.length == 0) {
                        sender.sendMessage(String.format("%s You did not specify a value! Please enter a number.", Messages.KBP_errormsg()));
                    }

                    if (args.length == 1) {
                        try {

                            EconomyResponse r = econ.depositPlayer(player, Double.parseDouble(args[0]));
//						double value = Double.parseDouble(args[0]);
                            // Messages.KBP_Main() +
                            sender.sendMessage(String.format("%s You have been given %s! You now have %s", Messages.KBP_Main(), econ.format(r.amount), econ.format(r.balance)));

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
}
