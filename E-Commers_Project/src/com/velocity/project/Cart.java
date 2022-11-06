package com.velocity.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;
import java.util.TreeSet;

public class Cart {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int input;
	static int grandTotal;
	private int total;
	int t;
	public Cart() {
		super();
	}

	public Cart(int total2) {
		// TODO Auto-generated constructor stub
		total=total2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	static Map<String, Integer> map = new HashMap<String, Integer>();

	static LinkedHashMap<String, Integer> lmap = new LinkedHashMap<String, Integer>();

	void getIntoCart(String userName) throws NumberFormatException, IOException {
		// String uName=userName;
		System.out.println("                                     _____________");
		System.out.println("======================              |             |");
		System.out.println("Enter 11) For Procced.              | 00) Logout. |");
		System.out.println("======================              |_____________|");
		System.out.println("Enter Your Choice:");
		int input2 = 0;
		boolean flag = true;
		do {
			try {
				input = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {

				e.printStackTrace();
			}

			if (input == 1) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("mobiles", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 2) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("pendrive", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 3) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("memorychard", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 4) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("charger", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");
			} else if (input == 5) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("watch", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 6) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("smart tv", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 7) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("mobile case", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 8) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("selfie stick", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 9) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("screengard", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 10) {
				System.out.println("Enter Quantity:");
				input2 = Integer.parseInt(br.readLine());
				map.put("goggle", input2);
				input2 = 0;
				System.out.println("Enter Your Choice:");

			} else if (input == 11) {
				// while loop.if user put invalid input
				while (flag) {
					System.out.println("1) Procced to Cart");
					System.out.println("2) Cancel");
					input2 = Integer.parseInt(br.readLine());
					if (input2 == 1) {
						cartData(userName);
						flag = false;
						break;
					} else if (input == 2) {
						map.clear();
						flag = false;

					} else if (input == 00) {
						System.out.println("Logout succesfully....!");
						Home_Page.frontInterface();
						flag = false;
						break;
					} else {
						System.out.println("Invalid Input..");

					}
					Products.productsData(userName);
				}
			} else if (input == 00) {
				System.out.println("Logout succesfully....!");
				Home_Page.frontInterface();
				flag = false;
				break;
			}

		} while (input != 11);
		if (flag) {
			Products.productsData(Login_Class.uname);
		}
	}

	static void cancelCart() {
		try {
			Products.productsData(Login_Class.uname);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 void cartData(String userName) {

		TreeSet<String> set = new TreeSet<String>();

		Set<String> keySet = map.keySet();

		for (String str : keySet) {
			set.add(str);
		}
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("+      Your Cart Items Are       +");
		System.out.println("++++++++++++++++++++++++++++++++++");
		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) {
			String str = itr.next();
			lmap.put(str, map.get(str));
		}
		final_Cart(lmap, userName);
	}

	 void final_Cart(LinkedHashMap<String, Integer> lmap, String userName) {
		Connection con = GetConnection.getConnection();
		String sql = "select * from product";
		Cart c = new Cart();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet result2 = stmt.executeQuery(sql);

			Set<Entry<String, Integer>> set = lmap.entrySet();

			int count = 1;

			System.out.println("===============================");
			while (result2.next()) {
				String s1 = result2.getString(4);
				int in = result2.getInt(3);

				for (Entry<String, Integer> entry : set) {
					if (s1.equals(entry.getKey())) 
					{
					    c.setTotal(entry.getValue() * in); 

						System.out.println(count + ")" + s1 + " x " + entry.getValue() + " = " + c.getTotal());
						System.out.println("===============================");

						grandTotal = (grandTotal + c.getTotal());
						count++;
						t=c.getTotal();

					}
				}
				

			}
			System.out.println("Total Of cart: " + grandTotal);
			boolean flag = true;
			while (flag) {
				System.out.println("  _____________               _____________");
				System.out.println(" |             |             |             |");
				System.out.println(" | 1) PAY      |             | 2) CANCEL   |");
				System.out.println(" |_____________|             |_____________|");
				try {
					int ip = Integer.parseInt(br.readLine());

					if (ip == 1) {

						proccedToPay(userName);
						flag = false;
						break;
					} else if (ip == 2) {
						System.out.println("Cancelled to Procced....!");
						Products.productsData(userName);
						break;
					} else {
						System.out.println("Invalid Input...!");
						flag = true;
					}
				} catch (NumberFormatException | IOException e) {

					System.out.println(e);
				}

				// proccedToPay(userName);
			}
		} catch (SQLException e) {
			System.out.println(e);
			;
		}

	}

	static void proccedToPay(String userName) {

		Payment.orderConform(userName, lmap);

	}
}
