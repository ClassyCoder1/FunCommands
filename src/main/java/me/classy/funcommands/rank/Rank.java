package me.classy.funcommands.rank;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.classy.funcommands.utility.Utils;

public class Rank implements RankManager {
    private final Player player;

    private final String id;

    public Rank(Player player) {
        this.player = player;
        this.id = player.getUniqueId().toString();
    }

    @Override
    public String getRankPrefix() {
        if (this.player.hasPermission("rank.owner")){
            return "§c[OWNER] §c";
        }
        if (this.player.hasPermission("rank.admin")){
            return "§c[ADMIN] §c";
        }
        if (this.player.hasPermission("rank.gm")){
            return "§2[GM] §2";
		}
        if (this.player.hasPermission("rank.youtube")){
            return "§c[§fYOUTUBE§c] §c";
        }
        if (this.player.hasPermission("rank.mvp++")){
            return "§6[MVP§c++§6] §6";
        }
        if (this.player.hasPermission("rank.mvp+")){
            return "§b[MVP§c+§b] §b";
        }
        if (this.player.hasPermission("rank.mvp")){
            return "§b[MVP] §b";
        }
        if (this.player.hasPermission("rank.vip+")){
            return "§a[VIP§6+§a] §a";
        }
        if (this.player.hasPermission("rank.vip")){
            return "§a[VIP] §a";
        }
        if (this.player.hasPermission("rank.default")){
            return "§7";
        }
        return null;
    }
	
	public String getRankSuffix() {
		if (this.player.hasPermission("rank.owner")){
            return "§cOWNER";
        }
        if (this.player.hasPermission("rank.admin")){
            return "§cADMIN";
        }
        if (this.player.hasPermission("rank.gm")){
            return "§2GM";
        }
        if (this.player.hasPermission("rank.youtube")){
            return "§cYOUTUBE";
        }
        if (this.player.hasPermission("rank.mvp++")){
            return "§6MVP§c++";
        }
        if (this.player.hasPermission("rank.mvp+")){
            return "§bMVP§c+";
        }
        if (this.player.hasPermission("rank.mvp")){
            return "§bMVP";
        }
        if (this.player.hasPermission("rank.vip+")){
            return "VIP§6+";
        }
        if (this.player.hasPermission("rank.vip")){
            return "§aVIP";
        }
        if (this.player.hasPermission("rank.default")){
            return "§7Dafault";
        }
        return null;
    }

    public void sendMessage(String s) {
        this.player.sendMessage(Utils.colorize(s));
    }

    public void setRank(String rank) {
        Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "lp user " + this.player.getName() + " group set " + rank);
    }
}
