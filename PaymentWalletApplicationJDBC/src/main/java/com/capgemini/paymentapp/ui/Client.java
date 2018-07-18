package com.capgemini.paymentapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capgemini.paymentapp.bean.Customer;
import com.capgemini.paymentapp.bean.Wallet;
import com.capgemini.paymentapp.exception.InvalidInputExp;
import com.capgemini.paymentapp.service.PaymentAppService;
import com.capgemini.paymentapp.service.PaymentAppValidate;

public class Client {
	public static void main(String args[]) {
		int choice = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PaymentAppService service = new PaymentAppService();
		PaymentAppValidate validate = new PaymentAppValidate();
		System.out.println("\t\t *****PAYMENT BANK APPLICATION*****");
		do {
			System.out.println("1. CREATE ACCOUNT\n2. LOG IN\n3. EXIT");

			try {
				System.out.println("Enter your choice");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					Customer customer = new Customer();
					Wallet wallet = new Wallet();
					boolean b = false;

					System.out.println("Enter your name:");
					String customerName = br.readLine();

					System.out.println("Enter your age:");
					int age = Integer.parseInt(br.readLine());

					System.out.println("Enter your Phone Number:");
					String phoneNumber = br.readLine();
					System.out.println("Enter your Adhar Number:");
					long adharNo = Long.parseLong(br.readLine());

					System.out.println("Enter your address:");
					String address = br.readLine();

					System.out.println("Enter your Gender(Male/Female):");
					String gender = br.readLine();

					double balance = 1000;
					System.out.println("Enter your User ID :");
					String user_ID = br.readLine();
					System.out.println("Enter your password:");
					String password = br.readLine();

					long accountNumber = (long) (Math.random() * 1000000000);
					customer.setAdharNumber(adharNo);
					customer.setCustomerName(customerName);
					customer.setAge(age);
					customer.setAddress(address);
					customer.setPhoneNumber(phoneNumber);
					wallet.setAccountNumber(accountNumber);
					wallet.setAdharNumber(adharNo);
					customer.setGender(gender);
					customer.setUser_ID(user_ID);
					customer.setPassword(password);
					wallet.setInitalBalance(balance);
					customer.setWallet(wallet);

					boolean b1 = validate.validatePhoneNo(phoneNumber);
					boolean b2 = validate.validateCustomerName(customerName);
					if (b1 && b2) {
						b = service.createAccount(customer);
					} else {
						System.out.println("Input is invalid(either phone number is incorrect or name shold not be null");
					}

					if (b) {
						System.out.println("Account Created Successfully  and your account number is: '" + accountNumber);
					} else {
						try {
							throw new InvalidInputExp("Your input details are invalid");
						} catch (InvalidInputExp e) {
							System.out.println("Account Creation is failed!!!!!!!!!");
						}
					}
					break;

				case 2:
					int choice1 = 1;
					boolean valid = false;
					System.out.println("Enter your UserId");
					String user_ID1 = br.readLine();
					System.out.println("Enter your Password");
					String password1 = br.readLine();
					valid = service.logIn(user_ID1, password1);
					if (valid) {
						do {
							System.out.println("Select any option:");
							System.out.println("1. SHOW BALANCE                           2.DEPOSIT      ");
							System.out.println("3. WITHDRAW                               4.FUND TRANSFER");
							System.out.println("5. PRINT TRANSCATION                      6.EXIT         ");
							System.out.println("Enter your choice");
							choice1 = Integer.parseInt(br.readLine());
							switch (choice1) {
							case 1:
								double d = service.showBalance();
								System.out.println("Your Account Balance: " + d);
								break;
							case 2:
								double amt;
								System.out.println("Enter amount to deposite:");
								amt = Double.parseDouble(br.readLine());
								boolean b5 = service.deposite(amt);
								if (b5) {
									System.out.println("Amount deposited succesfully");
								} else {
									System.out.println("Failed to Deposite");
								}
								break;
							case 3:
								double amt1;
								System.out.println("Enter amount to withdraw:");
								amt1 = Double.parseDouble(br.readLine());
								boolean d1 = service.withdraw(amt1);
								if (d1) {
									System.out.println("Amount withdrawn succesfully");
								} else
									System.out.println("Failed to withdraw");
								break;

							case 4:
								long accnum;
								double amt2;
								System.out.println("Enetr Receiver Account Number");
								accnum = Long.parseLong(br.readLine());
								System.out.println("Enter amount to Transfer:");
								amt2 = Double.parseDouble(br.readLine());
								boolean b6 = service.fundTransfer(accnum, amt2);
								if (b6) {
									System.out.println("Your amount is transferred successfully!!");
								} else
									System.out.println("Transaction failed!!");
								break;

							case 5:
								service.printTranscation();
								break;
							case 6:
								System.out.println("Thank You!!");
								break;
							}
						} while (choice1 != 6);
					}

					else {
						System.out.println("Invalid choice!!");
					}
					break;
				case 3:
					System.out.println("ThankYou");
					System.exit(0);
					break;
				default:
					System.out.println("Enter correct choice");
					break;
				}
				System.out.println("**************************************************************************\n");
			}
			catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} while (choice != 3);
	}
}
