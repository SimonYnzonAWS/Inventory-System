package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import models.Drinks;
import models.Foods;
import models.Product;
import models.Transaction;

public class InventorySystem {
	Scanner scan = new Scanner(System.in);
	
	private HashMap<String, Drinks> drinksList = new HashMap<>();
	private HashMap<String, Foods> foodsList = new HashMap<>();
	private ArrayList<Transaction> transaction = new ArrayList<>();

	public static int productId = 0;
	public static int transactionId = 0;

	public void addProduct(String productType, Product product) {

		if (productType.equals("drinks")) {
			drinksList.put(product.getProductName().toLowerCase(), (Drinks)product);
		} else {
			foodsList.put(product.getProductName().toLowerCase(), (Foods)product);
		}
	}

	public void addDrinks(Drinks drink) {
		drinksList.put(drink.getProductName().toLowerCase(), drink);
	}

	public void addFoods(Foods food) {
		foodsList.put(food.getProductName().toLowerCase(), food);
	}

	public HashMap<String, Drinks> getDrinks() {
		return drinksList;
	}

	public HashMap<String, Foods> getFoods() {
		return foodsList;
	}
	public ArrayList<Transaction> getTransactions(){
		return transaction;
	}

	public Drinks getDrinkData(String inputProduct) throws NoSuchElementException {
		if (drinksList.containsKey(inputProduct.toLowerCase())) {
			return drinksList.get(inputProduct);
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public Foods getFoodsData(String inputProduct) throws NoSuchElementException {
		if (foodsList.containsKey(inputProduct.toLowerCase())) {
			return foodsList.get(inputProduct);
		} else {
			throw new NoSuchElementException();
		}
	}

	public void productTypeCheckEdit(String inputProduct) {
		Product product = null;
		
		try{
			product = (Product)getDrinkData(inputProduct);
		}
		catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		if (product == null) {
			try{ product = (Product)getFoodsData(inputProduct); }
			catch(NoSuchElementException e){ System.out.println(e.getMessage());}		
		} 

		if(product != null){
			System.out.println("Enter new Data");
			System.out.println("Price: ");
			double price = scan.nextDouble();
			product.setUnitPrice(price);
		}
	}
	
	public void sellProduct(String name, int quantity) {
		Product product = null;
		
		try{ product = (Product)getDrinkData(name); }
		catch(NoSuchElementException e){ e.getMessage(); }

		if(product == null){
			try{ product = (Product)getFoodsData(name); }
			catch(NoSuchElementException e){ System.out.println(e.getMessage()); }

		}

		if(product != null){
			int currStock = product.getStockQuantity();
			if(quantity <= currStock)
				product.setStockQuantity(currStock - quantity);
			else
				System.out.println("Can't sell " + quantity + " " + product.getProductName() + " due to low stock.");
			transaction.add(new Transaction(++transactionId, product.getProductName(), Transaction.SALE_STRING, quantity, product.getUnitPrice()));
		}	
	}
	public void displayTransactions(){
		System.out.println("Transactions: \n");	
		
		for(Transaction t : transaction){
			System.out.println("Product: " + t.getProductName() + "\t\tQuantity: " + t.getQuantity() + "\t" +
			 "Price: " + t.getUnitPrice() + "\t" + "Transaction: " +t.getTransactionType() + "\t" + "Date: " + t.getTransactionDate());
		}
	}

	
}