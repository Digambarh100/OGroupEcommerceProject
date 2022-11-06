package com.velocity.project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registation_data {

	// static HashMap<String, String> map = new LinkedHashMap<String, String>();
	static final String ADMIN_PASSWORD = "admin@123";
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String pss;

	public void register() throws IOException {
		String Name;
		String pss;
		System.out.println("===============================");
		System.out.println(" Enter Your Name:              ");
		System.out.println("===============================");
		Name = br.readLine();
		System.out.println("===============================");
		System.out.println(" Enter UserName:               ");
		System.out.println("===============================");
		String UserName = br.readLine();
	
		System.out.println("===============================");
		System.out.println(" Enter Password:                 ");
		System.out.println("===============================");
		String Password = br.readLine();
	
		System.out.println("===============================");
		System.out.println(" Enter Your Age:                ");
		System.out.println("===============================");
		int Age = Integer.parseInt(br.readLine());
		System.out.println("===============================");
		System.out.println(" Enter Contact Details:          ");
		System.out.println("===============================");
		String MobNo = br.readLine();
		//password encryption
		{
			int key=6;
				pss="";
			char[] pass=Password.toCharArray();
			for (char c : pass) {
				c +=key;
				pss=pss+c;
			}
			
	   }

		Registration_Class registration_Class = new Registration_Class(UserName, pss, Age, MobNo, Name);

		// sc.close();
		DataBaseMethods.insertSignupData(registration_Class);
		// map.put(registration_Class.getUserName(), registration_Class.getPassword());

	}
}
