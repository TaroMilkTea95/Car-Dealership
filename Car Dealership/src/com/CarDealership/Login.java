package com.CarDealership;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		boolean exitInput = false;

		do {	
			Scanner scan = new Scanner(System.in);
			String loginPage = new String();

			System.out.println("Please Select User:");
			System.out.println("(1) Employee or (2) Customer");

			loginPage = scan.nextLine();
			if(loginPage.equals("1")) {
				EmployeeLogin.employeeL();
				exitInput = true;
			}else if(loginPage.equals("2"));
				CustomerLogin.customerL();
			exitInput = true;
		}while(exitInput != true);
		
	}
}
