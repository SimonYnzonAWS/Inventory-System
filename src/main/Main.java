package main;
import models.*;
import controllers.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static InventorySystem invSys = new InventorySystem();
	private static ArrayList<Drinks> drinksList = new ArrayList<>();
	private static ArrayList<Foods> foodsList = new ArrayList<>();
	
	public static void main(String[] args) {

		boolean useApp = true;
		drinksList.add(new Drinks(++(InventorySystem.productId), "Gatorade", 50.0, 100));
		drinksList.add(new Drinks(++(InventorySystem.productId), "Coke", 20.0, 100));
		drinksList.add(new Drinks(++(InventorySystem.productId), "Sprite", 30.0, 100));

		foodsList.add(new Foods(++(InventorySystem.productId), "Onigiri", 100.0, 100));
		foodsList.add(new Foods(++(InventorySystem.productId), "Noodles", 10.0, 100));
		foodsList.add(new Foods(++(InventorySystem.productId), "Can", 34.0, 100));

		for (Drinks item : drinksList) {
			invSys.addDrinks(item);
		}

		for (Foods item : foodsList) {
			invSys.addFoods(item);
		}

		while (useApp) {
			System.out.print("\n1 Add inventory\n" + "2 View inventory \n"
					+ "3 Edit inventory\n" + "4 Sell\n5 Display transaction history\n0 to Exit\n\nEnter choice: ");
			String selection = scan.next();
			switch (selection) {
			case "1":
				addInventory();
				break;
			case "2":
				viewInventory();
				break;
			case "3":
				editInventory();
				break;
			case "4":
				sell();
				break;
			case "5":
				displayTransactions();
				break;
			case "0":
				useApp = false;
				break;	
			}
		}

		scan.close();

	}

	private static void addInventory() {
		boolean isAdd = true;
		String name = null;
		double price =  -1;
		int quantity = -1;
		while (isAdd) {
			System.out.println("\nEnter Menu\nD Drinks\nF Foods\nE Exit");
			String selection = scan.next().toUpperCase();
			
			try{
				System.out.print("Enter Product Name: ");
				name = scan.next();
				System.out.print("Enter Price: ");
				price = scan.nextDouble();
				System.out.print("Enter Quantiy: ");
				quantity = scan.nextInt();
			}
			catch(Exception e ){
				System.out.println("Invalid input");
			}
			if(name != null || price != -1 || quantity != -1){
				Product product = new Product(++(InventorySystem.productId), name, price, quantity);

				switch (selection) {
				case "D":
					invSys.addProduct("drinks", product);
					break;
				case "F":
					invSys.addProduct("foods", product);
					break;
				case "E":
					isAdd = false;
					break;
				}
			}
			
		}
	}

	private static void viewInventory() {
		System.out.print("Products in the inventory: \n\n");
		for (Foods item : invSys.getFoods().values()) {
			System.out.println("Product ID: " + item.getProductID() + "\tName: " + item.getProductName()
					+ "\tUnit Price: " + item.getUnitPrice() + "\tQuantity Left: " + item.getStockQuantity());
		}
		for (Drinks item : invSys.getDrinks().values()) {
			System.out.println("Product ID: " + item.getProductID() + "\tName: " + item.getProductName()
					+ "\tUnit Price: " + item.getUnitPrice() + "\tQuantity Left: " + item.getStockQuantity());
		}

		System.out.println();
	}

	private static void editInventory() {
		boolean isEdit = true;
		while (isEdit) {
			System.out.print("Enter product name you want to update, select E to Home");
			String selection = scan.next();
			if (!selection.toLowerCase().equals("e")) {
				invSys.productTypeCheckEdit(selection);
			} else {
				isEdit=false;
			}
		}
	}
	
	private static void sell() {
		try {
			System.out.print("Enter sold product: ");
			String prodName = scan.next();
			System.out.print("Enter quantity: ");
			int quant = scan.nextInt();

			invSys.sellProduct(prodName, quant);	
		} catch (Exception e) {
			System.out.println("Invalid input.");	
		}	
	}
	
	private static void displayTransactions(){
		invSys.displayTransactions();
	}
}
