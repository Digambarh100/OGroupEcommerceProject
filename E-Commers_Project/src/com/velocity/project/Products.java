package com.velocity.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Products {

	static void productsData(String userName) throws NumberFormatException, IOException {
		String uName = userName;
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println("        WelCome " + uName);
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println("\n........Selct Products........");

		Map<Integer, String> map = new HashMap<Integer, String>();

		try {
			Connection con = GetConnection.getConnection();
			Statement stmt = con.createStatement();

			String sql = "select * from product";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {

				int i = result.getInt(1);

				String str = result.getString(4);
				map.put(i, str);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		Set<Entry<Integer, String>> set = map.entrySet();

		for (Entry<Integer, String> entry : set) {

			System.out.println(" _____________________________");
			System.out.println("|                             |");
			System.out.println("   " + entry.getKey() + ") " + entry.getValue());
			System.out.println("|_____________________________|");

		}
		Cart cart = new Cart();
		cart.getIntoCart(userName);
	}

}
