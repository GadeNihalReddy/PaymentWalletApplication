package com.capgemini.paymentapp.service;

import java.util.Map;

import com.capgemini.paymentapp.bean.Customer;

//import com.capgemini.paymentapp.dao.PaymentAppdao;
import com.capgemini.paymentapp.dao.PaymentAppdao2;

public class PaymentAppService implements IPaymentAppService {
  
	
	PaymentAppdao2 dao=new PaymentAppdao2();
	Customer customer= new Customer();
	public boolean createAccount(Customer customer) {
		
		return dao.createAccount(customer);
	}

	public double showBalance() {
		
		 return dao.showBalance();
		
	}
	public boolean logIn(String user_ID,String password)
	{
		return dao.logIn(user_ID,password);
	}

	public boolean deposite(double  amount) {
		
		return dao.deposite(amount);
	}

	public boolean withdraw(double amount) {
		
		return dao.withdraw(amount);
	}

	public boolean fundTransfer(long receiverAccountNumber,double amount) {
		
		return dao.fundTransfer(receiverAccountNumber,amount);
		
	}

	public void printTranscation() {
		
	dao.printTranscation();
	}

	public void logout() {
		dao.logout();
		
	}

}
