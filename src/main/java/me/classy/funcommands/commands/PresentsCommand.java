package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.classy.funcommands.FunCommands;

public class PresentsCommand implements CommandExecutor {

	private FunCommands plugin;
	
	public PresentsCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!isChristmas()) {
            sender.sendMessage(ChatColor.RED + "Hey it's not the time for presents anymore (or yet)!");
            return true;
        }
		else {
        sender.sendMessage(ChatColor.GREEN + "Merry Christmas! Sorry presents are unavailable right now...");
        return true;
       }
	}

    private boolean isChristmas() {
        return false;
    }
}
