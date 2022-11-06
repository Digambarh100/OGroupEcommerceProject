package com.velocity.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map.Entry;

public class OrderData extends Cart {

	// static LinkedHashMap<String, Integer> lmap2 = new LinkedHashMap<String,
	// Integer>(lmap);
	void orderDataToDb(String userName) {
		try {
			//Cart c1 = new Cart();
			String sql = "insert into ordereditems ( userName,itemName,totalPaid,quantity)values(?,?,?,?)";
			
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			Statement st =con.createStatement();
			
			Iterator<String> itr = lmap.keySet().iterator();
			while (itr.hasNext()) {
				String str = itr.next();
				pstmt.setString(1, userName);
				pstmt.setString(2, str);
				String sqll = "Select product_price from product where product_name = '"+str+"'";
				ResultSet s =st.executeQuery(sqll);
				while(s.next()) {
				pstmt.setInt(3, (s.getInt(1))*lmap.get(str)); }
				pstmt.setInt(4, lmap.get(str));
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void reduceQuantity() {
		
		//Updating quantity after user order done..
		try {
			Connection con = GetConnection.getConnection();
			String s = "select * from product";

			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(s);

			while (result.next()) {
				String itm = result.getString(4);
				int i = result.getInt(5);
				for (Entry<String, Integer> entry : lmap.entrySet()) {
					String str1 = entry.getKey();

					if (str1.equals(itm)) {
						Connection con2 = GetConnection.getConnection();
						int q = (i - entry.getValue());
					
						String sql = "update product set product_quantity= " + q + " where product_name='" + itm + "';";
						PreparedStatement pst = con2.prepareStatement(sql);
						pst.executeUpdate();
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
