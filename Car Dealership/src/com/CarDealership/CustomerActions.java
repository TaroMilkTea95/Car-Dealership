package com.CarDealership;

import java.util.Scanner;

public class CustomerActions {

	private static Scanner sc = new Scanner(System.in);

	public static void customerMenuOption() {

		int menuOption2;
		displayCustomerMenu();
		do {
			System.out.println("\n\nWhat would you like to do?");
			menuOption2 = sc.nextInt();
			while(menuOption2 <0 || menuOption2 >6)
			{
				System.out.println("Please enter a correct menu option.");
				menuOption2 = sc.nextInt();
			}
			actionMenu(menuOption2,null);
		} while(menuOption2 != 6);
	}
 
	public static void displayCustomerMenu() {

		System.out.println("Menu: ");
		System.out.println("-------------------------------------------------");
		System.out.println("1. Show all existing car in lot.");
		System.out.println("2. Make offer for car.");
		System.out.println("3. View owned car.");
		System.out.println("5. View remaining payments.");
		System.out.println("6. Return to login.\n\n");
	}
	
	public static void displayCars() {

		System.out.println("+-----------+-----------+-----------+-----------+-----------+------------+");
		System.out.println("|   year    |  color    |    make   |   model   |  mileage  |   price    |");
		System.out.println("+-----------+-----------+-----------+-----------+-----------+------------+");
		int i = 0;
		for (Car car : CarLot.getCars()) {
			System.out.println("    " + car.getYear() + "      " + car.getColor() + "      " + car.getMake()
			+ "      " + car.getModel() + "     " + car.getMileage() + "     " + car.getPrice());
			System.out.println("+-----------+-----------+-----------+-----------+-----------+------------+");
		}
	}
	
	public static void actionMenu(int action, CarLot cars) {

		switch (action) {
		case 0:
			System.out.println("Main Menu");
			displayCustomerMenu();
			break;
		case 1:
			System.out.println("List of Cars");
			displayCars();
			break;
		}
	}
}

