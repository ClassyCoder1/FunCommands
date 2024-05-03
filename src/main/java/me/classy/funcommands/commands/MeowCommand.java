package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class MeowCommand implements CommandExecutor {

    private final FunCommands plugin;
	
    public MeowCommand(FunCommands plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.AQUA + "Haha, you became a cat after using this command. Contact SigmaCot on discord to get a pfp.");
        return true;
    }
}
