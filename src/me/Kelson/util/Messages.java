package me.Kelson.util;

import org.bukkit.ChatColor;

public class Messages {

	public static String NoPermissionError = ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You do not have permission to use that command!";

	public static String CommandsThatAreWorking = "\n";

	public static String CommandsThatAreNotWorking = "/location does not show up when another player is specified, only one found so far";

	public static String TestCommands = "Working on Test Commands list!";

	public static String CommandsThatAreNotWorking() {
		return CommandsThatAreNotWorking;
	}

	public static String NoPermissionError(){
		return NoPermissionError;
	}

	public static String CommandsThatAreWorking(){
		return CommandsThatAreWorking;
	}
	public static String TestCommands(){
		return TestCommands;
	}

}
