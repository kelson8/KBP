package me.Kelson.util;

import me.Kelson.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.logging.Logger;

public class LogHelper {
	static Main plugin;


	public LogHelper(Main passedPlugin)
	{
		plugin = passedPlugin;
	}

	 public static final Logger LOGGER = Logger.getLogger("Minecraft.KBP");
	  
	  public static void logWarning(String msg)
	  {
	    LOGGER.warning(msg);
	  }
	  
	  public static void logSevere(String msg)
	  {
	    LOGGER.severe(msg);
	  }
	  
	  public static void logInfo(String msg)
	  {
	    LOGGER.info(msg);
	  }
	  
	  public static void logDebug(String msg)
	  {
	    if (plugin.getConfig().getBoolean("debugMode")) {
	      LOGGER.info(msg);
	    }
	  }
	  
	  public static void showInfo(String msg, CommandSender sender, ChatColor... altColor)
	  {
	    if (msg.contains("#####"))
	    {
	      String buildup = "";
	      String[] s = msg.split("#####");
	      for (String sx : s) {
	        if (sx.startsWith("[")) {
	          buildup = buildup + sx.substring(1);
	        } else {
	          buildup = buildup + sender.getName();
	        }
	      }
	      sender.sendMessage((altColor.length > 0 ? altColor[0] : ChatColor.AQUA) + buildup);
	    }
	  }
	  
	  public static void showInfos(CommandSender sender, String... msg)
	  {
	    for (String s : msg) {
	      showInfo(s, sender, new ChatColor[0]);
	    }
	  }
	  
	  public static void showWarning(String msg, CommandSender sender)
	  {
	    if (msg.contains("#####"))
	    {
	      String buildup = "";
	      String[] s = msg.split("#####");
	      for (String sx : s) {
	        if (sx.startsWith("[")) {
	          buildup = buildup + sx.substring(1);
	        } else {
	          buildup = buildup + sender.getName();
	        }
	      }
	      sender.sendMessage(ChatColor.RED + buildup);
	    }
	  }
	  
	  public static void showWarnings(CommandSender sender, String... msg)
	  {
	    for (String s : msg) {
	      showWarning(s, sender);
	    }
	  }
}
