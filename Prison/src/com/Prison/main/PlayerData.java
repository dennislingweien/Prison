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
	public Bank bank = new Bank();
	
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
	public void createBankAccount(String password) {
		this.bankPassword = Base64.getEncoder().encodeToString(password.getBytes());
		bank.initAccount(this, bankPassword);
	}
	public String getBankPassword() {
		return bankPassword;
	}
	
	//player
	public Player getPlayer() {
		return this.p;
	}
}
