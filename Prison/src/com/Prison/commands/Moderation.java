package com.Prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class Moderation implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("mod")) {
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) {
					//no target found
					return true;
				}
				int size = 9;
				Inventory inv = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', "&4&lModeration : &c&l" + target.getName()));
				
				ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
				ItemStack cancel = new ItemStack(Material.BARRIER,1);
				
				ItemMeta cancelMeta = head.getItemMeta();
				
				SkullMeta skull= (SkullMeta) head.getItemMeta();
				skull.setOwningPlayer(Bukkit.getOfflinePlayer(target.getUniqueId()));
				
				skull.setDisplayName(ChatColor.RED + target.getName() + "'s head");
				cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
				
				head.setItemMeta(skull);
				cancel.setItemMeta(cancelMeta);
				
				inv.setItem(0, head);
				
				inv.setItem(8, cancel);
				
			}
		}
		return false;
	}

}
