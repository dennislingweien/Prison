package com.Prison.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


import com.Prison.main.PlayerData;
import com.Prison.main.Main;


import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

	private Main main;
	public PlayerJoin(Main main) {
		this.main = main;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		setup(p);
		if(!p.hasPlayedBefore()) {
			Bukkit.broadcastMessage(ChatColor.DARK_GREEN + " + " + ChatColor.GRAY + p.getName());	
		}
		else
		{
			PlayerData pd = new PlayerData(p.getName(), p);
		}
	}

	public void setup(Player p) {
		String uuid = p.getUniqueId().toString();
		File file = new File(main.getDataFolder() + "/Player/"+ uuid + ".yml");	
		if(!file.exists()) {
			try {
				file.createNewFile();
				p.sendMessage("File created");
			} catch (IOException e) {
				e.printStackTrace();
				p.sendMessage("Error creating");
			}
		}
		else {
			p.sendMessage("file already created!");
		}
	}
}
