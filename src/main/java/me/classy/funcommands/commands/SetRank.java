package me.classy.funcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;
import me.classy.funcommands.utility.Utils;

public class SetRank implements CommandExecutor {

	private FunCommands plugin;

	public SetRank(FunCommands plugin) {
		this.plugin = plugin;
	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (player.hasPermission("funcommands.setrank")) {
                if (args.length == 0 || args.length == 1) {
                    player.sendMessage(ChatColor.RED + "Usage: /setrank <player> <rank>");
                    return false;
                }
                if (Bukkit.getPlayer(args[0]) == null) {
                    player.sendMessage(ChatColor.RED + "Could not find player '" + args[0] + "'");
                    return false;
                }
                Player target = Bukkit.getPlayer(args[0]);
                switch (args[1]) {
                    case "default":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set default");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &7" + target.getName() + "&a!"));
                        return false;
                    case "vip":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set vip");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &a[VIP] " + target.getName() + "&a!"));
                        return false;
                    case "vip+":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set vip+");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &a[VIP&6+&a] " + target.getName() + "&a!"));
                        return false;
                    case "mvp":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set mvp");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &b[MVP] " + target.getName() + "&a!"));
                        return false;
                    case "mvp+":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set mvp+");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &b[MVP&c+&b] " + target.getName() + "&a!"));
                        return false;
                    case "mvp++":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set mvp++");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &6[MVP&c++&6] " + target.getName() + "&a!"));
                        return false;
                    case "youtube":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set youtube");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &c[&fYOUTUBE&c] " + target.getName() + "&a!"));
                        return false;
                    case "gm":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set gm");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &2[GM] " + target.getName() + "&a!"));
                        return false;
                    case "admin":
                        Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + args[0] + " group set admin");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &c[ADMIN] " + target.getName() + "&a!"));
                        return false;
					case "owner":
                        Bukkit.getServer().dispatchCommand((CommandSender)  Bukkit.getConsoleSender(), "lp user " + args[0] + " group set owner");
                        player.sendMessage(Utils.colorize("&a" + target.getName() + " has been updated to &c[OWNER] " + target.getName() + "&a!"));
                        return false;
                }
                player.sendMessage(ChatColor.RED + "'" + args[1] + "' is not a valid rank");
                return false;
            }
        }
        return true;
    }
}
