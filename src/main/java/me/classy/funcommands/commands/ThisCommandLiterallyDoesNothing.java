package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class ThisCommandLiterallyDoesNothing implements CommandExecutor {
	
	private FunCommands plugin;

	public ThisCommandLiterallyDoesNothing(FunCommands plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("");
			return true;
		}
		
		p.sendMessage("");
		return true;
	}
}
