package com.CarDealership;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarLot {

	public static Scanner sc = new Scanner(System.in);
	private static final List<Car> cars = new ArrayList<>(
			Arrays.asList(new Car(2018, "Silver", "Toyota", "Highlander", 15000, 35000.00), 
					new Car(2012, "Black", "Accord", "TL", 27000, 200000.00), 
					new Car(2019, "Blue", "Tesla", "Roadster", 10000, 200000.00))
			);

	public static List<Car> getCars() {
		return cars;
	}
}
