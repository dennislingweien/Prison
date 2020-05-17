package com.Prison.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.Prison.main.Util;

public class ServerMOTD implements Listener {

	
	@EventHandler
	public void MOTD(ServerListPingEvent e) {
		e.setMotd(Util.setColor("&8&lPrison Server \n &6Active Staffs/Friendly Community/Custom plugins"));
	}
}
