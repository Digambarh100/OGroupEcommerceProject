package com.velocity.project;

public class Registration_Class {

	String userName;
	protected String password;
	int age;
	String mobNo;
	String name;
	
	public Registration_Class(String userName, String password, int age, String mobNo, String name) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.mobNo = mobNo;
		this.name = name;
	}
	
	public Registration_Class() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	
	
	
}
