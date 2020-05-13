package com.Prison.main;

import org.bukkit.ChatColor;

public enum ErrorMessages {
	MUST_BE_PLAYER(ChatColor.translateAlternateColorCodes('&', "Test")),
	NOT_ENOUGH_ARGS(ChatColor.translateAlternateColorCodes('&', "Test"));
	
	
	
	public String msg;
	private ErrorMessages(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return this.msg;
	}
}
