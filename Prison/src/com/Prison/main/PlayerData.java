package com.Prison.main;
import java.util.Base64;
import org.bukkit.entity.Player;

/**
 * @author Wayne
 *
 */
public class PlayerData {
	public String name = "";
	private int wallet = 0;
	private String bankPassword;
	public Player p;
	
	public PlayerData(String _name, Player _p){
		this.name = _name;
		this.p = _p;
	}
	
	
	//Wallet shit
	public void addFunds(int funds) {
		this.wallet += funds;
	}
	public int getFunds() {
		return this.wallet;
	}
	
	//Bank shit
	public void setBankPassword(String encodedPassword) {
		this.bankPassword = encodedPassword;
	}
	public String getBankPassword() {
		return bankPassword;
	}
}
