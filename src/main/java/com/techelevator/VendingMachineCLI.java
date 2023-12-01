package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		List<Product> products = readProductFromFile("main.csv");
		VendingMachine vendingMachine = new VendingMachine(products);
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while(!exit){
			VendingMachine.displayMain();
			System.out.println("Please Select an option: ");
			int choice = scanner.nextInt();
			switch (choice){
				case 1:
					vendingMachine.displayProducts();
					break;
				case 2:
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Invalid option> Please try again");
			}

		}

	}

	private static List<Product> readProductFromFile(String filename) {
		List<Product> products = new ArrayList<>();
		File input = new File(filename);
		if (input.exists()&& input.isFile()){
			try(Scanner inputScanner = new Scanner(input)){
				while (inputScanner.hasNextLine()){
					String currentLine = inputScanner.nextLine();
					System.out.println(currentLine);
					String[] splitValues = currentLine.split(",");
					String slotLocation = splitValues[0];
					String name  = splitValues[1];
					String price = splitValues[2];
					double priceDou = Double.parseDouble(price);
					String type = splitValues[3];
					int quality = 5;
					Product product = new Product(slotLocation,name,priceDou,type,quality);
					products.add(product);
				}

			}catch (FileNotFoundException e){
				System.out.println("Error" + e.getMessage());
			}
		}
		return products;
	}

}
