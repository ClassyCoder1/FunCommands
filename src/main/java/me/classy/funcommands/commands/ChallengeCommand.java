package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

import java.util.Random;

public class ChallengeCommand implements CommandExecutor {

    private final FunCommands plugin;
	private final String[] message = {"Get 100m coins in SkyBlock in 100 days.", "Win the first BedWars game of the day for next 10 days.", "Reach Pinkpixel Network Level 10 in 100 days.", "You're bored? Join the Pinkpixel Network's Discord Server.", "Joined for the first time? Play a BedWars game and win it to get started.", "Wanna become cool? Register on our website and start talking with other player."};

    public ChallengeCommand(FunCommands plugin) {
        this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		command.getName().equalsIgnoreCase("takechallenge");
		Random random = new Random();
		int index = random.nextInt(message.length);
		sender.sendMessage(ChatColor.RED + message[index]);
		return true;
	} 
}
