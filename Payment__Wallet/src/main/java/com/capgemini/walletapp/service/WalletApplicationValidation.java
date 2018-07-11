package com.capgemini.walletapp.service;

public class WalletApplicationValidation {
	
	public boolean isValidFirstName(String firstName)
	{
		if(firstName.isEmpty())
		{
			System.err.println("FirstName should not be empty");
			return false;
		}
		
		return true;
		
	}
	public boolean isValidLastname(String lastName)
	{
		if(lastName.isEmpty())
		{
			System.err.println("LastName should not be empty");
			return false;
		}
		
		return true;
		
	}
	public boolean isValidGender(String gender)
	{
		if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"))
		{
			return true;
		}
		return false;
		
	}
	public boolean isValidMobileNo(String mobileNo)
	{
		if(mobileNo.length()==10)
		{
			return true;
		}
		return false;
		
	}
	public boolean isValidAge(int age)
	{
		if(age<15)
		{
			return false;
		}
		return true;
		
	}
	public boolean isValidEmail(String email)
	{
		if(email.isEmpty())
		{
			return false;
		}
		return true;
		
	}
	public boolean isValidUsername(String username)
	{
		
		return true;
		
	}
	public boolean isValidPassword(String password)
	{
		return true;
		
	}
	public boolean isValidAmount(double amount)
	{
		return true;
		
	}

}
