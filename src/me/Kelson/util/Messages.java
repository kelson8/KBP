package me.Kelson.util;

import me.Kelson.Main;
import org.bukkit.ChatColor;

public class Messages {

	private static String NoPermissionError = Main.main + ChatColor.DARK_RED + "Error: "
			+ ChatColor.RED + "You do not have permission to use that command!";

	private static String NoPermissionErrorOth = Main.main + ChatColor.DARK_RED + "Error: "
			+ ChatColor.RED + "You do not have permission to use that command on others!";

	private static String CommandsThatAreWorking = "Mostly all commands in the list seem to be working.\n";

	private static String CommandsThatAreNotWorking = "None right now.";

	private static String TestCommands = "/test1 doesn't do much at all\n";
	private static String KelsonCommandUsage =
			Main.main + "Command Usage: \n"
					+ ChatColor.YELLOW + "/kelson version\n"
					+ ChatColor.YELLOW + "/kelson-reload (You have to have permission)"
					+ ChatColor.YELLOW + "/whitelist-list";

	public static String CommandsThatAreNotWorking() {
		return CommandsThatAreNotWorking;
	}

	public static String NoPermissionError(){
		return NoPermissionError;
	}
	public static String NoPermissionErrorOth(){
		return NoPermissionErrorOth;
	}

	public static String CommandsThatAreWorking(){
		return CommandsThatAreWorking;
	}
	public static String TestCommands(){
		return TestCommands;
	}

	public static String KelsonCommandUsage(){
		return KelsonCommandUsage;
	}


}
