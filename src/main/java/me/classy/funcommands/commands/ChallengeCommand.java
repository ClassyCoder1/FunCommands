package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

import java.util.Random;

public class ChallengeCommand implements CommandExecutor {

    private final FunCommands plugin;
	private final String[] message = {FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-1"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-2"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-3"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-4"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-5"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-6"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-7"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-8"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-9"), FunCommands.getPlugin(FunCommands.class).getConfig().getString("challenge-10")};

    public ChallengeCommand(FunCommands plugin) {
        this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		command.getName().equalsIgnoreCase("takechallenge");
		Random random = new Random();
		int index = random.nextInt(message.length);
		sender.sendMessage(ChatColor.AQUA + "Your challenge is: " + ChatColor.RED + message[index]);
		return true;
	} 
}
