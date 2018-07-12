package com.capgemini.walletapp.bean;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	
	Customer data=new Customer();

	public void testGetFirstName() {
		data.setFirstName("Nihal");
		assertEquals("Nihal",data.getFirstName());
		assertTrue("Nihal".equalsIgnoreCase(data.getFirstName()));
		assertNotNull(data);
	}

	public void testGetLastName() {
		data.setLastName("Gade");
		assertEquals("Gade",data.getLastName());
		assertTrue("Gade".equalsIgnoreCase(data.getLastName()));
		assertNotNull(data);
	}

	public void testGetGender() {
		data.setGender("Male");
		assertEquals("Male",data.getGender());
	}

	public void testGetMobileNo() {
		data.setMobileNo("8008746024");
		assertEquals("8008746024",data.getMobileNo());
		
	}

	public void testGetAge() {
		data.setAge(21);
		assertEquals(21,data.getAge());
	}

	public void testGetEmail() {
		data.setEmail("gadenihal@cap.com");
		assertEquals("gadenihal@cap.com",data.getEmail());
		
	}

	public void testGetUsername() {
		data.setUsername("Nihal22");
		assertEquals("Nihal22",data.getUsername());
		
	}

	public void testGetPassword() {
		data.setPassword("Nihal@22");
		assertEquals("Nihal@22",data.getPassword());
		
	}

}
