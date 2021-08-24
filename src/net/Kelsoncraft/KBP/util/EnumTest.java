package net.Kelsoncraft.KBP.util;

import java.util.ArrayList;

import org.bukkit.ChatColor;

public enum EnumTest {
	
    GUEST("Guest", ChatColor.GRAY, "[Guest]", "&7"),
    MEMBER("Member", ChatColor.WHITE, "&r[Member]", ChatColor.WHITE + "&f"),
    MOD("Mod", ChatColor.DARK_PURPLE, "[Mod]", ChatColor.DARK_PURPLE + "&5"),
    SMOD("SMod", ChatColor.DARK_PURPLE, "[SMod]", ChatColor.DARK_PURPLE + "&5"),
    ADMIN("Admin", ChatColor.RED, "[Admin]", "&a"),
    CO_OWNER("Co-Owner", ChatColor.RED, "[Co-Owner]", "&a"),
    OWNER("Owner", ChatColor.DARK_RED, ChatColor.RESET + "[" + ChatColor.DARK_RED +"Owner" + ChatColor.RESET + "]", "&b"); //Possibly format like this.
    
    private String name;
    private ChatColor rankColor; //redundant, possibly not needed
    private String rankSuffix;
    private String rankPrefix;
    
    private EnumTest(String name, ChatColor rankColor, String rankPrefix, String rankSuffix) {
        this.name = name;
        this.rankColor = rankColor;
        this.rankPrefix = rankPrefix;
        this.rankSuffix = rankSuffix;
    }

    public String getName() {
        return name;
    }

    public ChatColor getRankColor() {
        return rankColor;
    }
    
    public String getRankPrefix() {
    	return rankPrefix;
    }
    
    public String getRankSuffix() {
    	return rankSuffix;
    }
    
    public static ArrayList<String> getNames() {
    	ArrayList<String> names = new ArrayList<String>();
    	names.add(GUEST.getName());
    	names.add(MEMBER.getName());
    	names.add(MOD.getName());
    	names.add(SMOD.getName());
    	names.add(ADMIN.getName());
    	names.add(CO_OWNER.getName());
    	names.add(OWNER.getName());
    	
    	return names;
    }
    
    public ArrayList<String> getName;
    
    //private String names;
    //private static Map<String, names> map = new HashMap<String, names>();

    EnumTest() {
    	
    }
    
    //TODO figure out how to get this to work in this class and other classes.
    
}