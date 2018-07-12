package com.capgemini.walletapp.bean;

import junit.framework.TestCase;

public class WalletApplicationTest extends TestCase {
	
	WalletApplication details=new WalletApplication();
	

	public void testGetAccNo() {
		details.setAccNo(123456);
		assertEquals(123456,details.getAccNo());
	}
	
	public void testGetDate() {
		assertNull(details.getDate());
		
	}

	public void testGetAmount() {
		details.setAmount(2000);
		assertEquals(2000.0,details.getAmount());
	}

	public void testGetTid() {
		details.setTid(12345);
		assertEquals(12345,details.getTid());
	}

}
