package com.velocity.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login_Class extends Registation_data {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String uname;

	void loginAuthenticate() throws IOException

	{

		try {
			System.out.println("Enter UserName:");
			uname = br.readLine();

			System.out.println("Enter Password:");
			String pwrd = br.readLine();

			String sql = "select userName,userPassword from signupdata;";

			boolean flag = false;

			Connection con = GetConnection.getConnection();

			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(sql);

			while (set.next()) {
				String pss;
				
				// decrypting password
				{
					String password = set.getString("userPassword");
					int key = 6;
					pss = "";
					char[] pass = password.toCharArray();
					for (char c : pass) {
						c -= key;
						pss = pss+c;
					}
              
				}

				if ((uname.equals(set.getString("userName"))) && (pwrd.equals(pss))){

					System.out.println("Login succesfull...");
					flag = true;
					Products.productsData(uname);
					break;

				} else if (!flag) {
					System.out.println("Invalid Usernam/Password.");

					System.out.println("Enter UserName:");
					uname = br.readLine();

					System.out.println("Enter Password:");
					pwrd = br.readLine();

					if ((uname.equals(set.getString("userName"))) && (pwrd.equals(pss))) {
						System.out.println("Login succesfull...");
						flag = true;
						Products.productsData(uname);
						break;
					}
				}
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
