package com.Prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CmdFly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("");
				return true;
			}
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.getAllowFlight() == false) {
					p.setAllowFlight(true);
					p.sendMessage(ChatColor.GOLD + "Set fly mode " + ChatColor.GREEN + "enabled " + ChatColor.GOLD + "for " + p.getName());
					return true;
				}
				p.setAllowFlight(false);
				p.sendMessage(ChatColor.GOLD + "Set fly mode " + ChatColor.RED + "disabled " + ChatColor.GOLD + "for " + p.getName());
				return true;
			}
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) {
					sender.sendMessage(""); //player not found
					return true;
				}
				if(target.getAllowFlight() == false) {
					target.setAllowFlight(true);
					p.sendMessage(ChatColor.GOLD + "Set fly mode " + ChatColor.GREEN + "enabled " + ChatColor.GOLD + "for " + target.getName());
					return true;
				}
				target.setAllowFlight(false);
				p.sendMessage(ChatColor.GOLD + "Set fly mode " + ChatColor.RED + "disabled " + ChatColor.GOLD + "for " + target.getName());
				return true;
			}
		} else {
			sender.sendMessage(""); // too many args
			return true;
		}
		return false;
	}

}
