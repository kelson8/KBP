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
    private ChatColor rankColor;
    private String rankSuffix;
    private String rankPrefix;
    
    private EnumTest(String name, ChatColor rankColor, String rankPrefix, String rankSuffix) {
        this.name = name;
        this.rankColor = rankColor;
        this.rankPrefix = rankPrefix;
        this.rankSuffix = rankSuffix;
    }

    private String getName() {
        return name;
    }

    private ChatColor getRankColor() {
        return rankColor;
    }
    
    private String getRankPrefix() {
    	return rankPrefix;
    }
    
    private String getRankSuffix() {
    	return rankSuffix;
    }

    // Rank names
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

    // Rank Colors, I have no idea if chat color will work for this
    public static ArrayList<ChatColor> getRankColors(){
        ArrayList<ChatColor> rankColors = new ArrayList<>();
        rankColors.add(GUEST.getRankColor());
        rankColors.add(MEMBER.getRankColor());
        rankColors.add(MOD.getRankColor());
        rankColors.add(SMOD.getRankColor());
        rankColors.add(ADMIN.getRankColor());
        rankColors.add(CO_OWNER.getRankColor());
        rankColors.add(OWNER.getRankColor());

        return rankColors;
    }

    // Rank prefixes
    public static ArrayList<String> getRankPrefixes(){
        ArrayList<String> rankPrefixes = new ArrayList<>();
        rankPrefixes.add(GUEST.getRankPrefix());
        rankPrefixes.add(MEMBER.getRankPrefix());
        rankPrefixes.add(MOD.getRankPrefix());
        rankPrefixes.add(SMOD.getRankPrefix());
        rankPrefixes.add(ADMIN.getRankPrefix());
        rankPrefixes.add(CO_OWNER.getRankPrefix());
        rankPrefixes.add(OWNER.getRankPrefix());

        return rankPrefixes;
    }

    // Rank suffixes
    public static ArrayList<String> getRankSuffixes(){
        ArrayList<String> rankSuffixes = new ArrayList<>();
        rankSuffixes.add(GUEST.getRankSuffix());
        rankSuffixes.add(MEMBER.getRankSuffix());
        rankSuffixes.add(MOD.getRankSuffix());
        rankSuffixes.add(SMOD.getRankSuffix());
        rankSuffixes.add(ADMIN.getRankSuffix());
        rankSuffixes.add(CO_OWNER.getRankSuffix());
        rankSuffixes.add(OWNER.getRankSuffix());

        return rankSuffixes;
    }
    
    public ArrayList<String> getNames;
    
    //private String names;
    //private static Map<String, names> map = new HashMap<String, names>();

    EnumTest() {
    	
    }
    
    //TODO figure out how to get this to work in this class and other classes.
    
}