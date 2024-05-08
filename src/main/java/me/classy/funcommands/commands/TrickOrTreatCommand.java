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
        if (!isHalloween()) {
			sender.sendMessage("§cIt's not Halloween yet!");
			return true;
		}
		else {
		sender.sendMessage("Happy Halloween!");
		return true;
		}
	}

	private boolean isHalloween() {
		return plugin.getConfig().getBoolean("halloween-time");
	}
}
