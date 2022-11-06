package com.velocity.project;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admins_Functions {
	Scanner sc = new Scanner(System.in);
	Connection con = GetConnection.getConnection();

	void adminMenu() {
		System.out.println("==================================");
		System.out.println("+ 1) Check Product Quantity.     +");
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("+ 2) TO Check Register Records.  +");
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("+ 3) TO check User Order History +");
		System.out.println("==================================");
		System.out.println("                                        00) LogOut.");
		
		boolean flag = false;
		while (!flag) {
			System.out.println("Please Select Your Choice");
			String input = sc.next();
			
			  if (input.equals("1")) {
				flag = true;
				getQuantity();
			} else if (input.equals("2")) {
				flag = true;
				checkRegRecords();
			} else if (input.equals("3")) {
				flag = true;
				checkUserOrdersReco();
			} else if (input.equals("00")) {
				System.out.println("Logout Succesfully.....!");
				Home_Page.frontInterface();
			} else {
				System.out.println("Incorrect Input...!");
				flag = false;
			}
		}
		adminMenu();
	}

	void checkRegRecords() {
		try {
			Statement stmt = con.createStatement();
			String sql = "Select * from ordereditems";
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				System.out.println("+++++++++++++++++++++++++++++++");
				System.out.println("User Name: " + result.getString(1));
				System.out.println("Product Name: " + result.getString(2));
				System.out.println("Billing Amount: " + result.getInt(3));
				System.out.println("Quantity: " + result.getInt(4));
				System.out.println("+++++++++++++++++++++++++++++++");
			}
			adminMenu();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void getQuantity() {

		System.out.println("Please Enter productId:");
		int input = sc.nextInt();

		String sql = "Select product_name,product_quantity from product where product_id= " + input;
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				System.out.println("Product Name: " + result.getString(1));
				System.out.println("Quantity: " + result.getInt(2));

			}
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		adminMenu();
	}

	void checkUserOrdersReco() {
		try {
			Statement stmt = con.createStatement();
			System.out.println("Enter Customers Name: ");
			String name = sc.next();
			String sql = "Select * from ordereditems where userName='" + name + "'";
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				if (result.getString(1).equals(name)) {
					System.out.println("+++++++++++++++++++++++++++++++");
					System.out.println("User Name: " + result.getString(1));
					System.out.println("Product Name: " + result.getString(2));
					System.out.println("Billing Amount: " + result.getInt(3));
					System.out.println("Quantity: " + result.getInt(4));
					System.out.println("+++++++++++++++++++++++++++++++");
				} else {
					System.out.println("Customers Records Not Found");
					checkUserOrdersReco();
				}

			}
			adminMenu();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}