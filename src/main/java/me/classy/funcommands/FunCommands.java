package me.classy.funcommands;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;

import me.classy.funcommands.commands.*;

import java.util.ArrayList;
import java.util.List;

public class FunCommands extends JavaPlugin {
	
	public void onEnable() {
		
		getLogger().info("Registering commands...");
		
		this.getCommand("kaboom").setExecutor(new KaboomCommand(this));
		this.getCommand("boop").setExecutor(new BoopCommand(this));
		this.getCommand("gm").setExecutor(new Gamemode(this));
		this.getCommand("fly").setExecutor(new FlyCommand(this));
	    this.getCommand("iamtryingtobenicebutitshard").setExecutor(new RandomizeCapsCommand(this));
		this.getCommand("fw").setExecutor(new FireworkCommand(this));
		this.getCommand("zoo").setExecutor(new ZooCommand(this));
		this.getCommand("trickortreat").setExecutor(new TrickOrTreatCommand(this));
		this.getCommand("snowball").setExecutor(new SnowballCommand(this));
		this.getCommand("presents").setExecutor(new PresentsCommand(this));
		this.getCommand("whatsmyface").setExecutor(new WhatsMyFaceCommand(this));
		this.getCommand("whatdoyoudo").setExecutor(new WhatDoYouDoCommand(this));
		this.getCommand("floorislava").setExecutor(new FloorIsLavaCommand(this));
		this.getCommand("opme").setExecutor(new OpMeCommand(this));
		this.getCommand("rawr").setExecutor(new RawrCommand(this));
		this.getCommand("tpa").setExecutor(new tpa(this));
		this.getCommand("mystery").setExecutor(new MysteryCommand(this));
		this.getCommand("removearenabrawl").setExecutor(new RemoveArenaBrawlCommand(this));
		this.getCommand("pokemon").setExecutor(new PokemonCommand(this));
		this.getCommand("hello").setExecutor(new HelloCommand(this));
		this.getCommand("admin").setExecutor(new AdminCommand(this));
		this.getCommand("forum").setExecutor(new ForumCommand(this));
		this.getCommand("speed").setExecutor(new SpeedCommand(this));
		this.getCommand("store").setExecutor(new StoreCommand(this));
		this.getCommand("garlicbread").setExecutor(new GarlicBreadCommand(this));
		this.getCommand("ping").setExecutor(new PingCommand(this));
		this.getCommand("hack").setExecutor(new HackCommand(this));
		this.getCommand("announce").setExecutor(new AnnouncementCommand(this));
		this.getCommand("meow").setExecutor(new MeowCommand(this));
		this.getCommand("takechallenge").setExecutor(new ChallengeCommand(this));
		this.getCommand("iamveryhappy").setExecutor(new HappyCommand(this));
		
		getLogger().info("Registered commands!");
		
		getLogger().info("Initializing Gamerules...");
		
		initializeGameRules();
		
		getLogger().info("Initizlized Gamerules!");
		
		getLogger().info(ChatColor.YELLOW + "-----------------------------------------");
        getLogger().info(ChatColor.AQUA + "FunCommands plugin has been enabled!");
        getLogger().info(ChatColor.YELLOW + "-----------------------------------------");
	}

	@Override
	public void onDisable() {
		getLogger().info(ChatColor.YELLOW + "-----------------------------------------");
        getLogger().info(ChatColor.AQUA + "PinkpixelUtility plugin has been disabled!");
        getLogger().info(ChatColor.YELLOW + "-----------------------------------------");
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
}

