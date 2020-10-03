package me.Kelson;

import me.Kelson.util.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commands extends JavaPlugin implements Listener, Interface{
	//The config file stuff can be in other classes by typing plugin.getConfig or just plugin.
	public final Logger logger = Logger.getLogger("Minecraft.KBP");
	public static Commands plugin;
	public static String main = ChatColor.GOLD + "[Kelsons-Plugin] " + ChatColor.GREEN;
	private String ServerRules = "http://tinyurl.com/kc-server-rules";
	private String ServerMotd = getServer().getMotd();
	private String ServerInfo = Commands.main + "Hi, the owner of this server is " + ChatColor.AQUA + "kelson8\n"
			+ ChatColor.GREEN + "The servers motd is " + ServerMotd + "\n"

			 + ChatColor.GREEN + "The servers website is " + ChatColor.AQUA + "http://tinyurl.com/pfkqoce\n"
			+ ChatColor.GREEN + "The forums is " + ChatColor.AQUA + "http://tinyurl.com/qz6fa8nn\n"
			+ ChatColor.GREEN + "Read the server rules at " + ChatColor.AQUA + "http://tinyurl.com/omgkzoe\n" ;


	public Commands(){
		
	}

	private String PMaxHealth = "20";
	private String PMinHealth = "0";
	private int PMaxHealthInt = 20;
	private int PMinHealthInt = 0;
	private int PMaxMin = PMaxHealthInt + PMinHealthInt;
	private String PMaxAndMinHealth = "Max health: " + PMaxHealth + "\n" + "Min health: " + PMinHealth;
	private String TotalHealth = PMaxAndMinHealth;
	private String TotalHealth(){
		return TotalHealth;
	}
	@SuppressWarnings("unused")
	/*
	@EventHandler
    public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		if(player.getName().equals("kelson8")){
			player.chat("Hello everyone!");
    	player.sendMessage("Read the rules at " + ServerRules +" or you can read the rules in /rules");
	    }
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event){
		Player player = event.getPlayer();
		if(player.getName().equals("kelson8")){
			player.chat("Hello everyone!");
		}
	}*/

	    @EventHandler
	      public void onPlayerInteractBlock(PlayerInteractEvent event){
		Player player = event.getPlayer();
		// Possible test this for something later.. Bukkit.getOfflinePlayers();


		if(player.getInventory().getItemInMainHand().getType() == Material.BARRIER && player.hasPermission("kelson.destroy")) {
			//player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
			player.getWorld().createExplosion(player.getTargetBlock(null, 50).getLocation(), 100);
		}
		if(player.getInventory().getItemInMainHand().getType() == Material.BEDROCK && player.hasPermission("kelson.destroy")){

			player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
		}

	    }

		@EventHandler
    	  public void onFoodChange(FoodLevelChangeEvent event)
    	  {

    		//If the player has permission or if the player is op it disables their hunger
    	    if ((event.getEntity().hasPermission("no.hunger")) || (event.getEntity().isOp())) {
    	      //event.setCancelled(true);

    	    } else {
    	      //event.setCancelled(false);
    	    }

    }

    	@EventHandler
    	public void onPlayerChat(AsyncPlayerChatEvent event) {
    		Player player = event.getPlayer();

    	      if(event.getMessage().contains(".help") && player.hasPermission("kelson.secret.commands.help")){
    	    	  player.sendMessage("Secret command usage: .help");
    	    	  event.setCancelled(true);
    	      }
    	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " Has Been Disabled!");
		//saveConfig();
		
	}
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);

		if(!(getDataFolder().exists())){
			logger.log(Level.INFO, "The folder for this plugin was not found! creating one for you");
			getDataFolder().mkdirs();
			try {
				getDataFolder().createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() +  " Has Been Enabled!");
	    this.getCommand("disablewhitelist").setExecutor(new DisablewhitelistCommand(this));
	    this.getCommand("enablewhitelist").setExecutor(new EnablewhitelistCommand(this));
	    this.getCommand("fly").setExecutor(new FlyCommand(this));
	    this.getCommand("kheal").setExecutor(new KHealCommand(this));
	    this.getCommand("test").setExecutor(new TestCommand(this));
	    this.getCommand("location").setExecutor(new LocationCommand(this));
	    this.getCommand("kelson-reload").setExecutor(new me.Kelson.util.KelsonReloadCommand(this));
	    this.getCommand("kmotd").setExecutor(new KMotdCommand(this));
	    this.getCommand("setkmotd").setExecutor(new SetKMotdCommand(this));
	    this.getCommand("playerinfo").setExecutor(new PlayerInfoCommand(this));
	    this.getCommand("god").setExecutor(new GodCommand(this));
	    this.getCommand("nv").setExecutor(new NightVisionCommand(this));
	    this.getCommand("cleareff").setExecutor(new NightVisionCommand(this));
	    this.getCommand("lightning").setExecutor(new LightningCommand(this));
		getConfig().options().copyDefaults(true);
		saveConfig();


	}
	private PluginDescriptionFile pdfFile = this.getDescription();
	private String version = pdfFile.getVersion();

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		//The "=" indicates the start of the string, the start of it is after the "{"
		String KelsonCommandUsage =
			main + "Command Usage: \n"
			+ ChatColor.YELLOW + "/kelson version\n"
			 + ChatColor.YELLOW + "/kelson-reload (You have to have permission)"
			 + ChatColor.YELLOW + "/whitelist-list";
						   
	  if(!(sender instanceof Player)){
		if(cmd.getName().equalsIgnoreCase("kelson")){
			sender.sendMessage(ServerInfo + "\n");
		  }
		if(cmd.getName().equalsIgnoreCase("kelson")){
			  
			   if(args.length == 0){
				   sender.sendMessage(main + "Command Usage: \n"
						   + ChatColor.YELLOW + "/kelson version\n"
						   + ChatColor.YELLOW + "/kelson-reload (You have to have permission)");
				          return true;
			        }

			   if(args[0].equalsIgnoreCase("version")){
				   sender.sendMessage(version);
			     }
			   String Version = Bukkit.getServer().getVersion();
			   if(cmd.getName().equals("version")){
				   sender.sendMessage(Version);
			   }
			   if(args.length >1){
				   sender.sendMessage("Too many arguments! Command help: \n" + KelsonCommandUsage);
			     }
		       }
		}
		Player player = (Player) sender;
		
		   if(cmd.getName().equalsIgnoreCase("serverinfo")){
	    	   sender.sendMessage(ServerInfo);
	       }
		   if(cmd.getName().equalsIgnoreCase("kelson")){
			  
			   if(args.length == 0){
				   sender.sendMessage(main + ChatColor.AQUA + "======Command Usage====== \n"
						   + ChatColor.YELLOW + "/kelson version\n"
						   + ChatColor.YELLOW + "/kelson cmdsNotWorking (Shows the commands not working in this plugin)\n"
						   + ChatColor.YELLOW + "/kelson testCommands (Shows the test commands in this plugin)\n"
						   + ChatColor.YELLOW + "/kelson-reload (You have to have permission)"
						   + ChatColor.AQUA + "=====Command Usage====="
						   
						   
						   );
				          return true;
			        }

			   if(args[0].equalsIgnoreCase("version")){
				   sender.sendMessage(version);
			     }
			   if(args[0].equalsIgnoreCase("cmdsNotWorking")){
				   sender.sendMessage("These are the commands that are not working: " + Messages.CommandsThatAreNotWorking);
			     }
			   if(args[0].equalsIgnoreCase("TestCommands")){
				   sender.sendMessage("These are the test commands: " + Messages.TestCommands);
			     }//If the player has too much arguments it sends them the help message
			   if(args.length >1){
				   sender.sendMessage("Too many arguments! Command help: \n" + KelsonCommandUsage);
			     }
			   String Version = Bukkit.getServer().getVersion();
			   String kbpCommandUsage = "/kbp version\n/kbp help\n";
			   if(cmd.getName().equals("kbp")){
				   if(args.length <1){
					   sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "not enough arguments! Command usage: " + kbpCommandUsage);
				   }
				   if(args.length == 1 && args[0].equalsIgnoreCase("version")){
				   sender.sendMessage(Version);
				   }
				   if(args.length >1){
					   sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "too many arguments! Command usage: " + plugin.getConfig().getString("KBPUsage")
							   .replace("%s", player.getName()));
					   
				   }
			     }
		       }


	        if(cmd.getName().equalsIgnoreCase("ipbans") && sender.hasPermission("kelson.ipbans")){
	        	
	        	sender.sendMessage("ip bans: " + Bukkit.getIPBans());
	        	return true;
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
	        			+ ChatColor.YELLOW + "-------------------------\n"
	        			
	        			);
	        	return true;
	               }
		return false;
	        }
}
