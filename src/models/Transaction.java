ackage models;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	public static final String SALE_STRING = "Sales";
	public static final String RESTOCK_STRING = "Restock";
	
    private int transactionID;
	private double unitPrice;
	private String productName;
    private String transactionDate;
    private int quantity;
	private String transactionType;

    public Transaction(int transactionID, String product, String transactionType, int quantity, double unitPrice) {
        this.transactionID = transactionID;
        this.productName = product;
        this.transactionType = transactionType;
        this.quantity = quantity;
        
        this.unitPrice = unitPrice;

		this.transactionDate = getDate();
    }
    

    public double calculateTotal() {
        return quantity * unitPrice;
    }

    public String toString() {
        return "Transaction ID: " + transactionID + ", Type: " + transactionType + ", Product: " + productName + ", Quantity: " + quantity + ", Total: " + calculateTotal();
    }
	
	private String getDate(){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		return sdf.format(today);
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getTransactionDate() {
		return transactionDate;
	}
}
}
