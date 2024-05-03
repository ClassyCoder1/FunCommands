package me.classy.funcommands.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import me.classy.funcommands.FunCommands;

import java.util.Random;

public class FireworkCommand implements CommandExecutor {

		private final FunCommands plugin;

		public FireworkCommand(FunCommands plugin) {
			this.plugin = plugin;
		}
		
    private Color[] colors = new Color[]{
            Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GREEN, Color.LIME, Color.MAROON, Color.OLIVE, Color.ORANGE, Color.PURPLE,
            Color.RED, Color.TEAL, Color.WHITE, Color.YELLOW};

    private Random rnd = new Random();
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            if (p.hasPermission("funcommands.fly")) {
                p.sendMessage(ChatColor.GREEN + "Launched a firework!");
                Location loc = p.getLocation();
                if (loc != null) {
                    World w = loc.getWorld();
                    Firework fw = (Firework) w.spawnEntity(loc, EntityType.FIREWORK);
                    FireworkMeta fm = fw.getFireworkMeta();
                    FireworkEffect.Builder effect = FireworkEffect.builder();
                    effect.flicker((this.rnd.nextInt(10) > 2));
                    effect.trail((this.rnd.nextInt(10) > 2));
                    FireworkEffect.Type[] types = FireworkEffect.Type.values();
                    effect.with(types[this.rnd.nextInt(types.length)]);
                    int colorcnt = this.rnd.nextInt(3) + 2;
                    for (int i = 0; i < colorcnt; i++)
                        effect.withColor(this.colors[this.rnd.nextInt(this.colors.length)]);
                    fm.addEffect(effect.build());
                    fm.setPower(1);
                    fw.setFireworkMeta(fm);
                } else {
                    p.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
