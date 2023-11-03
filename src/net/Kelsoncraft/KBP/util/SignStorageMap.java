package net.Kelsoncraft.KBP.util;

import org.bukkit.block.Sign;

import net.Kelsoncraft.KBP.KbpMain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class SignStorageMap {
		KbpMain plugin;

		// I have no idea what the purpose of this class was.
		
		public SignStorageMap(KbpMain passedPlugin){
			this.plugin = passedPlugin;
		}

		private HashMap<String, Sign> signsStorage;
		 
	    public SignStorageMap() {
	        this.signsStorage = new HashMap<String, Sign>();
	    }
	 
	    public void makeSomethingWithSigns(String identifier) {
	        loadSigns();
	        Sign tmpSign = signsStorage.get(identifier);
	        tmpSign.setLine(0, "first line");
	        tmpSign.setLine(1, "second line");
	    }
	 
	    private void loadSigns() {
	        if (signsStorage.size() == 0) {
	            loadSignsFromSomewhere();
	        }
	    }
	 
	    private void loadSignsFromSomewhere() {
	        // Get the coordinates of Signs from somewhere and add them to signStorage.
	        // This is more efficient than checking every block of every loaded chunk for signs.
	    }
	    public void logToFile(String message) {
	    	
	        try {
	            File dataFolder = plugin.getDataFolder();
	            if(!dataFolder.exists()){
	            	
	                dataFolder.mkdir();
	            }
	 
	            File saveTo = new File(plugin.getDataFolder(), "sign_data.log");
	            if (!saveTo.exists()){
	                saveTo.createNewFile();
	            }

	            FileWriter fw = new FileWriter(saveTo, true);
	            PrintWriter pw = new PrintWriter(fw);

	            logToFile(plugin.getConfig().getString("warps"));
	            logToFile(plugin.getConfig().getString("motd"));
	            logToFile("\n N \n null");
	            
	            pw.println(message);
	            pw.flush();
	            pw.close();
	        }

	          catch (IOException e) {
	            e.printStackTrace();
	    }
	  }
}
