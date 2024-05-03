package me.classy.funcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class AnnouncementCommand implements CommandExecutor {
	
    private final FunCommands plugin;

    public AnnouncementCommand(FunCommands plugin) {
        this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (!(player.hasPermission("rank.admin"))) {
			player.sendMessage("§cYou have to be an ADMIN to do this.");
			return true;
		}
		
		if (args.length < 1) {
			sender.sendMessage("§eUsage: §b/announce <message>");
			return true;
		}
		
		String message = String.join(" ", args);
		Bukkit.broadcastMessage("§c[ANNOUNCEMENT] §r" + message);
		return true;
	}
}
