package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.classy.funcommands.FunCommands;

public class OpMeCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public OpMeCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.RED + "You are no longer OP.");
        return true;
    }
}
