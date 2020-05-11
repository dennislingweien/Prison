package com.Prison.main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Crates implements CommandExecutor,Listener{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("crates")) {
			if(args.length == 0) {
				sender.sendMessage("");
				//not enough args
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("help")) {
					String msg = "-----";
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c"+msg + "&6"+msg + "&e"+msg + "&a"+msg + "b"+msg + "&a"+msg + "&e"+msg + "&6"+msg + "&c"+msg));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "         /crates create - Create a new crate"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "         /crates delete - Delete an exisiting crate"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "         /crates edit - Edit an existing crate"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "         /crates list - Show all existing crates"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c"+msg + "&6"+msg + "&e"+msg + "&a"+msg + "b"+msg + "&a"+msg + "&e"+msg + "&6"+msg + "&c"+msg));
					return true;
				}
				if(args[0].equalsIgnoreCase("list")) {
					//display list
					return true;
				}
				else {
					//too many args
					return true;
				}
				
			}
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("delete")) {
					//loop through to search list for name
					return true;
				}
				if(args[0].equalsIgnoreCase("add")) {
					
					return true;
				}
			}
		}
		return false;
	}
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST) {
			
		
		}
	}
}
