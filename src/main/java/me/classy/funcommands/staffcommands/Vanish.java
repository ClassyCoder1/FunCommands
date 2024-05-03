package me.classy.funcommands.staffcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.classy.funcommands.FunCommands;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Vanish implements Listener {

	private Set<Player> vanishedPlayers = new HashSet();
	private FunCommands plugin;

	public Vanish(FunCommands plugin) {
		this.plugin = plugin;
		this.vanishedPlayers = vanishedPlayers;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player;
		if (cmd.getName().equalsIgnoreCase("vanish") && sender instanceof Player) {
			player = (Player)sender;
			if (this.vanishedPlayers.contains(player)) {
				this.unvanishPlayer(player);
				player.sendMessage("§aYou are no more vanished.");
			} else {
				this.vanishPlayer(player);
				player.sendMessage("§eYou have vanished!");
				ActionBarAPI.sendActionBar(player, "§rYou are currently §cVANISHED§r!");
			}

			return true;
		} else if (cmd.getName().equalsIgnoreCase("unvanish") && sender instanceof Player) {
			player = (Player)sender;
			this.unvanishPlayer(player);
			player.sendMessage("§aYou are no more vanished.");
			return true;
		} else {
			return false;
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (this.vanishedPlayers.contains(player)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
		}

	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		this.unvanishPlayer(player);
	}

	private void vanishPlayer(Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
		this.vanishedPlayers.add(player);
	}

	private void unvanishPlayer(Player player) {
		player.removePotionEffect(PotionEffectType.INVISIBILITY);
		this.vanishedPlayers.remove(player);
	}

	private void sendReminderMessages() {
		Iterator var1 = this.vanishedPlayers.iterator();

		while(var1.hasNext()) {
			Player player = (Player)var1.next();
			player.sendMessage("§eYou are still vanished. §6/unvanish §eto become visible.");
		}

		(new BukkitRunnable() {
			public void run() {
				Vanish.this.sendReminderMessages();
			}
		}).runTaskTimer(plugin, 0L, 36000L);
	}
}
