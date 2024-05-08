package me.classy.funcommands.commands;

import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class tpa implements CommandExecutor {
	
	private FunCommands plugin;
	
	public tpa(FunCommands plugin) {
		this.plugin = plugin;
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            if (p.hasPermission("funcommands.tpa")) {
                try {
                    Player player = Bukkit.getPlayer(args[0]);
                    p.teleport((Entity)p);
                } catch (Exception e) {
                    sender.sendMessage("§eUsage: §b/tpa <name>");
                }
            } else {
                sender.sendMessage("§cYou don't have permission to use this command!");
            }
        } else {
            sender.sendMessage("§cOnly players can use this command.");
        }
        return true;
    }
}
