package com.Prison.main;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

/**
 * @author Wayne
 *
 */
public class PlayerData {
	public String name = "";
	private int wallet = 0;
	private boolean isMuted = false;
	public Player p;
	private ItemStack playerhead;
	private String rank = "";
	private String prestige = "";


	public PlayerData(Player _p) {
		this.name = _p.getName();
		this.p = _p;
		setHead();
	}

	// Wallet shit
	public void addFunds(int funds) {
		this.wallet += funds;
	}

	public int getFunds() {
		return this.wallet;
	}

	// player

	public Player getPlayer() {
		return this.p;
	}

	// status
	public void toggleMute() {
		if (this.isMuted) {
			this.isMuted = false;
		} else {
			this.isMuted = true;
		}
	}

	private void setHead() {
		this.playerhead = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta skull = (SkullMeta) playerhead.getItemMeta();
		skull.setOwningPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()));
		skull.setDisplayName(ChatColor.RED + this.name + "'s Head");
		playerhead.setItemMeta(skull);
	}

	public ItemStack getHead() {
		return this.playerhead;
	}
	
	public void loadYAML(Main main) {
		YamlManager manager = new YamlManager(main);
		manager.writeYAML(p, "Name", this.name);
		manager.writeYAML(p, "Wallet", String.valueOf(this.wallet));
		manager.writeYAML(p, "isMuted", Boolean.toString(this.isMuted));
	}
}
