package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

import java.util.HashSet;
import java.util.Set;

public class FlyCommand implements CommandExecutor {

	private FunCommands plugin;
    private final Set<Player> flyingPlayers = new HashSet<>();
	
	public FlyCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("funcommands.fly")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            return true;
        }

        toggleFlight(player);
        return true;
    }

    private void toggleFlight(Player player) {
        if (flyingPlayers.contains(player)) {
            player.setAllowFlight(false);
            player.setFlying(false);
            flyingPlayers.remove(player);
            player.sendMessage(ChatColor.GREEN + "Flight mode disabled.");
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            flyingPlayers.add(player);
            player.sendMessage(ChatColor.GREEN + "Flight mode enabled.");
        }
    }
}
