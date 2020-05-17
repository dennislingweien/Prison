package com.Prison.main;

import java.io.File;
import java.lang.reflect.Field;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Prison.commands.CmdClearChat;
import com.Prison.commands.CmdCustomEnchant;
import com.Prison.commands.CmdFly;
import com.Prison.commands.CmdWithdraw;
import com.Prison.commands.filetest;
import com.Prison.listener.DeathEvent;
import com.Prison.listener.MineEvent;
import com.Prison.listener.PlayerJoin;
import com.Prison.listener.ServerMOTD;


public class Main extends JavaPlugin{
	
	private static Main instance;
	
	public void onEnable() {
	    getLogger().info("Prison is loaded.");
		registerCommands();
		registerListeners();
		registerEnchantments();
		setupFiles();
		instance = this;
	}
	
	public void onDisable() {
	    getLogger().info("Prison is loaded.");
	}
	
	public void registerCommands() {
		this.getCommand("fly").setExecutor(new CmdFly());
		this.getCommand("withdraw").setExecutor(new CmdWithdraw());
		this.getCommand("crates").setExecutor(new Crates());
		this.getCommand("clearchat").setExecutor(new CmdClearChat());
		this.getCommand("customenchant").setExecutor(new CmdCustomEnchant());
		//this.getCommand("").setExecutor(new CmdTrade());
		this.getCommand("filetest").setExecutor(new filetest(this));
	}
	
	public void registerListeners() {
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new Crates(), this);
	    pm.registerEvents(new ServerMOTD(), this);
	    pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new DeathEvent(), this);
		pm.registerEvents(new MineEvent(), this);
	}
	
	public void registerEnchantments() {
		addEnchant(new TremorEnchantment());
	}
	
	public void addEnchant(Enchantment enchantment) {
		boolean registered = true;
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
			Enchantment.registerEnchantment(enchantment);
		} catch (Exception e) {
			registered = false;
			e.printStackTrace();
		}
		if (registered) {
			getLogger().info("REGISTERED" + enchantment.getKey());
		}
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
	
	public static Main getInstance() {
		return instance;
	}

}
