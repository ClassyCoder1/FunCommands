package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.classy.funcommands.FunCommands;

import java.util.Random;

public class AdminCommand implements CommandExecutor {
	
	private FunCommands plugin;
    private final String[] messages = {"Try Harder", "Is there anybody out there?", "You're doing great!"};
	
	public AdminCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Random random = new Random();
        int index = random.nextInt(messages.length);
        sender.sendMessage(ChatColor.RED + messages[index]);
        return true;
    }
}
