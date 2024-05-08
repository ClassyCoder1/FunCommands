package me.classy.funcommands;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;

import me.classy.funcommands.commands.AdminCommand;
import me.classy.funcommands.commands.AnnouncementCommand;
import me.classy.funcommands.commands.BoopCommand;
import me.classy.funcommands.commands.ChallengeCommand;
import me.classy.funcommands.commands.DiscordCommand;
import me.classy.funcommands.commands.DupeCommand;
import me.classy.funcommands.commands.FireworkCommand;
import me.classy.funcommands.commands.FloorIsLavaCommand;
import me.classy.funcommands.commands.ForumCommand;
import me.classy.funcommands.commands.FlyCommand;
import me.classy.funcommands.commands.Gamemode;
import me.classy.funcommands.commands.GarlicBreadCommand;
import me.classy.funcommands.commands.HackCommand;
import me.classy.funcommands.commands.HappyCommand;
import me.classy.funcommands.commands.HelloCommand;
import me.classy.funcommands.commands.KaboomCommand;
import me.classy.funcommands.commands.MysteryCommand;
import me.classy.funcommands.commands.OpMeCommand;
import me.classy.funcommands.commands.PingCommand;
import me.classy.funcommands.commands.PokemonCommand;
import me.classy.funcommands.commands.PresentsCommand;
import me.classy.funcommands.commands.RandomizeCapsCommand;
import me.classy.funcommands.commands.RawrCommand;
import me.classy.funcommands.commands.RemoveArenaBrawlCommand;
import me.classy.funcommands.commands.SnowballCommand;
import me.classy.funcommands.commands.StoreCommand;
import me.classy.funcommands.commands.SpeedCommand;
import me.classy.funcommands.commands.tpa;
import me.classy.funcommands.commands.TrickOrTreatCommand;
import me.classy.funcommands.commands.WhatDoYouDoCommand;
import me.classy.funcommands.commands.WhatsMyFaceCommand;
import me.classy.funcommands.commands.ZooCommand;
import me.classy.funcommands.commands.ThisCommandLiterallyDoesNothing;
import me.classy.funcommands.commands.FunCommand;
import me.classy.funcommands.commands.ShrugCommand;

import java.util.ArrayList;
import java.util.List;

public class FunCommands extends JavaPlugin {
	
	public void onEnable() {
		
		getLogger().info("§eLoading configuration...");
		
		this.loadConfig();
		
		getLogger().info("§aLoaded configuration!");
		
		getLogger().info("§eRegistering commands...");
		
		initializeCommands();
		
		getLogger().info("§aRegistered commands!");
		
		getLogger().info("§eInitializing Gamerules...");
		
		initializeGameRules();
		
		getLogger().info("§aInitizlized Gamerules!");
		
		getLogger().info("§e------------------------------------");
        getLogger().info("§bFunCommands plugin has been enabled!");
		getLogger().info("§bAuthor: Classy");
        getLogger().info("§e------------------------------------");
	}

	@Override
	public void onDisable() {
		getLogger().info("§e-------------------------------------");
        getLogger().info("§bFunCommands plugin has been disabled!");
		getLogger().info("§bAuthor: Classy");
        getLogger().info("§e-------------------------------------");
	}
	
	public void loadConfig() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	public void initializeGameRules() {
        List<World> worlds = Bukkit.getWorlds();
        for (World world : worlds) {
            world.setGameRuleValue("doDaylightCycle", "false");
            world.setGameRuleValue("doWeatherCycle", "false");
            world.setGameRuleValue("doFireTick", "false");
            world.setGameRuleValue("doMobSpawning", "false");
            world.setGameRuleValue("doMobLoot", "false");
            world.setGameRuleValue("doTileDrops", "false");
            world.setGameRuleValue("naturalRegeneration", "false");
            world.setGameRuleValue("showDeathMessages", "false");
            world.setGameRuleValue("randomTickSpeed", "0");
            world.setGameRuleValue("announceAdvancements", "false");
            world.setGameRuleValue("fallDamage", "false");
        }
    }
	
	public void initializeCommands() {
		getCommand("kaboom").setExecutor(new KaboomCommand(this));
		getCommand("boop").setExecutor(new BoopCommand(this));
	    getCommand("gm").setExecutor(new Gamemode(this));
		getCommand("fly").setExecutor(new FlyCommand(this));
	    getCommand("iamtryingtobenicebutitshard").setExecutor(new RandomizeCapsCommand(this));
		getCommand("fireworks").setExecutor(new FireworkCommand(this));
		getCommand("zoo").setExecutor(new ZooCommand(this));
		getCommand("trickortreat").setExecutor(new TrickOrTreatCommand(this));
	    getCommand("snowball").setExecutor(new SnowballCommand(this));
		getCommand("presents").setExecutor(new PresentsCommand(this));
	    getCommand("whatsmyface").setExecutor(new WhatsMyFaceCommand(this));
		getCommand("whatdoyoudo").setExecutor(new WhatDoYouDoCommand(this));
		getCommand("floorislava").setExecutor(new FloorIsLavaCommand(this));
		getCommand("opme").setExecutor(new OpMeCommand(this));
		getCommand("rawr").setExecutor(new RawrCommand(this));
		getCommand("tpa").setExecutor(new tpa(this));
		getCommand("mystery").setExecutor(new MysteryCommand(this));
		getCommand("removearenabrawl").setExecutor(new RemoveArenaBrawlCommand(this));
		getCommand("pokemon").setExecutor(new PokemonCommand(this));
		getCommand("hello").setExecutor(new HelloCommand(this));
		getCommand("admin").setExecutor(new AdminCommand(this));
		getCommand("forum").setExecutor(new ForumCommand(this));
		getCommand("speed").setExecutor(new SpeedCommand(this));
		getCommand("store").setExecutor(new StoreCommand(this));
		getCommand("garlicbread").setExecutor(new GarlicBreadCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("hack").setExecutor(new HackCommand(this));
		getCommand("announce").setExecutor(new AnnouncementCommand(this));
		getCommand("takechallenge").setExecutor(new ChallengeCommand(this));
		getCommand("iamveryhappy").setExecutor(new HappyCommand(this));
	    getCommand("thiscommandliterallydoesnothing").setExecutor(new ThisCommandLiterallyDoesNothing(this));
		getCommand("discord").setExecutor(new DiscordCommand(this));
		getCommand("shrug").setExecutor(new ShrugCommand(this));
		getCommand("funcommands").setExecutor(new FunCommand(this));
	}
}

