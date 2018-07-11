package com.capgemini.walletapp.service;

import junit.framework.TestCase;

public class WalletApplicationValidationTest extends TestCase {
	WalletApplicationValidation v=new WalletApplicationValidation();
	public void testIsValidFirstName() {
		assertEquals(false, v.isValidFirstName(""));
		assertEquals(true, v.isValidFirstName("nihal"));
	}

	public void testIsValidLastname() {
		assertEquals(false,v.isValidLastname(""));
		assertEquals(true, v.isValidFirstName("gade"));
	}

	public void testIsValidGender() {
		assertEquals(false,v.isValidGender(""));
		assertEquals(true, v.isValidFirstName("male"));
	}

	public void testIsValidMobileNo() {
		assertEquals(false,v.isValidMobileNo(""));
		assertEquals(true, v.isValidFirstName("8008746024"));
	}

	public void testIsValidAge() {
		assertEquals(false,v.isValidAge(12));
		assertEquals(true, v.isValidAge(17));
	}

	public void testIsValidEmail() {
		assertEquals(false,v.isValidEmail(""));
		assertEquals(true,v.isValidEmail("gade@123.com"));
	}

	public void testIsValidUsername() {
		assertEquals(false,v.isValidUsername(""));
		assertEquals(true,v.isValidUsername("12345"));
	}

	public void testIsValidPassword() {
		assertEquals(false,v.isValidPassword(""));
		assertEquals(true,v.isValidPassword("12345"));
	}

	public void testIsValidAmount() {
		assertEquals(false,v.isValidAmount(0));
		assertEquals(true,v.isValidAmount(1250));
		
	}

}
