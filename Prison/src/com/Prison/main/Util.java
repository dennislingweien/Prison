package com.Prison.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class Util {
	public static String setColor(String text) {
		text = ChatColor.translateAlternateColorCodes('&', text);
		return text;
	}
	
	public Inventory createInventory(int size, String name) {
		Inventory inv = Bukkit.createInventory(null, size, setColor(name));
		return inv;
	}
}
