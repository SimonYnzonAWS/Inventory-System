package models;

public abstract class Product {
    private int productID;
    private String productName;
    public double unitPrice;
    public int stockQuantity;
    
    public int getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public Product(int productID, String productName, double unitPrice, int stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public String toString() {
        return productName + " (ID: " + productID + ")";
    }
}
