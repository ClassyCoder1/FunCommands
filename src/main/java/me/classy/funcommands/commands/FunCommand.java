package me.classy.funcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

import me.classy.funcommands.FunCommands;

public class FunCommand implements CommandExecutor {
	
	private FunCommands plugin;
	
	public FunCommand(FunCommands plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (args[0].equals("1") || args[0].equals(null)) {
			player.sendMessage("---------------------------------------------------------------------------------------------");
			player.sendMessage("Fun Commands, Page 1:");
			player.sendMessage("§b/boop <player>: §eSends the player a '§b§lBoop!'§e message.");
			player.sendMessage("§b/iamtryingtobenicebutitshard <text>: §eRandomizes the capital letters in the text you provide.");
			player.sendMessage("§b/zoo: §eResponds with '§6This isn't the Zoo, it's the lobby!§e'");
			player.sendMessage("§b/fun or /funcommands: §eGives a list of all the fun commands.");
			player.sendMessage("§b/trickortreat: §eA halloween command.");
			player.sendMessage("§b/snowball: §eLaunches a snowball.");
			player.sendMessage("§b/presents: §eChristmas command. If run outside of season, it responds with '§cHey it's not the time for presents anymore (or yet)!§e'");
			player.sendMessage("---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("2")) {
			player.sendMessage("---------------------------------------------------------------------------------------------");
			player.sendMessage("Fun Commands, Page 2:");
			player.sendMessage("§b/whatsmyface: §eResponds with '§cNot today! ... also not tomorrow.§e'");
			player.sendMessage("§b/floorislava: §eResponds with '§cNot today! ... also not tomorrow.§e'");
			player.sendMessage("§b/whatdoyoudo: §eResponds with '§7Nothing.§e'");
			player.sendMessage("§b/opme: §eResponds with '§cYou are no longer OP.§e'");
			player.sendMessage("§b/mystery: §eResponds with '§6Scooby dooby doo, where are you?§e'");
			player.sendMessage("§b/rawr: §eResponds with '§7Wow, you scared me there!§e'");
			player.sendMessage("§b/removearenabrawl: §eResponds with '§fok§e'.");
			player.sendMessage("---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("3")) {
			player.sendMessage("---------------------------------------------------------------------------------------------");
			player.sendMessage("Fun Commands, Page 3:");
			player.sendMessage("§b/pokemon: §eResponds with '§3Gotta catch 'em all!§e");
			player.sendMessage("§b/hello or /hi: §eResponds with '§aWhy hello there.§e'");
			player.sendMessage("§b/admin: §eResponds with a random messages.");
			player.sendMessage("§b/garlicbread: §eResponds with 'Mmm, Garlic Bread'.");
			player.sendMessage("§b/thiscommandliterallydoesnothing: §eLiterally does nothing.");
			player.sendMessage("§b/takechallenge: §eGives you a random challenge.");
			player.sendMessage("§b/dupe: §eResponds with '§cGo and watch pogo!§e'");
			player.sendMessage("---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("4")) {
			player.sendMessage("---------------------------------------------------------------------------------------------");
			player.sendMessage("Fun Commands, Page 4:");
			player.sendMessage("§b/hack: §eResponds with '§cDon't use hacks!§e'");
			player.sendMessage("§b/happy: §eResponds with '§a" + player.getName() + "§eis happy!'");
			player.sendMessage("§b/forum: §eGives you link of the forums.");
			player.sendMessage("§b/store: §eGives you link of the store.");
			player.sendMessage("§b/discord: §eGives you link of the discord server.");
			player.sendMessage("§b/ping: §eReturns with your ping.");
			player.sendMessage("§b/announce <messages>: §eUsed to make an announcement.");
			player.sendMessage("---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("5")) {
			player.sendMessage("---------------------------------------------------------------------------------------------");
			player.sendMessage("Fun Commands, Page 5:");
			player.sendMessage("§b/fly: §eUsed to enable or disable flight mode.");
			player.sendMessage("§b/gm <s|c|a|sp>: §eUsed to change the gamemode." + player.getName() + "§eis happy!'");
			player.sendMessage("§b/tpa <player>: §eTeleports you to the player.");
			player.sendMessage("§b/speed <fly|walk> <amount>: §eChanges your walking or flying speed.");
			player.sendMessage("§b/fw: §eLaunches a firework where you are standing, must be §aVIP §eor higher to use.");
			player.sendMessage("§b/shrug: §eSends the §6MVP§c++ §eshrug emote.");
			player.sendMessage("---------------------------------------------------------------------------------------------");
			return true;
		}
		
		
		return true;
	}
}
