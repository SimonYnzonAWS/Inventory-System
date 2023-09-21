package controllers;

import java.util.ArrayList;

import models.Drinks;
import models.Foods;

public class InventorySystem {
	private ArrayList<Drinks> drinksList = new ArrayList<>();
	private ArrayList<Foods> foodsList = new ArrayList<>();
	private ArrayList<Transaction> transactions = new ArrayList<>();

	public void addDrinks(Drinks drinks) {
		drinksList.add(drinks);
	}

	public void addFoods(Foods foods) {
		foodsList.add(foods);
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
}
