package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.classy.funcommands.FunCommands;

public class HelloCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public HelloCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		command.equals("hello");
		sender.sendMessage(ChatColor.GREEN + "Why hello there!");
		return true;
    }
}
