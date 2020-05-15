package com.Prison.listener;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class DeathEvent implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		String uuid = e.getEntity().getUniqueId().toString();
		
		//RNG shiet for head
		int randomnum = ThreadLocalRandom.current().nextInt(1, 5);
		if(randomnum == 3) {
			e.getDrops().add(dropHead(uuid));
		}
	}
	
	public ItemStack dropHead(String uuid) {
		ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString(uuid)));
		item.setItemMeta(meta);
		return item;
	}
}
