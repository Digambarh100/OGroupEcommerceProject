package com.velocity.project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home_Page {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void frontInterface() {
		System.out.println("  <<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>> ");
		System.out.println("  |      WELLCOME TO SHOPINGKART      |");
		System.out.println("  <<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>> ");
		System.out.println();
		System.out.println(" =========================================== ");
		System.out.println(" 1) Admin           ||               2) User  ");
		System.out.println(" =========================================== ");

		boolean flag = false;
		try {
			int input = Integer.parseInt(br.readLine());
			if (input == 1) {
				System.out.println("               =============                ");
				System.out.println("              | 1) Login    |               ");
				System.out.println("               =============                ");
				System.out.println("              | 2) Exit     |               ");
				System.out.println("               =============                ");

				int admip = Integer.parseInt(br.readLine());
				 flag = false;
				if (admip == 1) {

					while (flag == false) {
						System.out.println("Enter Password.");
						String pass = br.readLine();
						if (pass.equals("")) {
							System.out.println("Input Should Not Be Empty...!");
							flag = false;
						} else if (pass.equals(Registation_data.ADMIN_PASSWORD)) {
							Admins_Functions af = new Admins_Functions();
							flag = true;
							af.adminMenu();

						} else {
							System.out.println("Incorrect Password");
							flag = false;
						}
					}
				} else if (admip == 2) {
					frontInterface();
				}

			} else if (input == 2) {
				System.out.println("               =============                ");
				System.out.println("              | 1) Login    |               ");
				System.out.println("               =============                ");
				System.out.println("              | 2) Register |               ");
				System.out.println("               =============                ");

				while (!flag) {
					System.out.print("Please Selcet Your Choice: ");
					String uInput = br.readLine();
					if (uInput.equals("")) {
						System.out.println("Input Should Not Be Blank...!");
						flag = false;
					}

					else if (uInput.equals("1")) {
						flag = true;
						Login_Class login_Class=new Login_Class();
						login_Class.loginAuthenticate();

					} else if (uInput.equals("2")) {
						flag = true;
						Registation_data data=new Registation_data();
						data.register();
					}else if (!uInput.equals("0-9")){
						System.out.println("Please Enter Input In Number Format...!");
						flag=false;
					}else {
						System.out.println("Invalid Input...!");
						flag=false;
					}
				}
			}
		} catch (NumberFormatException | IOException e) {
			flag = false;
			e.printStackTrace();
		}

	}
}