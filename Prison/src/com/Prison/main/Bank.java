/**
 * import shiet
 */
package com.Prison.main;

import java.util.Base64;

/**
 * @author Wayne
 *
 */
public class Bank {
	private int balance = 0;
	private String encodedPassword;
	private PlayerData pd;
	
	public Bank(PlayerData _pd, String _encodedPassword) {
		this.pd = _pd;
		this.encodedPassword = _encodedPassword;
	}
	public Bank() {
		// TODO Auto-generated constructor stub
	}
	//create bank account
	public void initAccount(PlayerData pd, String password) {
		// TODO Initialize account with credentials and store them somewhere
	}
	
	//access bank account
	public int getBalance(PlayerData pd, String password) {
		int bal = 0;
		if (password == pd.getBankPassword()) {
			// TODO access bank

		}
		else{
			pd.p.sendMessage("Wrong Password!");
		}
		return bal;
	}
	//withdraw
	public boolean attemptWithdraw(PlayerData pd, String password, String _amount){
		int bal = getBalance(pd, password);
		int amount = Integer.parseInt(_amount);
		if(bal >= amount) {
			bal -= amount;
			return true;
		}
		else{
			pd.p.sendMessage("Withdraw Failed!");
			return false;
		}
	}
	//deposit
	
	
	
}
