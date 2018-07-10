package com.capgemini.walletapp.bean;

import junit.framework.TestCase;

public class WalletApplicationTest extends TestCase {
	
	WalletApplication details=new WalletApplication();
	public void testGetFirstName() {
		details.setFirstName("Nihal");
		assertEquals("Nihal",details.getFirstName());
		assertTrue("Nihal".equalsIgnoreCase(details.getFirstName()));
		assertNotNull(details);
		
	}

	public void testGetLastname() {
		details.setLastname("Gade");
		assertEquals("Gade",details.getLastname());
		assertTrue("Gade".equalsIgnoreCase(details.getLastname()));
		assertNotNull(details);
	}

	public void testGetGender() {
		details.setGender("Male");
		assertEquals("Male",details.getGender());
		
	}

	public void testGetAccNo() {
		details.setAccNo(123456);
		assertEquals(123456,details.getAccNo());
		
	}

	public void testGetMobileNo() {
		details.setMobileNo("8008746024");
		assertEquals("8008746024",details.getMobileNo());
		
	}

	public void testGetAge() {
		details.setAge(21);
		assertEquals(21,details.getAge());
	}

	public void testGetDate() {
		assertNull(details.getDate());
		
	}

	public void testGetEmail() {
		details.setEmail("gadenihal@cap.com");
		assertEquals("gadenihal@cap.com",details.getEmail());
		
	}

	public void testGetUsername() {
		details.setUsername("Nihal22");
		assertEquals("Nihal22",details.getUsername());
	}

	public void testGetPassword() {
		details.setPassword("Nihal@22");
		assertEquals("Nihal@22",details.getPassword());
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
