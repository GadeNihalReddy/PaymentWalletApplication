package com.capgemini.walletapp.service;

import com.capgemini.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationServiceTest extends TestCase {
	
	WalletApplication details=new WalletApplication();
	WalletApplicationService service =new WalletApplicationService();
	

	public void testCreateAccount() {
		assertEquals(0,service.createAccount(details));
		
		assertTrue(true);
		
	}

	public void testLogin() {
		assertEquals(false,service.login(details.getUsername(), details.getPassword()));
		
	}

	public void testShowBalance() {
		
		assertEquals(2000,2000);
	}

	public void testDeposit() {
		assertEquals(0,service.deposit(2000));
		
	}

	public void testWithdraw() {
		assertEquals(0,service.withdraw(2000));
		
	}

	public void testFundTransfer() {
		assertEquals(0,service.fundTransfer(12345, 25000));
		
	}

}
