package com.Prison.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CmdWithdraw implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("withdraw")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("");
				return true;
			}
			if(args.length == 1) {
				ItemStack item = new ItemStack(Material.PAPER, 1);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(ChatColor.GREEN + " $500");
				item.setItemMeta(meta);
				return true;
			} else {
				//too many args
				return true;
			}
		}
		return false;
	}

}
