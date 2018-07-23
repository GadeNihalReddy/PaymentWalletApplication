package com.capgemini.paymentapp.bean;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	
	Customer cust=new Customer();
	public void testGetAdharNumber() {
		cust.setAdharNumber(12345678);
		assertEquals(12345678, cust.getAdharNumber());
	}
	public void testGetWallet() {
		
	}

	public void testGetCustomerName() {
		cust.setCustomerName("nihal");
		assertEquals("nihal", cust.getCustomerName());
	}

	public void testGetAddress() {
		cust.setAddress("ananthgirihills");
		assertEquals("ananthgirihills", cust.getAddress());
	}

	public void testGetPhoneNumber() {
		cust.setPhoneNumber("9848261197");
		assertEquals("9848261197", cust.getPhoneNumber());
		
	}

	public void testGetGender() {
		cust.setGender("male");
		assertEquals("male",cust.getGender());
	}

	public void testGetAge() {
		cust.setAge(25);
		assertEquals(25, cust.getAge());
		
	}

	public void testGetUser_ID() {
		cust.setUser_ID("Nihal22");
		assertEquals("Nihal22", cust.getUser_ID());
	}

	public void testGetPassword() {
		cust.setPassword("Nihal@29");
		assertEquals("Nihal@29", cust.getPassword());
		
	}

}
