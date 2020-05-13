package com.Prison.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		String rank = "&4[OWNER]"; 
		String tag = "&7&l[&b&lFrosty&7&l]";
		Player p = (Player) e.getPlayer();
		e.setMessage(ChatColor.translateAlternateColorCodes('&', rank + " " + tag + p.getName() + ":" + e.getMessage()));
	}
}
