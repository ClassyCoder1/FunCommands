package me.classy.funcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.FunCommands;;

public class SpeedCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public SpeedCommand(FunCommands plugin) {
		this.plugin = plugin;
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("funcommands.speed")) {
            player.sendMessage("You don't have permission to use this command.");
            return true;
        }

        if (args.length < 2 || args.length > 3) {
            sender.sendMessage("§eUsage: §b/speed <fly|walk> <speed> [player]");
            return true;
        }

        Player targetPlayer = args.length == 3 ? Bukkit.getPlayer(args[2]) : player;

        if (targetPlayer == null || !targetPlayer.isOnline()) {
            player.sendMessage("Player not found or not online.");
            return true;
        }

        String speedType = args[0];
        float speed;

        try {
            speed = Float.parseFloat(args[1]);
        } catch (NumberFormatException e) {
            player.sendMessage("Invalid speed value.");
            return true;
        }

        if (speed < -10.0f || speed > 10.0f) {
            player.sendMessage("Speed value must be between -10.0 and 10.0.");
            return true;
        }

        if (speedType.equalsIgnoreCase("fly")) {
            targetPlayer.setFlySpeed(speed / 10);
            player.sendMessage("Fly speed set to " + speed + " for " + targetPlayer.getName());
        } else if (speedType.equalsIgnoreCase("walk")) {
            targetPlayer.setWalkSpeed(speed / 10);
            player.sendMessage("Walk speed set to " + speed + " for " + targetPlayer.getName());
        } else {
            player.sendMessage("Invalid speed type. Use 'fly' or 'walk'.");
        }

        return true;
    }
}
