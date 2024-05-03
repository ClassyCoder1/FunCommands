package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.classy.funcommands.FunCommands;

public class RandomizeCapsCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public RandomizeCapsCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("§eUsage: §b/iamtryingtobenicebutitshard <text>");
            return true;
        }

        String inputText = String.join(" ", args);
        String randomizedText = randomizeCaps(inputText);
        sender.sendMessage(ChatColor.RED + "Randomized Text: " + randomizedText);
        return true;
    }

    private String randomizeCaps(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Math.random() < 0.5) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
