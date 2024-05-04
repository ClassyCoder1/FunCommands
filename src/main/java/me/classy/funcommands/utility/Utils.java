package me.classy.funcommands.utility;

import org.bukkit.ChatColor;

public class Utils {
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
