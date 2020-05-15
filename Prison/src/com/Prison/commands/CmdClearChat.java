package com.Prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CmdClearChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("clearchat")) {
			String name = "Console";
			if(sender instanceof Player) {
				Player p = (Player) sender;
				name = p.getName();
			}
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7&lChat cleared by " + name));
			return true;
		}
		return false;
	}

}
