package models;

public class Product {
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
        setStockQuantity(stockQuantity);
        setUnitPrice(unitPrice);
    }
	
	public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnitPrice(double unitPrice) {
        if(unitPrice > 0)
            this.unitPrice = unitPrice;
    }

    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity > 0)
            this.stockQuantity = stockQuantity;
    }
    public String toString() {
        return productName + " (ID: " + productID + ")";
    }
}
