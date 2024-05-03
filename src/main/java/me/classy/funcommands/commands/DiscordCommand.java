package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class DiscordCommand implements CommandExecutor {

    private final FunCommands plugin;

    public DiscordCommand(FunCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;
        executeDiscordCommand(player);
        return true;
    }

    private void executeDiscordCommand(Player player) {
        player.sendMessage(ChatColor.YELLOW + "Join our Discord server at: " + ChatColor.AQUA + "https://discord.com/invite/wJSUvDP9bG");
    }
}
