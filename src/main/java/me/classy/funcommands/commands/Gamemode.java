package me.classy.funcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class Gamemode implements CommandExecutor {
	
	private FunCommands plugin;

	public Gamemode(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("pinkpixel.gamemode")) {
                if (args.length == 1) {
                    String mode = args[0].toLowerCase();

                    switch (mode) {
                        case "survival":
                        case "0":
                        case "s":
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to Survival.");
							ActionBarAPI.sendActionBar(player, "§rYour current gamemode is §cSURVIVAL§r!");
                            break;
                        case "creative":
                        case "1":
                        case "c":
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to Creative.");
                            ActionBarAPI.sendActionBar(player, "§rYour current gamemode is §cCREATIVE§r!");
							break;
                        case "adventure":
                        case "2":
                        case "a":
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to Adventure.");
                            break;
                        case "spectator":
                        case "3":
                        case "sp":
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to Spectator.");
							ActionBarAPI.sendActionBar(player, "§rYour current gamemode is §cSPECTATOR§r!");
                            break;
                    }
                } else {
                    sender.sendMessage("§eUsage: §b/gm <0|1|2|3>");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a player!");
        }
        return true;
    }
}
