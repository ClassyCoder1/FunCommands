package me.classy.funcommands.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatColor;

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
		
		if (args[0] == null) {
			player.sendMessage("§eUsage: §b/funcommands <pageNumber>");
			return true;
		}
		
		if (args[0].equals("1")) {
			TextComponent lastPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[LAST PAGE]"));
			ClickEvent clickLastPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 5");
			ComponentBuilder lastComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to last page."));
			HoverEvent hoverLastPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, lastComponentPage.create());

			lastPage.setClickEvent(clickLastPage);
			lastPage.setHoverEvent(hoverLastPage);
			player.spigot().sendMessage(lastPage);
			
			TextComponent nextPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[NEXT PAGE]"));
			ClickEvent clickNextPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 2");
			ComponentBuilder nextComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to next page."));
			HoverEvent hoverNextPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, nextComponentPage.create());

			nextPage.setClickEvent(clickNextPage);
			nextPage.setHoverEvent(hoverNextPage);
			player.spigot().sendMessage(nextPage);
			
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§aFun Commands, Page 1:");
			player.sendMessage("§b/boop <player>: §eSends the player a '§b§lBoop!'§e message.");
			player.sendMessage("§b/iamtryingtobenicebutitshard <text>: §eRandomizes the capital letters in the text you provide.");
			player.sendMessage("§b/zoo: §eResponds with '§6This isn't the Zoo, it's the lobby!§e'");
			player.sendMessage("§b/fun or /funcommands: §eGives a list of all the fun commands.");
			player.sendMessage("§b/trickortreat: §eA halloween command.");
			player.sendMessage("§b/snowball: §eLaunches a snowball.");
			player.sendMessage("§b/presents: §eChristmas command. If run outside of season, it responds with '§cHey it's not the time for presents anymore (or yet)!§e'");
			player.sendMessage("§e----------------------------------------------------------------------------------------------");
			player.sendMessage("§e------------ " + lastPage.toPlainText() + " §e------------ " + nextPage.toPlainText() + " §e------------");
			player.sendMessage("§e----------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("2")) {
			TextComponent prevPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[PREVIOUS PAGE]"));
			ClickEvent clickPrevPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 1");
			ComponentBuilder prevComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to last page."));
			HoverEvent hoverPrevPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, prevComponentPage.create());

			prevPage.setClickEvent(clickPrevPage);
			prevPage.setHoverEvent(hoverPrevPage);
			player.spigot().sendMessage(prevPage);

			TextComponent nextPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[NEXT PAGE]"));
			ClickEvent clickNextPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 3");
			ComponentBuilder nextComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to next page."));
			HoverEvent hoverNextPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, nextComponentPage.create());
			
			nextPage.setClickEvent(clickNextPage);
			nextPage.setHoverEvent(hoverNextPage);
			player.spigot().sendMessage(nextPage);
			
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§aFun Commands, Page 2:");
			player.sendMessage("§b/whatsmyface: §eResponds with '§cNot today! ... also not tomorrow.§e'");
			player.sendMessage("§b/floorislava: §eResponds with '§cNot today! ... also not tomorrow.§e'");
			player.sendMessage("§b/whatdoyoudo: §eResponds with '§7Nothing.§e'");
			player.sendMessage("§b/opme: §eResponds with '§cYou are no longer OP.§e'");
			player.sendMessage("§b/mystery: §eResponds with '§6Scooby dooby doo, where are you?§e'");
			player.sendMessage("§b/rawr: §eResponds with '§7Wow, you scared me there!§e'");
			player.sendMessage("§b/removearenabrawl: §eResponds with '§fok§e'.");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§e------------ " + prevPage.toPlainText() + " §e------------ " + nextPage.toPlainText() + " §e------------");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("3")) {
			TextComponent prevPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[PREVIOUS PAGE]"));
			ClickEvent clickPrevPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 2");
			ComponentBuilder prevComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to last page."));
			HoverEvent hoverPrevPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, prevComponentPage.create());

			prevPage.setClickEvent(clickPrevPage);
			prevPage.setHoverEvent(hoverPrevPage);
			player.spigot().sendMessage(prevPage);

			TextComponent nextPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[NEXT PAGE]"));
			ClickEvent clickNextPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 4");
			ComponentBuilder nextComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to next page."));
			HoverEvent hoverNextPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, nextComponentPage.create());

			nextPage.setClickEvent(clickNextPage);
			nextPage.setHoverEvent(hoverNextPage);
			player.spigot().sendMessage(nextPage);
			
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§aFun Commands, Page 3:");
			player.sendMessage("§b/pokemon: §eResponds with '§3Gotta catch 'em all!§e");
			player.sendMessage("§b/hello or /hi: §eResponds with '§aWhy hello there.§e'");
			player.sendMessage("§b/admin: §eResponds with a random messages.");
			player.sendMessage("§b/garlicbread: §eResponds with 'Mmm, Garlic Bread'.");
			player.sendMessage("§b/thiscommandliterallydoesnothing: §eLiterally does nothing.");
			player.sendMessage("§b/takechallenge: §eGives you a random challenge.");
			player.sendMessage("§b/dupe: §eResponds with '§cGo and watch pogo!§e'");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§e------------ " + prevPage.toPlainText() + " §e------------ " + nextPage.toPlainText() + " §e------------");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("4")) {
			TextComponent prevPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[PREVIOUS PAGE]"));
			ClickEvent clickPrevPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 3");
			ComponentBuilder prevComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to last page."));
			HoverEvent hoverPrevPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, prevComponentPage.create());

			prevPage.setClickEvent(clickPrevPage);
			prevPage.setHoverEvent(hoverPrevPage);
			player.spigot().sendMessage(prevPage);

			TextComponent nextPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[NEXT PAGE]"));
			ClickEvent clickNextPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 5");
			ComponentBuilder nextComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to next page."));
			HoverEvent hoverNextPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, nextComponentPage.create());

			nextPage.setClickEvent(clickNextPage);
			nextPage.setHoverEvent(hoverNextPage);
			player.spigot().sendMessage(nextPage);
			
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§aFun Commands, Page 4:");
			player.sendMessage("§b/hack: §eResponds with '§cDon't use hacks!§e'");
			player.sendMessage("§b/happy: §eResponds with '§a" + player.getName() + "§eis happy!'");
			player.sendMessage("§b/forum: §eGives you link of the forums.");
			player.sendMessage("§b/store: §eGives you link of the store.");
			player.sendMessage("§b/discord: §eGives you link of the discord server.");
			player.sendMessage("§b/ping: §eReturns with your ping.");
			player.sendMessage("§b/announce <messages>: §eUsed to make an announcement.");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§e------------ " + prevPage.toPlainText() + " §e------------ " + nextPage.toPlainText() + " §e------------");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			return true;
		}
		
		if (args[0].equals("5")) {
			TextComponent prevPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[PREVIOUS PAGE]"));
			ClickEvent clickPrevPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 4");
			ComponentBuilder prevComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to last page."));
			HoverEvent hoverPrevPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, prevComponentPage.create());

			prevPage.setClickEvent(clickPrevPage);
			prevPage.setHoverEvent(hoverPrevPage);
			player.spigot().sendMessage(prevPage);

			TextComponent firstPage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&a[FIRST PAGE]"));
			ClickEvent clickFirstPage = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/funcommands 1");
			ComponentBuilder firstComponentPage = new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&aGo to first page."));
			HoverEvent hoverFirstPage = new HoverEvent(HoverEvent.Action.SHOW_TEXT, firstComponentPage.create());

			firstPage.setClickEvent(clickFirstPage);
			firstPage.setHoverEvent(hoverFirstPage);
			player.spigot().sendMessage(firstPage);
			
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§aFun Commands, Page 5:");
			player.sendMessage("§b/fly: §eUsed to enable or disable flight mode.");
			player.sendMessage("§b/gm <s|c|a|sp>: §eUsed to change the gamemode." + player.getName() + "§eis happy!'");
			player.sendMessage("§b/tpa <player>: §eTeleports you to the player.");
			player.sendMessage("§b/speed <fly|walk> <amount>: §eChanges your walking or flying speed.");
			player.sendMessage("§b/fw: §eLaunches a firework where you are standing, must be §aVIP §eor higher to use.");
			player.sendMessage("§b/shrug: §eSends the §6MVP§c++ §eshrug emote.");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			player.sendMessage("§e------------ " + prevPage.toPlainText() + " §e------------ " + firstPage.toPlainText() + " §e------------");
			player.sendMessage("§e---------------------------------------------------------------------------------------------");
			return true;
		}
		return true;
	}
}
