package com.CarDealership;

import java.util.Scanner;

public class EmployeeActions {

	private static Scanner sc = new Scanner(System.in);

	public static void employeeMenuOption() {

		int menuOption;
		displayEmployeeMenu();
		do {
			System.out.println("\n\nWhat would you like to do?");
			menuOption = sc.nextInt();
			while(menuOption <0 || menuOption >6)
			{
				System.out.println("Please enter a correct menu option.");
				menuOption = sc.nextInt();
			}
			actionMenu(menuOption,null);
		} while(menuOption != 6);
	}

	public static void displayEmployeeMenu() {

		System.out.println("Menu: ");
		System.out.println();
		System.out.println("1. Show all existing car in lot.");
		System.out.println("2. Add a new car to lot.");
		System.out.println("3. Delete a car from lot.");
		System.out.println("5. View all payments.");
		System.out.println("6. Return to login.\n\n");
	}

	public static void displayCars() {

		System.out.println("|----|-----------|-----------|-----------|-----------|-----------|------------|");
		System.out.println("| #  |   year    |  color    |    make   |   model   |  mileage  |   price    |");
		System.out.println("|----|-----------|-----------|-----------|-----------|-----------|------------|");
		int i = 0;
		for (Car car : CarLot.getCars()) {
			System.out.println(++i + "      " + car.getYear() + "        " + car.getColor() + "        " + car.getMake()
			+ "        " + car.getModel() + "      " + car.getMileage() + "     " + car.getPrice());
		}
		System.out.println("|----|-----------|-----------|-----------|-----------|-----------|------------|");
	}

	public static void displayCars(Car car) {

		System.out.println("|----|-----------|-----------|-----------|-----------|-----------|------------|");
		System.out.println("| #  |   year    |  color    |    make   |   model   |  mileage  |   price    |");
		System.out.println("|----|-----------|-----------|-----------|-----------|-----------|------------|");
		System.out.println("1" + "      " + car.getYear() + "        " + car.getColor() + "        " + car.getMake()
		+ "        " + car.getModel() + "      " + car.getMileage() + "     " + car.getPrice());
		System.out.println("|----|-----------|-----------|-----------|-----------|-----------|------------|");
	}

	public static void addNewCar(CarLot cars) {

		boolean validInput;
		String color, make, model = null;
		int year = 0, mileage = 0;
		double price = 0.0;

		System.out.println("Enter a new car in the following format:");
		System.out.println("YEAR COLOR MAKE MODEL MILEAGE PRICE");
		System.out.println("EX: 2012 Black Acura TL 22000 19000.00");
		do {
			validInput = true;
			year = sc.nextInt();
			color = sc.next();
			make = sc.next();
			model = sc.next();
			mileage = sc.nextInt();
			price = sc.nextDouble();
			if (!validInput) {
				System.out.println("\nIncorrect Format.");
				System.out.println("Enter a new car in the following format:");
				System.out.println("YEAR COLOR MAKE MODEL MILEAGE PRICE");
				System.out.println("EX: 2012 Black Acura TL 22000 19000.00");
			}
		} while (validInput == false);
		CarLot.getCars().add(new Car(year,color,make,model,mileage,price));
	}

	public static void removeCar(CarLot car) {

		int carNumber;

		if(CarLot.getCars().size()>0) {
			System.out.println("Please select # of the car you want to delete");
			displayCars();
			do {
				System.out.print("Delete car #: ");
				while(!sc.hasNextInt())
				{
					System.out.println("Thats not a valid input");
					sc.next();
				}
				carNumber = sc.nextInt();

			} while (carNumber < 1 || carNumber > CarLot.getCars().size());
			CarLot.getCars().remove(carNumber-1);
		} else System.out.println("There are no cars to remove.");
	}

	public static void actionMenu(int action, CarLot cars) {

		switch (action) {
		case 0:
			System.out.println("Main Menu");
			displayEmployeeMenu();
			break;
		case 1:
			System.out.println("List of Cars");
			displayCars();
			break;
		case 2:
			System.out.println("Add car to lot");
			addNewCar(cars);
			break;
		case 3:
			System.out.println("Remove car from lot");
			removeCar(cars);
			break;
		case 6:
			System.out.println("Return to login");
			Login.main(null);
		}
	}

}
