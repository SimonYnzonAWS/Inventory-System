package models;

public class Supplier {
	private String supplierName;
	private int supplierID;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	public String toString() {
		return "Supplier: " + supplierName
				+ "\n Supplier ID: " +supplierID;
	}
	
}