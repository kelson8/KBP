package me.Kelson;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor
{
	Commands plugin;
	
	public TestCommand(Commands passedPlugin)
	{
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		
          if(sender instanceof Player) {
			sender.sendMessage("Hi");
		} else {
			sender.sendMessage("Hi console");
		}
		return false;
	}

}
