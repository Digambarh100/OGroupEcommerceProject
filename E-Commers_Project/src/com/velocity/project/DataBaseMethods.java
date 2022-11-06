package com.velocity.project;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseMethods {

	public static void insertSignupData(Registration_Class rs) {
		try {
			Connection con = GetConnection.getConnection();
			
			String str = "insert into signupdata(userName,userPassword,userContactNo,name,age) values (?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(str);
			
			statement.setString(1, rs.getUserName());
			statement.setString(2, rs.getPassword());
			statement.setString(3, rs.getMobNo());
			statement.setString(4, rs.getName());
			statement.setInt(5, rs.getAge());
		
			statement.executeUpdate();
			System.out.println("SignUp Succesfully...!");
			Home_Page.frontInterface();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
