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
				Player p = (Player) sender;
				if(target == null) {
					//no target found
					return true;
				}
				int size = 9;
				Inventory inv = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', "&4&lModeration"));
				
				ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
				ItemStack cancel = new ItemStack(Material.BARRIER,1);
				ItemStack blank = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
				ItemStack ban = new ItemStack(Material.DIAMOND_AXE, 1);
				ItemStack kick = new ItemStack(Material.IRON_BOOTS, 1);
				ItemStack warn = new ItemStack(Material.WRITABLE_BOOK, 1);
				
				ItemMeta cancelMeta = cancel.getItemMeta();
				ItemMeta blankMeta = blank.getItemMeta();
				ItemMeta banMeta = ban.getItemMeta();
				ItemMeta kickMeta = kick.getItemMeta();
				ItemMeta warnMeta = warn.getItemMeta();
				
				SkullMeta skull= (SkullMeta) head.getItemMeta();
				skull.setOwningPlayer(Bukkit.getOfflinePlayer(target.getUniqueId()));
				
				skull.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l" + target.getName()));
				cancelMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lCancel"));
				blankMeta.setDisplayName(" ");
				banMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lBan Player"));
				kickMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lKick Player"));
				warnMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lWarn Player"));
				
				head.setItemMeta(skull);
				cancel.setItemMeta(cancelMeta);
				blank.setItemMeta(blankMeta);
				ban.setItemMeta(banMeta);
				kick.setItemMeta(kickMeta);
				warn.setItemMeta(warnMeta);
				
				inv.setItem(0, head);
				inv.setItem(3, warn);
				inv.setItem(4, kick);
				inv.setItem(5, ban);
				inv.setItem(8, cancel);
				
				for(int i = 0; i < inv.getSize(); i++) {
					if(inv.getItem(i) == null) {
						inv.setItem(i, blank);
					}
				}
				p.openInventory(inv);
				return true;
			}
		}
		return false;
	}

}
