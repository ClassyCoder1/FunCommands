package me.classy.funcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;

public class KaboomCommand implements CommandExecutor {

    private final FunCommands plugin;

    public KaboomCommand(FunCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("funcommands.kaboom")) {
            player.sendMessage("§cYou don't have permission to use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("§eUsage: §b/kaboom <name>");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if (targetPlayer == null || !targetPlayer.isOnline()) {
            player.sendMessage("§cPlayer §r" + args[0] + "§c is not online!");
            return true;
        }

        strikeLightning(targetPlayer);
		spawnTnt(targetPlayer);
        targetPlayer.sendMessage("§cKaboomed by §r" + player.getName());

		String titleMessage = "§l§cKABOOM!";
        targetPlayer.sendTitle(titleMessage, null);
		
        return true;
    }

    private void strikeLightning(Player target) {
        target.getWorld().strikeLightningEffect(target.getLocation());
    }
	
	private void spawnTnt(Player target) {
		target.getWorld().createExplosion(target.getLocation(), 5f);
	}
}
