package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class ForumCommand implements CommandExecutor {
    
	private FunCommands plugin;
	
	public ForumCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        executeForumCommand(player);
        return true;
    }

    public void executeForumCommand(Player player) {
        player.sendMessage(ChatColor.YELLOW + "Visit our forum at: " + ChatColor.AQUA + ((FunCommands)FunCommands.getPlugin(FunCommands.class)).getConfig().getString("forums") + ChatColor.YELLOW + "!");
    }
}
