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
	
	
	//create bank account
	public void createAccount(PlayerData pd, String password) {
		this.encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		pd.setBankPassword(encodedPassword);
	}
	
	//access bank account
	public int getBalance(PlayerData pd, String password) {
		int bal = 0;
		if (password == pd.getBankPassword()) {
			//access bank
			return bal;
		}
		else{
			pd.p.sendMessage("Wrong Password!");
			return bal;
		}
	}
	//withdraw
	public boolean attemptWithdraw(PlayerData pd, String password, int amount){
		int bal = getBalance(pd, password);
		
		return false;
	}
	//deposit
	
	
	
}
