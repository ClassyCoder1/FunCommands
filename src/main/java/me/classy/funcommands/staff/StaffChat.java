package me.classy.funcommands.staff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;
import me.classy.funcommands.rank.Rank;
import me.classy.funcommands.rank.RankManager;

public class StaffChat implements CommandExecutor {
	
	private FunCommands plugin;
	
	public StaffChat(FunCommands plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return true;
		}
		
		if (!(player.hasPermission("staff.chat"))) {
			player.sendMessage("§cYou have to be a §9JR HELPER §cto do this.");
			return true;
		}
		
		if (args.length != 1) {
			player.sendMessage("§eUsage: §b/staffchat <message>");
			return true;
		}
		
		Rank rank = new Rank(player);

		String rankPrefix = rank.getRankPrefix();
		
		String message = String.join(" ", args);
		Bukkit.broadcast("§b[STAFF] " + rankPrefix + player.getName() + "§r:" + message, "staff.chat");
		return true;
	} 
}
