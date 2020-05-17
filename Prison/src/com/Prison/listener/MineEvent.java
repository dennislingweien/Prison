package com.Prison.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
			Block block = e.getBlock();
			//Get level for Tremor Enchant/Buff
			//apply level and multiplier x, y, z
			//for now i put default 3, 3, 3
			BreakRadius(3, 3, 3, block);
		}
	}
	
	private void BreakRadius(int x, int y, int z, Block _b) {
		int defOffset = -1;
        for(int xOff = defOffset; xOff < defOffset + x; ++xOff){
            for(int yOff = defOffset; yOff < defOffset + y; ++yOff){
                for(int zOff = defOffset; zOff < defOffset + z; ++zOff){
                    _b.getRelative(xOff, yOff, zOff).breakNaturally();
                }
            }
        }
	}
}
