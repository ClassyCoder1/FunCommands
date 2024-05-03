package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.classy.funcommands.FunCommands;

public class TrickOrTreatCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public TrickOrTreatCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.RED + "It's not Halloween yet!");
        return true;
    }
}
