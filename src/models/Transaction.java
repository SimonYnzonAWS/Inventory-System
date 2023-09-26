package controllers;

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
	}
}
