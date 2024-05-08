package me.classy.funcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;;

public class HappyCommand implements CommandExecutor {

	private FunCommands plugin;

	public HappyCommand(FunCommands plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return true;
		}
		
		Bukkit.broadcastMessage("§a" + player.getName() + " §eis happy!");
		return true;
	} 
}
