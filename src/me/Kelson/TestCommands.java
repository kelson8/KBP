package me.Kelson;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommands implements CommandExecutor
{
	Commands plugin;
	
	public TestCommands(Commands passedPlugin)
	{
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = (Player) sender;
		String getName = "";
		getName = player.getName();

		if(sender instanceof Player){

		if(cmd.getName().equalsIgnoreCase("test1") && sender.hasPermission("kelson.testcommands")) {
		   sender.sendMessage("Hello " + getName + " testing this out");
		   }
		} else {
			// Need to figure out how to make this part run..
			sender.sendMessage(Commands.main + ChatColor.DARK_RED + "Error:" + ChatColor.RED + "Console cannot use this command!");
		}


		return false;
	}

}
