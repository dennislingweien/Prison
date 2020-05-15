package com.Prison.listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerList {
	
	private static HashMap<String, Player> players = new HashMap<>();
	
	public PlayerList() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			players.put(p.getName(), p);
		}
	}
	
	public void onPlayerJoin(PlayerJoinEvent e) {
		players.put(e.getPlayer().getName(), e.getPlayer());
	}
	public void onPlayerLeave(PlayerQuitEvent e) {
		if(players.get(e.getPlayer().getName()) != null) {
			players.remove(e.getPlayer().getName());
		}
	}
	public void onPlayerJoin(PlayerKickEvent e) {
		if(players.get(e.getPlayer().getName()) != null) {
			players.remove(e.getPlayer().getName());
		}
	}
	public Player getPlayer(String name) {
		return players.get(name);
	}
}
