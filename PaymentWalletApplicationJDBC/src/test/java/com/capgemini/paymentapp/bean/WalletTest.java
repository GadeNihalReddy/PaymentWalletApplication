package com.capgemini.paymentapp.bean;

import java.time.LocalDate;

import junit.framework.TestCase;

public class WalletTest extends TestCase {
	Wallet wallet=new Wallet();
	public void testGetDate() {
		wallet.setDate(LocalDate.now());
		assertEquals(LocalDate.now(), wallet.getDate());
	}

	public void testGetAdharNumber() {
		wallet.setAdharNumber(12345678);
		assertEquals(12345678, wallet.getAdharNumber());
	}

	public void testGetInitalBalance() {
		
		wallet.setInitalBalance(1000);
		assertEquals(1000.0, wallet.getInitalBalance());
	}

	public void testGetAccountNumber() {
		wallet.setAccountNumber(1234566);
		assertEquals(1234566, wallet.getAccountNumber());
	}

}
