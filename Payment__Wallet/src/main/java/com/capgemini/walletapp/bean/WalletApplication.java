package com.capgemini.walletapp.bean;

import java.time.LocalDate;

public class WalletApplication {
	private long accNo;
//	private String username;
//	private String password;
	private LocalDate date;
	private String branch;
	private String iFSC;
	private double amount;
	private long tid;
	private Customer cust;
	
//	private String firstName;
//	private String lastName;
//	private String gender;
//	
//	private String mobileNo;
//	private int age;
//	
//	private String email;
	
	
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastname() {
//		return lastName;
//	}
//	public void setLastname(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
//	public String getMobileNo() {
//		return mobileNo;
//	}
//	public void setMobileNo(String mobileNo) {
//		this.mobileNo = mobileNo;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	
	
	
	
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIFSC() {
		return iFSC;
	}
	public void setIFSC(String iFSC) {
		this.iFSC = iFSC;
	}
//	@Override
//	public String toString() {
//		return "WalletApplication [firstName=" + firstName + ", lastname=" + lastName + ", gender=" + gender
//				+ ", accNo=" + accNo + ", mobileNo=" + mobileNo + ", age=" + age + ", date=" + date + ", email=" + email
//				+ ", username=" + username + ", password=" + password + ", amount=" + amount + ", tid=" + tid + "]";
//	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
	

}
