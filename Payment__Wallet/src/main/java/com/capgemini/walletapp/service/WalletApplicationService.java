package com.capgemini.walletapp.service;

import java.util.List;
import java.util.Map;

import com.capgemini.walletapp.bean.WalletApplication;
import com.capgemini.walletapp.dao.WalletApplicationDAO;

public class WalletApplicationService implements IWalletApplicationService {
	
	WalletApplicationDAO dao=new WalletApplicationDAO();
	

	public int createAccount(WalletApplication details) {
		
		return dao.createAccount(details);
	}

	public boolean login(String username, String password) {
		
		return dao.login(username, password);
	}

	public double showBalance() {
		
		return dao.showBalance();
	}

	public int deposit(double amount) {
		
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		
		return dao.withdraw(amount);
	}

	public int fundTransfer(long accNo, double amount) {
		
		return dao.fundTransfer(accNo, amount);
	}
	
	public List printTrans() {
		
		return dao.printTrans();
	}

}
