package com.Prison.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Prison.main.PlayerData;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()) {
			Bukkit.broadcastMessage(ChatColor.DARK_GREEN + " + " + ChatColor.GRAY + p.getName());
			
		}
		else
		{
			PlayerData pd = new PlayerData(p.getName(), p);
		}
	}
}
