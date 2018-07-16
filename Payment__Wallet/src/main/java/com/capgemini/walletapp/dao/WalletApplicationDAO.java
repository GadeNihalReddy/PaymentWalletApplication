package com.capgemini.walletapp.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.walletapp.bean.Customer;
import com.capgemini.walletapp.bean.WalletApplication;

public class WalletApplicationDAO implements IWalletApplicationDAO {
	static boolean flag;
	static double blnc;
	static long tid;
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
			if(app.getCust().getUsername().equals(username)&&app.getCust().getPassword().equals(password))
			{
				System.out.println("user found");
				temp=app;
				flag=true;
			}
		}
		return flag;
	}

	public double showBalance() {
		blnc=temp.getAmount();
		return blnc;
	}

	public int deposit(double amount) {
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getCust().getUsername().equals(app.getCust().getUsername()))
			{
			tid=(long)(Math.random()*1234 + 9999);
			blnc=app.getAmount()+amount;
			app.setAmount(blnc);
			LocalDateTime d=LocalDateTime.now();
			
			String s="TransactionId "+Long.toString(tid)+" on "+d.toString()+" and Deposited amount "+ Double.toString(amount);
			app.getTrans().add(s);
			//transactions.put(s, amount);
			System.out.println("Your account is credited with amount "+amount+" balance in your account is "+app.getAmount());
			return 1;
			}
		}
		return 0;
	}

	public int withdraw(double amount) {
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getCust().getUsername().equals(app.getCust().getUsername()))
			
			{
			tid=(long)(Math.random()*1234 + 9999);
			blnc=app.getAmount()-amount;
			app.setAmount(blnc);
			LocalDateTime d=LocalDateTime.now();
			String s="TransactionId "+Long.toString(tid)+" on "+d.toString()+" and Withdrawn amount"+Double.toString(amount);
			app.getTrans().add(s);
			//transactions.put(s, amount);
			System.out.println("Your account is debited with amount "+amount+" balance in your account is "+app.getAmount());
			return 1;
		}
		}
		return 0;
	}

	public int fundTransfer(long accNo, double amount) {
		Iterator<WalletApplication> it =list.iterator();
		Iterator<WalletApplication> it1 =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getCust().getUsername().equals(app.getCust().getUsername()))
			{
			tid=(long)(Math.random()*1234 + 9999);
			blnc=app.getAmount()-amount;
			app.setAmount(blnc);
			LocalDateTime d=LocalDateTime.now();
			//transfer to same bank account holder
			while(it1.hasNext()) {
				WalletApplication app1=it1.next();
				if(app1.getAccNo()==accNo) {
					app1.setAmount(app1.getAmount()+amount);
					String s="TransactionId "+Long.toString(tid)+" on "+d.toString()+" and Recieved amount"+Double.toString(amount)+Long.toString(app.getAccNo());
					app1.getTrans().add(s);
				}
			}
			
			String s="TransactionId "+Long.toString(tid)+" on "+d.toString()+" and Transfered amount"+Double.toString(amount);
			app.getTrans().add(s);
			//transactions.put(s, amount);
			System.out.println("fund amount "+amount+"is transfered to accountNumber "+accNo+" balance in your account is "+app.getAmount());
			return 1;
		}}
		return 0;
	}

	public List printTrans() {
		Iterator<WalletApplication> it =list.iterator();
		while(it.hasNext())
		{
			WalletApplication app=it.next();
			if(temp.getCust().getUsername().equals(app.getCust().getUsername()))
			
			{
				return app.getTrans();
			}
		}
		
		return null;
	}

}
