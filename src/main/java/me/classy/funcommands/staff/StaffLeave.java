package me.classy.funcommands.staff;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.classy.funcommands.FunCommands;
import me.classy.funcommands.rank.Rank;
import me.classy.funcommands.rank.RankManager;

public class StaffLeave implements Listener {

	private FunCommands plugin;

	public StaffLeave(FunCommands plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onStaffLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
        Rank rank = new Rank(player);

		String rankPrefix = rank.getRankPrefix();

		Bukkit.broadcast("§b[STAFF] " + rankPrefix + player.getName() + " §eleft!", "staff.leave.notice");
	}
}
