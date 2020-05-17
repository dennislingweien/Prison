package com.Prison.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MineEvent implements Listener{

	@EventHandler
	public void onPlayerMine(BlockBreakEvent e) {
		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (e.getBlock().getType() == Material.IRON_ORE) {
				e.getBlock().setType(Material.AIR);
				e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
			}

			if (e.getBlock().getType() == Material.GOLD_ORE) {
				e.getBlock().setType(Material.AIR);
				e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
			}
		}
	}
	
	@EventHandler
	public void tremor(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		ItemStack item = p.getInventory().getItemInMainHand();
		if(item.getType() == Material.DIAMOND_PICKAXE) {
			//ItemMeta meta = item.getItemMeta();
			//meta.setDisplayName(meta.getDisplayName() + "1");
			//item.setItemMeta(meta);
		}
	}
}
