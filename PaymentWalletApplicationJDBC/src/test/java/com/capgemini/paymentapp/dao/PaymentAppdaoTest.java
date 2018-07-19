package com.capgemini.paymentapp.dao;

import com.capgemini.paymentapp.bean.Customer;

import junit.framework.TestCase;

public class PaymentAppdaoTest extends TestCase {
	
	PaymentAppdao dao=new PaymentAppdao();
	Customer cust=new Customer();
	
	public void testCreateAccount() {
		assertEquals(0, dao.createAccount(cust));
		//assertTrue(true);
		
	}

	public void testShowBalance() {
		assertEquals(1000, 1000);
		
	}

	public void testDeposite() {
		assertEquals(0, dao.deposite(2000));
		}

	public void testLogIn() {
		assertEquals(false, dao.logIn(cust.getUser_ID(), cust.getPassword()));
	}

	public void testWithdraw() {
		assertEquals(1, dao.withdraw(2000));
	}

	public void testFundTransfer() {
		assertEquals(1, dao.fundTransfer(123456785, 2000));
	}

	
}
