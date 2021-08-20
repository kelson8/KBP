package net.Kelsoncraft.KBP;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import net.Kelsoncraft.KBP.commands.EnderChestCommand;
import net.Kelsoncraft.KBP.commands.FlyCommand;
import net.Kelsoncraft.KBP.commands.FlySpeedCommand;
import net.Kelsoncraft.KBP.commands.GodCommand;
import net.Kelsoncraft.KBP.commands.ItemRenameCommand;
import net.Kelsoncraft.KBP.commands.KHealCommand;
import net.Kelsoncraft.KBP.commands.KMotdCommand;
import net.Kelsoncraft.KBP.commands.KbpCommands;
import net.Kelsoncraft.KBP.commands.LightningCommand;
import net.Kelsoncraft.KBP.commands.LightningStickCommand;
import net.Kelsoncraft.KBP.commands.LocationCommand;
import net.Kelsoncraft.KBP.commands.NightVisionCommand;
import net.Kelsoncraft.KBP.commands.PlayerInfoCommand;
import net.Kelsoncraft.KBP.commands.SetKMotdCommand;
import net.Kelsoncraft.KBP.commands.InvTestCommands;
import net.Kelsoncraft.KBP.util.Events;
import net.Kelsoncraft.KBP.util.LightningRodEvent;
import net.Kelsoncraft.KBP.util.LocalChatEvent;
import net.Kelsoncraft.KBP.util.Messages;

/**
 * 
 * @author kelson8
 *
 */

public class KbpMain extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft.KBP");
	//public static KbpMain plugin;
	
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
	
	private PluginDescriptionFile pdfFile = this.getDescription();
	private String pluginName = pdfFile.getName();
	private String pluginVersion = pdfFile.getVersion();

	private void RegisterCommands() {
		this.getCommand("fly").setExecutor(new FlyCommand(this)); // keep in mini version
		this.getCommand("kheal").setExecutor(new KHealCommand(this));
		this.getCommand("location").setExecutor(new LocationCommand(this));
		this.getCommand("kmotd").setExecutor(new KMotdCommand(this)); //remove for mini version
		this.getCommand("setkmotd").setExecutor(new SetKMotdCommand(this)); //remove for mini version
		this.getCommand("playerinfo").setExecutor(new PlayerInfoCommand(this));
		this.getCommand("god").setExecutor(new GodCommand(this));
		this.getCommand("nightvision").setExecutor(new NightVisionCommand(this));
		this.getCommand("lightning").setExecutor(new LightningCommand(this));
		this.getCommand("lightningstick").setExecutor(new LightningStickCommand(this));
		this.getCommand("itemrename").setExecutor(new ItemRenameCommand(this));
		this.getCommand("flyspeed").setExecutor(new FlySpeedCommand(this)); //remove for mini version
		this.getCommand("kbp").setExecutor(new KbpCommands(this));
		this.getCommand("enderchest").setExecutor(new EnderChestCommand(this));
		this.getCommand("inv_test").setExecutor(new InvTestCommands(this));
		this.getCommand("test1").setExecutor(new InvTestCommands(this));
		//this.getCommand("stick").setExecutor(new SpecialStickCommands(this)); //temporarily remove this command, it needs worked on.

	}

	private void RegisterEvents(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Events(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LightningRodEvent(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LocalChatEvent(this), this);
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
