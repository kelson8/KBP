package me.Kelson;

import me.Kelson.util.Events;
import me.Kelson.util.LightningRodEvent;
import me.Kelson.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener{
	//The config file stuff can be in other classes by typing plugin.getConfig or just plugin.
	public final Logger logger = Logger.getLogger("Minecraft.KBP");
	public static Main plugin;


	public Main(){
		
	}

	private void dataFolderCreateCheck() {
		if(!(getDataFolder().exists())){
			logger.log(Level.INFO, "The folder for this plugin was not found! creating one for you");
			getDataFolder().mkdirs();
			try {
				getDataFolder().createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	@SuppressWarnings("unused")
	private void disableMessage() {
		this.logger.info(pluginVersion);
	}
	
	@Override
	public void onDisable() {
		this.logger.info(pluginName + " v" + pluginVersion + " Has Been Disabled!");
		
	}
	@Override
	public void onEnable() {
		
		dataFolderCreateCheck();
		this.logger.info(pluginName + " v" + pluginVersion +  " Has Been Enabled!");
		RegisterCommands();
		RegisterEvents();
		getConfig().options().copyDefaults(true);
		saveConfig();


	}
	private PluginDescriptionFile pdfFile = this.getDescription();
	private String pluginName = pdfFile.getName();
	private String pluginVersion = pdfFile.getVersion();

	private void RegisterCommands(){
		this.getCommand("disablewhitelist").setExecutor(new DisablewhitelistCommand(this));
		this.getCommand("enablewhitelist").setExecutor(new EnablewhitelistCommand(this));
		this.getCommand("fly").setExecutor(new FlyCommand(this));
		this.getCommand("kheal").setExecutor(new KHealCommand(this));
		this.getCommand("test").setExecutor(new TestCommands(this));
		this.getCommand("location").setExecutor(new LocationCommand(this));
		this.getCommand("kelson-reload").setExecutor(new me.Kelson.util.KelsonReloadCommand(this));
		this.getCommand("kmotd").setExecutor(new KMotdCommand(this));
		this.getCommand("setkmotd").setExecutor(new SetKMotdCommand(this));
		this.getCommand("playerinfo").setExecutor(new PlayerInfoCommand(this));
		this.getCommand("god").setExecutor(new GodCommand(this));
		this.getCommand("nightvision").setExecutor(new NightVisionCommand(this));
		this.getCommand("cleareff").setExecutor(new NightVisionCommand(this));
		this.getCommand("lightning").setExecutor(new LightningCommand(this));
		this.getCommand("test1").setExecutor(new TestCommands(this));
	}

	private void RegisterEvents(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LightningRodEvent(), this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

	        if(cmd.getName().equalsIgnoreCase("ipbans") && sender.hasPermission("kelson.ipbans")){
	        	
	        	sender.sendMessage("ip bans: " + Bukkit.getIPBans());
	        }
	        if (!sender.hasPermission("kelson.ipbans")) {
	        sender.sendMessage(Messages.NoPermissionError());
			}

	        if(cmd.getName().equalsIgnoreCase("kelson-help") && sender.hasPermission("kelson.help")){
	        	sender.sendMessage(ChatColor.YELLOW + "-------------------------\n"
	        			+ ChatColor.YELLOW + "This is the help for my plugin.\n"
	        			+ ChatColor.YELLOW + "-------------------------\n"
	        			+ ChatColor.BLUE + "Command 1: " + ChatColor.GOLD + "/kheal [playername] this heals the player, heals the targetplayer if specified\n"
	        			+ ChatColor.BLUE + "Command 2: " + ChatColor.GOLD + "/fly [player] This toggles your flying on/off and if specified another player.\n"
	        			+ ChatColor.BLUE + "Command 3: " + ChatColor.GOLD + "/disablewhitelist this will disable the whitelist\n"
	        			+ ChatColor.BLUE + "Command 4: " + ChatColor.GOLD + "/enablewhitelist this will enable the whitelist\n"
	        			+ ChatColor.BLUE + "Command 5: " + ChatColor.GOLD + "/kmotd this command shows the motd to the players\n"
	        		    + ChatColor.BLUE + "Command 6: " + ChatColor.GOLD + "/location [playername] this command shows your location if no player is specified and shows a players location if a player is specified\n"
	        		    + ChatColor.BLUE + "Command 7: " + ChatColor.GOLD + "/kelson testCommands Shows the test commands in this plugin\n"
	        			+ ChatColor.YELLOW + "-------------------------\n"
	        			+ ChatColor.YELLOW + "There might be more commands that is in the plugin here later!\n"
	        			+ ChatColor.YELLOW + "-------------------------\n");
	        }
		return false;
	        }
}