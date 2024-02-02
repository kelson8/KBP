package net.Kelsoncraft.KBP.util;

import org.bukkit.ChatColor;

import net.Kelsoncraft.KBP.KbpMain;

public class Messages{
    static KbpMain plugin;

    public Messages() {
    	
    }
    
	//public static String KBP_Main = ChatColor.GOLD + "[Kelsons-Plugin] " + ChatColor.GREEN;
    public static String KBP_Main = ChatColor.GOLD + "[KBP] " + ChatColor.GREEN;
	private static String KBP_errormsg = KBP_Main + ChatColor.DARK_RED + "Error: " + ChatColor.GREEN;
	
	//private static String ServerRules = "";
	//private static String ServerMotd = plugin.getServer().getMotd(); Broken, gives null pointer? 
	private static String ServerForum = "https://kelsoncraft.net/phpbb/";
	private static String ServerWebsite = "https://kelsoncraft.net";
	private static String ServerOwner = "kelson8";

	// private String ServerDiscord = "";
	
	private String ServerInfo = KBP_Main + "Hi, the owner of this server is " + ChatColor.AQUA + ServerOwner + "\n"
			//+ ChatColor.GREEN + "The servers motd is " + ServerMotd + "\n"
					+ ChatColor.GREEN + "The servers website is " + ChatColor.AQUA + ServerWebsite + "\n"
					+ ChatColor.GREEN + "The forums is at " + ChatColor.AQUA + ServerForum + "\n";
					//+ ChatColor.GREEN + "Read the server rules at " + ChatColor.AQUA + ServerRules + "\n";
	
	private static String NoPermissionError = KBP_Main + ChatColor.DARK_RED + "Error: "
			+ ChatColor.RED + "You do not have permission to use that command!";

	private static String NoPermissionErrorOth = KBP_Main + ChatColor.DARK_RED + "Error: "
			+ ChatColor.RED + "You do not have permission to use that command on others!";

	private static String ConsolePlayerError = KBP_errormsg + "Console must specify a player!";

	private static String TestCommands = "/test1 doesn't do much at all\n";
	private String KelsonCommandUsage =
			KBP_Main + "Command Usage: \n"
					+ ChatColor.YELLOW + "/kelson version\n"
					+ ChatColor.YELLOW + "/kelson-reload (You have to have permission)"
					+ ChatColor.YELLOW + "/whitelist-list";

	public static String NoPermissionError(){
		return NoPermissionError;
	}

	public static String NoPermissionErrorOth(){
		return NoPermissionErrorOth;
	}

	public static String TestCommands(){
		return TestCommands;
	}

	public String KelsonCommandUsage(){
		return KelsonCommandUsage;
	}
	
	public String ServerInfo() {
		return ServerInfo;
	}
	public static String ConsolePlayerError() {
		return ConsolePlayerError;
	}
	public static String KBP_errormsg() {
		return KBP_errormsg;
	}
	public static String KBP_Main() {
		return KBP_Main;
	}


}
