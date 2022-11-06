package com.velocity.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.LinkedHashMap;

public class Payment extends Cart {

	static void orderConform(String userName, LinkedHashMap<String, Integer> lmap) {
		try {
			String uName = userName;

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Connection con = GetConnection.getConnection();
			String sq = "insert into orderdetails(userName,mobileNo,mailId,adresss,pincode) values(?,?,?,?,?)";

			System.out.println("Enter Your Mobile Number:");
			String mob = br.readLine();

			System.out.println("Enter Your Mail Id:");
			String mail = br.readLine();

			System.out.println("Enter Your Adress:");
			String add = br.readLine();

			System.out.println("Enter Your Pincode:");
			int pin = Integer.parseInt(br.readLine());

			PreparedStatement pstmt = con.prepareStatement(sq);
			pstmt.setString(1, uName);
			pstmt.setString(2, mob);
			pstmt.setString(3, mail);
			pstmt.setString(4, add);
			pstmt.setInt(5, pin);
			// pstmt.setString(6, );
			pstmt.executeUpdate();
			System.out.println("Order Conformed.......!");
			OrderData.reduceQuantity();

			// pstmt.setInt(4, );

			OrderData orderData = new OrderData();
			orderData.orderDataToDb(userName);
			boolean flag = true;
			while (flag) {
				System.out.println("               =============                ");
				System.out.println("              | 1) Back     |               ");
				System.out.println("               =============                ");
				System.out.println("              | 2) Logout   |               ");
				System.out.println("               =============                ");

				int i = Integer.parseInt(br.readLine());
				if (i == 1) {
					Products.productsData(userName);

				} else if (i == 2) {
					System.out.println("Logout succesfully....!");
					Home_Page.frontInterface();
				} else {
					System.out.println("Invalid Input.");
					flag = true;
				}

				Products.productsData(userName);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
