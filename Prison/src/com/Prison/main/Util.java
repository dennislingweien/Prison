package com.Prison.main;

import org.bukkit.ChatColor;

public class Util {
	public String setColor(String text) {
		text = ChatColor.translateAlternateColorCodes('&', text);
		return text;
	}
}
