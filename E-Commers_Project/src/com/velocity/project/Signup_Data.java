package com.velocity.project;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Signup_Data {

	public static void usersSignupData() {
		Registration_Class registration_Class = new Registration_Class();

		HashMap<String, String> map = new LinkedHashMap<String, String>();

		map.put(registration_Class.getUserName(), registration_Class.getPassword());

		Set<Entry<String, String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
