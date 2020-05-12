package com.Prison.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		//e.setMessage("");
		Player p = (Player) e.getPlayer();
	}
}
