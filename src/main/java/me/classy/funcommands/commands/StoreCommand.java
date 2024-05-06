package me.classy.funcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import me.classy.funcommands.FunCommands;

public class StoreCommand implements CommandExecutor {

    private final FunCommands plugin;

    public StoreCommand(FunCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        executeStoreCommand(player);
        return true;
    }

    private void executeStoreCommand(Player player) {
        player.sendMessage(ChatColor.YELLOW + "Visit our store at: " + ChatColor.AQUA + FunCommands.getPlugin(FunCommands.class).getConfig().getString("store") + ChatColor.YELLOW + "!");
    }
}
