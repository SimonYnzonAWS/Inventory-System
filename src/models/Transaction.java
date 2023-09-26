package controllers;

import models.Product;

public class Transaction {
    private int transactionID;
	private Product product;
    private String transactionDate;
    private int quantity;

    public Transaction(int transactionID, Product product, String transactionDate, int quantity) {
        this.transactionID = transactionID;
        this.product = product;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
    }
    

    public int getTransactionID() {
		return transactionID;
	}

	public Product getProduct() {
		return product;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public int getQuantity() {
		return quantity;
	}
}
