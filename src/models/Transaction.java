package controllers;

<<<<<<< HEAD
public class Transaction {
	   private int transactionID;
	    private Product product;
	    private String transactionType;
	    private String transactionDate;
	    private int quantity;
	    private double unitPrice;

	    public Transaction(int transactionID, Product product, String transactionType, String transactionDate, int quantity, double unitPrice) {
	        this.transactionID = transactionID;
	        this.product = product;
	        this.transactionType = transactionType;
	        this.transactionDate = transactionDate;
	        this.quantity = quantity;
	        this.unitPrice = unitPrice;
	    }

	    public double calculateTotal() {
	        return quantity * unitPrice;
	    }

	    public String toString() {
	        return "Transaction ID: " + transactionID + ", Type: " + transactionType + ", Product: " + product + ", Quantity: " + quantity + ", Total: " + calculateTotal();
	    }
=======
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
>>>>>>> main
	}
}
