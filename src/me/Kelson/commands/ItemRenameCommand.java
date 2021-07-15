package me.Kelson.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Kelson.Main;
import me.Kelson.util.Messages;

public class ItemRenameCommand implements CommandExecutor{

	Main plugin;
	
	public ItemRenameCommand(Main passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] arg3) {
		
		//TODO make this into a working item rename command that works with colors using the & symbol.
		
		if(cmd.getName().equalsIgnoreCase("itemrename") && sender.hasPermission("kelson.rename")) {
			sender.sendMessage(Messages.KBP_Main + "Not implemented yet!");
		} else {
			sender.sendMessage(Messages.NoPermissionError());
		}
		
		return false;
	}

}
