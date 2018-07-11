package com.capgemini.walletapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.walletapp.bean.WalletApplication;

public class WalletApplicationDAO implements IWalletApplicationDAO {
	static boolean flag;
	static double blnc;
	static WalletApplication  temp=new WalletApplication();
	static List<WalletApplication> list=new ArrayList<WalletApplication>();
	static Map<String,Double> transactions=new HashMap<String,Double>();
	

	public int createAccount(WalletApplication details) {
		flag=list.add(details);
		if(flag)
		{
			return 1;
		}
		else
		return 0;
	}

	public boolean login(String username, String password) {
		
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(app.getUsername().equals(username) && app.getPassword().equals(password))
			{
				System.out.println("user found");
				temp=app;
				flag=true;
			}
		}
		return flag;
	}

	public double showBalance() {
//		Iterator<WalletApplication> it =list.iterator();
//		while(it.hasNext())
//		{
//			WalletApplication app=it.next();
//			if(temp.getUsername().equals(app.getUsername()))
//			blnc=app.getAmount();
//		}
		blnc=temp.getAmount();
		return blnc;
	}

	public int deposit(double amount) {
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getUsername().equals(app.getUsername()))
			blnc=app.getAmount()+amount;
			app.setAmount(blnc);
			//app.setTid((long)Math.random()*1234 + 9999);
			transactions.put("Credited amount :", amount);
			System.out.println("Your account is credited with amount "+amount+" balance in your account is "+app.getAmount());
			return 1;
		}
		return 0;
	}

	public int withdraw(double amount) {
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getUsername().equals(app.getUsername()))
			blnc=app.getAmount()-amount;
			app.setAmount(blnc);
			transactions.put("Debited amount :", amount);
			System.out.println("Your account is debited with amount "+amount+" balance in your account is "+app.getAmount());
			return 1;
		}
		return 0;
	}

	public int fundTransfer(long accNo, double amount) {
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getUsername().equals(app.getUsername()))
			blnc=app.getAmount()-amount;
			app.setAmount(blnc);
			transactions.put("Transfered amount ", amount);
			System.out.println("fund amount "+amount+"is transfered to accountNumber"+accNo+" balance in your account is "+app.getAmount());
			return 1;
		}
		return 0;
	}

	public Map printTransactions() {
		
		return transactions;
	}

}
