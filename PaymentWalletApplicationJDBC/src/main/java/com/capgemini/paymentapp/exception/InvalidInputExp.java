package com.capgemini.paymentapp.exception;

public class InvalidInputExp extends Exception {

	private String string;

	public InvalidInputExp(String string) {
		this.string=string;
	}
	

	@Override
	public String toString() {
		return "InvalidInputExp [string=" + string + "]";
	}


	private static final long serialVersionUID = 1L;

}
