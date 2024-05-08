package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

import me.classy.funcommands.FunCommands;

public class ShrugCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public ShrugCommand(FunCommands plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (!(player.hasPermission("funcommands.emojis.use"))) {
			sender.sendMessage(plugin.getConfig().getString("no-permission-messages"));
			return true;
		}
		
		player.sendMessage(ChatColor.YELLOW + "¯\\_(ツ)_/¯");
		return true;
	}
}
