package com.Prison.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Prison.listener.PlayerJoin;

public class Main extends JavaPlugin{
	public void onEnable() {
	    getLogger().info("Survival+ is loaded.");
		registerCommands();
		registerListeners();
	}
	public void onDisable() {
	    getLogger().info("Survival+ is loaded.");
	}
	public void registerCommands() {
		//this.getCommand("").setExecutor(new Cmd());
		
	}
	public void registerListeners() {
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new PlayerJoin(), this);
		
	}

}
