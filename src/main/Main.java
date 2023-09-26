package main;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.InventorySystem;
import controllers.Transaction;
import models.Drinks;
import models.Foods;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static InventorySystem invSys = new InventorySystem();
	static ArrayList<Drinks> drinksList = new ArrayList<>();
	static ArrayList<Foods> foodsList = new ArrayList<>();
	public static int transactioniD = 0;

	public static void main(String[] args) {

		boolean useApp = true;
		drinksList.add(new Drinks(1, "Dew", 50.0, 100));
		drinksList.add(new Drinks(2, "Coke", 20.0, 100));
		drinksList.add(new Drinks(3, "Sprite", 30.0, 100));

		foodsList.add(new Foods(1, "Onigiri", 100.0, 100));
		foodsList.add(new Foods(2, "Noodles", 10.0, 100));
		foodsList.add(new Foods(3, "Can", 34.0, 100));

		for (Drinks item : drinksList) {
			invSys.addDrinks(item);
		}

		for (Foods item : foodsList) {
			invSys.addFoods(item);
		}

		while (useApp) {
			System.out.print(
					"Select Option\n[1] Add Inventory\n[2] View Inventory\n[3] Edit Inventory\n[4] Sell\n[5] Transactions\n[6] Exit\n");
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
				transaction();
				break;
			case "6":
				useApp = false;
				break;
			}
		}

		scan.close();

	}
	static void addInventory() {
		boolean isAdd = true;
		while (isAdd) {
			System.out.println("Select Add menu Option\n[D] Add Drinks\n[F] Add Foods\n[E] Exit\n");
			String selection = scan.next().toUpperCase();
			switch (selection) {
			case "D":
				invSys.addProduct("drinks");
				break;
			case "F":
				invSys.addProduct("Foods");
				break;
			case "E":
				isAdd = false;
				break;
			}
		}
	}

	static void viewInventory() {
		System.out.println("Foods");
		System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
		for (Foods item : invSys.getFoods().values()) {
			System.out.println(item.getProductID() + "\t\t" + item.getProductName() + "\t\t" + item.getUnitPrice()
					+ "\t\t" + item.getStockQuantity());
		}

		System.out.print("Drinks\n");
		System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
		for (Drinks item : invSys.getDrinks().values()) {
			System.out.println(item.getProductID() + "\t\t" + item.getProductName() + "\t\t" + item.getUnitPrice()
					+ "\t\t" + item.getStockQuantity());
		}

		System.out.println();
	}

	static void editInventory() {
		boolean isEdit = true;
		while (isEdit) {
			System.out.print("Enter product name you want to update, select E to Home");
			String selection = scan.next();
			if (!selection.toLowerCase().equals("e")) {
				invSys.productTypeCheckEdit(selection);
			} else {
				isEdit = false;
			}
		}
	}
	static void sell() {
		System.out.print("Enter product to be dispatched");
		String prodName = scan.next();
		System.out.print("Enter quantity to be dispatched: ");
		int quant = scan.nextInt();
		invSys.sellProduct(prodName, quant);
	}
	static void transaction() {
		System.out.println("Transactions");
		System.out.println("Date\t\t\tName\t\tQuantity\tPrice");
		for (Transaction item : invSys.getTransactions().values()) {
			System.out.println(item.getTransactionDate()+"\t\t"+item.getProduct().getProductName()+"\t\t"+item.getQuantity()+"\t\t"+item.getProduct().getUnitPrice());
		}
		System.out.println("\n");
	}

}
