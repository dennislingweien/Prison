package com.Prison.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Prison.main.Bank;
import com.Prison.main.PlayerData;


public class CmdWithdraw implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("withdraw")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("");
				return true;
			}
			if(args.length == 2) {
				
				//Get the players inventory data
				PlayerData pd = (PlayerData) sender;
				Inventory inv = pd.getPlayer().getInventory();
				
				//Check for full inventory
				if(inv.firstEmpty() == -1) 
				{
					pd.getPlayer().sendMessage("INVENTORY IS FULL");
				}
				//if inventory has space
				else
				{
					if(pd.bank.attemptWithdraw(pd, args[0], args[1])) {
						
						//Create the Cheque Item
						ItemStack item = new ItemStack(Material.PAPER, 1);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(ChatColor.GREEN + args[1]);
						item.setItemMeta(meta);
						
						//add the withdrawn cheque
						inv.addItem(item);			
					}
					
				}
				return true;
			} 
			else {
				//too many args
				return true;
			}
		}
		return false;
	}

}
