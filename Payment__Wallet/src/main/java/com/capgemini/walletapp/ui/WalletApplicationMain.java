package com.capgemini.walletapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capgemini.walletapp.bean.Customer;
import com.capgemini.walletapp.bean.WalletApplication;
import com.capgemini.walletapp.service.WalletApplicationService;
import com.capgemini.walletapp.service.WalletApplicationValidation;

public class WalletApplicationMain {
	
public static void createAccount() {
	WalletApplicationService service=new WalletApplicationService();
	WalletApplicationValidation validate=new WalletApplicationValidation();
	List<String> trans=new ArrayList<String>();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	try {
		System.out.println("Enter FirstName: ");
		String firstName=br.readLine();
		System.out.println("Enter LastName");
		String lastName=br.readLine();
		System.out.println("Enter  gender(Male/Female): ");
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
		LocalDate date=LocalDate.now();
		long accNo=(long) (Math.random()*123456789 + 999999999);
		Customer data=new Customer();
		WalletApplication details=new WalletApplication();
		data.setFirstName(firstName);
		data.setLastName(lastName);
		data.setGender(gender);
		data.setMobileNo(mobileNo);
		data.setAge(age);
		data.setEmail(email);
		data.setUsername(username);
		data.setPassword(password);
		details.setAmount(amount);
		details.setAccNo(accNo);
		details.setTrans(trans);
		details.setCust(data);
		details.setDate(date);
		
		boolean isValidFName=validate.isValidFirstName(firstName);
		boolean isValidLName=validate.isValidLastname(lastName);
		boolean isValidgender=validate.isValidGender(gender);
		boolean isValidAge=validate.isValidAge(age);
		boolean isValidemail=validate.isValidEmail(email);
		if(isValidFName&&isValidLName&&isValidgender&&isValidAge&&isValidemail)
		{
			service.createAccount(details);
			System.out.println("Your Account has been created");
			System.out.println("Account No is :"+details.getAccNo());
		}
		else
		{
			System.out.println("Enter Valid Details");
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
public static void login() {
	int choice=0;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	WalletApplicationService service=new WalletApplicationService();
	
	try {
		System.out.println("Enter username");
		String username=br.readLine();
		System.out.println("Enter password");
		String password=br.readLine();
		
		service.login(username, password);
		System.out.println("LoggedIn succesfully");
		do {
		System.out.println("1.ShowBalance\n2.Deposit\n3.Withdraw\n4.FundTransfer\n5.PrintTransactions\n6.Exit the Application");
		System.out.println("Enter your choice");
		choice=Integer.parseInt(br.readLine());
		switch (choice) {
		case 1:
			System.out.println("Your Account Balance is :"+service.showBalance());
			break;
		case 2:
			System.out.println("Enter the amount to deposite");
			double amount=Double.parseDouble(br.readLine());
			service.deposit(amount);
			break;
		case 3:
			System.out.println("Enter the amount to withdraw");
			double with_amt=Double.parseDouble(br.readLine());
			service.withdraw(with_amt);
			
			break;
		case 4:
			System.out.println("Enter any accountNo. for MoneyTransfer");
			long accNo=Long.parseLong(br.readLine());
			System.out.println("Enter amount to transfer");
			double tran_amt=Double.parseDouble(br.readLine());
			service.fundTransfer(accNo, tran_amt);
			break;
		case 5:
			System.out.println(service.printTrans());
//			Map<String,Double> trans=new HashMap<String,Double>();
//			trans=service.printTransactions();
//			Set<String> st=trans.keySet();
//			Iterator<String> it=st.iterator();
//			while(it.hasNext())
//			{
//				String s=it.next();
//				System.out.println(s);
//				System.out.println(trans.get(s));
//			}
			
			break;
		case 6:
			mainMenu();
			break;
		default:
			
			System.out.println("Enter valid choice");
			break;
		}
		}while(choice!=6);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

	public static void mainMenu()
	{
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
				login();
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
	public static void main(String[] args) {
		
		mainMenu();
		
	}

}
