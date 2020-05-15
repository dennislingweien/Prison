package com.Prison.main;

import java.util.Base64;

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
	private String bankPassword;
	private boolean isMuted = false;
	public Player p;
	private ItemStack playerhead;
	// private SkullMeta skullmeta

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

	// Bank shit
	public void createBankAccount(String password) {
		this.bankPassword = Base64.getEncoder().encodeToString(password.getBytes());
		bank.initAccount(this, bankPassword);
	}

	public String getBankPassword() {
		return bankPassword;
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

	public void createYAML(Main main) {
		YamlManager manager = new YamlManager(main);
		manager.writeYAML(p, "Name", this.name);
		manager.writeYAML(p, "Wallet", String.valueOf(this.wallet));
	}
}
