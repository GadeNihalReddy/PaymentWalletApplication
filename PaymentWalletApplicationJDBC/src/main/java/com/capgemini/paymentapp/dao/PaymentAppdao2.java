package com.capgemini.paymentapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.capgemini.paymentapp.bean.Customer;
import com.capgemini.paymentapp.util.DBUtil;

public class PaymentAppdao2 implements IPaymentAppDao {
	Connection con;
	static double d;

	public static ResultSet rs2, rs1;
	public static double balance;
	public static long accNum, aadhaar;

	public boolean createAccount(Customer customer) {
		int n1 = 0;
		int n2 = 0;
		try {
			con = DBUtil.getConnection();
			String insertquery1 = "insert into customer values( ?,?,?,?,?,?,?,?)";

			java.sql.PreparedStatement pstmt1 = con.prepareStatement(insertquery1);
			pstmt1.setString(1, customer.getCustomerName());
			pstmt1.setLong(2, customer.getAdharNumber());
			pstmt1.setString(3, customer.getAddress());

			pstmt1.setString(4, customer.getPhoneNumber());
			pstmt1.setString(5, customer.getGender());
			pstmt1.setInt(6, customer.getAge());
			pstmt1.setString(7, customer.getUser_ID());
			pstmt1.setString(8, customer.getPassword());

			String insertquery2 = "insert into wallet values( ?,curdate(),?,?)";
			java.sql.PreparedStatement pstmt2 = con.prepareStatement(insertquery2);
			pstmt2.setLong(1, customer.getWallet().getAccountNumber());
			pstmt2.setDouble(2, customer.getWallet().getInitalBalance());
			pstmt2.setLong(3, customer.getWallet().getAdharNumber());
			n1 = pstmt1.executeUpdate();
			n2 = pstmt2.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				System.out.println("connection closed");
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (n1 == 1 && n2 == 1) {
			return true;
		} else
			return false;
	}

	public boolean logIn(String user_ID, String password) {
		try {
			con = DBUtil.getConnection();
			
			String selectquery1 = "select * from customer where user_ID='" + user_ID + "' and password='" + password
					+ "'";
			
			java.sql.PreparedStatement stmt1 = con.prepareStatement(selectquery1);
			ResultSet r = stmt1.executeQuery();
			
			if (r.first()) {
				String sel = "select * from wallet where adharNo=" + r.getLong(2);
				java.sql.PreparedStatement stmt2 = con.prepareStatement(sel);
				ResultSet r1 = stmt2.executeQuery();
				
				if (r1.first()) {
					balance = r1.getDouble(3);
					aadhaar = r1.getLong(4);
					accNum = r1.getLong(1);
					return true;
				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public double showBalance() {

		return balance;

	}
	public boolean deposite(double amount) {
		try {
			balance += amount;
			String updatequery = "update wallet set initialBalance=" + balance + " where adharNo=" + aadhaar;
			java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);
			int r = stmt.executeUpdate();
			if (r == 1) {
				long tid = (long) (Math.random() * 1234 + 1234);
				LocalDateTime date = LocalDateTime.now();
				String s = "Deposited " + Double.toString(amount) + " with transaction id " + Long.toString(tid)
						+ " on " + date.toString();
				String insrt = "insert into transactions values(" + aadhaar + ",'" + s + "')";
				java.sql.PreparedStatement pstmt = con.prepareStatement(insrt);
				pstmt.executeUpdate();
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean withdraw(double amount) {
		try {
			balance -= amount;
			String updatequery = "update wallet set initialBalance='" + balance + "' where adharNo='" + aadhaar + "'";
			java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);
			int r = stmt.executeUpdate();
			if (r == 1) {
				long tid = (long) (Math.random() * 1234 + 1234);
				LocalDateTime date = LocalDateTime.now();
				String s = "Withdrawn " + Double.toString(amount) + " with transaction id " + Long.toString(tid)
						+ " on " + date.toString();
				String withdraw = "insert into transactions values('" + aadhaar + "','" + s + "')";
				java.sql.PreparedStatement pstmt = con.prepareStatement(withdraw);
				pstmt.executeUpdate();
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean fundTransfer(long receiverAccountNumber, double amount) {
		int r = 0, r1 = 0;
		try {
			String sel = "select * from wallet where accountNumber=" + receiverAccountNumber;
			java.sql.PreparedStatement smt = con.prepareStatement(sel);
			rs2 = smt.executeQuery();
			if (rs2.first()) {
				d = rs2.getDouble(3) + amount;
				String updatequery = "update wallet set initialBalance=" + d + " where adharNo=" + rs2.getDouble(4);
				java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);
				r1 = stmt.executeUpdate();
				balance -= amount;
				String updatequery1 = "update wallet set initialBalance=" + balance + " where adharNo=" + aadhaar;
				java.sql.PreparedStatement stmt1 = con.prepareStatement(updatequery1);
				r = stmt1.executeUpdate();
				if (r == 1) {
					long tid1 = (long) (Math.random() * 1234 + 1234);
					LocalDateTime date = LocalDateTime.now();
					String s = "Recieved " + Double.toString(amount) + " with transaction id " + Long.toString(tid1)
							+ " on " + date.toString();
					String recieve = "insert into transactions values('" + rs2.getDouble(4) + "','" + s + "')";
					java.sql.PreparedStatement pstmt = con.prepareStatement(recieve);
					String s1 = "Transfered " + Double.toString(amount) + " with transaction id " + Long.toString(tid1)
							+ " on " + date.toString();
					String transfer = "insert into transactions values('" + aadhaar + "','" + s1 + "')";
					java.sql.PreparedStatement pstmt1 = con.prepareStatement(transfer);
					pstmt1.executeUpdate();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void printTranscation() {
		try {
			String select = "select * from transactions where adharNo='" + aadhaar + "'";
			java.sql.PreparedStatement stmt = con.prepareStatement(select);
			rs1 = stmt.executeQuery();
			while (rs1.next()) {
				System.out.println(rs1.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			System.out.println("Logged out of server");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
