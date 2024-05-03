package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.classy.funcommands.FunCommands;

public class PingCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public PingCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;
        int ping = getPing(player);

        player.sendMessage(ChatColor.GREEN + "Your ping: " + ping + "ms");
        return true;
    }

    private int getPing(Player player) {
        int ping = 0;

        try {
            long startTime = System.currentTimeMillis();
            Plugin plugin = null;
            player.sendPluginMessage(plugin, "BungeeCord", new byte[0]);
            long endTime = System.currentTimeMillis();
            ping = (int) (endTime - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ping;
    }
}
