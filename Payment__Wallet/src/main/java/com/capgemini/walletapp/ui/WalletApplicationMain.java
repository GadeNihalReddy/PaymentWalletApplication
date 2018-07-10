package com.capgemini.walletapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WalletApplicationMain {
	
public static void createAccount() {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	try {
		System.out.println("Enter FirstName: ");
		String firstName=br.readLine();
		System.out.println("Enter  LastName");
		String lastName=br.readLine();
		System.out.println("Enter  gender: ");
		String gender=br.readLine();
		System.out.println("Enter Mobile Number: ");
		String mobileNo=br.readLine();
		System.out.println("Enter age: ");
		int age=Integer.parseInt(br.readLine());
		System.out.println("Enter email: ");
		String email=br.readLine();
		System.out.println("Enter UserName: ");
		String username=br.readLine();
		System.out.println("Enter password");
		String password=br.readLine();
		System.out.println("Enter amount");
		double amount=Double.parseDouble(br.readLine());
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public static void main(String[] args) {
		int key=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***Welcome to Payment Wallet Application***");
		do {
		System.out.println("1.CreateAccount\n2.Login\n3.Exit");
		System.out.println("Enter choice");
		try {
			key=Integer.parseInt(br.readLine());
			switch (key) {
			case 1:
				createAccount();
				break;
			case 2:
				
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Enter correct choice");
				break;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}while(key!=3);

	}

	

}
