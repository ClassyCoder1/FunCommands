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
		if (!(sender.hasPermission("funcommands.kaboom"))) {
			sender.sendMessage("§cYou have to be an ADMIN to do this.");
			return true;
		}
		
		if (args.length == 0) {
			if (sender instanceof Player) {
				kaboomPlayer((Player) sender);
			} else {
				sender.sendMessage("§eUsage: §b/kaboom <all|playerName>");
			}
			return true;
		}
		
		if (args[0].equalsIgnoreCase("all")) {
			kaboomAllPlayer(sender);
			return true;
		}
		
		Player targetPlayer = Bukkit.getPlayer(args[0]);
		
		if (targetPlayer == null || !targetPlayer.isOnline()) {
			sender.sendMessage("§cPlayer §b" + args[0] + " §cis not online!");
			return true;
		}
		
		kaboomPlayer(targetPlayer);
		return true;
	}
	
	private void kaboomAllPlayer(CommandSender sender) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player != sender) {
				kaboomPlayer(player);
			}
		}
		sender.sendMessage("§cKaboomed all player!");
	}
	
	private void kaboomPlayer(Player target) {
		target.getWorld().strikeLightningEffect(target.getLocation());
		target.setVelocity(target.getVelocity().add(target.getLocation().getDirection().multiply(2)));
		target.sendMessage("You wad kaboomed.");
		
		sendKaboomTitle(target);
	}
	
	private void sendKaboomTitle(Player player) {
		String titleMessage = "§cKABOOM!";
		player.sendTitle(titleMessage, null);
	}
}
