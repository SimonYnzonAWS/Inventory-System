package controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

import models.Drinks;
import models.Foods;
import main.Main;

public class InventorySystem {
	Scanner scan = new Scanner(System.in);
	private HashMap<String, Drinks> drinksList = new HashMap<>();
	private HashMap<String, Foods> foodsList = new HashMap<>();
	private HashMap<String, Transaction> transactionList = new HashMap<>();

	public void addProduct(String productType) {
		System.out.print("Enter Product ID: ");
		int id = scan.nextInt();
		System.out.print("Enter Product Name: ");
		String name = scan.next();
		System.out.print("Enter Price: ");
		double price = scan.nextDouble();
		System.out.print("Enter Quantiy: ");
		int quantity = scan.nextInt();
		if (productType.equals("drinks")) {
			drinksList.put(name, new Drinks(id, name, price, quantity));
		} else {
			foodsList.put(name, new Foods(id, name, price, quantity));
		}
	}

	public void addDrinks(Drinks drinks) {
		drinksList.put(drinks.getProductName(), drinks);
	}

	public void addFoods(Foods foods) {
		foodsList.put(foods.getProductName(), foods);
	}

	public HashMap<String, Drinks> getDrinks() {
		return drinksList;
	}

	public HashMap<String, Foods> getFoods() {
		return foodsList;
	}
	
	public HashMap<String, Transaction> getTransactions() {
		return transactionList;
	}

	private Drinks getDrinkData(String inputProduct) {
		if (drinksList.containsKey(inputProduct)) {
			return drinksList.get(inputProduct);
		} else {
			throw new NoSuchElementException();
		}
	}

	private Foods getFoodsData(String inputProduct) {
		if (foodsList.containsKey(inputProduct)) {
			return foodsList.get(inputProduct);
		} else {
			throw new NoSuchElementException();
		}
	}

	public void productTypeCheckEdit(String inputProduct) {
		if (getDrinkData(inputProduct) != null) {
			System.out.println("Enter new Data");
			System.out.println("Price: ");
			double price = scan.nextDouble();
			drinksList.put(getDrinkData(inputProduct).getProductName(),
					new Drinks(getDrinkData(inputProduct).getProductID(), getDrinkData(inputProduct).getProductName(),
							price, getDrinkData(inputProduct).getStockQuantity()));
		} else {
			System.out.println("Enter new Data");
			System.out.println("Price: ");
			double price = scan.nextDouble();
			foodsList.put(getFoodsData(inputProduct).getProductName(),
					new Foods(getFoodsData(inputProduct).getProductID(), getFoodsData(inputProduct).getProductName(),
							price, getFoodsData(inputProduct).getStockQuantity()));

		}
	}

	public void sellProduct(String name, int quantity) {
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDateTime = currentDateTime.format(formatter);
		if (getDrinkData(name) != null) {
			if (getDrinkData(name).getStockQuantity() > quantity) {
				int newStock = getDrinkData(name).getStockQuantity() - quantity;
				Drinks data = new Drinks(getDrinkData(name).getProductID(), getDrinkData(name).getProductName(),
						getDrinkData(name).getUnitPrice(), newStock);
				drinksList.put(getDrinkData(name).getProductName(), data);
				transactionList.put(getDrinkData(name).getProductName(),
						new Transaction(++(Main.transactioniD), data, formattedDateTime, quantity));
			}else {
				System.out.println("Out of Stocks");
			}
		} else {
			if (getFoodsData(name).getStockQuantity() > quantity) {
				int newStock = getFoodsData(name).getStockQuantity() - quantity;
				Foods data = new Foods(getFoodsData(name).getProductID(), getFoodsData(name).getProductName(),
						getFoodsData(name).getUnitPrice(), newStock);
				foodsList.put(getFoodsData(name).getProductName(), data);
				transactionList.put(getDrinkData(name).getProductName(),
						new Transaction(++(Main.transactioniD), data, formattedDateTime, quantity));
			}else {
				System.out.println("Out of Stocks");
			}
		}
	}
	
}