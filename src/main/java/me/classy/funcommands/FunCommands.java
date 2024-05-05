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
import me.classy.funcommands.commands.SetRank;
import me.classy.funcommands.commands.ThisCommandLiterallyDoesNothing;
import me.classy.funcommands.rank.Rank;
import me.classy.funcommands.rank.RankManager;
import me.classy.funcommands.staff.StaffChat;
import me.classy.funcommands.staff.StaffJoin;
import me.classy.funcommands.staff.StaffLeave;
import me.classy.funcommands.staffcommands.Vanish;

import java.util.ArrayList;
import java.util.List;

public class FunCommands extends JavaPlugin {
	
	public void onEnable() {
		
		getLogger().info("Registering events...");
		
		getServer().getPluginManager().registerEvents(new Vanish(this), this);
		getServer().getPluginManager().registerEvents(new StaffJoin(this), this);
		getServer().getPluginManager().registerEvents(new StaffLeave(this), this);
		
		getLogger().info("Registered events!");
		
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
		this.getCommand("takechallenge").setExecutor(new ChallengeCommand(this));
		this.getCommand("iamveryhappy").setExecutor(new HappyCommand(this));
		this.getCommand("sc").setExecutor(new StaffChat(this));
		this.getCommand("setrank").setExecutor(new SetRank(this));
		this.getCommand("hi").setExecutor(new HelloCommand(this));
		this.getCommand("thiscommandliterallydoesnothing").setExecutor(new ThisCommandLiterallyDoesNothing(this));
		
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

