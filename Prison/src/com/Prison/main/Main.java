package com.Prison.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Prison.commands.CmdFly;
import com.Prison.commands.CmdWithdraw;
import com.Prison.listener.CustomPickaxe;
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
	}
	public void onDisable() {
	    getLogger().info("Prison is loaded.");
	}
	public void registerCommands() {
		this.getCommand("fly").setExecutor(new CmdFly());
		this.getCommand("withdraw").setExecutor(new CmdWithdraw());
		this.getCommand("crates").setExecutor(new Crates());
		//this.getCommand("").setExecutor(new CmdTrade());
		
	}
	public void registerListeners() {
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new Crates(), this);
	    pm.registerEvents(new ServerMOTD(), this);
	    pm.registerEvents(new PlayerJoin(), this);
	    pm.registerEvents(new PlayerChat(), this);
	    pm.registerEvents(new MineEvent(), this);
	    pm.registerEvents(new CustomPickaxe(), this);
		pm.registerEvents(new DeathEvent(), this);
	}

}
