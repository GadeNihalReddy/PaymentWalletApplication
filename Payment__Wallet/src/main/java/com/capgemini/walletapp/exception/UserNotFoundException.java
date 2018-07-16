package com.capgemini.walletapp.exception;

public class UserNotFoundException extends Exception {

	private String string;

	public UserNotFoundException(String string) {
		this.string=string;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [string =" + string + "]";
	}
	
	

}
