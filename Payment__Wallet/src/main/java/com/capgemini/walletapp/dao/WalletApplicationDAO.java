package com.capgemini.walletapp.dao;

import com.capgemini.walletapp.bean.WalletApplication;

public class WalletApplicationDAO implements IWalletApplicationDAO {

	public int createAccount(WalletApplication details) {
		
		return 0;
	}

	public boolean login(String username, String password) {
	
		return false;
	}

	public double showBalance() {
		
		return 0;
	}

	public int deposit(double amount) {
		
		return 0;
	}

	public int withdraw(double amount) {
		
		return 0;
	}

	public int fundTransfer(long accNo, double amount) {
		
		return 0;
	}

}
