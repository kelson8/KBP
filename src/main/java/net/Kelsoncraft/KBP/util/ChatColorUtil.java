package net.Kelsoncraft.KBP.util;

import net.Kelsoncraft.KBP.KbpMain;
import org.bukkit.ChatColor;

public class ChatColorUtil {

    static KbpMain plugin;

    public ChatColorUtil(){

    }

    public static String format(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
