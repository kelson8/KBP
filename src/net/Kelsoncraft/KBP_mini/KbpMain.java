package net.Kelsoncraft.KBP_mini;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import net.Kelsoncraft.KBP_mini.commands.FlyCommand;
import net.Kelsoncraft.KBP_mini.commands.LightningCommand;
import net.Kelsoncraft.KBP_mini.commands.LightningStickCommand;
import net.Kelsoncraft.KBP_mini.commands.LocationCommand;
import net.Kelsoncraft.KBP_mini.commands.NightVisionCommand;
import net.Kelsoncraft.KBP_mini.commands.PlayerInfoCommand;
import net.Kelsoncraft.KBP_mini.util.Events;
import net.Kelsoncraft.KBP_mini.util.LightningRodEvent;
import net.Kelsoncraft.KBP_mini.util.LocalChatEvent;
import net.Kelsoncraft.KBP_mini.util.Messages;

public class KbpMain extends JavaPlugin implements Listener{
	//The config file stuff can be in other classes by typing plugin.getConfig or just plugin.
	public final Logger logger = Logger.getLogger("Minecraft.KBP");
	public static KbpMain plugin;
	public static KbpMain instance;

	public KbpMain(){
	}
	
	/*
	 * Part of this plugin has been inspired by the IDP source code 
	 * from the old Innectis server. 
	 * https://github.com/MisterVector/Innectis-Dedicated-Plugin/
	 */

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
	
	public static KbpMain getInstance(){
		return instance;
	}
	
	private PluginDescriptionFile pdfFile = this.getDescription();
	private String pluginName = pdfFile.getName();
	private String pluginVersion = pdfFile.getVersion();

	private void RegisterCommands(){
		this.getCommand("fly").setExecutor(new FlyCommand(this));
		this.getCommand("location").setExecutor(new LocationCommand(this));
		this.getCommand("kelson-reload").setExecutor(new net.Kelsoncraft.KBP_mini.util.KelsonReloadCommand(this));
		this.getCommand("playerinfo").setExecutor(new PlayerInfoCommand(this));
		this.getCommand("nightvision").setExecutor(new NightVisionCommand(this));
		this.getCommand("lightning").setExecutor(new LightningCommand(this));
		this.getCommand("lightningstick").setExecutor(new LightningStickCommand(this));
	}

	private void RegisterEvents(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LightningRodEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LocalChatEvent(), this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

	        if(cmd.getName().equalsIgnoreCase("ipbans") && sender.hasPermission("kelson.ipbans")){
	        	sender.sendMessage("ip bans: " + Bukkit.getIPBans());

	        } 
	        
	        if (!sender.hasPermission("kelson.ipbans")) {
	        sender.sendMessage(Messages.NoPermissionError());
			}

		return false;
	        }
}
