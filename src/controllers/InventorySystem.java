package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import models.Drinks;
import models.Foods;

public class InventorySystem {
	Scanner scan = new Scanner(System.in);
	private HashMap<String, Drinks> drinksList = new HashMap<>();
	private HashMap<String, Foods> foodsList = new HashMap<>();

	protected void addProduct(String productType) {
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

	protected void addDrinks(Drinks drinks) {
		drinksList.put(drinks.getProductName(), drinks);
	}

	protected void addFoods(Foods foods) {
		foodsList.put(foods.getProductName(), foods);
	}

	protected HashMap<String, Drinks> getDrinks() {
		return drinksList;
	}

	protected HashMap<String, Foods> getFoods() {
		return foodsList;
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

	protected void productTypeCheckEdit(String inputProduct) {
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
	
	protected void sellProduct(String name, int quantity) {
		if (getDrinkData(name) != null) {
			int newStock = getDrinkData(name).getStockQuantity() - quantity;
			drinksList.put(getDrinkData(name).getProductName(),
					new Drinks(getDrinkData(name).getProductID(), getDrinkData(name).getProductName(),
							getDrinkData(name).getUnitPrice(), newStock));
		}else {
			int newStock = getFoodsData(name).getStockQuantity() - quantity;
			foodsList.put(getFoodsData(name).getProductName(),
					new Foods(getFoodsData(name).getProductID(), getFoodsData(name).getProductName(),
							getFoodsData(name).getUnitPrice(), newStock));
		}
	}