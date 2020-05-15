package com.Prison.main;

import java.io.File;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Prison.commands.CmdFly;
import com.Prison.commands.CmdReport;
import com.Prison.commands.CmdWithdraw;
import com.Prison.commands.Moderation;
import com.Prison.commands.filetest;
import com.Prison.listener.DeathEvent;
import com.Prison.listener.MineEvent;
import com.Prison.listener.PlayerChat;
import com.Prison.listener.PlayerJoin;
import com.Prison.listener.ServerMOTD;

public class Main extends JavaPlugin{
	
	public void onEnable() {
	    getLogger().info("Prison is loaded.");
		registerCommands();
		registerListeners();
		setupFiles();
	}
	
	public void onDisable() {
	    getLogger().info("Prison is loaded.");
	}
	
	public void registerCommands() {
		this.getCommand("fly").setExecutor(new CmdFly());
		this.getCommand("withdraw").setExecutor(new CmdWithdraw());
		this.getCommand("report").setExecutor(new CmdReport(this));
		this.getCommand("crates").setExecutor(new Crates());
		this.getCommand("mod").setExecutor(new Moderation());
		//this.getCommand("").setExecutor(new CmdTrade());
		this.getCommand("filetest").setExecutor(new filetest(this));
	}
	
	public void registerListeners() {
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new Crates(), this);
	    pm.registerEvents(new ServerMOTD(), this);
	    pm.registerEvents(new PlayerJoin(this), this);
	    pm.registerEvents(new PlayerChat(), this);
	    pm.registerEvents(new MineEvent(), this);
		pm.registerEvents(new DeathEvent(), this);
	}
	
	public void setupFiles() {
		File dataFolder = new File(getDataFolder()+"/Player");
		if(!dataFolder.exists()) {
			getLogger().info("Woof woof! Data folder not found!");
			getLogger().info("Sparky is here to save the day!");
			dataFolder.mkdirs();
			getLogger().info("Sucessfully created Player folder!");
		} else {
			getLogger().info("[Folder] Player is found!");
		}
		
	}

}
