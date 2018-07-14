package com.capgemini.walletapp.bean;

import java.time.LocalDate;
import java.util.List;

public class WalletApplication {
	private long accNo;
	private LocalDate date;
	private String branch;
	private String iFSC;
	private double amount;
	private long tid;
	private List<String> trans;
	private Customer cust;
	private String accountType;
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIFSC() {
		return iFSC;
	}
	public void setIFSC(String iFSC) {
		this.iFSC = iFSC;
	}
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public List<String> getTrans() {
		return trans;
	}
	public void setTrans(List<String> trans) {
		this.trans = trans;
	}


}
