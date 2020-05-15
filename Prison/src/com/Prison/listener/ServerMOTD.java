package com.Prison.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerMOTD implements Listener {

	
	@EventHandler
	public void MOTD(ServerListPingEvent e) {
		
		e.setMotd(ChatColor.translateAlternateColorCodes('&', "&8&lPrison Server \n &6Active Staffs/Friendly Community/Custom plugins"));
	}
}
