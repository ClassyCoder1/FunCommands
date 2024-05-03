package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class BoopCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public BoopCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("§eUsage: §b/boop <name>");
            return true;
        }

        String targetName = args[0];
        Player target = sender.getServer().getPlayer(targetName);

        if (target != null && target.isOnline()) {
            target.sendMessage(ChatColor.LIGHT_PURPLE + "Boop!");
            sender.sendMessage(ChatColor.GREEN + "Booped " + target.getName() + "!");
        } else {
            sender.sendMessage(ChatColor.RED + "Player " + targetName + " not found or offline.");
        }
        return true;
    }
}
